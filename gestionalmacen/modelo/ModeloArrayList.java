/** Implementa la parte de Modelo de Datos
 * 
 * @author Marcos Alloza 
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
		for (Producto producto : lista) {
			if (producto.getStock() <= producto.getStock_min()) {
				System.out.println(producto);
			}
		}
	}

	public boolean modificarProducto(Producto nuevo) {
		int p = lista.indexOf(nuevo);
		return (p != -1);
	}

}
