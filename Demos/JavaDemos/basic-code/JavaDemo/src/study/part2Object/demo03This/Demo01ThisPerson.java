package study.part2Object.demo03This;

public class Demo01ThisPerson {
    public static void main(String[] args) {
        Person per = new Person();
        per.name = "王健林";

        per.sayHello("马云");
        //per调用了sayHello，sayHello里的this指per，this.name指per.name。
    }
}
