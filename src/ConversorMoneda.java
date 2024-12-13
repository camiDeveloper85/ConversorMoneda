import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.*;

import java.io.*;
import java.util.*;


public class ConversorMoneda {

    public static final String API_KEY = "your API_KEY";  // ponga su API_KEY una vez registrado en la pagina excha4nge
    public static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    public static HistorialConversiones historial = new HistorialConversiones();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            System.out.println("\nConversor de Monedas");
            System.out.println("1. USD a Peso Argentino");
            System.out.println("2. Peso Argentino a USD");
            System.out.println("3. USD a Real Brasileño");
            System.out.println("4. Real Brasileño a USD");
            System.out.println("5. USD a Peso Colombiano");
            System.out.println("6. Peso Colombiano a USD");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertir("USD", "ARS");
                    break;
                case 2:
                    convertir("ARS", "USD");
                    break;
                case 3:
                    convertir("USD", "BRL");
                    break;
                case 4:
                    convertir("BRL", "USD");
                    break;
                case 5:
                    convertir("USD", "COP");
                    break;
                case 6:
                    convertir("COP", "USD");
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }


    public static void convertir(String monedaOrigen, String monedaDestino) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL)
                .build();
        try (Response response = client.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(body.string(), JsonObject.class);
            double tasaCambioBase = jsonObject.getAsJsonObject("conversion_rates")
                    .get("USD").getAsDouble();
            double tasaCambioDestino = jsonObject.getAsJsonObject("conversion_rates")
                    .get(monedaDestino).getAsDouble();
            double tasaCambio = tasaCambioDestino / tasaCambioBase;


            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la cantidad en " + monedaOrigen + ": ");
            double cantidad = scanner.nextDouble();

            double resultado = cantidad * tasaCambio;
            System.out.println(cantidad + " " + monedaOrigen + " equivalen a " + resultado + " " + monedaDestino);

            historial.agregarConversion(monedaOrigen, monedaDestino, resultado);

        }
    }

}