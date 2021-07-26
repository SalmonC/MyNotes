package study.part5.demo01Synchronized;

public class RunnableImpl implements Runnable{
    Object obj = new Object();
    int ticket = 100;
    @Override
    public void run() {
        synchronized (obj){
            while(true){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName() + "正在卖第"+ticket--+"张票");
                }
            }
        }
    }
}
