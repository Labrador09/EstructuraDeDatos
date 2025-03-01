import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Ejer52 {
    public static int sumaElementos(int[] arr) {
        int suma = 0;
        for (int num : arr) {
            suma += num;
        }
        return suma;
        
    }
    int[] arr = new int[10];
    int suma = 0;
        
   
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
        Random random = new Random();

        int n = 10;
        int[] arr = new int[10];
 
        System.out.println("------------TOTAL DE DEPOSITOS EN EL DIA-----------");
        for (int i = 0; i < 10; i++) {
            arr[i] =  random.nextInt(10000)+1000;
            System.out.println (arr[i]);
        }
 
        System.out.println("la suma total de depósitos realizados en el día es de:  " + sumaElementos(arr));
    }
    
}

