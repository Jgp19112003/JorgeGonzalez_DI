import java.util.ArrayList;

public class Gasolinera {

    String nombre;
    ArrayList<Surtidor> surtidores = new ArrayList<>();
    int ganancias;


    public Gasolinera(String nombre) {
        this.nombre = nombre;
    }

    public void obtenerGanancias() {
        System.out.println("Las ganancias son :" + ganancias);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Surtidor> getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(ArrayList<Surtidor> surtidores) {
        this.surtidores = surtidores;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }
}
