/**
 *  MiAlmacen
 *  Programa principal de gestiÃ³n de un almacÃ©n de productos
 *  implementa un CRUD ( Creat, Read, Update, Delete) ofreciendo varios
 *  informes.
 */
package principal;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;
import modelo.ModeloAbs;
import modelo.ModeloArrayList;
import modelo.ModeloHashMap;
import modelo.Producto;

//Completar los mÃ©todos
public class MiAlmacen {
    // Defino como estaticas para que puedan usarse
    // dentro de la clase sin necesidad de pasarlas como
    // parametros.
    static private ModeloAbs almacen;
    static private Scanner sc;

    public static void main(String[] args) {
        almacen = new ModeloHashMap();
        sc = new Scanner(System.in);
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerOpcion(1, 10);
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    borrar();
                    break;
                case 4:
                    modificarPrecio();
                    break;
                case 5:
                    comprar();
                    break;
                case 6:
                    vender();
                    break;
                case 7:
                    listar();
                    break;
                case 8:
                    listarPocoStock();
                    break;
                case 9:
                    generarCSV();
                    break;
            }
            System.out.println("\n---------------------------- ");
            if (opcion != 10) {
                System.out.print("Pulse enter para continuar");
                sc.nextLine();
            }
        } while (opcion != 10);
        sc.close();

    }

    private static void mostrarMenu() {
        System.out.println("\n\n    MENU:");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al m�nimo");
        System.out.println("9. Generar CSV Hoja de cálculo");
        System.out.println("10. Terminar ");
        System.out.print("Elige una opción (1-10): ");
    }

    // Lee un entero del System.in que este comprendido entre primero y ultimo
    private static int leerOpcion(int primero, int ultimo) {
        int valor = leerEntero();
        while (valor < primero || valor > ultimo) {
            valor = leerEntero();
        }
        return valor;
    }

    private static void generarCSV() {
        try {
            PrintWriter pw = new PrintWriter("salida.csv");
            Collection<Producto> cproductos = almacen.getProductos();

            for (Producto producto : cproductos) {
                pw.println(producto.getCodigo() + "," + producto.getNombre() + "," + producto.getPrecio());
            }
            pw.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    // Metodos Auxiliares leerFloat y LeerEntero,
    // Lee de la System.in con el scanner sc y controlan la excepcion de
    // NumberFormatException

    static private int leerEntero() {
        boolean error = false;
        int valor = 0;
        String cadena;
        do {
            error = false;
            try {
                // Intento leer directamente un entero
                cadena = sc.nextLine();
                valor = Integer.parseInt(cadena);

            } catch (NumberFormatException e) {
                System.out.println("Error en formato.");
                error = true;
            }
        } while (error);
        return valor;
    }

    static private float leerFloat() {
        boolean error = false;
        float valor = 0;
        String cadena;
        do {
            error = false;
            try {
                // Intento leer directamente un entero
                cadena = sc.nextLine();
                valor = Float.parseFloat(cadena);

            } catch (NumberFormatException e) {
                System.out.println("Error en formato.");
                error = true;
            }
        } while (error);
        return valor;
    }

    // Muestra los datos de un producto a partir de su codigo

    private static void consultar() {
        System.out.println("<CONSULTA>");
        System.out.print("Introduzca codigo: ");
        int codigo = leerEntero();
        Producto p = almacen.buscarProducto(codigo);
        if (p == null) {
            System.out.println("El producto no se encuentra en almacen");
        } else {
            System.out.println("PRODUCTO " + p);
        }

    }

    // Borrar un producto a partir de su codigo

    private static void borrar() {
        System.out.println("<ELIMINAR>");
        System.out.print("Introduzca codigo: ");
        int codigo = leerEntero();
        boolean borrar = almacen.borrarProducto(codigo);
        if (borrar == true) {
            System.out.println("El producto se ha eliminado del almacen");
        } else {
            System.out.println("El producto no se ha eliminado del almacen");
        }

    }

    // Cambia el precio de un producto a partir de su codigo
    private static void modificarPrecio() {
        System.out.println("<MODIFICAR PRECIO>");
        System.out.print("Introduzca un código: ");
        int codigo = leerEntero();
        Producto producto = almacen.buscarProducto(codigo);
        if (producto == null) {
            System.out.println("El producto con el código indicado no se encuentra en el almacen.");
        } else {
            System.out.println("Producto: " + producto);
            System.out.print("Introduzca el precio nuevo: ");
            float precio = leerFloat();
            if (precio > 0) {
                producto.setPrecio(precio);
                almacen.modificarProducto(producto);
                System.out.println("Producto actualizado");
            } else {
                System.out.println("El precio no puede ser menor a 0");
            }
        }
    }

    // Incrementa el stock
    private static void comprar() {
        System.out.println("<COMPRAR>");
        System.out.print("Introducza un código: ");
        int codigo = leerEntero();
        Producto producto = almacen.buscarProducto(codigo);
        if (producto == null) {
            System.out.println("El producto con el código indicado no se encuentra en el almacen.");
        } else {
            System.out.println("Producto: " + producto);
            System.out.print("Introduzca la cantidad que quiere comprar: ");
            int cantidad = leerEntero();
            producto.setStock(producto.getStock() + cantidad);
            almacen.modificarProducto(producto);
            System.out.println("Producto actualizado.");
        }
    }

    // Decrementa el stock
    private static void vender() {
        System.out.println("<VENDER>");
        System.out.print("Introducza un código: ");
        int codigo = leerEntero();
        Producto producto = almacen.buscarProducto(codigo);
        if (producto == null) {
            System.out.println("El producto con el código indicado no se encuentra en el almacen.");
        } else {
            System.out.println("Producto: " + producto);
            System.out.print("Introduzca la cantidad que quiere vender: ");
            int cantidad = leerEntero();
            if (cantidad > producto.getStock()) {
                System.out.println(
                        "No se puede vender el producto " + producto.getNombre() + " porque no hay stock suficiente.");
            } else {
                producto.setStock(producto.getStock() - cantidad);
                almacen.modificarProducto(producto);
                System.out.println("Producto actualizado.");
            }

        }
    }

    // Listado de todos los productos
    private static void listar() {
        System.out.println("<LISTAR>");
        almacen.listarProductosTodos();
    }

    // Listado de todos los productos con stock inferior a stock minimo
    private static void listarPocoStock() {
        System.out.println("<LISTAR STOCK BAJO MINIMOS>");
        almacen.listarProductosStockMin();
    }

    // Solicita datos al usuario para dar de alta un nuevo producto
    // El codigo no se puede repetir
    private static void crear() {
        System.out.println("<NUEVO PRODUCTO>");
        System.out.print("Introduzca un código: ");
        int codigo = leerEntero();
        Producto producto = almacen.buscarProducto(codigo);
        if (producto != null) {
            System.out.println("Ya existe el código en el almacen " + producto);
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        producto = new Producto(codigo, nombre);
        System.out.print("Stock: ");
        int stock = leerEntero();
        producto.setStock(stock);
        System.out.print("Stock Mínimo: ");
        int stock_min = leerEntero();
        producto.setStock_min(stock_min);
        System.out.print("Precio: ");
        float precio = leerFloat();
        producto.setPrecio(precio);
        almacen.insertarProducto(producto);
    }

}
