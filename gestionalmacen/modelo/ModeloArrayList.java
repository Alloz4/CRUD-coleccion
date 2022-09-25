/** Implementa la parte de Modelo de Datos
 * 
 * @author Marcos Alloza 
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ModeloArrayList implements ModeloAbs {
	private ArrayList<Producto> lista;

	public ModeloArrayList() {
		lista = new ArrayList<Producto>();
		cargarProductos();
	}

	// Implementar los metodos abstractos de ModeloAbs
	public boolean insertarProducto(Producto p) {
		lista.add(p);
		salvarProducto();
		return true;
	}

	public boolean borrarProducto(int codigo) {
		Producto producto = buscarProducto(codigo);
		if (producto != null) {
			lista.remove(producto);
			salvarProducto();
			return true;
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

    public List<Producto> getProductos(){
    	return lista;
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
		salvarProducto();
		return (p != -1);
	}

	public boolean cargarProductos() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);

			while (true) {
				Producto p = (Producto) ois.readObject();
				lista.add(p);
			}
			
		} catch (ClassNotFoundException e){
		
		} catch (IOException e) {
			return false;
		}

		try {
			fis.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean salvarProducto() {

		try {

			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (Producto producto : lista) {
				oos.writeObject(producto);
			}

			oos.close();

		} catch (IOException e) {
			return false;
		}

		return true;
	}

}
