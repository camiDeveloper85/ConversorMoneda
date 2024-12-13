/*import com.google.gson.Gson;
import okhttp3.*;

import com.google.gson.JsonObject;
import java.io.IOException;
*/

public class Moneda {
    String codigo;
    String nombre;


    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /*public double getTasaCambio(String monedaDestino) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ConversorMonedas.API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(body.string(), JsonObject.class);

            // Suponiendo que la estructura del JSON es similar a la siguiente:
            // {
            //     "conversion_rates": {
            //         "USD": 1,
            //         "ARS": 0.02,
            //         "BRL": 0.2,
            //         "COP": 0.0002
            //     }
            // }
            double tasaCambioBase = jsonObject.getAsJsonObject("conversion_rates")
                    .get("USD").getAsDouble();
            double tasaCambioDestino = jsonObject.getAsJsonObject("conversion_rates")
                    .get(monedaDestino).getAsDouble();

            return tasaCambioDestino / tasaCambioBase;
        }
    */

}

   /* public double getTasaCambio(String monedaDestino) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ConversorMonedas.API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(body.string(), JsonObject.class);

            double tasaCambioBase = jsonObject.getAsJsonObject("conversion_rates")
                    .get("USD").getAsDouble();
            double tasaCambioDestino = jsonObject.getAsJsonObject("conversion_rates")
                    .get(monedaDestino).getAsDouble();

            return tasaCambioDestino / tasaCambioBase;
        }
    }*/

//}