package Examen;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Paciente {
    String nombre;
    LocalTime horarioDeLlegada;  // Cambiar LocalDate a LocalTime

    // Constructor para Paciente
    public Paciente(String nombre, String horarioDeLlegada) {
        this.nombre = nombre;
        // Convertir la hora de llegada a LocalTime (solo horas y minutos)
        this.horarioDeLlegada = LocalTime.parse(horarioDeLlegada, DateTimeFormatter.ofPattern("HH:mm"));
    }
}

public class clinicaConsulta {

    // Método de ordenación burbuja para ordenar pacientes por hora de llegada
    public static void burbuja(List<Paciente> pacientes) {
        int n = pacientes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (pacientes.get(j).horarioDeLlegada.isAfter(pacientes.get(j + 1).horarioDeLlegada)) {
                    Collections.swap(pacientes, j, j + 1);
                }
            }
        }
    }

    // Método para imprimir el encabezado
    public static void encabezadoPgm() {
        // Datos del encabezado
        String nombre = "Miguel Angel Labrador Valencia";
        String campus = "Campus Cali, U. Cooperativa de Colombia";
        String repositorioGit = "https://github.com/Labrador09/EstructuraDeDatos/tree/805736ea8f232cef6433d1453d46b6e660516545/Sesion%204%20-%20trabajo%20en%20clase";

        // Obtener la fecha y hora actual
        LocalTime ahora = LocalTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm");
        String fechaHora = ahora.format(formateador);

        // Imprimir el encabezado
        System.out.println("+----------------------------------------");
        System.out.println("| 👤 Nombre: " + nombre);
        System.out.println("| 🎓 Campus: " + campus);
        System.out.println("| 📅 Hora actual: " + fechaHora);
        System.out.println("| 📂 Repositorio Git: " + repositorioGit);
        System.out.println("+----------------------------------------");
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar un nuevo turno");
            System.out.println("2. Mostrar turnos");
            System.out.println("3. Salir");
            System.out.print("Elija una opción (1-3): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántos pacientes desea agregar?: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();  

                    for (int i = 0; i < n; i++) {
                        System.out.print("Nombre del paciente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Hora de llegada del paciente (HH:mm): ");
                        String horarioDeLlegada = scanner.nextLine();

                        
                        pacientes.add(new Paciente(nombre, horarioDeLlegada));
                    }

                    burbuja(pacientes);
                    System.out.println(n + " pacientes han sido agregados y ordenados.");
                    break;

                case 2:
                    System.out.println("\nLista de pacientes ordenados por hora de llegada:");
                    for (Paciente p : pacientes) {
                        System.out.println(p.nombre + " - " + p.horarioDeLlegada.format(formatter));
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida, por favor ingrese una opción válida.");
                    break;
            }
        }
    }
}
