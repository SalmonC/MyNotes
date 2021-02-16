package study.part3API.demo08Multi;

public class Laptop {
    public void powerOn(){
        System.out.println("PowerOn");
    }

    public void powerOff(){
        System.out.println("PowerOff");
    }

    public void useDevice(USB dev){ //使用接口作为方法的参数
        if(dev instanceof Keyboard){
            System.out.println("Using Keyboard");
            ((Keyboard) dev).type();
        }else if(dev instanceof Mouse){
            System.out.println("Using Mouse");
        }
    }
}
