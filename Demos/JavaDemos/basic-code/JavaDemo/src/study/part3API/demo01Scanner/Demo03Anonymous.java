package study.part3API.demo01Scanner;

import java.util.Scanner;

public class Demo03Anonymous {
    public static void main(String[] args) {
        /*普通使用方式
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();*/

        /*匿名对象方式
        int num = new Scanner(System.in).nextInt();*/

        /*使用一般方法传参
        Scanner sc = new Scanner(System.in);
        methodParam(sc);*/

        //使用匿名对象传参
        methodParam(new Scanner(System.in));
    }

    public static void methodParam(Scanner sc) {
        int i = sc.nextInt();
        System.out.println("输入的是：" + i);
    }

    public static Scanner methodReturn(){
//        Scanner sc = new Scanner(System.in);
//        return sc;
        return new Scanner(System.in);
    }
}
