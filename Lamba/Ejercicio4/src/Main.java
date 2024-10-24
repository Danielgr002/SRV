import java.util.ArrayList;
import java.util.List;

interface Filtre {
    boolean filtrar(Estudiante est);
}


class MostradorDeAlumnos {
    void mostrar(ArrayList<Estudiante> estdiantes, Filtre filtre) {
        for (Estudiante estudiant : estdiantes) {
            if (filtre.filtrar(estudiant)) {
                System.out.print(estudiant.toString()+", ");
            }
        }
        System.out.println();
    }
}

class Estudiante{
    String nombre;
    int nota;

    public Estudiante(String n, int note){
        nombre=n;
        nota=note;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+ " Nota: "+nota;
    }
}


public class Main {
    public static void main(String[] args) {

        //var numeros = List.of(2, 6, 4, 8, 1, 9, 3, 7, 5);

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        Estudiante est1 = new Estudiante("Dani",10);
        Estudiante est2 = new Estudiante("Iker",7);
        Estudiante est3 = new Estudiante("Luismi",5);
        Estudiante est4 = new Estudiante("Martin",3);

        estudiantes.add(est1);
        estudiantes.add(est2);
        estudiantes.add(est3);
        estudiantes.add(est4);

        MostradorDeAlumnos mostradorDeAlumnos = new MostradorDeAlumnos();

        mostradorDeAlumnos.mostrar(estudiantes, new Filtre() {
            @Override
            public boolean filtrar(Estudiante est) {
                return est.nota>5;
            }
        });

        mostradorDeAlumnos.mostrar(estudiantes, new Filtre() {
            @Override
            public boolean filtrar(Estudiante est) {
                return est.nombre.contains("c");
            }
        });

        mostradorDeAlumnos.mostrar(estudiantes, new Filtre() {
            @Override
            public boolean filtrar(Estudiante est) {
                return est.nombre.length()>5;
            }
        });

        mostradorDeAlumnos.mostrar(estudiantes, new Filtre() {
            @Override
            public boolean filtrar(Estudiante est) {
                return true;
            }
        });
    }
}