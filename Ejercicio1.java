import java.util.Scanner;

    public class Ejercicio1 {
        
        public static void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
            int[] numeros = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.println("Ingrese el numero "+ ( i + 1) + ": ");
                numeros [i] = scanner.nextInt();
            }

            int MAYOR = numeros[0];
            int MENOR = numeros[0];

            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i] > MAYOR) {
                    MAYOR = numeros[i];
                }
                if (numeros[i] < MENOR) {
                    MENOR = numeros[i];
            }
        }
        System.out.println("El número mayor es: " + MAYOR);

        System.out.println("El numero menor es: " + MENOR);
        
        
        scanner.close();
    }
}