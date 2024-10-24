import java.util.List;

    record Producto(String nombre, int precio) {}

    interface Accion{
        void hacerAccion(Producto prod);
    }

    class Almacen{

        List<Producto> productos;

        Almacen(List<Producto> productos) { this.productos = productos; }

        void Paracadaproducto(Accion ac){
            for (Producto pr: productos){
                    ac.hacerAccion(pr);
            }
        }
    }


    class Main {
        public static void main(String[] args) {

            Almacen almacen = new Almacen(List.of(new Producto("lapiz", 5), new Producto("boli", 6), new Producto("libro", 10)));

            almacen.Paracadaproducto(new Accion() {
                @Override
                public void hacerAccion(Producto prod) {
                    System.out.println("Nombre: "+prod.nombre()+" precio"+prod.precio());
                }
            });
        }
    }