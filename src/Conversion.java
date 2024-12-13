import java.text.SimpleDateFormat;
import java.util.*;


public class Conversion {
    Moneda monedaOrigen;
    Moneda monedaDestino;
    double resultado;
    Date fecha;

    public Conversion(String monedaOrigen, String monedaDestino, double resultado, Date date) {
    }

    // Constructor con sus getters y setters

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(fecha) + " - " + monedaOrigen.codigo + " -> " + monedaDestino.codigo + " = " + resultado;
    }
}
