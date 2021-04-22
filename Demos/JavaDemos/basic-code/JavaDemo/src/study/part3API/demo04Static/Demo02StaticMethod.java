package study.part3API.demo04Static;

import study.part2Object.demo03This.Person;

public class Demo02StaticMethod {

    public static void main(String[] args) {
//        MyClass obj = new MyClass();
//        obj.method();
//        MyClass.methodStatic();


        Person p1 = new Person("迪丽热巴", 18);
        Person p2 = new Person("迪丽热巴", 18);
        Person p3 = new Person("古力娜扎", 19);
        System.out.println("p1" + p1);
        System.out.println("p2" + p2);
        boolean b = p1.equals(p2);
        String k = p1.toString();
        boolean b2 = k.equals(p2.toString());
        System.out.println(b2);

        System.out.println(b);
    }
}
