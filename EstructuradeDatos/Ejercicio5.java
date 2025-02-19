import java.util.Scanner;

public class Ejercicio5 {

    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
      
        System.out.print("Ingrese el nombre de la ciudad que le interesa: ");
        String ciudad = scanner.nextLine();
        double celsius = 0;
        
    
        if (ciudad.equalsIgnoreCase("Cali")) {
            celsius = 25.0;
        } else if (ciudad.equalsIgnoreCase("Barranquilla")) {
            celsius = 31.0;
        } else if (ciudad.equalsIgnoreCase("Bogota")) {
            celsius = 10.0;
        
        } else {
            System.out.println("Lo siento, no tenemos datos para la ciudad: " + ciudad);
            scanner.close(); // Cerramos el scanner
            return; 
        }

        
        double fahrenheit = celsiusAFahrenheit(celsius);

        System.out.println("La temperatura en " + ciudad + " es de " + celsius + "°C, que equivale a " + fahrenheit + "°F.");
        
        scanner.close(); 
    }
}
        



