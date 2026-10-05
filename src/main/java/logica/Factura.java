package logica;

import java.util.ArrayList;

public class Factura {
	
	private int numero;
	private ArrayList<Producto> productos;
	
	public Factura(int numero) {
		this.numero = numero;
		this.productos = new ArrayList<Producto>();
	}
	
	public int getNumero() {
		return numero;
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
	
	public int calcularTotal() {
		int total = 0;
		
		for(Producto producto : this.productos) {
			total += producto.getPrecio();
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		String mensaje = "Factura numero: " + this.numero + "\n";
		
		for(Producto producto : this.productos) {
			mensaje += producto + "\n";
		}
		
		mensaje += "Total: $" + this.calcularTotal();
		
		return mensaje;
	}
}