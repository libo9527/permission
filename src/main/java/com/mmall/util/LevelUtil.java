package com.mmall.util;


import org.apache.commons.lang3.StringUtils;

/**
 * @Description：
 * @Auther： libo
 * @date： 2018/11/21:17:27
 */
public class LevelUtil {

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    // 0
    // 0.1
    // 0.1.2
    public static String calculateLevel(String parentLevel, int parentId){
        if (StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
