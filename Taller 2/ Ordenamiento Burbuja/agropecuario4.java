import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Parcela {
    String nombre;
    LocalDate fechaSiembra;

    public Parcela(String nombre, String fechaSiembra) {
        this.nombre = nombre;
        this.fechaSiembra = LocalDate.parse(fechaSiembra, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

public class agropecuario4 {

    public static void burbuja(List<Parcela> parcelas) {
        int n = parcelas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (parcelas.get(j).fechaSiembra.isAfter(parcelas.get(j + 1).fechaSiembra)) {
                    Collections.swap(parcelas, j, j + 1);
                }
            }
        }
    }

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
        encabezadoPgm();
        Scanner scanner = new Scanner(System.in);
        List<Parcela> parcelas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Ingrese el número de parcelas: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre de la parcela: ");
            String nombre = scanner.nextLine();
            System.out.print("Fecha de siembra (dd/MM/yyyy): ");
            String fechaSiembra = scanner.nextLine();
            parcelas.add(new Parcela(nombre, fechaSiembra));
        }

        burbuja(parcelas);

        System.out.println("Parcelas ordenadas por fecha de siembra:");
        for (Parcela p : parcelas) {
            System.out.println(p.nombre + " - " + p.fechaSiembra.format(formatter));
        }
    }
}