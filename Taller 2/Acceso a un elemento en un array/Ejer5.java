import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Ejer5 {
    public static int obtenerPrimeraTransaccion(int[] arr) {
        return arr[0];
    }
    public static void encabezadoPgm(){
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
        encabezadoPgm();

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuantas transacciones quiere ver? : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] arr = new String[n];
        int[] temp = new int[n];
        int[] transacciones = new int[n];
        

        System.out.println("Generando Transacciones del dia...");
        for (int i = 0; i < n; i++) {
            transacciones[i] = random.nextInt(10000000) + 10000000;  // Genera un número aleatorio entre 0 y 100
        }

        // Mostrar las lecturas generadas
        System.out.println("Transacciones del dia de hoy: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Transaccion " + (i + 1) + ": " + transacciones[i]+ " $ ");
        }
        System.out.println("\n La primera transaccion del dia es: " + obtenerPrimeraTransaccion(transacciones));

}
}
