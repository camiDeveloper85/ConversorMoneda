import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.*;

public class HistorialConversiones {
    private List<Conversion> conversiones = new ArrayList<>();

    public void agregarConversion(String monedaOrigen, String monedaDestino, double resultado) {
        Conversion conversion = new Conversion(monedaOrigen, monedaDestino, resultado, new Date());
        conversiones.add(conversion);

        // Guardar el historial en un archivo JSON
        guardarHistorialJSON();

        // Guardar el historial en un archivo TXT
        guardarHistorialTXT();
    }

    private void guardarHistorialJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(conversiones);
        try (FileWriter writer = new FileWriter("historial.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarHistorialTXT() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("historial.txt"))) {
            for (Conversion conversion : conversiones) {
                writer.println(conversion.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
