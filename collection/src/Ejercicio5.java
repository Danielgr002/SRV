import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

record Mensaje (String text, LocalDateTime date){
    public Mensaje(String text) {
        this(text, LocalDateTime.now());
    }
}

class MesageSystem {
    List<Mensaje> arrayList = new CopyOnWriteArrayList<>();

    void enviar(Mensaje mj){
        arrayList.add(mj);
        System.out.println(arrayList.size());
    }

    void removeAll(){
        arrayList.removeIf(m -> {
            return m.date().minusSeconds(3).isAfter(LocalDateTime.now());
        });
    }


}
public class Ejercicio5 {
    public static void main(String[] args) {

        MesageSystem mg = new MesageSystem();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i=0;i<30;i++) {
                executor.submit(() -> {
                    while (true) {
                        mg.enviar(new Mensaje("hola"));
                        Thread.sleep(ThreadLocalRandom.current().nextInt(2000,4000));
                    }
                });
            }
            executor.submit(()->{
                while (true) {
                    mg.removeAll();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }
    }
}
