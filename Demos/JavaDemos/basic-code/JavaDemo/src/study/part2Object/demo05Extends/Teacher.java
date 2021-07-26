package study.part2Object.demo05Extends;

public class Teacher extends Employee {
    String name = "te";
    // 自动继承了父类method

    @Override
    public void method(){
        super.method();
        System.out.println("Zi1");
    }

    public Teacher() {
//        super(); 默认赠送
        System.out.println("调用子类构造");
    }

    public Teacher(String name, int age) {
        super();
    }

}
