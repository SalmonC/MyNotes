package study.part3API.demo07Abstract.TestHongbao;

public class Qunzhu extends User {
    public Qunzhu(String name, double yue) {
        super(name, yue);
    }

    public Qunzhu() {
    }

    public void fahongbao(double money) {
        setYue(getYue() - money);
    }
}
