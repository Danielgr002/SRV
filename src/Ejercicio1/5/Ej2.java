package Ejercicio2;

public class Ej2 {
}

interface Rasgos{
    void caucasico();
}

class Main{

    static void imprimirJerarquiaDeClasses(Class<?> c) {
        System.out.print(c.getName() + (c.getSuperclass() != null ? "  >  " : "\n"));
        if (c.getSuperclass() == null) return;
        imprimirJerarquiaDeClasses(c.getSuperclass());
    }

    public static void main(String[] args){
        Object objeto = new Object(){
          void caucasico(){
              System.out.println("Soy caucasico");
          }
        };

        imprimirJerarquiaDeClasses(objeto.getClass());
    }
}

