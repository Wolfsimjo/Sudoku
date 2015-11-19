package Game;

import java.io.Serializable;

public class Grille implements Serializable{
	private static final long serialVersionUID = 2L;
	private Case[][] cases;
	
	public Grille() {
		super();
	}
	
	public Grille(Case[][] cases) {
		super();
		this.setCases(cases);
	}
	
	public int[][] grilleToArray(Grille grille){
		//TODO Fonction de conversion de la grille (vers tableau)
		return null;
	}
	
	public Grille arrayToGrille(int[][] array){
		//TODO Fonction de conversion de la grille (vers Grille)
		return null;
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
