package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Case {
	
	// Nombre dans la case
	private int nombre;
	
	// Numéro de la région (1-9)
	private int numeroRegion; 
	
	// Case modifiable ou non
	private boolean modifiable;
	
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
		
		g.setColor(Color.WHITE);
		g.fillRect(colonne * 50, ligne * 50, 50, 50);
		g.setColor(Color.BLACK);
		g.drawRect(colonne * 50, ligne *50, 50, 50);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g.drawString(Integer.toString(this.nombre), colonne * 50 + 20, ligne * 50 + 30);
		
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
