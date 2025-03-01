def busqueda_lineal(lista, objetivo):
    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i  
    return -1 

def busqueda_binaria(lista, objetivo):
    inicio, fin = 0, len(lista) - 1
    while inicio <= fin:
        medio = (inicio + fin) // 2
        if lista[medio] == objetivo:
            return medio
        elif lista[medio] < objetivo:
            inicio = medio + 1
        else:
            fin = medio - 1
    return -1

lista_numeros = [1, 3, 5, 7, 9, 11, 13]
print(busqueda_lineal(lista_numeros, 7))  
print(busqueda_binaria(lista_numeros, 7))  

