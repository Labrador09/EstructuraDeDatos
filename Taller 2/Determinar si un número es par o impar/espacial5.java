import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class espacial5 {
    public static boolean esPar(int num) {
        return num % 2 == 0;
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
        Scanner scanner = new Scanner(System.in);
        List<Integer> lotesPares = new ArrayList<>();
        List<Integer> lotesImpares = new ArrayList<>();

        System.out.print("Ingrese el número de piezas que va a verificar: ");
        int totalLotes = scanner.nextInt();

        System.out.println("Ingrese los números de las piezas:");
        for (int i = 0; i < totalLotes; i++) {
            int lote = scanner.nextInt();
            if (esPar(lote)) {
                lotesPares.add(lote);
            } else {
                lotesImpares.add(lote);
            }
        }

        System.out.println("\nel numero de las piezas es (pares): " + lotesPares);
        System.out.println("el numero de las piezas es(impares): " + lotesImpares);

        scanner.close();
    }
}

