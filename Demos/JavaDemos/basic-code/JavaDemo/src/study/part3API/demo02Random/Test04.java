package study.part3API.demo02Random;

import java.util.ArrayList;

public class Test04 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("0");
        students.add("1");
        students.add("2");
        students.add("3");
        System.out.println(students);
        printAL(students);

    }

    public static void printAL(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + "@");
        }
        System.out.println(list.get(list.size() - 1) + "}");
    }
}
