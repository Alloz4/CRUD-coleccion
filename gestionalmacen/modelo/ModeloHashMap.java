
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

	public boolean insertarProducto(Producto p) {
		if (p != null) {
			lista.put(p.getCodigo(), p);
		}
		return true;
	}

	public boolean borrarProducto(int codigo) {
		return (lista.remove(codigo) != null);
	}

	public Producto buscarProducto(int codigo) {	
		return lista.get(codigo);
	}

	public void listarProductosTodos() {
		for (Map.Entry<Integer, Producto> valor : lista.entrySet()) {
			System.out.println(valor.getValue());
		}
		
	}
	
	public void listarProductosStockMin() {
		for (Map.Entry<Integer, Producto> valor : lista.entrySet()) {
			if (valor.getValue().getStock() <= valor.getValue().getStock_min()) {
				System.out.println(valor.getValue());	
			}
		}
	}

	public boolean modificarProducto(Producto nuevo) {
		return (lista.containsValue(nuevo));
	}

    
    
}
