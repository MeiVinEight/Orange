package org.orange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings
{
	private static final Pattern SINGLE_ARGUMENT = Pattern.compile("^[\\S]*[ \\r\\n]*");

	/**
	 * 删掉字符串的第一个可见子串和后面紧跟的不可见子串<br/>
	 * arg1 arg2 arg3 -> arg2 arg3<br/>
	 * 特别的，当字符串为空或只有一个可见子串时返回空字符串<br/>
	 * 当字符串以空格或换行等不可见字符开头时仅删除开头的不可见子串
	 *
	 * @param str 原字符串
	 * @return 处理后的字符串
	 */
	public static String cut(String str)
	{
		Matcher matcher = SINGLE_ARGUMENT.matcher(str);
		if (matcher.find())
		{
			int sub = matcher.end();
			if (str.length() > sub)
			{
				return str.substring(sub);
			}
			else
			{
				return "";
			}
		}
		else
		{
			return "";
		}
	}
}
