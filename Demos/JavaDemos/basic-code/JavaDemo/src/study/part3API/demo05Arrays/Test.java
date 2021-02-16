package study.part3API.demo05Arrays;

/*
使用Arrays相关API，将随机字符串中所有字符升序排列并倒序打印。
*/

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str = "ahe1iohlasd2312hjl";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[chars.length - 1 - i] + ", ");
        }
    }
}
