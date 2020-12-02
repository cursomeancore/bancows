package com.banco.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json");
		
		JSONObject jsonPrincipal = new JSONObject();
		jsonPrincipal.put("ok", true);
		jsonPrincipal.put("mensaje", "");
		JSONArray clientes = new JSONArray();
		
		// cliente1
		JSONObject cliente1 = new JSONObject();
		cliente1.put("id", 1);
		cliente1.put("id_gestor", 1);
		cliente1.put("usuario", "cliente1");
		cliente1.put("email", "cliente1@mail.com");
		cliente1.put("saldo", 0);
		clientes.put(cliente1);
		
		// cliente2
		JSONObject cliente2 = new JSONObject();
		cliente2.put("id", 1);
		cliente2.put("id_gestor", 1);
		cliente2.put("usuario", "cliente2");
		cliente2.put("email", "cliente2@mail.com");
		cliente2.put("saldo", 0);
		clientes.put(cliente2);
		
		jsonPrincipal.put("data", clientes);
		
		response.getWriter().append(jsonPrincipal.toString());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
