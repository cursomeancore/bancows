package com.banco.main;

import java.util.ArrayList;

import com.banco.entidades.Gestor;
import com.banco.utils.Criptografia;
import com.banco.utils.Database;

public class MainTestDatabase {

	public static void main(String[] args) {

		//String passwordSHA3 = Criptografia.SHA3_256("gestor1");
		//System.out.println(passwordSHA3);
		
		// inicialización de la base de datos
		Database database = new Database();
		
		// inserto un gestor
		
		// inserto un gestor
		Gestor gestorNuevo = new Gestor("gestor", "gestor3", "gestor3@mail.com");
		database.insertarGestor(gestorNuevo);

		// obtengo todos los gestores y los muestro por pantalla
		ArrayList<Gestor> gestores = database.getGestores();
		/*for (Gestor gestorTemp : gestores) {
			gestorTemp.mostrarDatos();
			System.out.println("--");
		}*/
		
		int id = 3333390;
		Gestor gestor = database.getGestor(id);
		if(gestor != null) {
			gestor.mostrarDatos();
		}
		else {
			System.out.println("El gestor con id " + id + " no existe");
		}
		
		
		
		/*try {

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			Statement instruccion = conexion.createStatement();

			// construir sentencia SQL
			String query = "SELECT * FROM gestor";
			ResultSet resultados1 = instruccion.executeQuery(query);

			System.out.println("Listado de gestores (con executeQuery): ");

			// ejecutar instrucción con el método executeQuery
			while (resultados1.next()) {
				System.out.println("ID: " + resultados1.getInt("id"));
				System.out.println("Usuario: " + resultados1.getString("usuario"));
				System.out.println("Password: " + resultados1.getString("password"));
				System.out.println("Correo: " + resultados1.getString("correo"));
				System.out.println("...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		// insertar
		/*
		 * try {
		 * 
		 * Connection conexion =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco",
		 * "banco"); Statement instruccion = conexion.createStatement();
		 * 
		 * // construir sentencia SQL String query =
		 * "INSERT INTO gestor (usuario, password, correo) " +
		 * "VALUES ('gestor1', 'gestor1', 'gestor1@correo.com')";
		 * 
		 * // ejecutar instrucción con el método executeUpdate int registrosInsertados =
		 * instruccion.executeUpdate(query);
		 * 
		 * // mostrar el número de registros insertados
		 * System.out.println("Registros insertados: " + registrosInsertados);
		 * 
		 * 
		 * 
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 */

	}

}
