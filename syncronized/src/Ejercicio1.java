import java.util.concurrent.Executors;

        public class Ejercicio1 {
            public static void main(String[] args) {
                for (int i = 0; i < 100000; i++) {
                    wtf();
                }
            }

            static void wtf() {
                Counter counter = new Counter();

                try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                    executor.submit(counter::increment);
                    executor.submit(counter::decrement);
                }

                if (counter.value != 0)
                    System.out.println(counter.value);
            }
        }

        class Counter {
            int value = 0;

            synchronized public void increment() {
                value++;
            }

            synchronized public void decrement() {
                value--;
            }
        }