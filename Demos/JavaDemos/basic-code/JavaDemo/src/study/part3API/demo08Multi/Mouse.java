package study.part3API.demo08Multi;

public class Mouse implements USB{
    @Override
    public void powerOn() {
        System.out.println("使用鼠标开机");
    }

    @Override
    public void powerOff() {
        System.out.println("使用鼠标关机");
    }

    public void click(){
        System.out.println("点击了一下");
    }
}
