package study.part7IO.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo02Copy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/SalmonC/Documents/Coding/Demos/JavaDemos/basic-code/1.jpeg");
        FileOutputStream fos = new FileOutputStream("/Users/SalmonC/Documents/Coding/Demos/JavaDemos/basic-code/2.jpeg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();

    }
}
