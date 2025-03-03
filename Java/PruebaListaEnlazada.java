package Java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PruebaListaEnlazada {

    public static void encabezadoPgm() {
        // Datos del encabezado
        String nombre = "Miguel Angel Labrador Valencia";
        String campus = "Campus Cali, U. Cooperativa de Colombia";
        String repositorioGit = "https://github.com/Labrador09/EstructuraDeDatos/tree/805736ea8f232cef6433d1453d46b6e660516545/Sesion%204%20-%20trabajo%20en%20clase";

        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formateador);

        // Imprimir el encabezado
        System.out.println("+----------------------------------------");
        System.out.println("| 👤 Nombre: " + nombre);
        System.out.println("| 🎓 Campus: " + campus);
        System.out.println("| 📅 Fecha y hora: " + fechaHora);
        System.out.println("| 📂 Repositorio Git: " + repositorioGit);
        System.out.println("+----------------------------------------");
        System.out.println();
    }
    public static void main(String[] args) {

        ListaEnlazadaTransacciones lista = new ListaEnlazadaTransacciones();

        encabezadoPgm();

        lista.agregarTransaccion("T001", 500.0, "deposito");

        lista.agregarTransaccion("T002", 200.0, "retiro");

        lista.agregarTransaccion("T003", 1000.0, "deposito");

        System.out.println("Transacciones pendientes:");
        lista.mostrarTransacciones();
        Transaccion procesada = lista.procesarTransaccion();
        System.out.println("\nTransacción procesada: ID: " + procesada.getId());
        System.out.println("\nTransacciones pendientes:");
        lista.mostrarTransacciones();
    }
}
    

