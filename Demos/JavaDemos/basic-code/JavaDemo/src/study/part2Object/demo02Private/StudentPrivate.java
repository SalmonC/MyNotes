package study.part2Object.demo02Private;

public class StudentPrivate {
    String name; //姓名
    private int age; //年龄，private封装

    public void setAge(int num) { //Setter方法，专门用于向age设置数据
        if (num <= 100 && num >= 9) {
            age = num;
        } else {
            System.out.println("数据不合理");
        }
    }

    public int getAge() { //Getter方法，专门用于获取age数据
        return age;
    }

}
