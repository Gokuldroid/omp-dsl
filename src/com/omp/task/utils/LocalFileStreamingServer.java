package com.omp.task.utils;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import org.jetbrains.annotations.Nullable;


/**
 * A single-connection HTTP server that will respond to requests for files and
 * pull them from the application's SD card.
 */
public class LocalFileStreamingServer implements Runnable
{
	private static final String TAG = LocalFileStreamingServer.class.getName();
	private int port = 0;
	private boolean isRunning = false;
	private ServerSocket socket;
	private Thread thread;
	private long cbSkip;
	private boolean seekRequest;
	private File mMovieFile;

	public static void main(String[] args)
	{
		LocalFileStreamingServer localFileStreamingServer = new LocalFileStreamingServer(new File("E:\\movies\\Baahubali_The_Beginning.mp4"));
		localFileStreamingServer.init("127.0.0.1");
		localFileStreamingServer.start();
		System.out.println(localFileStreamingServer.getFileUrl());
	}

	/**
	 * This server accepts HTTP request and returns files from device.
	 */
	public LocalFileStreamingServer(File file)
	{
		mMovieFile = file;
	}

	/**
	 * @return A port number assigned by the OS.
	 */
	public int getPort()
	{
		return port;
	}

	/**
	 * Prepare the server to start.
	 * <p/>
	 * This only needs to be called once per instance. Once initialized, the
	 * server can be started and stopped as needed.
	 */
	@Nullable
	public String init(String ip)
	{
		String url = null;
		try
		{
			InetAddress inet = InetAddress.getByName(ip);
			byte[] bytes = inet.getAddress();
			socket = new ServerSocket(port, 0, InetAddress.getByAddress(bytes));
			socket.setSoTimeout(10000);
			port = socket.getLocalPort();
			url = "http://" + socket.getInetAddress().getHostAddress() + ":"
				   + port;
		}
		catch (Exception ignored)
		{

		}
		return url;
	}


	public String getFileUrl()
	{
		return "http://" + socket.getInetAddress().getHostAddress() + ":"
			   + port + "/" + mMovieFile.getName();
	}

	/**
	 * Start the server.
	 */
	public void start()
	{
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}

	/**
	 * Stop the server.
	 * <p/>
	 * This stops the thread listening to the port. It may take up to five
	 * seconds to close the service and this call blocks until that occurs.
	 */
	public void stop()
	{
		isRunning = false;
		if (thread == null)
		{
			return;
		}
		thread.interrupt();
	}

	/**
	 * Determines if the server is running (i.e. has been <code>start</code>ed
	 * and has not been <code>stop</code>ed.
	 *
	 * @return <code>true</code> if the server is running, otherwise
	 * <code>false</code>
	 */
	public boolean isRunning()
	{
		return isRunning;
	}

	/**
	 * This is used internally by the server and should not be called directly.
	 */
	@Override
	public void run()
	{
		while (isRunning)
		{
			try
			{
				Socket client = socket.accept();
				if (client == null)
				{
					continue;
				}
				ExternalResourceDataSource data = new ExternalResourceDataSource(
					   mMovieFile);
				processRequest(data, client);
			}
			catch (Exception ignored)
			{

			}
		}
	}

	private int findHeaderEnd(final byte[] buf, int rlen)
	{
		int splitbyte = 0;
		while (splitbyte + 3 < rlen)
		{
			if (buf[splitbyte] == '\r' && buf[splitbyte + 1] == '\n'
				   && buf[splitbyte + 2] == '\r' && buf[splitbyte + 3] == '\n')
				return splitbyte + 4;
			splitbyte++;
		}
		return 0;
	}

