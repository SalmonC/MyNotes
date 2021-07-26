package study.part8Web.demo01Upload;

import java.io.*;
import java.net.Socket;

public class Demo01Socket {
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("127.0.0.1", 8888);
        OutputStream os = sc.getOutputStream();
        InputStream is = sc.getInputStream();
        byte[] b = new byte[1024];
        FileInputStream fis = new FileInputStream("/Users/SalmonC/Documents/Coding/Demos/JavaDemos/basic-code/1.jpeg");
        int len = 0;
        while((len = fis.read(b)) != -1){
            os.write(b, 0, len);
        }
        sc.shutdownOutput();
        while((len = is.read(b)) != -1){

            System.out.println(new String(b, 0, len));
        }

        sc.close();
        fis.close();
    }


}
