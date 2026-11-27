public class Operation {
	// Attributes.
	private int id;
	private String type;
	private float amount;
	private String status;
	
	// Constructor.
	public Operation(int id, String type, float amount, String status) {
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.status = status;
	}
	
	// Setters.
	public void setID(int id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	// Getters.
	public int getID() {
		return id;
	}
	public String getType() {
		return type;
	}
	public float getAmount() {
		return amount;
	}
	public String getStatus() {
		return status;
	}
	
	// This method is to print operations properly.
	public String toString() {
		return "\nID: " + id + " | Type: " + type + " | Amount: " + String.format("%.2f", amount) + " | Status: " + status;
	}
}
