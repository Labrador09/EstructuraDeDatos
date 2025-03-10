package Examen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SoporteTecnico {

    public static class sistemaDePrioridad {  
        private String id;
        private String prioridad;
        public sistemaDePrioridad siguiente;
        private String equipo;
            
        public sistemaDePrioridad(String id, String equipo, String prioridad){
            this.id = id;
            this.equipo = equipo;
            this.prioridad = prioridad.toLowerCase();
            this.siguiente = null;
        }

        public String getId() {
            return id;
        }

        public String getPrioridad() {
            return prioridad;
        }

        public sistemaDePrioridad getSiguiente() {
            return siguiente;
        }

        public String getEquipo() {
            return equipo;
        }

    }

    public static class ListaEnLazadaMantenimiento {  
        private sistemaDePrioridad cabeza;

        public ListaEnLazadaMantenimiento() {
            this.cabeza = null;
        }

        public void agregarSolicitud( String id, String equipo, String prioridad) {
         sistemaDePrioridad nueva = new sistemaDePrioridad(id, equipo,prioridad);

            if (cabeza == null || prioridadEsMayor(nueva, cabeza)) {
                nueva.siguiente = cabeza;
                cabeza = nueva;
            } else {
             sistemaDePrioridad temp = cabeza;
                while (temp.siguiente != null && !prioridadEsMayor(nueva, temp.siguiente)) {
                    temp = temp.siguiente;
                }
                nueva.siguiente = temp.siguiente;
                temp.siguiente = nueva;
            }
        }
     
        public sistemaDePrioridad procesarSolicitud() {
            if (cabeza == null) {
                return null;
            }
         sistemaDePrioridad procesada = cabeza;
            cabeza = cabeza.siguiente;
            return procesada;
        }

        public void mostrarSolicitudes() {
         sistemaDePrioridad temp = cabeza;
            while (temp != null) {
                System.out.println("ID: " + temp.getId() + ", Problema: " + temp.getEquipo() + ", Prioridad: " + temp.getPrioridad());
                temp = temp.siguiente;
            }
        }
     
        private boolean prioridadEsMayor (sistemaDePrioridad nueva, sistemaDePrioridad actual) {
            String[] niveles = {"Criticas", "Importantes", "Generales"};
            int prioridadNueva = java.util.Arrays.asList(niveles).indexOf(nueva.getPrioridad());
            int prioridadActual = java.util.Arrays.asList(niveles).indexOf(actual.getPrioridad());
            return prioridadNueva < prioridadActual;
        }
    }

    public static class PruebaListaMantenimiento {
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
            ListaEnLazadaMantenimiento lista = new ListaEnLazadaMantenimiento();
            Scanner scanner = new Scanner(System.in);
     
            while (true) {
                System.out.println("\nOpciones:");
                System.out.println("1. Agregar Solicitud");
                System.out.println("2. Mostrar Solicitudes");
                System.out.println("3. Salir");
                System.out.print("Elija una opción (1-3): ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (opcion) {
                    case 1:
                        System.out.print("¿Cuántos solicitudes desea agragar?: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();  
    
                        for (int i = 0; i < n; i++) {
                            System.out.print("Escriba el ID de la solicitud: ");
                            String id = scanner.nextLine();
                            System.out.print("Escriba el problema: ");
                            String equipo = scanner.nextLine();
                            System.out.print("Escriba la prioridad del problema: ");
                            String prioridad = scanner.nextLine();
    
                           lista.agregarSolicitud(id, equipo, prioridad);
                        }
    
                        System.out.println(n + " solicitudes han sido agregadas y ordenadas por prioridad.");
                        break;

                    case 2:
                        System.out.println("\nLista de solicitudes ordenadas según su prioridad:");
                        lista.mostrarSolicitudes();
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
}