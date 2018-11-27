package com.mmall.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    public static List<Integer> splitToListInt(String str) {
        List<String> strList =
                Splitter.on(",") // 以逗号为分隔符
                .trimResults() // 去掉前后空格
                .omitEmptyStrings() // 移除空字符串
                .splitToList(str); // 转化为list
        return strList.stream().map(strItem -> Integer.parseInt(strItem)).collect(Collectors.toList());
    }
}
