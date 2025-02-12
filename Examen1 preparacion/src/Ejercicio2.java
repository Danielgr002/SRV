public class Ejercicio2 {
    public static void main(String[] args) {
        ProcessComponent proceso = new ProcessComponent( 1) {

            @Override
            void execute() {
                System.out.println("Generacion de informe");
            }

            @Override
            String getDescripcion() {
                return "Proceso de lavar la ropa";
            }
        };

        System.out.print("Ejecutando el proceso: ");
        proceso.execute();
        System.out.print("Prioridad: ");
        System.out.println(proceso.getPriority());
        System.out.print("Descripcion: ");
        System.out.println(proceso.getDescripcion());
    }
}

abstract class ProcessComponent {
    int priority;

    public ProcessComponent(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    abstract void execute();

    abstract String getDescripcion();
}
