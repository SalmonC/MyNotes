package study.part3API.demo02Random;

import java.util.Random;

public class Demo01Random {
    public static void main(String[] args) {


        Random r = new Random();
        int num = r.nextInt(5);
        System.out.println("随机数是："+ num);
    }
}
