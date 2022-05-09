
/**
 * Write a description of class Producto here.
 * 
 * @author Marcos Alloza
 */
package modelo;

public class Producto {
	// instance variables - replace the example below with your own
	int codigo; // Código del producto, se utiliza para buscar
	String nombre; // Nombre un texto
	int stock; // existencia actuales
	int stock_min; // Número mínimo de existencias recomedadas
	float precio; // Precio

	/**
	 * Constructor for objects of class Producto
	 */
	public Producto() {

	}

	public Producto(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String valor) {
		nombre = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int valor) {
		codigo = valor;
	}

	public String toString() {
		// return codigo +":"+ nombre +": Existencias: "+ stock + " : Precio: "+precio;
		return String.format("| %5d | %-20.20s | %5d | min: %5d | %10.2f |", codigo, nombre, stock, stock_min, precio);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int valor) {
		stock = valor;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int valor) {
		stock_min = valor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float valor) {
		precio = valor;
	}
}
