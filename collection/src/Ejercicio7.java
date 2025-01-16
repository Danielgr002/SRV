import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio7 {

}

record Producto(int id, String nombre, AtomicInteger Stock){

    void aumentarStock(int cantidad){
        Stock.getAndAdd(cantidad);
    }

    void disminuirStock(int cantidad){
        Stock.getAndAdd(-cantidad);
    }

    public static void main(String[] args) {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(1,"Papas", new AtomicInteger(12)));
        lista.add(new Producto(2,"Lentejas", new AtomicInteger(8)));
        lista.add(new Producto(3,"prod3", new AtomicInteger(5)));
        lista.add(new Producto(4,"prod4", new AtomicInteger(8)));
        lista.add(new Producto(5,"Lentejas", new AtomicInteger(10)));

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            executor.submit(()->{
                while (true) {
                    for (Producto p : lista) {
                        System.out.println(p);
                    }
                }
            });
            for (int i=0; i<100;i++) {
                executor.submit(() -> {
                    Random rand = new Random();
                    Producto randelement = lista.get(rand.nextInt(lista.size()));
                    randelement.aumentarStock(3);
                });
            }
            for (int i=0; i<100;i++) {
                executor.submit(() -> {
                    Random rand = new Random();
                    Producto randelement = lista.get(rand.nextInt(lista.size()));
                    randelement.disminuirStock(4);
                });
            }
        }
    }
}
