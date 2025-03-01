import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
 
public class telecomunicaciones4 {
    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
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
    public static int obtenerPrimerElemento(int[] arr) {
            return arr[0];
    }
    public static int maximo(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        encabezadoPgm();
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Ingrese el numero de torres: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
 
        System.out.println("Ingrese el numero de la intesidades de la señales: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Numero de intesidades de las torres ");
        for (int i = 0; i < n; i++) {
            System.out.println("Torre " + (i + 1) + ": " + arr[i] + " dBm");
        }
 
        burbuja(arr);
 
        System.out.println("Señales ordenadas: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nLa señal " + obtenerPrimerElemento(arr)+" dBm" + " tiene menor intensidad");
        System.out.println("La señal " + maximo(arr)+" dBm" + " tiene Mayor intensidad");
    }
}
