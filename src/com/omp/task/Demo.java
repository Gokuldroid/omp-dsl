package com.omp.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gokul-4192.
 */
public class Demo
{
	public static void main(String[] args)
	{
		String i18n = "Gokul {{o365.input.component}} Hello";
		Pattern pattern = Pattern.compile("(?<start>.*\\{\\{)(?<i18n>[a-z.].*)(?<end>\\}\\}.*)");
		Matcher matcher = pattern.matcher(i18n);
		if (matcher.matches())
		{
			System.out.println(matcher.group("i18n"));
		}
	}
}
