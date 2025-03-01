import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
 
public class Ejer1 {
    public static void encabezadoPgm(){
         // Datos del encabezado
        String nombre = "Miguel Angel Labrador Valencia";
        String campus = "Campus Cali, U. Cooperativa de Colombia";
        String repositorioGit = "https://github.com/Labrador09/EstructuraDeDatos.git";

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
        
        System.out.print("Ingrese, el numero de pacientes: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] arr = new String[n];
 
        System.out.println("ingrese los elementos del nombre de los pacientes");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
 
        System.out.println("El primer paciente de la lista es: " + obtenerPrimerElemento(arr));
        scanner.close();
    }
}
