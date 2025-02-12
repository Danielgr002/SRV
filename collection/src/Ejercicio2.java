import java.util.*;
import java.util.concurrent.*;

class Reserva {
    String nombre;
    int hora_in;
    int hora_fin;

    public Reserva() {
    }

    public Reserva(String nombre, int hora_in, int hora_fin) {
        this.nombre = nombre;
        this.hora_in = hora_in;
        this.hora_fin = hora_fin;
    }

    public int getHora_in() {
        return hora_in;
    }

    public void setHora_in(int hora_in) {
        this.hora_in = hora_in;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }
}

class GestorReservas {
    ConcurrentHashMap<Integer, List<Reserva>> reservas = new ConcurrentHashMap<>();

    // Método para reservar una habitación
    boolean reservar(int hab, int hora_in, int hora_fin, String nombre) {
        reservas.putIfAbsent(hab, new ArrayList<>());

        boolean ocupada = false;
        for (Reserva r : reservas.get(hab)) {
            if (r.getHora_in() < hora_fin && hora_in < r.getHora_fin()) { // Verificación de solapamiento
                ocupada = true;
                System.out.println("La hora está ocupada");
                break;
            }
        }

        if (!ocupada) {  // Si no está ocupada, se realiza la reserva
            reservas.get(hab).add(new Reserva(nombre, hora_in, hora_fin));
            System.out.println("Reserva realizada para " + nombre + " en la habitación " + hab + " de " + hora_in + " a " + hora_fin);
        }
        return !ocupada; // Retorna true si se hizo la reserva, false si estaba ocupada
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        // Inicialización de variables necesarias
        Scanner leer = new Scanner(System.in);

        GestorReservas g = new GestorReservas();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Realizamos 1000 intentos de reserva concurrentes
            for (int i = 0; i < 1000; i++) {
                // Generación de valores aleatorios para las variables
                executor.submit(() -> {
                    int hab = ThreadLocalRandom.current().nextInt(1, 5); // 4 habitaciones aleatorias
                    int hora_in = ThreadLocalRandom.current().nextInt(8, 17); // Horas entre 8 AM y 5 PM
                    int hora_fin = hora_in + ThreadLocalRandom.current().nextInt(1, 3); // Duración de la reserva entre 1 y 3 horas
                    String nombre = "Empleado" + ThreadLocalRandom.current().nextInt(1, 101); // Nombres de empleados aleatorios

                    // Intentar realizar la reserva
                    g.reservar(hab, hora_in, hora_fin, nombre);
                });
            }
        }
    }
}


//hashmap strngList (Ej. ex2)
// copywwiterarrayList
