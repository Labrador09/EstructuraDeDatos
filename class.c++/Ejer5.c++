#include <iostream>
#include <iomanip>
#include <ctime>
#include <stack>
using namespace std;

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
using namespace std;
 
void factorial(int n) {
    stack<int> pila;
    int resultado = 1;
    for (int i = n; i > 1; i--) {
        pila.push(i);
    }
    while (!pila.empty()) {
        resultado *= pila.top();
        pila.pop();
    }
    cout << "Factorial: " << resultado << endl;
}
 
int main() {
    factorial(5); // Output: 120
    return 0;
}
