import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Reponer stock");
            System.out.println("4. Aplicar descuento");
            System.out.println("5. Mostrar información");
            System.out.println("6. Aumentar precio");
            System.out.println("7. Calcular valor total en inventario");
            System.out.println("8. Eliminar producto por código");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese cantidad en stock: ");
                    int cantidadStock = scanner.nextInt();
                    productos.add(Producto.crearProducto(codigo, nombre, precio, cantidadStock));
                    break;

                case 2:
                    System.out.print("Ingrese código del producto a vender: ");
                    String codigoVender = scanner.nextLine();
                    System.out.print("Ingrese cantidad a vender: ");
                    int cantidadVender = scanner.nextInt();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoVender)) {
                            // Fórmula: Si cantidad <= cantidadStock, entonces restamos la cantidad del stock
                            if (producto.venderProducto(cantidadVender)) {
                                System.out.println("Venta realizada con éxito.");
                            }
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese código del producto a reponer: ");
                    String codigoReponer = scanner.nextLine();
                    System.out.print("Ingrese cantidad a reponer: ");
                    int cantidadReponer = scanner.nextInt();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoReponer)) {
                            // Fórmula: cantidadStock = cantidadStock + cantidad
                            producto.reponerStock(cantidadReponer);
                            System.out.println("Stock repuesto con éxito.");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Ingrese código del producto para aplicar descuento: ");
                    String codigoDescuento = scanner.nextLine();
                    System.out.print("Ingrese porcentaje de descuento: ");
                    double porcentajeDescuento = scanner.nextDouble();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoDescuento)) {
                            // Fórmula: precio = precio - (precio * (porcentaje / 100))
                            producto.aplicarDescuento(porcentajeDescuento);
                            System.out.println("Descuento aplicado con éxito.");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Ingrese código del producto para mostrar información: ");
                    String codigoMostrar = scanner.nextLine();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoMostrar)) {
                            producto.mostrarInformacion();
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.print("Ingrese código del producto para aumentar precio: ");
                    String codigoAumentar = scanner.nextLine();
                    System.out.print("Ingrese porcentaje de aumento: ");
                    double porcentajeAumento = scanner.nextDouble();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoAumentar)) {
                            // Fórmula: precio = precio + (precio * (porcentaje / 100))
                            producto.aumentarPrecio(porcentajeAumento);
                            System.out.println("Precio aumentado con éxito.");
                            break;
                        }
                    }
                    break;

                case 7:
                    double totalInventario = 0;
                    for (Producto producto : productos) {
                        totalInventario += producto.calcularValorTotalInventario();
                    }
                    System.out.println("Valor total en inventario: " + totalInventario);
                    break;

                case 8:
                    System.out.print("Ingrese código del producto a eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    boolean encontrado = false; // Variable para verificar si el producto fue encontrado
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoEliminar)) {
                            productos.remove(producto);
                            System.out.println("Producto eliminado con éxito.");
                            encontrado = true; // Marcamos que el producto fue encontrado y eliminado
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró un producto con el código: " + codigoEliminar);
                    }
                    break;

                case 9:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 9);

        scanner.close();
    }
}