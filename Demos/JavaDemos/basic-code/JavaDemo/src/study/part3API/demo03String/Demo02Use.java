package study.part3API.demo03String;

public class Demo02Use {
    public static void main(String[] args) {
        String str1 = "Hello";
        str1 = "abc";
        String str2 = "Hello";
        str2 = "abc";
        char[] charArray = {'H','e','l','l','o'};
        String str3 = new String(charArray);

        System.out.println(str1 == str2);
        System.out.println(str1 == "abc");

        System.out.println(str1.equals(str3));
        System.out.println(str1.equals("Hello"));
        System.out.println("Hello".equals(str2));

    }
}
