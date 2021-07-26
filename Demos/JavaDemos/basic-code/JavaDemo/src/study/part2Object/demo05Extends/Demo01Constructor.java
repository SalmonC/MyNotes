package study.part2Object.demo05Extends;

public class Demo01Constructor {
    public static void main(String[] args) {
        Employee a = new Teacher();
        System.out.println("======");
        System.out.println(a.name);
        System.out.println("======");
        a = (Teacher) a;
        System.out.println(a instanceof Teacher2);
    }
}
