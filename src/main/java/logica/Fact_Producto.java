package logica;

public class Fact_Producto extends Factura {
	
	private Producto producto;
	
	public Fact_Producto(int numero, Producto producto) {
		super(numero);
		this.producto = producto;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + this.producto;
	}
}