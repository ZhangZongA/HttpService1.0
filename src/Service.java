import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.UUID;

public class Service implements Runnable{
    private Socket CusSocket;




    public Service(Socket CusSocket )
    {
        this.CusSocket=CusSocket;

    }

    public  void LinkCus(Socket CusSocket) throws IOException {
        String str= UUID.randomUUID().toString().replace("-","");
        BufferedInputStream bf=new BufferedInputStream( CusSocket.getInputStream());
        BufferedOutputStream bo=new BufferedOutputStream(new FileOutputStream("D:\\java\\demo\\HttpService1.0\\image\\"+str+".png"));

        byte [] bytes=new byte[1024];
        int b;
        while((b=bf.read(bytes))!=-1)
        {
          bo.write(bytes,0,b);

        }

    bo.close();
        bf.close();
         CusSocket.close();


    }









    @Override
    public void run() {
        try {
            LinkCus(CusSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
