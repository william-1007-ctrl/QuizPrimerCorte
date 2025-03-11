import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(String codigo, String nombre, double precio, int cantidadStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    // Método para crear producto
    public static Producto crearProducto(String codigo, String nombre, double precio, int cantidadStock) {
        return new Producto(codigo, nombre, precio, cantidadStock);
    }

    // Método para vender producto
    public boolean venderProducto(int cantidad) {
        if (cantidad <= cantidadStock) {
            cantidadStock -= cantidad;
            return true;
        } else {
            System.out.println("No hay suficiente stock para vender.");
            return false;
        }
    }

    // Método para reponer stock
    public void reponerStock(int cantidad) {
        cantidadStock += cantidad;
    }

    // Método para aplicar descuento
    public void aplicarDescuento(double porcentaje) {
        precio -= precio * (porcentaje / 100);
    }

    // Método para mostrar información
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad en stock: " + cantidadStock);
    }

    // Método para aumentar precio
    public void aumentarPrecio(double porcentaje) {
        precio += precio * (porcentaje / 100);
    }

    // Método para calcular valor total en inventario
    public double calcularValorTotalInventario() {
        return precio * cantidadStock;
    }

    // Método para obtener el código del producto
    public String getCodigo() {
        return codigo;
    }
}