from collections import deque

''' Pila '''
print("--- Pila ---")

pila = []

pila.append(5)
pila.append(8)

print(pila[-1]) # 5

pila.pop()

print(pila[-1]) # 8

''' Cola '''
print("\n--- Cola ---")

cola = deque()

cola.append(5)
cola.append(8)

print(cola[0]) # 5

cola.popleft()

print(cola[0]) # 8