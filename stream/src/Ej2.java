import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;

public class Ej2 {
    record Student(String name, double nota) {
        public Student(double i) {
            this("Student" + i, i);
        }

        public String toString() {
            return name + ":" + nota;
        }
    }

    public static void main(String[] args) throws IOException {
        var lines = ThreadLocalRandom.current()
                .doubles(100, 0, 10);
                .mapToObj(Student::new);
                .map(Student::toString);
                .toList();
        Files.write(Path.of("estudiantes",lines));
    }
}
