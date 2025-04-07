#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;
 
class Grafo {
    int V;
    vector<vector<int>> adyacente;
public:
    Grafo(int V) {
        this->V = V;
        adyacente.resize(V);
    }
    void agregarArista(int u, int v) {
        adyacente[u].push_back(v);
        adyacente[v].push_back(u); // No dirigido
    }
    void mostrar() {
        for (int i = 0; i < V; i++) {
            cout << i << ": ";
            for (int v : adyacente[i])
                cout << v << " ";
            cout << endl;
        }
    }
    void BFS(int inicio) {
        vector<bool> visitado(V, false);
        queue<int> cola;
        visitado[inicio] = true;
        cola.push(inicio);
 
        while (!cola.empty()) {
            int actual = cola.front(); cola.pop();
            cout << actual << " ";
            for (int v : adyacente[actual]) {
                if (!visitado[v]) {
                    visitado[v] = true;
                    cola.push(v);
                }
            }
        }
    }
 
    void DFS(int inicio) {
        vector<bool> visitado(V, false);
        stack<int> pila;
        pila.push(inicio);
 
        while (!pila.empty()) {
            int actual = pila.top(); pila.pop();
            if (!visitado[actual]) {
                cout << actual << " ";
                visitado[actual] = true;
            }
            for (int v : adyacente[actual]) {
                if (!visitado[v]) {
                    pila.push(v);
                }
            }
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
    Grafo g(5);
    g.agregarArista(0, 1);
    g.agregarArista(0, 4);
    g.agregarArista(1, 2);
    g.agregarArista(1, 3);
    g.agregarArista(1, 4);
    g.agregarArista(2, 3);
    g.agregarArista(3, 4);
 
    cout << "\nLista de adyacencia:" << endl;
    g.mostrar();
 
    cout << "\nRecorrido BFS desde nodo 0: ";
    g.BFS(0);
 
    cout << "\nRecorrido DFS desde nodo 0: ";
    g.DFS(0);
 
    return 0;
}
