package study.part2Object.demo05Extends;

public class Teacher2 extends Teacher {
    public Teacher2() {
        System.out.println("调用子2类");
    }

    @Override
    public void method(){
        super.method();
        System.out.println("zi2");

    }
}
