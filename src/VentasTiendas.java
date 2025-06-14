import java.util.Scanner;

public class VentasTiendas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cuántas tiendas deseas registrar? ");
        int cantidadTiendas = scanner.nextInt();

        System.out.print("Cuántos días de ventas vas a registrar? ");
        int cantidadDias = scanner.nextInt();

        int[][] matrizVentas = new int[cantidadTiendas][cantidadDias];

        // Registro de ventas por tienda y día
        for (int tienda = 0; tienda < cantidadTiendas; tienda++) {
            for (int dia = 0; dia < cantidadDias; dia++) {
                System.out.print("Ingrese la venta de la Tienda " + (tienda + 1) + " en el Día " + (dia + 1) + ": ");
                matrizVentas[tienda][dia] = scanner.nextInt();
            }
        }

        CantidadVentasMayoresA500k(matrizVentas);
        calcularPromedioVentasMenoresA100mil(matrizVentas);
        mostrarPosicionesVentasEnCero(matrizVentas);
        mostrarPosicionMayorVenta(matrizVentas);
        mostrarTotalVentasPorTienda(matrizVentas); // BONUS
    }

    // Método 1: Cuenta las ventas mayores a $500.000
    public static void CantidadVentasMayoresA500k(int[][] ventas) {
        int contadorVentasAltas = 0;
        for (int[] filaTiendas : ventas) {
            for (int ventaDelDia : filaTiendas) {
                if (ventaDelDia > 500000) {
                    contadorVentasAltas++;
                }
            }
        }
        System.out.println(" Total de ventas mayores a $500.000: " + contadorVentasAltas);
    }

    // Método 2: Calcula el promedio de ventas menores a $100.000
    public static void calcularPromedioVentasMenoresA100mil(int[][] ventas) {
        int sumaVentasBajas = 0;
        int cantidadVentasBajas = 0;
        for (int[] filaTiendas : ventas) {
            for (int ventaDelDia : filaTiendas) {
                if (ventaDelDia > 0 && ventaDelDia < 100000) {
                    sumaVentasBajas += ventaDelDia;
                    cantidadVentasBajas++;
                }
            }
        }

        if (cantidadVentasBajas > 0) {
            double promedio = (double) sumaVentasBajas / cantidadVentasBajas;
            System.out.println(" Promedio de ventas menores a $100.000: $" + promedio);
        } else {
            System.out.println(" No se registraron ventas menores a $100.000.");
        }
    }

    // Método 3: Muestra las posiciones donde hubo ventas iguales a 0
    public static void mostrarPosicionesVentasEnCero(int[][] ventas) {
        for (int tienda = 0; tienda < ventas.length; tienda++) {
            for (int dia = 0; dia < ventas[tienda].length; dia++) {
                if (ventas[tienda][dia] == 0) {
                    System.out.println(" Venta en 0 en Tienda " + (tienda + 1) + ", Día " + (dia + 1));
                }
            }
        }
    }

    // Método 4: Devuelve la posición donde ocurrió la venta más alta
    public static void mostrarPosicionMayorVenta(int[][] ventas) {
        int valorMayorVenta = ventas[0][0];
        int tiendaMayor = 0;
        int diaMayor = 0;

        for (int tienda = 0; tienda < ventas.length; tienda++) {
            for (int dia = 0; dia < ventas[tienda].length; dia++) {
                if (ventas[tienda][dia] > valorMayorVenta) {
                    valorMayorVenta = ventas[tienda][dia];
                    tiendaMayor = tienda;
                    diaMayor = dia;
                }
            }
        }

        System.out.println(" Mayor venta fue de " + valorMayorVenta + " en Tienda " + (tiendaMayor + 1) + ", Día " + (diaMayor + 1));
    }

    // BONUS: Muestra el total de ventas por tienda,esta explicado en el readme
    public static void mostrarTotalVentasPorTienda(int[][] ventas) {
        for (int tienda = 0; tienda < ventas.length; tienda++) {
            int totalVentasTienda = 0;
            for (int dia = 0; dia < ventas[tienda].length; dia++) {
                totalVentasTienda += ventas[tienda][dia];
            }
            System.out.println("Total de ventas Tienda " + (tienda + 1) + ": $" + totalVentasTienda);
        }
    }
}

    