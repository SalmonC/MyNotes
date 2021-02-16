package study.part2Object.demo01Object;

public class Demo02StudentParam {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "Lily";
        method(stu);
    }

    public static void method(Student param) {
        System.out.println(param.name);
    }
}
