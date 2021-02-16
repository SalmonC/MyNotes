package study.part3API.demo06Math;

// 计算在-10.8到5.9之间,绝对值大于6或者小于2.1整数有多少个?
public class Test {

    public static void main(String[] args) {
        int count = 0;
        double min = -10.8;
        double max = 5.9;
        for (double i = Math.ceil(min); i < max; i++) {
            if (Math.abs(i) > 6 || Math.abs(i) < 2.1) {
                count++;
            }
        }
        System.out.println("count = " + count);
    }

}
