import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Practica7 {
	public static void main(String[] args) {
		// Pila
		System.out.println("--- Pila ---");
	
		Deque<Integer> pila = new ArrayDeque<>();
	
		pila.push(5);
		pila.push(8);
	
		System.out.println(pila.peek()); // 8
	
		pila.pop();
	
		System.out.println(pila.peek()); // 5
	
	
		// Cola
		System.out.println("\n--- Cola ---");
		Queue<Integer> cola = new ArrayDeque<>();
		
		cola.offer(5);
		cola.offer(8);
		
		System.out.println(cola.peek()); // 5
		
		cola.poll();
		
		System.out.println(cola.peek()); // 8
	}
}