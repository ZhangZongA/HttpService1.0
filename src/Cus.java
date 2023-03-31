import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cus {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",10086);

        //读取本地文件

        BufferedInputStream bi=new BufferedInputStream(new FileInputStream("D:\\java\\demo\\HttpService1.0\\src\\image1.png"));
        BufferedOutputStream bo=new BufferedOutputStream(socket.getOutputStream());

        byte[] bytes=new byte[1024];
        int b;
        while((b=bi.read(bytes))!=-1)
        {
            bo.write(bytes,0,b);
        }


        //网服务器写结束标记
        bo.flush(); //在bo写的过程中，只会先写到buffer缓冲区中  在调用flush 或者  close才会把缓冲区中的 内容写出去
        socket.shutdownOutput();
        bo.close();
        bi.close();socket.close();
    }
}
