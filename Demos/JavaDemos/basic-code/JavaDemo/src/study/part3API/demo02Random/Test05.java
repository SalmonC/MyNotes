package study.part3API.demo02Random;

import java.util.ArrayList;
import java.util.Random;

public class Test05 {
    public static void main(String[] args) {
        //创建大集合
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(new Random().nextInt());
        }
        System.out.println(list1);
        //添加20个随机数
        ArrayList<Integer> list2 =isOdd(list1);

        System.out.println("所有的偶数是：" + list2);
    }

    public static ArrayList<Integer> isOdd(ArrayList<Integer> list) {

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            if (temp %2 ==0) {
                list2.add(temp);
            }
        }
        return list2;
    }
}
