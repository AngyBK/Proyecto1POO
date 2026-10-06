package logica;

import java.util.ArrayList;

public class Comida extends Producto {
	
	private ArrayList<Ingrediente> ingredientes;
	
	public Comida(int codigo, String nombre, int precio) {
		super(codigo, nombre, precio);
		this.ingredientes = new ArrayList<Ingrediente>();
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void agregarIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}
	
	@Override
	public String toString() {
		String mensaje = super.toString() + "\n";
		
		for(Ingrediente ingrediente : this.ingredientes) {
			mensaje += "\t" + ingrediente + "\n";
		}
		
		return mensaje;
	}
}