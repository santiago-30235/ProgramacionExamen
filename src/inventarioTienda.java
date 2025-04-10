import java.util.Scanner; // Importa la clase Scanner para leer datos del usuario

public class inventarioTienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea el objeto Scanner para leer entradas

        // Arreglos para almacenar hasta 5 productos
        String[] nombres = new String[5];
        int[] cantidades = new int[5];
        double[] precios = new double[5];
        int totalProductos = 0; // Contador de productos registrados

        int opcion; // Variable para controlar la opción del menú

        // Bucle principal del menú
        do {
            // Muestra el menú
            System.out.println(" MENÚ ");
            System.out.println("1. Agregar productos");
            System.out.println("2. Ver reporte de inventario");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt(); // Lee la opción del usuario
            scanner.nextLine(); // Limpia el salto de línea pendiente

            if (opcion == 1) {
                // Agregar productos al inventario
                System.out.print("¿Cuántos productos deseas agregar? ");
                int productosAgg = scanner.nextInt(); // Lee cuántos productos quiere agregar
                scanner.nextLine(); // Limpia el salto de línea

                for (int i = 0; i < productosAgg; i++) {
                    if (totalProductos < 5) { // Solo permite hasta 5 productos
                        // Pide el nombre del producto
                        System.out.print("Nombre del producto: ");
                        nombres[totalProductos] = scanner.nextLine();

                        // Pide la cantidad
                        System.out.print("Cantidad: ");
                        cantidades[totalProductos] = scanner.nextInt();

                        // Pide el precio por unidad
                        System.out.print("Precio por unidad: ");
                        precios[totalProductos] = scanner.nextDouble();
                        scanner.nextLine(); // Limpia el salto de línea

                        totalProductos++; // Aumenta el contador de productos
                    } else {
                        // Si ya hay 5 productos, muestra este mensaje y termina el ciclo
                        System.out.println("Ya no puedes agregar más productos");
                        break;
                    }
                }

            } else if (opcion == 2) {
                // Mostrar reporte de inventario
                double totalInventario = 0;
                System.out.println(" REPORTE DE INVENTARIO ");

                for (int i = 0; i < totalProductos; i++) {
                    // Calcula el valor total de cada producto (cantidad * precio)
                    double totalProducto = cantidades[i] * precios[i];
                    // Muestra los detalles del producto
                    System.out.println(nombres[i] + " - Cantidad: " + cantidades[i] +
                                       "  Precio: $" + precios[i] +
                                       "  Total: $" + totalProducto);
                    // Suma al total del inventario
                    totalInventario += totalProducto;
                }

                // Muestra el valor total de todos los productos en inventario
                System.out.println("Valor total del inventario: $" + totalInventario);

            } else if (opcion == 3) {
                // Salida del programa
                System.out.println("Saliendo del programa...");
            } else {
                // Si elige una opción inválida
                System.out.println("Opción no válida.");
            }

        } while (opcion != 3); // El ciclo se repite hasta que el usuario elija salir (3)
    }
}
