def encontrar_maximo(lista):
    maximo = lista[0]  
    for num in lista:
        if num > maximo:
            maximo = num
    return maximo

numeros = [2, 8, 1, 6, 12, 5, 3]
print(encontrar_maximo(numeros)) 
