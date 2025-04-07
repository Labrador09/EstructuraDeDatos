#include <iostream>
#include <vector>
using namespace std;
 
class Ciudad {
    int nodos;
    vector<vector<int>> adyacente;
public:
    Ciudad(int n) {
        nodos = n;
        adyacente.resize(n);
    }
    void conectar(int u, int v) {
        adyacente[u].push_back(v);
        adyacente[v].push_back(u);
    }
    void mostrar() {
        for (int i = 0; i < nodos; i++) {
            cout << "Intersección " << i << ": ";
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
    Ciudad c(4);
    c.conectar(0, 1);
    c.conectar(0, 2);
    c.conectar(1, 3);
 
    cout << "Red de intersecciones:\n";
    c.mostrar();
    return 0;
}
