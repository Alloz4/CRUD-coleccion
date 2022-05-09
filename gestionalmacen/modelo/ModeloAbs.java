package modelo;

/**
 * Abstract class ModeloAbs - Clase de acceso a Modelo de DATOS
 * 
 * @author: Marcos Alloza
 */
public interface ModeloAbs {

	public boolean insertarProducto(Producto p);

	boolean borrarProducto(int codigo);

	public Producto buscarProducto(int codigo);

	void listarProductosTodos();

	void listarProductosStockMin();

	boolean modificarProducto(Producto nuevo);

}
