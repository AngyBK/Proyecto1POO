package Persistencia; 
 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.ArrayList; 
 
public class ArchivoPlano { 
 
	public static void escribir(String nombreArchivo, ArrayList<String> lineas) { 
		try { 
			BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo)); 
			for(String linea : lineas) { 
				bw.write(linea + "\n"); 
			} 
			bw.close(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
	 
	public static ArrayList<String> leer(String nombreArchivo){ 
		ArrayList<String> lineas = new ArrayList<String>(); 
		try { 
			BufferedReader br = new BufferedReader(new FileReader(nombreArchivo)); 
			String linea; 
			while((linea=br.readLine()) != null) { 
				lineas.add(linea); 
			} 
			br.close(); 
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return lineas; 
	} 
	 
}