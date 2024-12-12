import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

class Cliente {
    int habi;
    String nombre;
    int hora_in;
    int hora_fin;

    public int getHabi() {
        return habi;
    }

    public void setHabi(int habi) {
        this.habi = habi;
    }

    public Cliente() {
    }

    public Cliente(String nombre, int hora_in, int hora_fin) {
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
        Map<Integer, Cliente> reservas = new ConcurrentHashMap<>();

        Cliente cl = new Cliente("Daniel", 1, 2);
        Cliente cl2 = new Cliente("Pedro", 1, 2);

        System.out.println(hacer_reserva(reservas));
        System.out.println(hacer_reserva(reservas));

    }

    public static boolean hacer_reserva( Map<Integer, Cliente> reserva){
        Cliente cl = new Cliente();
        Scanner leer = new Scanner(System.in);
        System.out.println("Numero de habitacion: ");
        int hab = leer.nextInt();
        cl.setHabi(hab);
        System.out.println("Nombre: ");
        String nom = leer.next();
        cl.setNombre(nom);
        System.out.println("Hora inicio");
        int hora_in = leer.nextInt();
        cl.setHora_in(hora_in);
        System.out.println("Hora fin: ");
        int hora_fin = leer.nextInt();
        cl.setHora_fin(hora_fin);
        for (Map.Entry<Integer,Cliente> entry: reserva.entrySet()) {
            if (entry.getKey().equals(hab)) {
                if (entry.getValue().hora_in == cl.hora_in || entry.getValue().hora_fin == cl.hora_fin) {
                    return false;
                }
            }
        }
        reserva.put(hab, cl);
        return true;
    }
}
