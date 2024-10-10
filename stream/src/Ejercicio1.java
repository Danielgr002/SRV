import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

record Movie (String title, int duration, double rating, int year){}

public class Ejercicio1 {
    public static void main(String[] args) {

                var pelis = Stream.of(
                        new Movie("The Shawshank Redemption", 142, 9.3, 1994),
                        new Movie("The Godfather", 175, 9.2, 1972),
                        new Movie("The Dark Knight", 152, 9.0, 2008),
                        new Movie("Pulp Fiction", 154, 8.9, 1994),
                        new Movie("The Lord of the Rings: The Return of the King", 201, 8.9, 2003),
                        new Movie("Schindler's List", 195, 8.9, 1993),
                        new Movie("Fight Club", 139, 8.8, 1999),
                        new Movie("Inception", 148, 8.8, 2010),
                        new Movie("Forrest Gump", 142, 8.8, 1994),
                        new Movie("The Matrix", 136, 8.7, 1999),
                        new Movie("Goodfellas", 146, 8.7, 1990),
                        new Movie("Star Wars: Episode IV - A New Hope", 121, 8.6, 1977),
                        new Movie("Interstellar", 169, 8.6, 2014),
                        new Movie("The Silence of the Lambs", 118, 8.6, 1991),
                        new Movie("Seven", 127, 8.6, 1995)

                );

       Stream<String> titulos = pelis.map(r->r.title().toUpperCase());
       titulos.forEach(System.out::println);
    }
}
