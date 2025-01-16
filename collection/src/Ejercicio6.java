import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.*;

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
            return (state.get() == State.CHECKED ? "✔️" : " ") + " Descripcion: "+ description + "\n";
        }
    }

    public static void main(String[] args) {
        List<Item> lista = new CopyOnWriteArrayList<>();
        Lock lock = new ReentrantLock();

        try (var executors = Executors.newVirtualThreadPerTaskExecutor()){
            executors.submit(() -> {
                while (true) {
                    if (lista.size() < 10) {

                        lista.add(new Item("Item" + ThreadLocalRandom.current().nextInt()));

                    }
                }
            });
            executors.submit(()-> {
                while (true) {
                    try {
                        lock.lock();
                        if (lista.size()>0) {
                            lista.get(ThreadLocalRandom.current().nextInt(lista.size())).setState(Item.State.CHECKED);
                        }
                        lock.unlock();
                    } catch (Exception e){
                        out.println("Mierdon!!!");
                    }
                }
            });

            executors.submit(()-> {
                while (true) {
                    lock.lock();
                    lista.remove(ThreadLocalRandom.current().nextInt(lista.size()));
                    lock.unlock();
                }
            });
            executors.submit(()->{
                while (true){
                    for (Item i: lista){
                        out.println(i.toString());
                    }
                }
            });
        }
    }
}
