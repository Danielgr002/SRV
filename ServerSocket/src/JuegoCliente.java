import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class JuegoCliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.2.1.175", 9099);

        PrintWriter writer1 = new PrintWriter(socket.getOutputStream(), true);
        var socketreader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        var scanner = new Scanner(System.in);
        while (true){
            var mensaje = socketreader1.readLine();
            System.out.println(mensaje);

            if (mensaje.contains("👊 Piedra (1)")){
                var hand = scanner.nextLine();
                writer1.println(hand);
            }
        }
    }
}
