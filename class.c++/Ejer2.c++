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
 
bool validarExpresion(string expr) {
    stack<char> pila;
    for (char c : expr) {
        if (c == '(') {
            pila.push(c);
        } else if (c == ')') {
            if (pila.empty()) return false;
            pila.pop();
        }
    }
    return pila.empty();
}
 
int main() {
    encabezadoPgm();
    string expresion = "(5+3)*(2+(4-1))";
    if (validarExpresion(expresion))
        cout << "Expresión válida." << endl;
    else
        cout << "Expresión inválida." << endl;
    return 0;
}
