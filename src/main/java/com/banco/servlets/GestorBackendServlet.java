package com.banco.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.banco.utils.HTTP;

/**
 * Servlet implementation class GestorBackendServlet
 */
@WebServlet("/gestor/backend")
public class GestorBackendServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorBackendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Hacemos una petición HTTP al banco-backend para obtener el token");
		String token = HTTP.authGestor("gestor1", "gestor1");

		System.out.println("Ya tenemos el token: " + token);
		
		if(token == null) {
			response.getWriter().append("Autenticación incorrecta");
			return;
		}
		
		// obtener gestores (pero ahora con el token)
		String respuesta = HTTP.send("http://127.0.0.1:8085/gestores/", "GET", token, null);
//		String respuesta = HTTP.send("https://www.marca.com", "GET", null, null);
		
		JSONObject jsonBackend = new JSONObject(respuesta);
		System.out.println("Respuesta del banco backend");
		System.out.println("ok: " + jsonBackend.getBoolean("ok"));
		JSONArray gestores = jsonBackend.getJSONArray("data");
		System.out.println("Número de gestores: " + gestores.length());
		
		response.setContentType("application/json");
		
		response.getWriter().append(respuesta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
