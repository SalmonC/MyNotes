package study.part3API.demo07Abstract.TestHongbao;

public abstract class User {
    private String name;
    private double yue;

    public double getYue() {
        return yue;
    }

    public void show(){
        System.out.println(name + "的余额是:" + yue);
    }

    public void setYue(double yue) {
        if (yue >= 0) {
            this.yue = yue;
        } else {
            System.out.println("余额不足！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User(String name, double yue) {
        this.name = name;
        this.yue = yue;
    }

    public User() {
    }
}
