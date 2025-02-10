import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Para leer la entrada del usuario
        
        // Solicitar al usuario que ingrese una oración
        System.out.print("Ingresa una oración: ");
        String oracion = scanner.nextLine();
        
        // Llamamos a la función para contar las palabras
        contarPalabras(oracion);
        
        scanner.close();  // Cerramos el scanner
    }

   
    public static void contarPalabras(String oracion) {
    
        ArrayList<String> palabras = new ArrayList<>();
        ArrayList<Integer> conteos = new ArrayList<>();
        
        String[] arrayPalabras = oracion.split("\\s+");  // Dividir por espacios
        
        // Recorremos las palabras y contamos su frecuencia
        for (String palabra : arrayPalabras) {
            palabra = palabra.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");  // Normalizar palabra

            int index = palabras.indexOf(palabra);  // Buscar si la palabra ya está
            if (index != -1) {
                conteos.set(index, conteos.get(index) + 1);  // Aumentamos su contador
            } else {
                // Si no está, la agregamos con un conteo de 1
                palabras.add(palabra);
                conteos.add(1);
            }
        }
        
       
        System.out.println("Conteo de palabras:");
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i) + ": " + conteos.get(i));
        }
    }
}