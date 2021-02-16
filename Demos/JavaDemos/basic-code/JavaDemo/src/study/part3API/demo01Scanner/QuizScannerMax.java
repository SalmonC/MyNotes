package study.part3API.demo01Scanner;

import java.util.Scanner;

public class QuizScannerMax {
    public static void main(String[] args) {

        Scanner scmax = new Scanner(System.in);

        System.out.print("请输入第一个数字：" );
        int num1 = scmax.nextInt();
        System.out.print("请输入第一个数字：" );
        int num2 = scmax.nextInt();
        int max = num1 > num2 ? num1 : num2;
        System.out.print("请输入第三个数字：" );
        int num3 = scmax.nextInt();
        max = max > num3 ? max : num3;
        System.out.println("最大的数字是："+ max);

    }
}
