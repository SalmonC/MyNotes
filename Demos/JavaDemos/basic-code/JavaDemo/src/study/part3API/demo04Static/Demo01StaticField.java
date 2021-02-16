package study.part3API.demo04Static;

public class Demo01StaticField {

    public static void main(String[] args) {
        Student one = new Student("Lily",18);
        Student two = new Student("Tom",19);
        one.room = "101";

        System.out.println(two.room);// 101
    }
}
