#include <iostream>
#include <vector>
using namespace std;
 
class Red {
    int nodos;
    vector<vector<int>> adyacente;
public:
    Red(int n) {
        nodos = n;
        adyacente.resize(n);
    }
    void conectar(int origen, int destino) {
        adyacente[origen].push_back(destino);
    }
    void mostrar() {
        for (int i = 0; i < nodos; i++) {
            cout << "Nodo " << i << " -> ";
            for (int j : adyacente[i])
                cout << j << " ";
            cout << endl;
        }
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
    Red red(5);
    red.conectar(0, 1);
    red.conectar(0, 2);
    red.conectar(1, 3);
    red.conectar(2, 3);
    red.conectar(3, 4);
 
    cout << "Conexiones eléctricas:\n";
    red.mostrar();
    return 0;
}
