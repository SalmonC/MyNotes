package study.part2Object.demo04New;

public class demo01Student {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("1");
        stu1.setAge(1);
        System.out.println("我叫" + stu1.getName() + "，年龄是" + stu1.getAge());

        System.out.println("================");
        Student stu2 = new Student("马云", 88);
        System.out.println("我叫" + stu2.getName() + "，年龄是" + stu2.getAge());

        System.out.println("================");
        stu2.setAge(90);
        stu2.setName("风清扬");
        System.out.println("我叫" + stu2.getName() + "，年龄是" + stu2.getAge());

    }
}
