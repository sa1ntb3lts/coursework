import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Practice7 {
	public static void main(String[] args) {
		// Stack
		System.out.println("--- Stack ---");
	
		Deque<Integer> stack = new ArrayDeque<>();
	
		stack.push(5);
		stack.push(8);
	
		System.out.println(stack.peek()); // 8
	
		stack.pop();
	
		System.out.println(stack.peek()); // 5
	
	
		// Queue
		System.out.println("\n--- Queue ---");
		Queue<Integer> queue = new ArrayDeque<>();
		
		cola.offer(5);
		cola.offer(8);
		
		System.out.println(queue.peek()); // 5
		
		queue.poll();
		
		System.out.println(cola.queue()); // 8
	}
}
