import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Pedido implements Comparable<Pedido> { 
    String cliente;
    LocalDate fecha;

    public Pedido(String cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public int compareTo(Pedido otro) {
        return this.fecha.compareTo(otro.fecha);
    }
}


public class Agropecuario3 { // Corregir nombre de la clase
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
    public static int busquedaBinaria(List<Pedido> pedidos, LocalDate fechaBuscada) {
        int izquierda = 0, derecha = pedidos.size() - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparacion = pedidos.get(medio).fecha.compareTo(fechaBuscada);
            
            if (comparacion == 0) return medio;
            if (comparacion < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        encabezadoPgm();
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Ingrese el número de pedidos: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Cliente: ");
            String cliente = scanner.nextLine();
            System.out.print("Fecha (dd/MM/yyyy): ");
            String fecha = scanner.nextLine();
            pedidos.add(new Pedido(cliente, fecha)); 
        }

        Collections.sort(pedidos);

        System.out.print("Ingrese la fecha a buscar (dd/MM/yyyy): ");
        LocalDate fechaBuscada = LocalDate.parse(scanner.nextLine(), formatter);

        int resultado = busquedaBinaria(pedidos, fechaBuscada);
        if (resultado != -1) {
            System.out.println("Pedido encontrado: " + pedidos.get(resultado).cliente + " en fecha " + pedidos.get(resultado).fecha);
        } else {
            System.out.println("No se encontraron pedidos en esa fecha.");
        }
    }
}