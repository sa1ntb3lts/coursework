import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		float saldo = 1000.00f;
		float monto;
		int id = 1;
		Operacion operacion;
		
		// Lista para el historial, Queue para pendientes y Pila para guardar las operaciones procesadas y deshacer la ultima.
		ArrayList<Operacion> historial = new ArrayList<Operacion>();
		Queue<Operacion> pendientes = new ArrayDeque<Operacion>();
		Deque<Operacion> procesadas = new ArrayDeque<Operacion>();
		
		int opcion;
		
		do {
			System.out.println("\n---------------------------");
			System.out.println("|| OPERACIONES BANCARIAS ||");
			System.out.println("---------------------------");
			System.out.println("1. Registrar deposito.");
			System.out.println("2. Registrar retiro.");
			System.out.println("3. Procesar operacion pendiente.");
			System.out.println("4. Consultar operaciones pendientes.");
			System.out.println("5. Historial de operaciones.");
			System.out.println("6. Consultar saldo.");
			System.out.println("7. Deshacer ultima operacion procesada.");
			System.out.println("0. Salir.");
			
			System.out.print("\n- Seleccione una opcion: ");
			opcion = input.nextInt();
			
			switch (opcion) {
				case 1:
					System.out.print("\nMonto a depositar: ");
					monto = input.nextFloat();
					
					operacion = new Operacion(id++, "Deposito.", monto, "Pendiente.");
					pendientes.offer(operacion);
					historial.add(operacion);
					
					break;
				case 2:
					System.out.print("\nMonto a retirar: ");
					monto = input.nextFloat();
					
					operacion = new Operacion(id++, "Retiro.", monto, "Pendiente.");
					pendientes.offer(operacion);
					historial.add(operacion);
					
					break;
				case 3:
					if (pendientes.isEmpty()) {
						System.out.println("\nNo hay operaciones para procesar.");
					} else {
						operacion = pendientes.poll(); 	// Retira de pendientes la primera operacion.
						
						/* En caso de que sea un deposito, se agrega el monto de la operacion al saldo y se anade
						 * la operacion al tope del stack. Funciona de la misma manera en un retiro, solo que necesita
						 * verificar que el saldo sea mayor o igual al monto, para que en caso de que la condicion no se 
						 * cumpla la operacion quedara como rechazada, por eso no se mete al stack de procesadas.
						 */
						if (operacion.getTipo().equalsIgnoreCase("Deposito.")) {
							saldo += operacion.getMonto();
							operacion.setEstado("Procesada.");
							procesadas.push(operacion);
							System.out.printf("\nID de la operacion: %d\n", operacion.getID());
						} else if (operacion.getTipo().equalsIgnoreCase("Retiro.")) {
							if (saldo >= operacion.getMonto()) {
								saldo -= operacion.getMonto();
								operacion.setEstado("Procesada.");
								procesadas.push(operacion);
								System.out.printf("\nID de la operacion: %d\n", operacion.getID());
							} else {
								operacion.setEstado("Rechazada.");
								System.out.printf("\nID de la operacion: %d - FONDOS INSUFICIENTES.\n", operacion.getID());
							}
						}
					}
					
					break;
				case 4:
					if(pendientes.isEmpty()) {
						System.out.println("\nNo hay operaciones pendientes.");
					} else {
						for(Operacion op : pendientes) {
							System.out.println(op);
						}
					}
					
					break;
				case 5:
					if(historial.isEmpty()) {
						System.out.println("\nNo se han realizado operaciones.");
					} else {
						for(Operacion op : historial) {
							System.out.println(op);
						}
					}
					break;
				case 6:
					System.out.printf("\nSaldo disponible: %.2f\n", saldo);
					break;
				case 7:
					if (procesadas.isEmpty()) {
						System.out.println("\nNo hay operaciones para deshacer.");
					} else {
						/* Utilizamos la funcion peek de las pilas para checar el tipo de la ultima operacion
						 * procesada, dependiendo de cual tipo sea se retira o se devuelve el monto al saldo.
						 */
						if (procesadas.peek().getTipo().equalsIgnoreCase("Deposito.")) {
							saldo -= procesadas.peek().getMonto();
						} else if (procesadas.peek().getTipo().equalsIgnoreCase("Retiro.")) {
							saldo += procesadas.peek().getMonto();
						}
						procesadas.peek().setEstado("Deshecha");
						System.out.printf("\nID de la operacion: %d\n", procesadas.peek().getID());
						procesadas.pop(); // Se saca la operacion deshecha de la pila para que no interfiera con las demas operaciones procesadas.
					}
					break;
				case 0:
					System.out.println("\nSaliendo del programa...");
					break;
				default:
					System.out.println("\nERROR! Opcion invalida");
					break;
			}
		} while (opcion != 0);
		
		input.close();
	}
}