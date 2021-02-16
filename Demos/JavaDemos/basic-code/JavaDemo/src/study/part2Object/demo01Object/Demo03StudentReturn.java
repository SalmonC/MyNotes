package study.part2Object.demo01Object;

public class Demo03StudentReturn {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.age = 18;
        System.out.println(ageAfter(stu).age);
    }
    public static Student ageAfter(Student after){//返回一个Student类型的对象
        after.age +=5;
        return after;
    }
}
