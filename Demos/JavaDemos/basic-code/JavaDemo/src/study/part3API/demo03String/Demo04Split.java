package study.part3API.demo03String;

public class Demo04Split {
    public static void main(String[] args) {
        String str1 = "aaa,bbb,ccc";
        String[] strArray = str1.split(","); // {"aaa","bbb","ccc"}
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
    }
}
