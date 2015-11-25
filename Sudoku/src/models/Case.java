package models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.Serializable;

public class Case  implements Serializable{
	private static final long serialVersionUID = 5L;

	// Nombre dans la case
	private int nombre;
	
	// Numéro de la région (1-9)
	private int numeroRegion; 
	
	// Case modifiable ou non
	private boolean modifiable;
	
	// Case sélectionné ou non
	private boolean selected;
	
	// Position dans la grille
	private int positionX;
	private int positionY;
	
	// Taille de la case
	public static final int size = 70;
	// Marge à gauche et en haut du Sudoku
	public static final int margin = (int) (1000 - 9*size) / 2; // Centre le sudoku
	
	/**
	 * Constructeur pour case modifiable
	 */
	public Case(int numeroRegion, int x, int y) {
		this.nombre = 0;
		this.numeroRegion = numeroRegion;
		this.modifiable = true;
		this.selected = false;
		this.positionX = x;
		this.positionY = y;
	}
	
	/**
	 * Constructeur pour case non modifiable
	 */
	public Case(int nombre, int numeroRegion, int x, int y) {
		this.nombre = nombre;
		this.numeroRegion = numeroRegion;
		this.modifiable = false;
		this.selected = false;
		this.positionX = x;
		this.positionY = y;
	}

	public Case(int nombre, int numeroRegion, boolean modifiable, int x, int y) {
		this.nombre = nombre;
		this.numeroRegion = numeroRegion;
		this.modifiable = modifiable;
		this.selected = false;
		this.positionX = x;
		this.positionY = y;
	}
	
	/**
	 * Méthode qui dessine une case en fonction de sa position
	 * @param g => Passé par le panel pour dessiner (méthode draw dans InterfaceJeu)
	 * @param colonne => 0-9
	 * @param ligne => 0-9
	 */
	public void draw(Graphics2D g, int colonne, int ligne) {
		
		g.setColor(Color.WHITE);
		g.fillRect(margin + colonne * size, margin + ligne * size, size, size);
		
		Stroke oldStroke = g.getStroke();
		if (this.isSelected()) {
			g.setStroke(new BasicStroke(4));
			g.setColor(Color.BLUE);
		}
		else
			g.setColor(Color.BLACK);
		g.drawRect(margin + colonne * size, margin + ligne *size, size, size);
		g.setStroke(oldStroke);
		g.setColor(Color.BLACK);
		
		// Dessine le nombre à l'intérieur de la case si celui-ci est compris entre 0 et 9
		if (this.nombre > 0 && this.nombre <= 9) {
			if (this.isModifiable())
				g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
			g.drawString(Integer.toString(this.nombre), margin + colonne * size + (int)(size / 2.5), margin + ligne * size + (int)(size / 2.5) + 10);
			g.setColor(Color.BLACK);
		}
		
	}
	
	public String toString() {
		return "Case en x :" + this.positionX + " y : " + this.positionY + " Chiffre : " + this.nombre;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		if (this.modifiable)
			this.selected = selected;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}	
	
}
