package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Case  implements Serializable{
	private static final long serialVersionUID = 5L;

	// Nombre dans la case
	private int nombre;
	
	// Numéro de la région (1-9)
	private int numeroRegion; 
	
	// Case modifiable ou non
	private boolean modifiable;
	
	// Taille de la case
	public static final int size = 70;
	// Marge à gauche et en haut du Sudoku
	public static final int margin = (int) (1000 - 9*size) / 2; // Centre le sudoku
	
	/**
	 * Constructeur pour case modifiable
	 */
	public Case(int numeroRegion) {
		this.numeroRegion = numeroRegion;
		this.nombre = 0;
		this.modifiable = true;
	}
	
	/**
	 * Constructeur pour case non modifiable
	 */
	public Case(int nombre, int numeroRegion) {
		this.nombre = nombre;
		this.numeroRegion = numeroRegion;
		this.modifiable = false;
	}

	public Case(int nombre, int numeroRegion, boolean modifiable) {
		this.nombre = nombre;
		this.numeroRegion = numeroRegion;
		this.modifiable = modifiable;
	}
	
	/**
	 * Méthode qui dessine une case en fonction de sa position
	 * @param g => Passé par le panel pour dessiner (méthode draw dans InterfaceJeu)
	 * @param colonne => 0-9
	 * @param ligne => 0-9
	 */
	public void draw(Graphics2D g, int colonne, int ligne) {
		
		// Dessine l'intérieur des cases (carré blanc)
		g.setColor(Color.WHITE);
		g.fillRect(margin + colonne * size, margin + ligne * size, size, size);
		// Dessine le contour des cases (carré vide noir)
		g.setColor(Color.BLACK);
		g.drawRect(margin + colonne * size, margin + ligne *size, size, size);
		
		// Dessine le nombre à l'intérieur de la case si celui-ci est compris entre 0 et 9
		if (this.nombre > 0 && this.nombre <= 9) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g.drawString(Integer.toString(this.nombre), margin + colonne * size + (int)(size / 2.5), margin + ligne * size + (int)(size / 2.5) + 10);
		}
		
	}
	
	// Getters et Setters //
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
