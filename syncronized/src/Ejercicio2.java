import java.util.concurrent.Executors;

public class Ejercicio2 {
    static Object o1 = new Object();
    static Object o2 = new Object();
    static Object o3 = new Object();
    static Object o4 = new Object();

    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(Ejercicio2::rojoynegro);
            executor.submit(Ejercicio2::rojoynegro);
            executor.submit(Ejercicio2::rojoynegro);
            executor.submit(Ejercicio2::rojoynegro);
        }
    }


    public static void rojoynegro() {
        synchronized (o1) {
            synchronized (o4) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print("♥️");
                    }
                    System.out.println();
                }
            }

            synchronized (o3) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print("♠️");
                    }
                    System.out.println();
                }
            }
        }

        synchronized (o2) {
            synchronized (o3) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print("♦️");
                    }
                    System.out.println();
                }
            }

            synchronized (o4) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print("♣️");
                    }
                    System.out.println();
                }
            }
        }
    }
}