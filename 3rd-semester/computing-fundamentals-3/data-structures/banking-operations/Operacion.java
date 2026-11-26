public class Operacion {
	// Atributos.
	private int id;
	private String tipo;
	private float monto;
	private String estado;
	
	// Constructor.
	public Operacion(int id, String tipo, float monto, String estado) {
		this.id = id;
		this.tipo = tipo;
		this.monto = monto;
		this.estado = estado;
	}
	
	// Setters.
	public void setID(int id) {
		this.id = id;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	// Getters.
	public int getID() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}
	public float getMonto() {
		return monto;
	}
	public String getEstado() {
		return estado;
	}
	
	// Este metodo es para imprimir correctamente las operaciones.
	public String toString() {
		return "\nID: " + id + " | Tipo: " + tipo + " | Monto: " + String.format("%.2f", monto) + " | Estado: " + estado;
	}
}