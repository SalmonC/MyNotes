package study.part3API.demo02Random;

import java.util.Random;

public class Demo02RamdomBound {
    public static void main(String[] args) {
        Random r = new Random();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += r.nextInt(10);
        }
        double avg = sum /1000.0;
        System.out.println(avg);
    }
}
