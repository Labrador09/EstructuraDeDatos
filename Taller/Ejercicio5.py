"""
Universidad Cooperativa de Colombia - Campus
Nombre: Miguel Ángel Labrador Valencia
Fecha: 19 de Febrero de 2025
"""

import time
import random


def busqueda_lineal(lista, objetivo):
    """Búsqueda lineal (O(n))"""
    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i
    return -1

def busqueda_binaria(lista, objetivo):
    """Búsqueda binaria (O(log n))"""
    izquierda, derecha = 0, len(lista) - 1
    while izquierda <= derecha:
        medio = (izquierda + derecha) // 2
        if lista[medio] == objetivo:
            return medio
        elif lista[medio] < objetivo:
            izquierda = medio + 1
        else:
            derecha = medio - 1
    return -1

tamaños = [1000, 10000, 100000]

for tamaño in tamaños:
    lista = sorted(random.sample(range(tamaño * 10), tamaño))  # Lista ordenada sin duplicados
    objetivo = random.choice(lista)
    
    tiempo_inicio = time.time()
    busqueda_lineal(lista, objetivo)
    tiempo_lineal = time.time() - tiempo_inicio
    
    tiempo_inicio = time.time()
    busqueda_binaria(lista, objetivo)
    tiempo_binaria = time.time() - tiempo_inicio
    
    print(f"Tamaño de la lista: {tamaño}")
    print(f"Tiempo de búsqueda lineal: {tiempo_lineal:.5f} segundos")
    print(f"Tiempo de búsqueda binaria: {tiempo_binaria:.5f} segundos\n")
