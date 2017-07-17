package cn.feng.utils;

import org.junit.Test;

import java.util.regex.Pattern;

public class ValidateUtils {


    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }


    @Test
    public void test() {

        int maxValue = Integer.MAX_VALUE;

        maxValue += 1;
        System.out.println(ValidateUtils.isNumber((maxValue + 1) + ""));
    }
}	
