"""
Universidad Cooperativa de Colombia - Campus
Nombre: Miguel Ángel Labrador Valencia
Fecha: 19 de Febrero de 2025
"""

import time

def fibonacci_recursivo(n):
    """Cálculo de Fibonacci usando recursión simple (O(2^n))"""
    if n <= 1:
        return n
    return fibonacci_recursivo(n - 1) + fibonacci_recursivo(n - 2)

def fibonacci_dinamico(n, memo={}):
    """Cálculo de Fibonacci usando programación dinámica (O(n))"""
    if n in memo:
        return memo[n]
    if n <= 1:
        return n
    memo[n] = fibonacci_dinamico(n - 1, memo) + fibonacci_dinamico(n - 2, memo)
    return memo[n]

n = 35 

tiempo_inicio = time.time()
fib_recursivo = fibonacci_recursivo(n)
tiempo_recursivo = time.time() - tiempo_inicio

tiempo_inicio = time.time()
fib_dinamico = fibonacci_dinamico(n)
tiempo_dinamico = time.time() - tiempo_inicio

print(f"Fibonacci recursivo ({n}): {fib_recursivo}, tiempo: {tiempo_recursivo:.5f} segundos")
print(f"Fibonacci dinámico ({n}): {fib_dinamico}, tiempo: {tiempo_dinamico:.5f} segundos")