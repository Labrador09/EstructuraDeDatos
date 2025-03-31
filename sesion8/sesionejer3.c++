#include <iostream>
#include <queue>
#include <thread>
#include <mutex>
#include <chrono>
using namespace std;
 
queue<string> transacciones;
mutex mtx;
 
void productor() {
    for (int i = 1; i <= 5; ++i) {
        this_thread::sleep_for(chrono::milliseconds(500));
        lock_guard<mutex> lock(mtx);
        string trans = "Transaccion #" + to_string(i);
        transacciones.push(trans);
        cout << "Producida: " << trans << endl;
    }
}
 
void consumidor() {
    for (int i = 1; i <= 5; ++i) {
        this_thread::sleep_for(chrono::milliseconds(800));
        lock_guard<mutex> lock(mtx);
        if (!transacciones.empty()) {
            cout << "Procesada: " << transacciones.front() << endl;
            transacciones.pop();
        }
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
    thread t1(productor);
    thread t2(consumidor);
    t1.join();
    t2.join();
    return 0;
}


