import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
       
        String[] nombres = {"Juan", "Messi", "Firu", "Goku"};
        String[] telefonos = {"5616516814", "987654321", "555123456", "666789012"};
        
       
        Scanner scanner = new Scanner(System.in);
        
      
        System.out.print("Ingrese el nombre de la persona para buscar su número de teléfono: ");
        String nombre = scanner.nextLine();
        
       
        boolean encontrado = false;
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                System.out.println("El número de teléfono de " + nombre + " es: " + telefonos[i]);
                encontrado = true;
                break;
            }
        }
        
        
        if (!encontrado) {
            System.out.println("No se encontro el usuario " + nombre);
        }
        
        scanner.close();
    }
}

