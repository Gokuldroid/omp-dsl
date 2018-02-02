package com.omp.task;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * Created by gokul-4192.
 */
public class Demo
{
	public static void main(String[] args) throws Exception
	{
		Class<?> extHDTDBCustomValueHandlerClass = Class.forName("com.omp.task.Demo");
		Class<?>[] argTypes = new Class[]{JSONObject.class};
		Method extDBCustomValueHandlerMethod = extHDTDBCustomValueHandlerClass.getMethod("demoApp", argTypes);// No I18N


		JSONObject jsonObject = new JSONObject();
		Stopwatch watch = Stopwatch.createStarted();
		for (int i = 0; i < 10000; i++)
		{
			extDBCustomValueHandlerMethod.invoke(null,jsonObject);
		}
		System.out.println(watch.elapsed(TimeUnit.MICROSECONDS));

		watch = Stopwatch.createStarted();
		for (int i = 0; i < 10000; i++)
		{
			demoApp(jsonObject);
		}

		System.out.println(watch.elapsed(TimeUnit.MICROSECONDS));

	}

	static int i = 0;

	public static void demoApp(JSONObject jsonObject)
	{
		i += jsonObject.length();
	}
}
