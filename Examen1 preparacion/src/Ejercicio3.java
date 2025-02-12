import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println(" El factorial de un número ");
        long n= 12;
        System.out.println(LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b)); // 120


        System.out.println("Los códigos de los n productos más caros ");

        Producto producto1 = new Producto("1", 12.3);
        Producto producto2 = new Producto("2", 15.7);
        Producto producto3 = new Producto("3", 10.3);
        List<Producto> productos = new ArrayList<>();
        int num;

        List<String> codigosMasCaros = productos.stream()
                .sorted((p1, p2) -> Double.compare(p2.precio(), p1.precio()))
                .limit(n)
                .map(Producto::codigo)
                .collect(Collectors.toList());

        codigosMasCaros.forEach(System.out::println);

        System.out.println(") Las líneas de un fichero que hay antes de una línea determinada");


    }


}

record Producto(String codigo, double precio){}