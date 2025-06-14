import java.util.Scanner;

public class VentasTiendas {}

    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);

        System.out.print("Cuántas tiendas quieres registrar? ");
        int cantidadTiendas = entradaUsuario.nextInt();

        System.out.print("Cuántos días de ventas vas a registrar? ");
        int cantidadDias = entradaUsuario.nextInt();
        int[][] matrizVentas = new int[cantidadTiendas][cantidadDias];

        // Registro de ventas por tienda y día
        for (int tienda = 0; tienda < cantidadTiendas; tienda++) {
            for (int dia = 0; dia < cantidadDias; dia++) {
                System.out.print("Ingrese la venta de la Tienda " + (tienda + 1) + " en el Día " + (dia + 1) + ": ");
                matrizVentas[tienda][dia] = entradaUsuario.nextInt();
            }
        }
}
        mostrarCantidadVentasMayoresA500k(matrizVentas);
        calcularPromedioVentasMenoresA100mil(matrizVentas);
        mostrarPosicionesVentasEnCero(matrizVentas);
        mostrarPosicionMayorVenta(matrizVentas);
        mostrarTotalVentasPorTienda(matrizVentas); 
    }
    public static void mostrarCantidadVentasMayoresA500mil(int[][] ventas) {
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

