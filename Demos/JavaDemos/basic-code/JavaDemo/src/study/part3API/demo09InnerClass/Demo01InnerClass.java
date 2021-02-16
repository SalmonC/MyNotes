package study.part3API.demo09InnerClass;

public class Demo01InnerClass {

    // 间接访问
    public static void main(String[] args) {
        Body body = new Body();
        body.methodBody();

        // 直接访问
        Body.Heart heart = new Body("abc").new Heart();
        heart.beat();
    }

}