	private void processRequest(ExternalResourceDataSource dataSource,
						   Socket client) throws IllegalStateException, IOException
	{

		InputStream is = client.getInputStream();

		final int bufsize = 8192;
		byte[] buf = new byte[bufsize];
		int splitbyte = 0;
		int rlen = 0;
		{
			int read = is.read(buf, 0, bufsize);
			while (read > 0)
			{
				rlen += read;
				splitbyte = findHeaderEnd(buf, rlen);
				if (splitbyte > 0)
					break;
				read = is.read(buf, rlen, bufsize - rlen);
			}
		}

		// Create a BufferedReader for parsing the header.
		ByteArrayInputStream hbis = new ByteArrayInputStream(buf, 0, rlen);
		BufferedReader hin = new BufferedReader(new InputStreamReader(hbis));
		String range = decodeHeader(hin, "range");
		cbSkip = 0;
		seekRequest = false;
		if (range != null)
		{
			seekRequest = true;
			range = range.substring(6);
			int charPos = range.indexOf('-');
			if (charPos > 0)
			{
				range = range.substring(0, charPos);
			}
			cbSkip = Long.parseLong(range);
		}
		else
		{
			cbSkip = 0;
			System.out.println("setting seek");
			seekRequest = true;
		}
		String headers = "";
		if (seekRequest)
		{

			headers += "HTTP/1.1 206 Partial Content\n"
				   + "Content-Type: " + dataSource.getContentType() + "\n"
				   + "Accept-Ranges: bytes\n"
				   + "Content-Length: " + dataSource.getContentLength(false)
				   + "\n"
				   + "Content-Range: bytes " + cbSkip + "-"
				   + dataSource.getContentLength(true) + "/*\n"
				   + "\n";
		}
		else
		{
			System.out.println("Not seek request");
		}

		InputStream data = null;
		try
		{
			data = dataSource.createInputStream();
			byte[] buffer = headers.getBytes();
			client.getOutputStream().write(buffer, 0, buffer.length);

			byte[] buff = new byte[1024];
			data.skip(cbSkip);
			int cbSentThisBatch = 0;
			while (isRunning)
			{
				int cbRead = data.read(buff, 0, buff.length);
				if (cbRead == -1)
				{
					data.close();
					data = dataSource.createInputStream();
					cbRead = data.read(buff, 0, buff.length);
					if (cbRead == -1)
					{
						throw new IOException(
							   "Error re-opening data source for looping.");
					}
				}
				client.getOutputStream().write(buff, 0, cbRead);
				client.getOutputStream().flush();
				cbSkip += cbRead;
				cbSentThisBatch += cbRead;

			}
			if (cbSentThisBatch == 0)
			{
				Thread.sleep(1000);
			}
		}
		catch (Exception ignored)
		{
		}
		finally
		{
			if (data != null)
			{
				data.close();
			}
			client.close();
		}
	}

	private String decodeHeader(BufferedReader in, String header)
	{
		try
		{
			String inLine = in.readLine();
			if (inLine == null)
				return null;
			StringTokenizer st = new StringTokenizer(inLine);
			if (st.hasMoreTokens())
			{
				String line = in.readLine();
				while (line != null && line.trim().length() > 0)
				{
					int p = line.indexOf(':');
					if (p >= 0 && line.substring(0, p).trim().equalsIgnoreCase(header))
						return line.substring(p + 1).trim();
					line = in.readLine();
				}
			}

		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		return null;
	}

	/**
	 * provides meta-data and access to a stream for resources on SD card.
	 */
	protected class ExternalResourceDataSource
	{

		private FileInputStream inputStream;

		private final File movieResource;
		long contentLength;
		String mimeType;

		public ExternalResourceDataSource(File resource)
		{
			movieResource = resource;
			contentLength = resource.length();
			mimeType = "mp4";
		}

		public String getContentType()
		{
			return mimeType;
		}

		public InputStream createInputStream()
		{
			getInputStream();
			return inputStream;
		}

		public long getContentLength(boolean ignoreSimulation)
		{
			if (!ignoreSimulation)
			{
				return -1;
			}
			return contentLength;
		}

		private void getInputStream()
		{
			try
			{
				if (inputStream == null)
				{
					inputStream = new FileInputStream(movieResource);
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	}
}