package modelo;

import java.util.Collection;

/**
 * Abstract class ModeloAbs - Clase de acceso a Modelo de DATOS
 * 
 * @author: Marcos Alloza
 */
public interface ModeloAbs {

	static final String fichero = "productos.objetos";

	boolean cargarProductos();

	boolean salvarProducto();

	public boolean insertarProducto(Producto p);

	boolean borrarProducto(int codigo);

	public Producto buscarProducto(int codigo);

	void listarProductosTodos();
	
	Collection<Producto> getProductos();

	void listarProductosStockMin();

	boolean modificarProducto(Producto nuevo);

}
