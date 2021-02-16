package study.part3API.demo01Scanner;

import java.util.Scanner;

public class QuizScannerSum {
    public static void main(String[] args) {
        Scanner scsum = new Scanner(System.in);
        System.out.print("请输入数字1:");
        int num1 = scsum.nextInt();
        System.out.print("请输入数字2:");
        int num2 = scsum.nextInt();
        int sum = num1 + num2;
        System.out.println("它们的和是：" + sum);

    }
}
