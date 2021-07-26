package study.part5.demo01Synchronized;

public class Sell {
    public static void main(String[] args) {
        Runnable r1 = new RunnableImpl();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t3.start();
        t2.start();
    }
}
