import java.util.Scanner;

public class inventarioTienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nombres = new String[5];
        int[] cantidades = new int[5];
        double[] precios = new double[5];
        int totalProductos = 0;

        int opcion;

        do {
            
            System.out.println(" MENÚ ");
            System.out.println("1. Agregar productos");
            System.out.println("2. Ver reporte de inventario");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
               
                System.out.print("¿Cuántos productos deseas agregar? ");
                int productosAgg = scanner.nextInt();
                scanner.nextLine(); 

                for (int i = 0; i < productosAgg; i++) {
                    if (totalProductos < 6) {
                        System.out.print("Nombre del producto: ");
                        nombres[totalProductos] = scanner.nextLine();

                        System.out.print("Cantidad: ");
                        cantidades[totalProductos] = scanner.nextInt();

                        System.out.print("Precio por unidad: ");
                        precios[totalProductos] = scanner.nextDouble();
                        scanner.nextLine(); 

                        totalProductos++;
                    } else {
                        System.out.println("Ya no puedes agregar más productos");
                        break;
                    }
                }

            } else if (opcion == 2) {
                
                double totalInventario = 0;
                System.out.println(" REPORTE DE INVENTARIO ");

                for (int i = 0; i < totalProductos; i++) {
                    double totalProducto = cantidades[i] * precios[i];
                    System.out.println(nombres[i] + " - Cantidad: " + cantidades[i] +
                                       "  Precio: $" + precios[i] +
                                       "  Total: $" + totalProducto);
                    totalInventario += totalProducto;
                }

                System.out.println("Valor total del inventario: $" + totalInventario);

            } else if (opcion == 3) {
               
            } else {
                System.out.println("Opción no válida.");
            }

        } while (opcion != 3);
    }
}





