package com.yese.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 拼音工具类
 *
 * @author zqf
 */
public class PinYinUtil {
    /**
     * 将字符串中的中文转换为拼音(小写),其他字符不变
     *
     * @param str
     * @return 拼音(小写)
     */
    public static String getPingYin1(String str) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        char[] input = str.trim().toCharArray();
        StringBuilder output = new StringBuilder();
        try {
            for (char c : input) {
                if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    output.append(temp[0]);
                } else {
                    output.append(Character.toString(c));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    /**
     * 将字符串中的中文转换为拼音且每个字的首字母大写,其他字符不变
     *
     * @param str
     * @return 拼音(首字母大写)
     */
    public static String getPingYin2(String str) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        char[] input = str.trim().toCharArray();
        String[] strings;
        StringBuilder output = new StringBuilder();
        try {
            for (char c : input) {
                // 判断是否为汉字字符
                if (Character.toString(c).matches(
                        "[\\u4E00-\\u9FA5]+")) {
                    strings = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    output.append(strings[0].substring(0, 1).toUpperCase()).append(strings[0].substring(1));
                } else {
                    output.append(c);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output.toString();

    }

    /**
     * 将字符串中的中文转换为每个汉字的小写首字母,其他字符不变
     *
     * @param str
     * @return 小写首字母
     */
    public static String getPinYinHeadChar1(String str) {
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].toLowerCase().charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString();
    }

    /**
     * 将字符串中的中文转换为每个汉字的大写首字母,其他字符不变
     *
     * @param str
     * @return 大写首字母
     */
    public static String getPinYinHeadChar2(String str) {
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].toUpperCase().charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString();
    }


}