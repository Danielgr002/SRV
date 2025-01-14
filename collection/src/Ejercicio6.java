import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

public class Ejercicio6 {
    record Item(String description, AtomicReference<State> state){
        enum State {
            CHECKED, UNCHEKED
        }

        public Item(String description) {
            this(description, new AtomicReference<>(State.UNCHEKED));
        }

        void setState(State newState) {
            state.set(newState);
        }

        public String toString(){
            return (state.get() == State.CHECKED ? ("✔️") : (" ") + description + "\n");
        }
    }

    public static void main(String[] args) {
        List<Item> lista = new CopyOnWriteArrayList<>();

        try (var executors = Executors.newVirtualThreadPerTaskExecutor()){
            executors.submit(() -> {
                while (true) {
                    if (lista.size() < 10) {

                        lista.add(new Item("Item" + ThreadLocalRandom.current().nextInt()));

                    }
                }
            });
            executors.submit(()-> {
                lista.get(ThreadLocalRandom.current().nextInt(lista.size())).setState(Item.State.CHECKED);
            });

            executors.submit(()-> {
                lista.remove(ThreadLocalRandom.current().nextInt(lista.size()));
            });
            executors.submit(()->{
                while (true){
                    System.out.println(lista);
                }
            });
        }
    }
}
