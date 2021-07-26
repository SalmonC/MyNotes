package study.part6Lambda.person;

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {
        Person[] ars = {
                new Person("张三",19),
                new Person("zs",23),
                new Person("ww",21)
        };
        Arrays.sort(ars, (Person o1, Person o2) -> {return o1.getAge() - o2.getAge();});
        for (int i = 0; i < ars.length; i++) {
            System.out.println(ars[i]);
        }
    }
}
