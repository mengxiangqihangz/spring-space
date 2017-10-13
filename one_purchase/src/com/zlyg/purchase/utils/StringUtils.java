package com.zlyg.purchase.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 判断对象是否为空，或者无具体值，包括字符串为null或者空字符串，集合为空集合，数组为空数组的情况
	 * 
	 * @param objs
	 *            要判断的对象
	 * @return 不为空时返回true
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Object... objs) {
		if (objs == null) {
			return false;
		}
		for (int i = 0; i < objs.length; i++) {
			if (objs[i] == null) {
				return false;
			}
			if ((objs[i] instanceof String)
					&& "".equals(((String) objs[i]).trim())) {
				return false;
			}
			if ((objs[i] instanceof Collection && ((Collection) objs[i]).size() == 0)) {
				return false;
			}
		}
		return true;
	}

	public static boolean matches(String regex, String... str) {
		Pattern pattern = Pattern.compile(regex);
		if (str == null) {
			return false;
		}
		for (int i = 0; i < str.length; i++) {
			if (str[i] == null) {
				return false;
			}
			Matcher m = pattern.matcher(str[i]);
			if (!m.matches()) {
				return false;
			}
		}
		return true;
	}

	public static String firstToUpperCase(String str) {
		char[] chars = str.toCharArray();
		if (chars.length > 0 && chars[0] >= 'a' && chars[0] <= 'z') {
			chars[0] = (char) (chars[0] - 'a' + 'A');
		}
		return new String(chars);
	}

	public static String firstToLowerCase(String str) {
		char[] chars = str.toCharArray();
		if (chars.length > 0 && chars[0] >= 'A' && chars[0] <= 'Z') {
			chars[0] = (char) (chars[0] - 'A' + 'a');
		}
		return new String(chars);
	}

	/**
	 * 判断字符串是不是为空(NULL 或者"" 或者 "  ").
	 * 
	 * @param str
	 *            要处理的字符串.
	 * @return 如果字符串没有内容,则返回true.
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().equals(""));
	}

	public static String stringName(String str) {
		String[] value = str.split("=");

		if (value.length > 0) {
			return value[0].trim();
		}

		return "";
	}

	public static String stringValue(String str) {
		String[] value = str.split("=");

		if (value.length > 1) {
			return value[1].trim();
		}

		return "";
	}

	public static String stringValue(String str, String name, String sept) {
		return stringValue(str, name, sept, true);
	}

	public static String stringValue(String str, String name, String sept,
			Boolean valueTrim) {
		// 获取分隔符号分开的参数定义(name=value)
		String[] paramList = str.split(sept);

		for (String prm : paramList) {
			// 分析(name=value)
			String[] vals = prm.split("=");
			String n = "";

			if (vals.length > 0) {
				n = vals[0].trim(); // name
			}

			if (n.equals(name)) {
				if (vals.length > 1) {
					if (valueTrim) {
						return vals[1].trim(); // value
					} else {
						return vals[1];
					}
				}
			}

		}

		return "";
	}

	public static byte[] toBytes(String source, int len) {
		byte[] original, result = new byte[len];
		original = toBytes(source);

		if (original.length > len) {
			copyTo(original, result);
		} else {
			Arrays.fill(result, (byte) 0);
			copyTo(original, result);
		}

		return result;
	}

	public static void copyTo(byte[] source, byte[] dest) {
		int length = (source.length > dest.length ? dest.length : source.length);

		for (int i = 0; i < length; i++) {
			dest[i] = source[i];
		}
	}

	/**
	 * 转换为字符串二进制流
	 * 
	 * @param source
	 *            String
	 * @return byte[]
	 */
	public static byte[] toBytes(String source) {
		byte[] result = null;

		try {
			result = source.getBytes();
		} catch (Exception e) {
//			log.error(ExceptionUtils.getStackTrace(e));
			// result = source.getBytes();
		}

		return result;
	}

	/**
	 * 二进制流转换为字符串
	 * 
	 * @param source
	 *            byte[]
	 * @return String
	 */
	public static String parse(byte[] sources) {
		return new String(sources);
	}

	public static String toHexString(byte[] source) {
		StringBuffer buffer = new StringBuffer("");

		for (int i = 0; i < source.length; i++) {
			buffer.append(Integer.toHexString(source[i]));
		}

		return buffer.toString();
	}

	public static String replace(String source, String oldStr, String newStr) {
		String result = source;
		int index = source.indexOf(oldStr);

		if (index >= 0) {
			String begin = source.substring(0, index);
			String end = source.substring(index + oldStr.length());
			result = begin + newStr + end;
		}

		return result;
	}

	public static boolean containsChs(String value) {
		Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
		return pattern.matcher(value).find();
	}

	public static boolean allIsAscii(String value) {
		Pattern pattern = Pattern.compile("[^\\x00-\\x7f]+");
		return !pattern.matcher(value).find();
	}

	public static boolean allIsPrintAscii(String value) {
		Pattern pattern = Pattern.compile("[^\\x21-\\x7f]+");
		return !pattern.matcher(value).find();
	}

	/**
	 * 将逗号隔开的多个长整型数字组成的字符串转化,如"1,2,3"=>{1,2,3}
	 * 
	 * @param ids
	 * @return
	 */
	public static List<Long> ids2Long(String ids) {
		List<Long> list = new ArrayList<>();
		String[] ss = ids.split(",");
		for (String s : ss) {
			if (s.matches("\\d+")) {
				Long l = Long.parseLong(s);
				list.add(l);
			}
		}
		return list;
	}

	/**
	 * 将逗号隔开的多个长整型数字组成的字符串转化,如"1,2,3"=>{1,2,3}
	 * 
	 * @param ids
	 * @return
	 */
	public static List<Integer> ids2Int(String ids) {
		List<Integer> list = new ArrayList<>();
		String[] ss = ids.split(",");
		for (String s : ss) {
			if (s.matches("\\d+")) {
				Integer l = Integer.parseInt(s);
				list.add(l);
			}
		}
		return list;
	}
	public static String cutString(String str,int len){
		if(null != str && str.length() > len){
			return str.substring(0, len);
		}
		return str;
	}
	/**
	 * 将数字列表按逗号分割成字符串,如{1,2,3}=>"1,2,3"
	 * 
	 * @param ids
	 * @return
	 */
	public static String num2Ids(List<? extends Number> list) {
		StringBuilder s = new StringBuilder();
		for (Number l : list) {
			s.append(l + ",");
		}
		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}
		return s.toString();
	}

	/**
	 * 与 {@link #ids2Long(String)} 相反
	 * 
	 * @param ids
	 * @return
	 */
	public static String long2Ids(List<Long> list) {
		return num2Ids(list);
	}

	 /**
     * 查找字符串pattern在str中第一次出现的位置
     * @param str
     * @param pattern
     * @return
     */
    public static int firstIndexOf(String str, String pattern) {
        for (int i = 0; i < (str.length() - pattern.length()); i++) {
            int j = 0;
            while (j < pattern.length()) {
                if (str.charAt(i + j) != pattern.charAt(j)) break;
                j++;
            }
            if(j==pattern.length()) return  i;
        }
        return -1;
    }
	public static void main(String[] args) {
		// String s = "nihao";
		// System.out.println(s + " == " + containsChs(s));
		// s = "ni好hao";
		// System.out.println(s + " == " + containsChs(s));
		// s = "好hao";
		// System.out.println(s + " == " + containsChs(s));
		// s = "ni好";
		// System.out.println(s + " == " + containsChs(s));
		// s = "  fdds分隔符好hao";
		// System.out.println(s + " == " + containsChs(s));

		String s = "nihao";
		System.out.println(s + " == " + allIsPrintAscii(s));
		s = "ni好hao";
		System.out.println(s + " == " + allIsPrintAscii(s));
		s = "好hao";
		System.out.println(s + " == " + allIsPrintAscii(s));
		s = "ni好";
		System.out.println(s + " == " + allIsPrintAscii(s));
		s = "分隔符好";
		System.out.println(s + " == " + allIsPrintAscii(s));
	}

}
