package com.banco.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Archivos {

	public static void guardarGestores(String gestoresStr) {

		try {

			FileWriter fileWriter = new FileWriter("gestores.txt");
			fileWriter.write(gestoresStr);
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leerGestores() {

		try {
			return new String(Files.readAllBytes(Paths.get("gestores.txt")));
		} catch (IOException e) {
			return "{}";
			//e.printStackTrace();
		}

	}
}
