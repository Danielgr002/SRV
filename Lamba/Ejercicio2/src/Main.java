import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Thread> threadList = new ArrayList<>();
        while(true) {
            System.out.println("Dime la posición: ");
            int posicion = scanner.nextInt();
            threadList.add(Thread.ofVirtual().start(() -> {;
                System.out.println("El número en la posicion " + posicion + " de la sucesión de fibonacci es: " + fibonacci(posicion));
            }));
        }
    }

    static int fibonacci(int n){
        return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }
}