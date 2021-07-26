package study.part7IO.file;


import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class demo01Test {
    public static void main(String[] args) {
        File f1 = new File("/Users/SalmonC/Documents/Coding/MyNotes/Demos/JavaDemos/basic-code/JavaDemo/src");
        getFile(f1);
    }
    public static void getFile(File f1){

        File[] fs = f1.listFiles(f -> f.isDirectory()||f.toString().toLowerCase().endsWith(".java"));
        for(File f : fs){
            if(f.isDirectory())getFile(f);
            else System.out.println(f.getName());
        }
    }

}
