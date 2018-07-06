package com.xiaowuu.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Random;

public class StringUtil {
	/**
	 * 将字符串有某种编码转变成另一种编码
	 * 
	 * @param string
	 *            编码的字符串
	 * @param originCharset
	 *            原始编码格式
	 * @param targetCharset
	 *            目标编码格式
	 * @return String 编码后的字符串
	 */
	public static String encodeString(String string, Charset originCharset,
                                      Charset targetCharset) {
		return string = new String(string.getBytes(originCharset),
				targetCharset);
	}

	/**
	 * URL编码
	 * 
	 * @param string
	 *            编码字符串
	 * @param charset
	 *            编码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String encodeUrl(String string, String charset) {
		if (null != charset && !charset.isEmpty()) {
			try {
				return URLEncoder.encode(string, charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return URLEncoder.encode(string);
	}

	/**
	 * URL编码
	 * 
	 * @param string
	 *            解码字符串
	 * @param charset
	 *            解码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String decodeUrl(String string, String charset) {
		if (null != charset && !charset.isEmpty()) {
			try {
				return URLDecoder.decode(string, charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return URLDecoder.decode(string);
	}

	public static boolean isNull(String string) {
		if (null == string || "".equals(string)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 方法用途: 判断字符串是否是大写 <br>
	 * 实现步骤: <br>
	 * 
	 * @param word
	 * @return true 是 false不是
	 */
	public static boolean isAcronym(String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (Character.isLowerCase(c)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * 方法用途: 判断字符串是否是字母<br>
	 * 实现步骤: <br>
	 * 
	 * @param word
	 * @return true 是 false不是
	 */
	public static boolean isLetter(String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0)
			return true;
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return false;

		return true;
	}

	// 将String 数据转成Sting返回，以逗号分隔。
	public static String array2String(String[] array) {
		String rs = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]).append(",");

		}
		if (sb.length() > 0) {
			rs = sb.substring(0, sb.length() - 1);
		}
		return rs;
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}


	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
