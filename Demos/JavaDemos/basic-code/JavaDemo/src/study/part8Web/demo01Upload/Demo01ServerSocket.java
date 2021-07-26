package study.part8Web.demo01Upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo01ServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        FileOutputStream fos = new FileOutputStream(
                "/Users/SalmonC/Documents/Coding/Demos/Upload/1.jpeg");
        byte[] b = new byte[1024];
        int len = 0;
        while((len = is.read(b))!= -1){
            fos.write(b, 0, len);
        }
        os.write("上传成功".getBytes());

        ss.close();
        s.close();
        fos.close();
    }
}
