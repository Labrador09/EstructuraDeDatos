"""
Universidad Cooperativa de Colombia - Campus
Nombre: Miguel Ángel Labrador Valencia
Fecha: 19 de Febrero de 2025
"""

import time
import random

def bubble_sort(arr):
 
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

def merge_sort(arr):

    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result

tamanio = 10000
lista_original = [random.randint(0, 100000) for _ in range(tamanio)]

lista_bubble = lista_original.copy()
tiempo_inicio = time.time()
bubble_sort(lista_bubble)
tiempo_bubble = time.time() - tiempo_inicio

lista_merge = lista_original.copy()
tiempo_inicio = time.time()
merge_sort(lista_merge)
tiempo_merge = time.time() - tiempo_inicio

print(f"Tiempo de ejecución Bubble Sort: {tiempo_bubble:.5f} segundos")
print(f"Tiempo de ejecución Merge Sort: {tiempo_merge:.5f} segundos")
