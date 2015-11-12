package Game;

public class Grille {
	private Case[][] cases;
	
	public Grille() {
		super();
	}
	
	public Grille(Case[][] cases) {
		super();
		this.setCases(cases);
	}

	public boolean verifierLigne(int numeroLigne){
		//TODO 
		return false;
	}
	
	public boolean verifierColonne(int numeroColonne){
		//TODO 
		return false;
	}
	
	public boolean verifierRegion(int numeroRegion){
		//TODO 
		return false;
	}

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
}
