package Ejercicio2.src;

public class EjTwo {
}

class Notification {
    void show(int num) {
        System.out.println("You have " + num + " new messages");
    }
}

class Main {
    public static void main(String[] args) {

        Notification notification = new Notification(){
            void show(int n){
                if (n==1){
                    System.out.println("You have a new messages");
                } else if (n>99){
                    System.out.println("You have a +99 new messages");
                } else {
                    System.out.println("You have " + n + " new messages");
                }
            }

        };

        notification.show(1);
        notification.show(10);
        notification.show(99);
        notification.show(100);
        notification.show(135);
    }
}
