package presentacion;

import java.util.Scanner;

import logica.Ingrediente;
import logica.Restaurante;

public class Principal {
	private Restaurante restaurante;
	private Scanner sc;

	public Principal() {
		this.restaurante = new Restaurante("Hamburguesas");
		this.sc = new Scanner(System.in);
		this.menu();
		this.sc.close();
	}

	private void menu() {
		int op;

		do {
			System.out.println("----\nDigite\n"
					+ "0. Salir\n"
					+ "1. Mostrar Menu\n"
					+ "2. Crear Comida\n"
					+ "3. Crear Bebida\n"
					+ "4. Crear Combo\n"
					+ "5. Agregar Producto a Combo\n"
					+ "6. Crear Factura\n"
					+ "7. Agregar Producto a Factura\n"
					+ "8. Mostrar Facturas\n"
					+ "9. Agregar Ingrediente a Comida\n"
					+ "10. Guardar Productos\n"
					+ "----\n");

			op = sc.nextInt();

			if(op == 1) {
				this.mostrarMenu();
			}else if(op == 2) {
				this.crearComida();
			}else if(op == 3) {
				this.crearBebida();
			}else if(op == 4) {
				this.crearCombo();
			}else if(op == 5) {
				this.agregarProductoCombo();
			}else if(op == 6) {
				this.crearFactura();
			}else if(op == 7) {
				this.agregarProductoFactura();
			}else if(op == 8) {
				this.mostrarFacturas();
			}else if(op == 9) {
				this.agregarIngredienteComida();
			}else if(op == 10) {
				this.guardarProductos();
			}

		}while(op != 0);
	}

	private void mostrarMenu() {
		System.out.println(this.restaurante.mostrarMenu());
	}

	private void crearComida() {
		System.out.println("Digite codigo: ");
		int codigo = this.sc.nextInt();

		System.out.println("Digite nombre: ");
		String nombre = this.sc.next();

		System.out.println("Digite precio: ");
		int precio = this.sc.nextInt();

		try {
			this.restaurante.crearComida(codigo, nombre, precio);
			System.out.println("Comida creada correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void crearBebida() {
		System.out.println("Digite codigo: ");
		int codigo = this.sc.nextInt();

		System.out.println("Digite nombre: ");
		String nombre = this.sc.next();

		System.out.println("Digite precio: ");
		int precio = this.sc.nextInt();

		try {
			this.restaurante.crearBebida(codigo, nombre, precio);
			System.out.println("Bebida creada correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void crearCombo() {
		System.out.println("Digite codigo: ");
		int codigo = this.sc.nextInt();

		System.out.println("Digite nombre: ");
		String nombre = this.sc.next();

		System.out.println("Digite precio: ");
		int precio = this.sc.nextInt();

		try {
			this.restaurante.crearCombo(codigo, nombre, precio);
			System.out.println("Combo creado correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void agregarProductoCombo() {
		System.out.println("Digite codigo del combo: ");
		int codigoCombo = this.sc.nextInt();

		System.out.println("Digite codigo del producto: ");
		int codigoProducto = this.sc.nextInt();

		try {
			this.restaurante.agregarProductoCombo(codigoCombo, codigoProducto);
			System.out.println("Producto agregado al combo correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void agregarIngredienteComida() {
		System.out.println("Digite codigo de la comida: ");
		int codigoComida = this.sc.nextInt();

		System.out.println("Digite codigo del ingrediente: ");
		int codigoIngrediente = this.sc.nextInt();

		System.out.println("Digite nombre del ingrediente: ");
		String nombre = this.sc.next();

		System.out.println("Digite precio del ingrediente: ");
		int precio = this.sc.nextInt();

		Ingrediente ingrediente = new Ingrediente(codigoIngrediente, nombre, precio);

		try {
			this.restaurante.agregarIngredienteComida(codigoComida, ingrediente);
			System.out.println("Ingrediente agregado correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void crearFactura() {
		System.out.println("Digite numero de factura: ");
		int numero = this.sc.nextInt();

		try {
			this.restaurante.crearFactura(numero);
			System.out.println("Factura creada correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void agregarProductoFactura() {
		System.out.println("Digite numero de factura: ");
		int numeroFactura = this.sc.nextInt();

		System.out.println("Digite codigo del producto: ");
		int codigoProducto = this.sc.nextInt();

		try {
			this.restaurante.agregarProductoFactura(numeroFactura, codigoProducto);
			System.out.println("Producto agregado a la factura correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void mostrarFacturas() {
		System.out.println("---- FACTURAS ----");
		System.out.println(this.restaurante.mostrarFacturas());
	}

	private void guardarProductos() {
		this.restaurante.guardarProductosArchivo();
		System.out.println("Productos guardados correctamente");
	}

	public static void main(String[] args) {
		new Principal();
	}
}