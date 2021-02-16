package study.part3API.demo03String;

public class Test01 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        String str = strConcat(array);
        System.out.println(str);
    }

    public static String strConcat(int[] intArray) {
        String target = "[";
        for (int i = 0; i < intArray.length - 1; i++) {
            target += "word" + intArray[i] + "#";
        }
        target += "word" + intArray[intArray.length-1]+ "]";

        return target;
    }
}
