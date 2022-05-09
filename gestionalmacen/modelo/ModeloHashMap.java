
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author Marcos Alloza 
 */
package modelo;
import java.util.HashMap;
import java.util.Map;
// Faltan incluir los metodos del interfaz 
public class ModeloHashMap implements ModeloAbs
{
    private HashMap <Integer,Producto> lista;
    
    public ModeloHashMap()
    {
       lista=new HashMap  <Integer,Producto>();
    }

	@Override
	public boolean insertarProducto(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarProducto(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto buscarProducto(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listarProductosTodos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarProductosStockMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modificarProducto(Producto nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

    
    
}
