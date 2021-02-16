package study.part2Object.demo05Extends;

public class Demo01Constructor {
    public static void main(String[] args) {
        Teacher2 a = new Teacher2();
        System.out.println("======");
        a.method();
        System.out.println("======");

        System.out.println(a.age);// 0, 不是18
    }
}
