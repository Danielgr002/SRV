import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        Map<Integer, List<Reserva>> reservas = new HashMap<>();
        while (true) {
            int hab = leer.nextInt();
            String nombre = leer.next();
            int hora_in = leer.nextInt();
            int hora_fin = leer.nextInt();

            if (reservas.get(hab) == null) {
                reservas.put(hab, new ArrayList<>());
            }

            boolean esta = false;
            for (Reserva r: reservas.get(hab)) {
                if (r.getHora_in() == hora_in) {
                    esta =true;
                    break;
                }
            }
            if (esta = false){
                reservas.get(hab).add(new Reserva());
            }

            System.out.println("La hora esta ocupada");
        }

    }
}
