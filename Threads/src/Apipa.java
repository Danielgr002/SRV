import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Apipa {
    public static void main(String[] args) throws InterruptedException {

        var future = Thread.startVirtualThread(()-> {
            String weather = fetch("https://apipa.vercel.app/api/w/weather");
            System.out.println(weather);
        });
        var future1 = Thread.startVirtualThread(()->{
            String temperature = fetch("https://apipa.vercel.app/api/w/temperature");
            System.out.println(temperature);
        });
        var future2 = Thread.startVirtualThread(()-> {
            String wind = fetch("https://apipa.vercel.app/api/w/wind");
            System.out.println(wind);
        });
        var future3 = Thread.startVirtualThread(()-> {
            String moon = fetch("https://apipa.vercel.app/api/w/moon");
            System.out.println(moon);
        });
        future.join();
        future1.join();
        future2.join();
        future3.join();




    }

    static String fetch(String url) {
        try(var inputStream = new URI(url).toURL().openStream()) {
            return new String(inputStream.readAllBytes());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}