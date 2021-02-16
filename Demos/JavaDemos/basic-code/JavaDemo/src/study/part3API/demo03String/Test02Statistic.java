package study.part3API.demo03String;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test02Statistic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str1 = sc.next();
        int cap = 0, low = 0, num = 0, other = 0;
        char[] bA = str1.toCharArray();
        for (int i = 0; i < bA.length; i++) {
            char b = bA[i];
            //判断种类
            if (bA[i] >= '0' && bA[i] <= '9') {
                num += 1;
            } else if (bA[i] >= 'a' && bA[i] <= 'z' ) {
                low += 1;
            } else if (bA[i] >= 'A' && bA[i] <= 'Z') {
                cap += 1;
            } else {
                other += 1;
            }
        }

        System.out.printf("大写字母个数：%d，小写字母个数：%d，数字个数：%d，其他字符个数：%d。",cap,low,num,other);

    }
}
