#include <iostream>
using namespace std;
 
struct Producto {
    int codigo;
    Producto* izq;
    Producto* der;
};
 
Producto* nuevoProducto(int codigo) {
    Producto* p = new Producto();
    p->codigo = codigo;
    p->izq = p->der = nullptr;
    return p;
}
 
Producto* insertar(Producto* raiz, int codigo) {
    if (raiz == nullptr) return nuevoProducto(codigo);
    if (codigo < raiz->codigo) raiz->izq = insertar(raiz->izq, codigo);
    else raiz->der = insertar(raiz->der, codigo);
    return raiz;
}
 
bool buscar(Producto* raiz, int codigo) {
    if (raiz == nullptr) return false;
    if (raiz->codigo == codigo) return true;
    return (codigo < raiz->codigo) ? buscar(raiz->izq, codigo) : buscar(raiz->der, codigo);
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
    Producto* raiz = nullptr;
    raiz = insertar(raiz, 102);
    insertar(raiz, 85);
    insertar(raiz, 150);
    insertar(raiz, 60);
    insertar(raiz, 90);
 
    int codigoBuscado = 90;
    cout << "¿Existe el producto con código " << codigoBuscado << "? "
         << (buscar(raiz, codigoBuscado) ? "Sí" : "No") << endl;
    return 0;
}
