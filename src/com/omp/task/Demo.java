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
		System.out.println("Go'kul".replace("'","\\'"));

	}

	static int i = 0;

	public static void demoApp(JSONObject jsonObject)
	{
		i += jsonObject.length();
	}
}
