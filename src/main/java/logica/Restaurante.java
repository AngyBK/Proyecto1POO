package logica;

import java.util.ArrayList;

import Persistencia.ArchivoPlano;

public class Restaurante {
	private String nombre;
	private ArrayList<Producto> productos;
	private ArrayList<Factura> facturas;

	public Restaurante(String nombre) {
		this.nombre = nombre;
		this.productos = new ArrayList<Producto>();
		this.facturas = new ArrayList<Factura>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}

	private Producto buscarProducto(int codigo) {
		for(Producto producto : this.productos) {
			if(producto.getCodigo() == codigo) {
				return producto;
			}
		}
		return null;
	}

	public void crearComida(int codigo, String nombre, int precio) throws Exception {
		if(this.buscarProducto(codigo) != null) {
			throw new Exception("El producto con codigo " + codigo + " ya existe");
		}else {
			Comida comida = new Comida(codigo, nombre, precio);
			this.productos.add(comida);
		}
	}

	public void crearBebida(int codigo, String nombre, int precio) throws Exception {
		if(this.buscarProducto(codigo) != null) {
			throw new Exception("El producto con codigo " + codigo + " ya existe");
		}else {
			Bebida bebida = new Bebida(codigo, nombre, precio);
			this.productos.add(bebida);
		}
	}

	public void crearCombo(int codigo, String nombre, int precio) throws Exception {
		if(this.buscarProducto(codigo) != null) {
			throw new Exception("El producto con codigo " + codigo + " ya existe");
		}else {
			Combo combo = new Combo(codigo, nombre, precio);
			this.productos.add(combo);
		}
	}

	public void agregarProductoCombo(int codigoCombo, int codigoProducto) throws Exception {
		Producto producto = this.buscarProducto(codigoProducto);

		if(producto == null) {
			throw new Exception("El producto con codigo " + codigoProducto + " no existe");
		}else {
			Producto productoCombo = this.buscarProducto(codigoCombo);

			if(productoCombo == null) {
				throw new Exception("El producto con codigo " + codigoCombo + " no existe");
			}else if(productoCombo instanceof Combo) {
				Combo combo = (Combo) productoCombo;
				combo.agregarProducto(producto);
			}else {
				throw new Exception("El producto con codigo " + codigoCombo + " no es un combo");
			}
		}
	}

	public void agregarIngredienteComida(int codigoComida, Ingrediente ingrediente) throws Exception {
		Producto producto = this.buscarProducto(codigoComida);

		if(producto == null) {
			throw new Exception("La comida con codigo " + codigoComida + " no existe");
		}else if(producto instanceof Comida) {
			Comida comida = (Comida) producto;
			comida.agregarIngrediente(ingrediente);
		}else {
			throw new Exception("El producto con codigo " + codigoComida + " no es una comida");
		}
	}

	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}

	public Factura crearFactura(int numero) throws Exception {
		for(Factura factura : this.facturas) {
			if(factura.getNumero() == numero) {
				throw new Exception("La factura con numero " + numero + " ya existe");
			}
		}

		Factura factura = new Factura(numero);
		this.facturas.add(factura);
		return factura;
	}

	public void agregarProductoFactura(int numeroFactura, int codigoProducto) throws Exception {
		Producto producto = this.buscarProducto(codigoProducto);

		if(producto == null) {
			throw new Exception("El producto con codigo " + codigoProducto + " no existe");
		}else {
			Factura factura = this.buscarFactura(numeroFactura);

			if(factura == null) {
				throw new Exception("La factura con numero " + numeroFactura + " no existe");
			}else {
				factura.agregarProducto(producto);
			}
		}
	}

	private Factura buscarFactura(int numero) {
		for(Factura factura : this.facturas) {
		if(factura.getNumero() == numero) {
				return factura;
			}
		}
		return null;
	}

	public String mostrarMenu() {
		String mensaje = "---- MENU " + this.nombre + " ----\n";

		for(Producto producto : this.productos) {
			mensaje += producto + "\n";
		}

		return mensaje;
	}

	public String mostrarFacturas() {
		String mensaje = "";

		for(Factura factura : this.facturas) {
			mensaje += factura + "\n";
		}

		return mensaje;
	}

	public ArrayList<String> guardarProductos() {
		ArrayList<String> lineas = new ArrayList<String>();

		for(Producto producto : this.productos) {
			lineas.add(producto.getCodigo() + ","
					+ producto.getNombre() + ","
					+ producto.getPrecio());
		}

		return lineas;
	}

	public void guardarProductosArchivo() {
		ArrayList<String> lineas = this.guardarProductos();
		ArchivoPlano.escribir("productos.txt", lineas);
	}
}