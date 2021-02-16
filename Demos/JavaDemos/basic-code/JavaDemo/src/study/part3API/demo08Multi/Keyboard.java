package study.part3API.demo08Multi;

public class Keyboard implements USB{
    @Override
    public void powerOn() {
        System.out.println("使用键盘开机");
    }

    @Override
    public void powerOff() {
        System.out.println("使用键盘关机");
    }

    public void type(){
        System.out.println("敲击了一下");
    }
}
