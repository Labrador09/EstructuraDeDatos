package M2;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class M2Ejer2 {

    public static class SolucitudMantenimiento {  
        private String id;
        private String prioridad;
        public SolucitudMantenimiento siguiente;
        private String equipo;
            
        public SolucitudMantenimiento(String id, String equipo, String prioridad){
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

        public SolucitudMantenimiento getSiguiente() {
            return siguiente;
        }

        public String getEquipo() {
            return equipo;
        }

    }

    public static class ListaEnLazadaMantenimiento {  
        private SolucitudMantenimiento cabeza;

        public ListaEnLazadaMantenimiento() {
            this.cabeza = null;
        }

        public void agregarSolicitud( String id, String equipo, String prioridad) {
            SolucitudMantenimiento nueva = new SolucitudMantenimiento(id, equipo,prioridad);

            if (cabeza == null || prioridadEsMayor(nueva, cabeza)) {
                nueva.siguiente = cabeza;
                cabeza = nueva;
            } else {
                SolucitudMantenimiento temp = cabeza;
                while (temp.siguiente != null && !prioridadEsMayor(nueva, temp.siguiente)) {
                    temp = temp.siguiente;
                }
                nueva.siguiente = temp.siguiente;
                temp.siguiente = nueva;
            }
        }
     
        public SolucitudMantenimiento procesarSolicitud() {
            if (cabeza == null) {
                return null;
            }
            SolucitudMantenimiento procesada = cabeza;
            cabeza = cabeza.siguiente;
            return procesada;
        }

        public void mostrarSolicitudes() {
            SolucitudMantenimiento temp = cabeza;
            while (temp != null) {
                System.out.println("ID: " + temp.getId() + ", Equipo: " + temp.getEquipo() + ", Prioridad: " + temp.getPrioridad());
                temp = temp.siguiente;
            }
        }
     
        private boolean prioridadEsMayor(SolucitudMantenimiento nueva, SolucitudMantenimiento actual) {
            String[] niveles = {"alta", "media", "baja"};
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
     
          
            lista.agregarSolicitud("M001", "Bomba de Agua", "media");
            lista.agregarSolicitud("M002", "Generador Principal", "alta");
            lista.agregarSolicitud("M003", "Sistema de Ventilación", "baja");
            lista.agregarSolicitud("M004", "Sensor de Gas", "alta");
     
            System.out.println("Solicitudes pendientes:");
            lista.mostrarSolicitudes();
     
            SolucitudMantenimiento procesada = lista.procesarSolicitud();
            System.out.println("\nSolicitud procesada: ID: " + procesada.getId() + ", Equipo: " + procesada.getEquipo());
     
            
            System.out.println("\nSolicitudes pendientes:");
            lista.mostrarSolicitudes();
        }
    }
}

