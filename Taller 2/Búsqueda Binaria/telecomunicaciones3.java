import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
 
public class telecomunicaciones3 {
    public static int busquedaBinaria(int[] arr, int target) {
        int izquierda = 0, derecha = arr.length - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arr[medio] == target) return medio;
            if (arr[medio] < target) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
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
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Ingrese el numero de personas en la lista: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
 
        System.out.println("Ingrese el numero escpecifica para cada persona en forma ordenada: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            System.out.println(" Persona " + (i + 1) + ": " + arr[i]);
        }
 
        System.out.print("Ingrese el numero especifico para resolver la queja: ");
        int target = scanner.nextInt();
 
        int resultado = busquedaBinaria(arr, target);
        if (resultado != -1) {
            System.out.println("La persona se encuentra en la posicion  " + resultado);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
}

