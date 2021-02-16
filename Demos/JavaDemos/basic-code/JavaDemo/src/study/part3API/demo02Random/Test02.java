package study.part3API.demo02Random;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        System.out.print("输入上限：");
        int max = new Scanner(System.in).nextInt();
        int target = getRanNum(max);
        int num, min = 0;
        System.out.println("范围是" + min + "~" + max);
        // 可以直接while(true)，break！！
        do {
            System.out.print("请输入猜测：");
            num = new Scanner(System.in).nextInt();
            if (num == target) {
                System.out.println("你猜对了");
            } else if (num >= target) {
                max = num;
                System.out.println("范围是" + min + "~" + max);
            } else {
                min = num;
                System.out.println("范围是" + min + "~" + max);
            }
        } while (num != target);
    }

    public static int getRanNum(int max) {
        return new Random().nextInt(max);
    }

}
