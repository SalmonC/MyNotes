package study.part3API.demo03String;

public class Demo01create {
    public static void main(String[] args) {
        //构造方法1
        String str1 = new String();
        System.out.println(str1);
        System.out.println("=============");

        //2
        char[] charArray = {'a', 'b', 'c'};
        String str2 = new String(charArray);
        System.out.println(str2);
        System.out.println("=============");

        //3
        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println(str3);
        System.out.println("=============");

        //直接创建
        String str4 = "abc";
        System.out.println(str4);
    }
}
