package Ejercicio1.src;

public class Ej2 {
}

interface Rasgos{
    void caucasico();
}

class Main2{

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

