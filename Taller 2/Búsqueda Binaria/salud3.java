import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
 
public class salud3 {

public static void main(String[] args) {
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
     
    class Usuario {
        String nombre;
        int edad;
        String diagnostico;
    
        Usuario(String nombre, String diagnostico, int edad) {
            this.nombre = nombre;
            this.diagnostico = diagnostico;
            this.edad = edad;
        }
    }
    ArrayList<Usuario> usuarios = new ArrayList<>();{
    usuarios.add(new Usuario("Manuel lucio", "Contusion", 14));
    usuarios.add(new Usuario("Ana Lucia", "Viruela", 50));
    usuarios.add(new Usuario("Xavi Hernandez", "Problemas respiratorios", 32));
    usuarios.add(new Usuario("Grizzman", "Fiebre", 32));
    usuarios.add(new Usuario("Kanye West", "Gripe", 33));
    usuarios.add(new Usuario("Lionel Messi", "Prueba de sangre", 38));
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el diagnóstico a buscar: ");
    String diagnosticoBuscado = scanner.nextLine();
    
    boolean encontrado = false;
    for (Usuario usuario : usuarios) {
        if (usuario.diagnostico.equalsIgnoreCase(diagnosticoBuscado)) {
            System.out.println("Nombre: " + usuario.nombre + ", Diagnóstico: " + usuario.diagnostico + ", Edad: " + usuario.edad);
            encontrado = true;
        }
    }
    
    if (!encontrado) {
        System.out.println("No se encontró ningún usuario con el diagnóstico: " + diagnosticoBuscado);
    }
    scanner.close();
    
}
}
}






