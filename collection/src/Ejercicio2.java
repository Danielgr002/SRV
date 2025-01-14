/*
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

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
    boolean reservar (int hab, int hora_in, int hora_fin, String nombre) {
        reservas.putIfAbsent(hab, new ArrayList<>());

        boolean ocupada = false;
        for (Reserva r: reservas.get(hab)) {
            if (r.getHora_in() >= hora_fin || hora_in <= r.getHora_fin()) {
                ocupada =true;
                System.out.println("La hora ocupada ocupada");
                break;
            }
        }
        if (ocupada = false){
            reservas.get(hab).add(new Reserva(nombre, hora_in, hora_fin));
        }
        return ocupada;
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);


        GestorReservas g = new GestorReservas();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i < 1000; i++) {
                executor.submit(()->
                        g.reservar(
                                ThreadLocalRandom.current().nextInt(
                                        int hab;
                                        int hora_in;
                                        int hora_fin;
                                        String nombre;
                                )
                        )
                )
            }
        }
    }
}
*/