package study.part3API.demo02Random;

import java.util.ArrayList;

public class Demo03ArrayList {
    public static void main(String[] args) {
        // 创建了一个ArrayList集合，里面全都是String类型的数据
        // 备注：从JDK1.7开始，右侧尖括号内部可以不写内容，但<>本身还是要写的。
        ArrayList<String> list = new ArrayList<>();

        System.out.println(list);
        System.out.println("===========");

        //向集合中添加数据需要用到add方法。
        list.add("666");
        System.out.println(list);

        //泛型规定了是字符串，就只能添加字符串
        //list.add(123);
        list.add("123");
        list.add("111");

        list.remove(0);
        System.out.println(list);
    }
}
