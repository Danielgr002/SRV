import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class Ej2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8338);
        while (true) {
            Socket socket = server.accept();
            try (var executor =Executors.newVirtualThreadPerTaskExecutor()) {
                executor.submit(()-> {
                    try {
                        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                        Thread.sleep(5000);
                        writer.println("Hola mundo");
                        writer.close();
                        socket.close();
                    }catch (IOException e){
                        System.out.println("Error");
                    } catch (InterruptedException e) {
                        System.out.println("Error");
                    }
                });
            }
        }
    }
}
