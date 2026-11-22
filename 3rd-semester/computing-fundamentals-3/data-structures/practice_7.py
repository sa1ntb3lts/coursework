from collections import deque

''' Stack '''
print("--- Stack ---")

stack = []

stack.append(5)
stack.append(8)

print(stack[-1]) # 5

stack.pop()

print(stack[-1]) # 8

''' Queue '''
print("\n--- Queue ---")

queue = deque()

queue.append(5)
queue.append(8)

print(queue[0]) # 5

queue.popleft()

print(queue[0]) # 8
