package Ejercicio3.src;

public class Ejercicio3 {
}

class Executable {
        void executar(){}
}

class Executor {
        void executarXVegades(int x, Executable executable){
            for (int i = 0; i < x; i++) {
                executable.executar();
            }
        }
}

class Main {
        public static void main(String[] args) {

            Executor executor = new Executor(){};

            executor.executarXVegades(10, new Executable(){
                void executar(){
                    System.out.println("Hello World");
                }
            });
        }
}
