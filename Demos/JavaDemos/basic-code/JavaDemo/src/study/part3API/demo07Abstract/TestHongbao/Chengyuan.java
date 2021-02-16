package study.part3API.demo07Abstract.TestHongbao;

public class Chengyuan extends User {
    public void qianghongbao(double money, int n) {
        setYue(getYue() + money / n);
    }

    public Chengyuan(String name, double yue) {
        super(name, yue);
    }

    public Chengyuan() {
    }
}
