package com.banco.main;

import com.banco.utils.HTTP;

public class MainTestHTTP {
	
	private static final String SERVER = "http://127.0.0.1:8085/";

	public static void main(String[] args) {
	
		// obtener gestores (sin token)
//		String respuesta = HTTP.send(SERVER + "/gestores/", "GET", null, null);
//		System.out.println(respuesta);
		
		// obtener token mediante credenciales (usuario y contraseña)
		String token = HTTP.authGestor("gestor1", "gestor1");
		System.out.println(token);
		
		// obtener gestores (pero ahora con el token)
		String respuesta = HTTP.send(SERVER + "/gestores/", "GET", token, null);
		System.out.println(respuesta);
		
		// crear JSONObject con la información del nuevo gestor
		/*for(int i=0; i<1000; i++) {
			JSONObject gestor = new JSONObject();
			gestor.put("usuario", "gestor" + i);
			gestor.put("password", "gestor" + i);
			gestor.put("correo", "gestor" + i + "@mail.com");
			String body = gestor.toString();
			
			// agregarGestor
			respuesta = HTTP.send(SERVER + "/gestores/", 
					"POST", token, body);
		}*/
		
		// obtenerGestor
//		respuesta = HTTP.send(SERVER + "/gestores/", 
//				"GET", token, null);
//		
//		System.out.println(respuesta);
		
		//System.out.println(respuesta);
		/*JSONObject jsonObject = new JSONObject(respuesta);
		boolean ok = jsonObject.getBoolean("ok");
		
		if(ok == true) {
			
			JSONArray data = jsonObject.getJSONArray("data");
			
			for (int i = 0; i < data.length(); i++) {
				JSONObject gestor = data.getJSONObject(i);
				System.out.println(gestor.getString("correo"));
			}
			
			/*System.out.println(jsonObject.toString());
			System.out.println(ok);
		}*/
	}

}
