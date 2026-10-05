package logica;

import java.util.ArrayList;

public class Comida extends Producto {
	
	private ArrayList<Ingredientes> ingredientes;
	
	public Comida(int codigo, String nombre, int precio) {
		super(codigo, nombre, precio);
		this.ingredientes = new ArrayList<Ingredientes>();
	}
	
	public ArrayList<Ingredientes> getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(ArrayList<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void agregarIngrediente(Ingredientes ingrediente) {
		this.ingredientes.add(ingrediente);
	}
	
	@Override
	public String toString() {
		String mensaje = super.toString() + "\n";
		
		for(Ingredientes ingrediente : this.ingredientes) {
			mensaje += "\t" + ingrediente + "\n";
		}
		
		return mensaje;
	}
}