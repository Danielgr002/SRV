import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JuegoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5009);
        Socket socket1 = server.accept();

        PrintWriter writer1 = new PrintWriter(socket1.getOutputStream(), true);
        var socketreaser1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));

        writer1.write("Waiting for player2...");

        Socket socket2 = server.accept();

        PrintWriter writer2 = new PrintWriter(socket2.getOutputStream(), true);
        var socketreaser2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));

        writer1.write("GAME START");
        writer2.write("GAME START");

        int winsP1 = 0;
        int winsP2 = 0;

        while (true){
            writer1.write("SACAR MANO: 👊 Piedra (1) 👋 Papel (2) ✌Tijeras (3)");

            writer2.write("SACAR MANO: 👊 Piedra (1) 👋 Papel (2) ✌Tijeras (3)");

            var hand1 = socketreaser1.readLine();
            var hand2 = socketreaser2.readLine();
            if (hand1.equals(hand2)){
                writer1.write("EMPATE");
                writer2.write("EMPATE");
            } else if (hand1.equals("1") && hand2.equals("3") || hand1.equals("2") && hand2.equals("1") || hand1.equals("3") && hand2.equals("2")){
                winsP1++;
                writer1.write("YOU WIN");
                writer2.write("YOU LOSE");
            } else {
                winsP2++;
                writer1.write("YOU LOSE");
                writer2.write("YOU WIN");
            }
            writer1.write("PUNTUACION P1: "+winsP1 +" PUNTUACION P2: "+winsP2);
            writer1.write("PUNTUACION P1: "+winsP1 +" PUNTUACION P2: "+winsP2);
        }

        //hashmap strngList (Ej. ex2)
        // copywwiterarrayList
    }
}
