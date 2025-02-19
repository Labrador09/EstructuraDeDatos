"""
Universidad Cooperativa de Colombia - Campus
Nombre: Miguel Ángel Labrador Valencia
Fecha: 19 de Febrero de 2025
"""

import time
import sys


sys.setrecursionlimit(2000)

def factorial_recursivo(n):
    """Cálculo del factorial usando recursión (O(n)) con manejo de límite"""
    if n == 0 or n == 1:
        return 1
    return n * factorial_recursivo(n - 1)

def factorial_dinamico(n):
    """Cálculo del factorial usando programación dinámica (O(n))"""
    resultado = 1
    for i in range(2, n + 1):
        resultado *= i
    return resultado


numero = 500  


tiempo_inicio = time.time()
try:
    factorial_recursivo(numero)
    tiempo_recursivo = time.time() - tiempo_inicio
except RecursionError:
    tiempo_recursivo = "Error: Profundidad de recursión excedida"


tiempo_inicio = time.time()
factorial_dinamico(numero)
tiempo_dinamico = time.time() - tiempo_inicio


print(f"Tiempo de ejecución Factorial Recursivo: {tiempo_recursivo}")
print(f"Tiempo de ejecución Factorial Dinámico: {tiempo_dinamico:.5f} segundos")