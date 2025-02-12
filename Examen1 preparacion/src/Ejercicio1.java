public class Ejercicio1 {
    public static void main(String[] args) {
        Button boton = new Button();

        boton.setOnClickListener(() -> System.out.println("Hola"));
        boton.click();
    }
}


interface OnclickListener {
    void onClick();
}

class Button {

    private OnclickListener listener;

    void click(){
        listener.onClick();
    }

    void setOnClickListener( OnclickListener listener){
        this.listener = listener;
    }

}
