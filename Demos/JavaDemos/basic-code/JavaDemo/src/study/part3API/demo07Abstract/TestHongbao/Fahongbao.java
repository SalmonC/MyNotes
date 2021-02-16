package study.part3API.demo07Abstract.TestHongbao;

import java.util.Scanner;

public class Fahongbao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Qunzhu qz = new Qunzhu("张三", 500);
        Chengyuan cy1 = new Chengyuan("李四",123);
        Chengyuan cy2 = new Chengyuan("王五",1294);

//        输入红包信息
        System.out.println("输入红包金额：");
        double money = sc.nextInt();
        System.out.println("输入红包个数：");
        int n = sc.nextInt();

//        进行发红包操作
        qz.fahongbao(money);
        cy1.qianghongbao(money,n);
        cy2.qianghongbao(money,n);

//        输出现在状态
        qz.show();
        cy1.show();
        cy2.show();
    }
}
