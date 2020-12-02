package com.banco.main;

import java.util.HashMap;

import org.json.JSONObject;

import com.banco.entidades.Datos;
import com.banco.entidades.Gestor;

public class MainGestores {

	/*
	 * almacene la información de los gestores mediante una 
	 * estructura de datos (ArrayList o HashMap)
	 */
	// atributos
	//private HashMap<String, Gestor> gestores;
	private Datos datos;
	private int id;
	
	// constructor parametrizado
	public MainGestores(Datos datos) {
		
		this.datos = datos;
			
		// la clave es el nombre de usuario
		//this.datos.getGestores() = new HashMap<String, Gestor>();
		
		// el primer gestor que se introduzca tendrá el id=1
		this.id = 1;
	}
	
	/*
	 *  insertarGestor que reciba tres parámetros:
		usuario, password y correo. Este método devolver true si 
		el gestor ha sido correctamente almacenado,
		o false, en caso contrario
	 */
	public boolean insertarGestor(String usuario, String password, String correo) {

		// se iteran todos los gestores a partir de sus claves
		for (String usuarioTemp : this.datos.getGestores().keySet()) {
			
			// se obtiene el gestor de la iteración actual
			Gestor gestor = this.datos.getGestores().get(usuarioTemp);
			
			// si ya existe un gestor con el mismo correo que el correo del gestor nuevo 
			// que se pretende introducir
			String correoTemp = gestor.getCorreo();
			
			if(correoTemp.equals(correo)) {
				System.out.println("Ya existe un usuario con el mismo correo");
				return false;
			}
		}
		
		// si existe el usuario, entonces no se inserta
		if(this.datos.getGestores().containsKey(usuario)) {
			System.out.println("Ya existe un usuario con el mismo nombre");
			return false;
		}
				
		// crear el objeto gestor
		Gestor gestor = new Gestor(id, usuario, password, correo);
		
		// introduce el objeto gestor en el HashMap gestores utilizando el usuario como clave
		this.datos.getGestores().put(usuario, gestor);
		
		// incremento el id para el próximo gestor
		this.id++;
		
		return true;
	}

	// muestra la información de todos los gestores almacenados
	public void verGestores() {
		
		if(this.datos.getGestores().size() == 0) {
			System.out.println("No hay gestores");
		}
		
		for (String usuario : this.datos.getGestores().keySet()) {
			System.out.println("---");
			Gestor gestor = this.datos.getGestores().get(usuario);
			gestor.mostrarDatos();
		}
	}
	
	// muestra toda la información de un gestor
	public void verGestor(String usuario) {
		
		// si no existe el usuario, se termina el método
		if(!this.datos.getGestores().containsKey(usuario)) {
			System.out.println("No existe el usuario");
			return;
		}
		
		// el usuario existe, por tanto, se muestra los datos por pantalla
		Gestor gestor = this.datos.getGestores().get(usuario);
		gestor.mostrarDatos();
	}
	
	// elimina un gestor a partir de su nombre de usuario
	public void eliminarGestor(String usuario) {
		
		// si no existe el usuario, se termina el método
		if(!this.datos.getGestores().containsKey(usuario)) {
			System.out.println("No existe el usuario");
			return;
		}
		
		// el usuario existe. Por tanto, lo eliminamos
		this.datos.getGestores().remove(usuario);
		
		System.out.println("El usuario se ha eliminado correctamente");
	}

	public JSONObject getGestoresJSON() {
		
		HashMap<String, Gestor> gestores = this.datos.getGestores();
		JSONObject jsonGestores = new JSONObject();
		
		for (String usuario : gestores.keySet()) {
			Gestor gestor = gestores.get(usuario);
			JSONObject jsonGestor = gestor.convertirAJSONObject();
			jsonGestores.put(usuario, jsonGestor);
		}
		
		return jsonGestores;
	}

	public void setGestoresJSON(JSONObject gestoresJSON) {

		HashMap<String, Gestor> gestores = this.datos.getGestores();
		
		// reiniciar el HashMap (0 elementos)
		gestores.clear();
		
		// iteran todos las claves del JSONObject gestoresJSON
		for(String usuarioTemp : gestoresJSON.keySet()) {

			// se obtiene el valor asociado a la clave (usuarioTemp)
			JSONObject jsonGestor = gestoresJSON.getJSONObject(usuarioTemp);
			
			// extraigo todos los pares clave/valor del JSONOBject jsonGestor
			int id = jsonGestor.getInt("id");
			String usuario = jsonGestor.getString("usuario");
			String password = jsonGestor.getString("password");
			String correo = jsonGestor.getString("correo");
			
			// crea el objeto gestor pasando por parámetros al constructor todos
			// los parámetros
			Gestor gestor = new Gestor(id, usuario, password, correo);
			
			// se inerta el objeto gestor dentro del HashMap gestores
			gestores.put(usuario, gestor);
		}
	}
}
