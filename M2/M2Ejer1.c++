#include <iostream>
#include <fstream>
#include <stack>
#include <string>
#include <sstream>

using namespace std;

struct Registro {
    string hora;
    double consumo;
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
    string nombreArchivo = "consumo.txt"; 
    ifstream archivo(nombreArchivo);

    if (!archivo) {
        cerr << "No se pudo abrir el archivo: " << nombreArchivo << endl;
        return 1;  
    }

    stack<Registro> pila;  

    string linea;
    while (getline(archivo, linea)) {
        stringstream ss(linea);
        string hora;
        double consumo;

        ss >> hora >> consumo; 

        Registro reg = {hora, consumo};
        pila.push(reg);

        if (consumo > 550) {
            cout << "¡Alerta! Consumo superior a 550 kW: " << hora << " - " << consumo << " kW" << endl;
        }
    }

    cout << "\nRegistros de consumo en orden inverso:" << endl;
    while (!pila.empty()) {
        Registro reg = pila.top();  
        cout << reg.hora << " - " << reg.consumo << " kW" << endl;
        pila.pop();  
    }

    archivo.close(); 
    return 0;
}