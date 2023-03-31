import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpTest {


    public static void main(String[] args) throws IOException {
        ServerSocket sc=new ServerSocket(10086);
        ExecutorService threads= Executors.newFixedThreadPool(30);
        while(true)
        {
            Socket accept = sc.accept();

            threads.execute(new Service(accept));
        }

    }
}
