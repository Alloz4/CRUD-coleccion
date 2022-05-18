
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author Marcos Alloza 
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

// Faltan incluir los metodos del interfaz 
public class ModeloHashMap implements ModeloAbs {
	private HashMap<Integer, Producto> mapa;

	public ModeloHashMap() {
		mapa = new HashMap<Integer, Producto>();
		cargarProductos();
	}

	public boolean insertarProducto(Producto p) {
		if (p != null) {
			salvarProducto();
			mapa.put(p.getCodigo(), p);
		}
		return true;
	}

	public boolean borrarProducto(int codigo) {
		salvarProducto();
		return (mapa.remove(codigo) != null);
	}

	public Producto buscarProducto(int codigo) {
		return mapa.get(codigo);
	}

	public void listarProductosTodos() {
		for (Map.Entry<Integer, Producto> valor : mapa.entrySet()) {
			System.out.println(valor.getValue());
		}

	}

	public void listarProductosStockMin() {
		for (Map.Entry<Integer, Producto> valor : mapa.entrySet()) {
			if (valor.getValue().getStock() <= valor.getValue().getStock_min()) {
				System.out.println(valor.getValue());
			}
		}
	}

	public boolean modificarProducto(Producto nuevo) {
		salvarProducto();
		return (mapa.containsValue(nuevo));
	}


	public boolean cargarProductos() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fichero);
			ois = new ObjectInputStream(fis);

			while (true) {
				Producto p = (Producto) ois.readObject();
				mapa.put(p.codigo, p);
			}

		} catch (ClassNotFoundException e) {
			
		} catch (IOException e) {
			return false;
		}
		
		try {
			ois.close();
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
			
			for (Producto producto : mapa.values()) {
				oos.writeObject(producto);
			}

			fos.close();
			oos.close();

		} catch (IOException e) {
			return false;
		}

		return true;
	}
}