package logica;

public class Ingrediente {
	
	private int codigo;
	private String nombre;
	private int precio;
	
	public Ingrediente(int codigo, String nombre, int precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	@Override
	public String toString() {
		return this.codigo + "\t" + this.nombre + "\t$" + this.precio;
	}
}
