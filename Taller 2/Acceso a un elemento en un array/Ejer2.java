import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
 
public class Ejer2 {
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
    
    public static String obtenerPrimerElemento(String[] arr) {
        return arr[0];
    }
    public static void main(String[] args) {
        encabezadoPgm();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del array (número de routers activos):");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] arr = new String[n];
 
        System.out.println("Ingrese el tamaño del array (número de routers activos");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
 
        System.out.println("El primer nodo de la lista de routers activos es: " + obtenerPrimerElemento(arr));
        scanner.close();
    }
}