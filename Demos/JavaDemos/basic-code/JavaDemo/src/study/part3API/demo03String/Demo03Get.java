package study.part3API.demo03String;

public class Demo03Get {
    public static void main(String[] args) {
        //创建"hello"
        String str1 = "Hello";
        System.out.println(str1.length());
        System.out.println("=========");

        //添加"java"
        String str2 = str1.concat("Java");
        System.out.println(str2);
        System.out.println("=========");

        //获取J
        System.out.println(str2.charAt(5));
        System.out.println("=========");

        //查找W的位置
        System.out.println(str2.indexOf("W"));
    }
}
