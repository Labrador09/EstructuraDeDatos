import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio3 {

    private static ArrayList<String> listaCompras;

    public Ejercicio3() {
        listaCompras = new ArrayList<>();
    }

    public void agregaProducto(String producto) {
        listaCompras.add(producto);
        System.out.println("El producto " + producto + "fue agregado ");

    }

    public void eliminarProducto(String producto) {
        if (listaCompras.contains(producto)) {
            listaCompras.remove(producto);
            System.out.println("El producto " + producto + "fue eliminado ");
        } else {
            System.out.println("INVALIDO NO SE ENCUENTRA EL PRODUCTO");
        }

    }

    public void verLista() {
        if (listaCompras.isEmpty()) {
            System.out.println("No hay nada en la lista");

        } else {
            System.out.println("La lista es: " + listaCompras);

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ejercicio3 lista = new Ejercicio3();   
        String opcion;

    do {
        System.out.println("\n--- Menú de la lista de compras ---");
        System.out.println("1. Agregar un producto");
        System.out.println("2. Eliminar un producto");
        System.out.println("3. Ver lista de compras");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción (1-4): ");
        opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                System.out.print("Ingresa el producto que deseas agregar: ");
                String productoAgregar = scanner.nextLine();
                lista.agregaProducto(productoAgregar);
                break;
            case "2":
                System.out.print("Ingresa el producto que deseas eliminar: ");
                String productoEliminar = scanner.nextLine();
                lista.eliminarProducto(productoEliminar);
                break;
            case "3":
                lista.verLista();
                break;
            case "4":
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción entre 1 y 4.");
        }

    } while (!opcion.equals("4"));

    scanner.close();
    }

}
