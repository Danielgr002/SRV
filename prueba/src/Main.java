import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of("ana","pepe","luis","irene","innes")
                .sorted((a, b) -> {
                    String nueva_pal = "";
                    for (int i = a.length() - 1; i >= 0; i--) {
                        nueva_pal += a.charAt(i);
                    }

                    String nueva_pal2 = "";
                    for (int i = b.length() - 1; i >= 0; i--) {
                        nueva_pal2 += b.charAt(i);
                    }
                    return nueva_pal.compareTo(nueva_pal2);
                })
                .forEach(System.out::println);

    }
}