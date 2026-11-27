import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		float balance = 1000.00f;
		float amount;
		int id = 1;
		Operation operation;
		
		// List for history, Queue for pending operations, and Stack to save processed operations and undo the last one.
		ArrayList<Operation> history = new ArrayList<Operation>();
		Queue<Operation> pending = new ArrayDeque<Operation>();
		Deque<Operation> processed = new ArrayDeque<Operation>();
		
		int option;
		
		do {
			System.out.println("\n---------------------------");
			System.out.println("|| BANKING OPERATIONS ||");
			System.out.println("---------------------------");
			System.out.println("1. Register deposit.");
			System.out.println("2. Register withdrawal.");
			System.out.println("3. Process pending operation.");
			System.out.println("4. View pending operations.");
			System.out.println("5. Operation history.");
			System.out.println("6. Check balance.");
			System.out.println("7. Undo last processed operation.");
			System.out.println("0. Exit.");
			
			System.out.print("\n- Select an option: ");
			option = input.nextInt();
			
			switch (option) {
				case 1:
					System.out.print("\nAmount to deposit: ");
					amount = input.nextFloat();
					
					operation = new Operation(id++, "Deposit.", amount, "Pending.");
					pending.offer(operation);
					history.add(operation);
					
					break;
				case 2:
					System.out.print("\nAmount to withdraw: ");
					amount = input.nextFloat();
					
					operation = new Operation(id++, "Withdrawal.", amount, "Pending.");
					pending.offer(operation);
					history.add(operation);
					
					break;
				case 3:
					if (pending.isEmpty()) {
						System.out.println("\nNo operations to process.");
					} else {
						operation = pending.poll(); 	// Removes the first operation from pending.
						
						/* If it is a deposit, the operation amount is added to the balance and
- the operation is added to the top of the stack. It works the same way for a withdrawal, except it needs
- to verify that the balance is greater than or equal to the amount, so that if the condition is not
- met, the operation will be marked as rejected, which is why it is not pushed to the processed stack.
						 */
						if (operation.getType().equalsIgnoreCase("Deposit.")) {
							balance += operation.getAmount();
							operation.setStatus("Processed.");
							processed.push(operation);
							System.out.printf("\nOperation ID: %d\n", operation.getID());
						} else if (operation.getType().equalsIgnoreCase("Withdrawal.")) {
							if (balance >= operation.getAmount()) {
								balance -= operation.getAmount();
								operation.setStatus("Processed.");
								processed.push(operation);
								System.out.printf("\nOperation ID: %d\n", operation.getID());
							} else {
								operation.setStatus("Rejected.");
								System.out.printf("\nOperation ID: %d - INSUFFICIENT FUNDS.\n", operation.getID());
							}
						}
					}
					
					break;
				case 4:
					if(pending.isEmpty()) {
						System.out.println("\nNo pending operations.");
					} else {
						for(Operation op : pending) {
							System.out.println(op);
						}
					}
					
					break;
				case 5:
					if(history.isEmpty()) {
						System.out.println("\nNo operations have been performed.");
					} else {
						for(Operation op : history) {
							System.out.println(op);
						}
					}
					break;
				case 6:
					System.out.printf("\nAvailable balance: %.2f\n", balance);
					break;
				case 7:
					if (processed.isEmpty()) {
						System.out.println("\nNo operations to undo.");
					} else {
						/* We use the peek function of stacks to check the type of the last
- processed operation; depending on which type it is, the amount is subtracted from or returned to the balance.
						 */
						if (processed.peek().getType().equalsIgnoreCase("Deposit.")) {
							balance -= processed.peek().getAmount();
						} else if (processed.peek().getType().equalsIgnoreCase("Withdrawal.")) {
							balance += processed.peek().getAmount();
						}
						processed.peek().setStatus("Undone");
						System.out.printf("\nOperation ID: %d\n", processed.peek().getID());
						processed.pop(); // Removes the undone operation from the stack so it does not interfere with the other processed operations.
					}
					break;
				case 0:
					System.out.println("\nExiting program...");
					break;
				default:
					System.out.println("\nERROR! Invalid option");
					break;
			}
		} while (option != 0);
		
		input.close();
	}
}
