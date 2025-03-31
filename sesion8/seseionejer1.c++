#include <iostream>
#include <queue>
#include <string>
using namespace std;
 
struct Siniestro {
    string descripcion;
    int prioridad;
    bool operator<(const Siniestro& otro) const {
        return prioridad < otro.prioridad;
    }
};
void encabezadoPgm() {
    // Datos del encabezado
    string nombre = "Miguel Angel Labrador Valencia";
    string campus = "Campus Cali, U. Cooperativa de Colombia";
    string repositorioGit = "https://github.com/Labrador09/EstructuraDeDatos/tree/805736ea8f232cef6433d1453d46b6e660516545/Sesion%204%20-%20trabajo%20en%20clase";
    
    time_t now = time(0);
    tm *ltm = localtime(&now);
 
    char fechaHora[20];
    strftime(fechaHora, sizeof(fechaHora), "%d/%m/%Y %H:%M:%S", ltm);
 
    cout << "+----------------------------------------" << endl;
    cout << "| 👤 Nombre: " << nombre << endl;
    cout << "| 🎓 Campus: " << campus << endl;
    cout << "| 📅 Fecha y hora: " << fechaHora << endl;
    cout << "| 📂 Repositorio Git: " << repositorioGit << endl;
    cout << "+----------------------------------------" << endl;
    cout << endl;
}
int main() {
    encabezadoPgm();
    priority_queue<Siniestro> cola;
    cola.push({"Robo leve", 1});
    cola.push({"Incendio", 3});
    cola.push({"Accidente vial", 2});
 
    while (!cola.empty()) {
        cout << "Procesando: " << cola.top().descripcion << endl;
        cola.pop();
    }
    return 0;
}

