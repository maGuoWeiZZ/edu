package com.edu.utils;

//web工具类
public class WebUtils {

    public static Integer toInteger(String str){
        try {
            if (str != null) {
                int value = Integer.parseInt(str);
                return value;
            }
        } catch (NumberFormatException e) {
//            出现转换异常返回默认值0
            return 0;
        }
        return 0;
    }

}
