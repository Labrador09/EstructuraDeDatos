#include <iostream>
#include <string>
using namespace std;
 
struct Especie {
    string nombre;
    Especie* izq;
    Especie* der;
};
 
Especie* nuevaEspecie(string nombre) {
    Especie* e = new Especie();
    e->nombre = nombre;
    e->izq = e->der = nullptr;
    return e;
}
 
Especie* insertar(Especie* raiz, string nombre) {
    if (raiz == nullptr) return nuevaEspecie(nombre);
    if (nombre < raiz->nombre) raiz->izq = insertar(raiz->izq, nombre);
    else raiz->der = insertar(raiz->der, nombre);
    return raiz;
}
 
void inorden(Especie* raiz) {
    if (raiz) {
        inorden(raiz->izq);
        cout << raiz->nombre << " ";
        inorden(raiz->der);
    }
}
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
    
    Especie* raiz = nullptr;
    raiz = insertar(raiz, "Tigre");
    insertar(raiz, "Elefante");
    insertar(raiz, "Mono");
    insertar(raiz, "Cebra");
    insertar(raiz, "Gorila");
 
    cout << "Especies en orden alfabético: ";
    inorden(raiz);
    return 0;
}
