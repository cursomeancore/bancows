package com.banco.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.stream.Collectors;

import org.json.JSONObject;


public class HTTP {

  public static String authGestor(String usuario, String password) {

    // construye el cuerpo de la petición
    String body = "usuario="+ usuario + "&password=" + password;

    // realiza la petición HTTP
    String respuesta = HTTP.send("http://127.0.0.1:8085/login/gestor/", 
    		"POST", null, body);
    
    // convierta la respuesta a JSON
    JSONObject jsonObject = new JSONObject(respuesta);


    // devuelve null si la respuesta no es correcta
    if (!jsonObject.getBoolean("ok")) return null;

    // si es correcta devuelve el token
    JSONObject jsonData = jsonObject.getJSONObject("data");
    String token =  jsonData.getString("token");
    return token;
  }

  public static String send(String urlString, String method, String token, String body) {

    // StringBuilder para almacenar los datos que van llegando del servidor
    StringBuilder content = new StringBuilder();

    // objeto para manejar la solicitud HTTP
    HttpURLConnection connection = null;

    try {

      // crea el objeto HttpURLConnection a partir de un objeto de clase URL
      URL url = new URL(urlString);
      connection = (HttpURLConnection) url.openConnection();

      // se establece el método
      if (method != null) {
        connection.setRequestMethod(method.toUpperCase());
      }

      // se establece el valor del campo Accept de la cabecera HTTP
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

      // se establece el valor del token en caso de que haya autenticación
      if (token != null) {
        connection.setRequestProperty("Authorization", "Basic " + token);
      }

      // se establece el body si se ha pasado por parámetros y el método es distinto de get
      if ((body != null) && (method != null) && (!method.equalsIgnoreCase("get"))) {

        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(body);
        osw.flush();
        osw.close();
        os.close();
      }

      // se establece la comunicación
      connection.connect();

      // lee los datos devueltos por el servidor
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

      String line = in.readLine();
      while (line != null) {
        content.append(line);
        line = in.readLine();
      }

      // cierra la conexión
      in.close();

    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {

      // se obtienen los datos en caso de error (HTTP code distinto a 2xx)
      InputStream inputStream = connection.getErrorStream();  
      return new BufferedReader(new InputStreamReader(inputStream))
              .lines().collect(Collectors.joining("\n"));
    }
    return content.toString();
  }
}