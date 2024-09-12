package Ejercicio1;

public class EJ1 {
}
class Persona{

}

class Alumne extends Persona{
    void imprimirNom(){
        System.out.println("Soc un alumne");
    }
}

class Main {

    static void imprimirJerarquiaDeClasses(Class<?> c) {
        System.out.print(c.getName() + (c.getSuperclass() != null ? "  >  " : "\n"));
        if (c.getSuperclass() == null) return;
        imprimirJerarquiaDeClasses(c.getSuperclass());
    }

    public static void main(String[] args){
        Alumne  alumne1 = new Alumne(){
            void imprimirNom(){
                System.out.println("Soy alumno1");
            }
        };

        imprimirJerarquiaDeClasses(alumne1.getClass());
    }
}


