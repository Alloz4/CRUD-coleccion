/** Implementa la parte de Modelo de Datos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package modelo;

import java.util.ArrayList;

public class ModeloArrayList implements ModeloAbs {
	private ArrayList<Producto> lista;

	public ModeloArrayList() {
		lista = new ArrayList<Producto>();
	}

	// Implementar los metodos abstractos de ModeloAbs
	public boolean insertarProducto(Producto p) {
		return lista.add(p);
	}

	public boolean borrarProducto(int codigo) {
		Producto producto = buscarProducto(codigo);
		if (producto != null) {
			return lista.remove(producto);
		} else {
			return false;
		}
	}

	public Producto buscarProducto(int codigo) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodigo() == codigo) {
				return lista.get(i);
			}
		}
		return null;
	}

	public void listarProductosTodos() {
		for (Producto producto : lista) {
			System.out.println(producto);
		}
	}

	public void listarProductosStockMin() {

	}

	public boolean modificarProducto(Producto nuevo) {
		return false;
	}

}
