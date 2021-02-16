package study.part3API.demo01Scanner;
import java.util.Scanner;

public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// 代表从键盘进行输入
        int num = sc.nextInt();
        System.out.println("输入的数字是："+ num);

        String str = sc.next();
        System.out.println("输入的字符串是："+ str);
    }
}
