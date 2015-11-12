package Game;

public class Case {
	private int nombre;
	private int numeroRegion;
	private boolean modifiable;
	
	public Case(int numeroRegion) {
		super();
		this.numeroRegion = numeroRegion;
	}
	public Case(int nombre, int numeroRegion, boolean modifiable) {
		super();
		this.nombre = nombre;
		this.numeroRegion = numeroRegion;
		this.modifiable = modifiable;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getNumeroRegion() {
		return numeroRegion;
	}
	public void setNumeroRegion(int numeroRegion) {
		this.numeroRegion = numeroRegion;
	}
	public boolean isModifiable() {
		return modifiable;
	}
	public void setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
	}	
}
