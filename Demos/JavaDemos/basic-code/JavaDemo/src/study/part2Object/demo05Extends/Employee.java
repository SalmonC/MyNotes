package study.part2Object.demo05Extends;

public class Employee {

    String name = "emp";
    int age;

    public void method() {
        System.out.println("父方法执行");
    }

    public Employee() {
        System.out.println("调用父类构造");
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
