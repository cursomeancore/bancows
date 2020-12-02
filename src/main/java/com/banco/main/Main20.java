package com.banco.main;

import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONObject;

import com.banco.entidades.Datos;
import com.banco.utils.Archivos;

public class Main20 {

	public static void main(String[] args) {

		// almacén de datos
		Datos datos = new Datos();

		// clase principal para gestionar los gestores
		MainGestores mainGestores = new MainGestores(datos);

		// leo los datos de los gestores
		String gestoresStr = Archivos.leerGestores();
		JSONObject gestoresJSONInicial = new JSONObject(gestoresStr);
		mainGestores.setGestoresJSON(gestoresJSONInicial);

		// clase principal para gestionar los mensajes
		// MainMensajes mainMensajes = new MainMensajes(datos);

		// clase para leer datos por teclado
		Scanner keyboard = new Scanner(System.in);
		int numero;

		// menú principal
		do {
			JSONObject gestoresJSON = mainGestores.getGestoresJSON();
			Archivos.guardarGestores(gestoresJSON.toString(4));

			System.out.println("\n---");
			System.out.println("MENÚ PRINCIPAL");
			System.out.println("1. Gestores");
			System.out.println("2. Clientes");
			System.out.println("3. Transferencia");
			System.out.println("4. Mensajes");
			System.out.println("5. Préstamos");
			System.out.println("6. Salir");
			System.out.print("Introduzca un número: ");
			numero = keyboard.nextInt();

			if (numero == 1) {
				Main20.menuGestores(keyboard, mainGestores);
			}

			else if (numero == 2) {
				Main20.menuClientes();
			}

			else if (numero == 3) {
				Main20.menuTransferencias();
			}

			else if (numero == 4) {
				Main20.menuMensajes();
			}

			else if (numero == 5) {
				Main20.menuPrestamos();
			}

			else if (numero == 6)
				System.out.print("Salir\n");

			// salgo de while cuando el usuario introduzca un 6
		} while (numero != 6);

		keyboard.close();
	}

	public static void menuGestores(Scanner keyboard, MainGestores mainGestores) {

		int numero;

		do {
			System.out.println("MENÚ GESTOR");
			System.out.println("1. Añadir gestor");
			System.out.println("2. Modificar gestor");
			System.out.println("3. Eliminar gestor");
			System.out.println("4. Ver gestor");
			System.out.println("5. Ver gestores");
			System.out.println("6. Atrás");
			System.out.print("Introduzca un número: ");
			numero = keyboard.nextInt();

			if (numero == 1) {

				System.out.print("Introduzca el nombre de usuario: ");
				String usuario = keyboard.next();

				System.out.print("Introduzca el password: ");
				String password = keyboard.next();

				System.out.print("Introduzca el correo: ");
				String correo = keyboard.next();

				boolean ok = mainGestores.insertarGestor(usuario, password, correo);
				if (ok == true) {
					System.out.println("El gestor ha sido introducido correctamente");
				} else {
					System.out.println("El gestor NO ha sido introducido correctamente");
				}
			}

			else if (numero == 3) {

				System.out.print("Introduzca el nombre de usuario: ");
				String usuario = keyboard.next();

				mainGestores.eliminarGestor(usuario);
			}

			else if (numero == 4) {

				System.out.print("Introduzca el nombre de usuario: ");
				String usuario = keyboard.next();

				mainGestores.verGestor(usuario);
			} else if (numero == 5) {
				mainGestores.verGestores();
			}

		} while (numero != 6);

	}

	public static void menuClientes() {
		System.out.print("Clientes");
	}

	public static void menuTransferencias() {
		System.out.print("Transferencias");
	}

	public static void menuMensajes() {
		System.out.print("Mensajes");
	}

	public static void menuPrestamos() {
		System.out.print("Préstamos");
	}

}
