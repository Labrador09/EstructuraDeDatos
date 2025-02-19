"""
Universidad Cooperativa de Colombia - Campus
Nombre: Miguel Ángel Labrador Valencia
Fecha: 19 de Febrero de 2025
"""

import time

num_elementos = 100000

lista = []
tiempo_inicio = time.time()
for i in range(num_elementos):
    lista.append(i)
tiempo_lista = time.time() - tiempo_inicio

diccionario = {}
tiempo_inicio = time.time()
for i in range(num_elementos):
    diccionario[i] = i
tiempo_diccionario = time.time() - tiempo_inicio

print(f"Tiempo de inserción en lista: {tiempo_lista:.5f} segundos")
print(f"Tiempo de inserción en diccionario: {tiempo_diccionario:.5f} segundos")