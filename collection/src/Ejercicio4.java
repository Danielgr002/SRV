import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;

public class Ejercicio4 {
    public static void main(String[] args) {
        var arrayList = new CopyOnWriteArrayList<>();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                arrayList.add("Hola mundo");
            });
            executor.submit(() -> {
                arrayList.add("Adios mundo");
            });
        }
        System.out.println(arrayList);
    }
}
