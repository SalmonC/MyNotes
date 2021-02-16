package study.part3API.demo04Static;

public class Student {
    private int id;
    private String name;
    private int age;
    static String room;//其中一个赋值，所有都改变
    private static int idCounter = 0;//学号计数器，每new一个Student，计数器++

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
        this.id = ++idCounter;// 每构造一次，计数器++，并赋值给id
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }
}
