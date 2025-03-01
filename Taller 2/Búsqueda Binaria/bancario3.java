import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class bancario3 {
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
    public static class cliente {
        int id;
        String nombre;
        int telefono;
        boolean reportado;

        cliente(int id, String nombre, int telefono, boolean reportado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.reportado = true; // true = sospechoso
    }
}
public static void main(String[] args) {
        encabezadoPgm();
        ArrayList<cliente> clientes = new ArrayList<>();
    clientes.add(new cliente(1, "Pedrito", 300102020, false));
    clientes.add(new cliente(2, "Scarlett Johansson", 310203040, true));
    clientes.add(new cliente(3, "Robert Downey Jr.", 320405060, false));
    clientes.add(new cliente(4, "Jennifer Lawrence", 330607080, true));
    clientes.add(new cliente(5, "Tom Holland", 340809010, false));
    clientes.add(new cliente(6, "Emma Watson", 350901112, true));
    clientes.add(new cliente(7, "Chris Hemsworth", 361011213, false));
    clientes.add(new cliente(8, "Margot Robbie", 371213314, true));
    clientes.add(new cliente(9, "Keanu Reeves", 381415415, false));
    clientes.add(new cliente(10, "Zendaya", 391617516, true));

    Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente que desea buscar: ");
        int idBuscado = scanner.nextInt();
        cliente clienteEncontrada = null;
        for (cliente f : clientes) {
            if (f.id == idBuscado) {
                clienteEncontrada = f;
                break;
            }
        }
        if (clienteEncontrada != null) {
            System.out.println("cliente encontrado:");
            System.out.println("ID: " + clienteEncontrada.id);
            System.out.println("Nombre: " + clienteEncontrada.nombre);
            System.out.println("telefono: " + clienteEncontrada.telefono);
            System.out.println("estado: " + clienteEncontrada.reportado);
        } else {
            System.out.println("cliente con ID " + idBuscado + " no encontrado.");
        }

        scanner.close();
    }
}

