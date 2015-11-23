package Game;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.Serializable;

public class Grille implements Serializable{
	private static final long serialVersionUID = 2L;

	private Case[][] cases;
	
	/**
	 * Constructeur de grille vide
	 */
	public Grille() {
		this.cases = new Case[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int numeroRegion;
				if (i < 3 && j < 3)
					numeroRegion = 0;
				else if (i >= 3 && i < 6 && j <3)
					numeroRegion = 1;
				else if (i >= 6 && j < 3)
					numeroRegion = 2;
				else if (i < 3 && j >= 3 && j < 6)
					numeroRegion = 3;
				else if (i >= 3 && i < 6 && j >= 3 && j < 6)
					numeroRegion = 4;
				else if (i >= 6 && j >= 3 && j < 6)
					numeroRegion = 5;
				else if (i < 3 && j >= 6)
					numeroRegion = 6;
				else if (i >= 3 && i < 6 && j >= 6)
					numeroRegion = 7;
				else
					numeroRegion = 8;
				
				this.cases[i][j] = new Case(numeroRegion, i, j);
			}
		}
	}
	
	/**
	 * Constructeur de grille à partir d'un tableau de cases
	 * @param cases
	 */
	public Grille(Case[][] cases) {
		super();
		this.setCases(cases);
	}
	
	/**
	 * Méthode qui dessine la grille : 
	 * Dessine d'abord les cases du tableau cases
	 * Dessine ensuite les bordures des régions, plus épaisses
	 * @param g
	 */
	public void draw(Graphics2D g) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.cases[i][j].draw(g, i, j);
			}
		}
		
		// Bordures des régions 
		float epaisseur = 3;
		Stroke oldStroke = g.getStroke();
		g.setStroke(new BasicStroke(epaisseur));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				g.drawRect(Case.margin + i * Case.size*3, Case.margin + j * Case.size*3, Case.size*3, Case.size*3);
			}
		}
		g.setStroke(oldStroke);
	}
	
	/**
	 * Méthode pour récupérer une case en fonction de sa position physique
	 * @param clicX : position x d'un clic
	 * @param clicY : position y d'un clic
	 * @return : la case présente à cet endroit, null le cas échéant
	 */
	public Case getCase(int clicX, int clicY) {
		int positionX = (int) Math.floor((double)(clicX - Case.margin) / Case.size);
		int positionY = (int) Math.floor((double)(clicY - Case.margin) / Case.size);
		
		if (positionX >= 0 && positionX <= 8 && positionY >= 0 && positionY <= 8) {
			Case c = this.cases[positionX][positionY];
			return c;
		} else {
			return null;
		}
	}
	
	/**
	 * Méthode pour remplacer une case dans la grille
	 * @param c : la nouvelle case
	 * @param positionX : la position x dans le tableau cases de l'ancienne case
	 * @param positionY : idem pour y 
	 */
	public void setCase(Case c) {
		if (c != null) { 
			int positionX = c.getPositionX();
			int positionY = c.getPositionY();
			
			if (positionX >= 0 && positionX <= 8 && positionY >= 0 && positionY <= 8) {
				this.cases[positionX][positionY] = c;
			}
		}
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
