package study.part3API.demo02Random;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("请输入上限：");
        System.out.println(ran(new Scanner(System.in).nextInt()));
    }

    public static int ran(int n) {
        Random r = new Random();
        return r.nextInt(n) + 1;
    }

}
