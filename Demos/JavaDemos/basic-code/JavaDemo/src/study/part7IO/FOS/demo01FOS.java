package study.part7IO.FOS;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class demo01FOS {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt", true);
        fos.write("cao".getBytes());
        fos.close();
    }
}
