package study.part3API.demo08Multi;

public class DemoMain {
    public static void main(String[] args) {
        //创建电脑
        Laptop lap = new Laptop();
        lap.powerOn();

        //先进行向上转型,左边是接口,右边是实现类.
        USB usb1 = new Mouse();
        lap.useDevice(usb1);
        usb1.powerOn();
        usb1 = (Mouse) usb1;
        ((Mouse) usb1).click();
        usb1.powerOff();

        lap.powerOff();
    }
}
