package study.part3API.demo09InnerClass;

public class Body {
    public class Heart{// 内部类

        public void beat(){
            System.out.println("心脏跳动");
            System.out.println("name = " + name);
        }

    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //构造方法
    public Body(String name) {
        this.name = name;
    }

    public Body() {
    }

    public void methodBody(){ // 外部方法
        System.out.println("调用外部类方法");
        new Heart().beat();
    }
}
