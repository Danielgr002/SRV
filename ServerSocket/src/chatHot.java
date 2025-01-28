import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class chatHot {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket socket = server.accept();
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                executor.submit(() -> {
                    DataOutputStream writer;
                    try {
                        writer = new DataOutputStream(socket.getOutputStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.write("Petición recibida y aceptada".getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                executor.submit(() -> {
                    String mensajeServidor;
                    try {
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while ((mensajeServidor = entrada.readLine()) != null) {
                            System.out.println(mensajeServidor);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }
}
