package study.part2Object.demo02Private;

public class Deme04GetPrivate {
    public static void main(String[] args) {
        StudentPrivate sp = new StudentPrivate();
        System.out.println("我叫：" + sp.name + "，年龄：" + sp.getAge());
        System.out.println("=================");

        sp.name = "刘德华";
        sp.setAge(-25);
        System.out.println("我叫：" + sp.name + "，年龄：" + sp.getAge());
        System.out.println("=================");

        sp.setAge(25);
        System.out.println("我叫：" + sp.name + "，年龄：" + sp.getAge());
        System.out.println("=================");
    }
}
