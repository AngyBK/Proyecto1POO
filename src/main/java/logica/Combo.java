package logica;

import java.util.ArrayList;

public class Combo extends Producto {
	
	private ArrayList<Producto> productos;
	
	public Combo(int codigo, String nombre, int precio) {
		super(codigo, nombre, precio);
		this.productos = new ArrayList<Producto>();
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	@Override
	public String toString() {
		String mensaje = super.toString() + "\n";
		
		for(Producto producto : this.productos) {
			mensaje += "\t" + producto + "\n";
		}
		
		return mensaje;
	}
}
