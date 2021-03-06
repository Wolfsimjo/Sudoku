package models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class Grille extends Observable implements Serializable{
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
				g.drawRect(Case.marginHorizontal + i * Case.size*3, Case.marginVertical + j * Case.size*3, Case.size*3, Case.size*3);
			}
		}
		
		if (this.isGrilleFull()) {
			String validity = this.isGrilleValide();
			
			if (validity.charAt(0) == 'F') {
				g.setStroke(new BasicStroke(5));
				g.setColor(Color.RED);
				
				char zone = validity.charAt(1);
				int nb = Character.getNumericValue(validity.charAt(2));
				
				if (zone == 'C') {
					g.drawRect(Case.marginHorizontal + nb * Case.size, Case.marginVertical, Case.size, Case.size*9);
				} else if (zone == 'L') {
					g.drawRect(Case.marginHorizontal, Case.marginVertical + nb * Case.size, Case.size*9, Case.size);
				} else if (zone == 'R') {
					g.drawRect(Case.marginHorizontal + (nb%3) * 3 * Case.size, Case.marginVertical + (nb%3) * 3 * Case.size, Case.size*3, Case.size*3);
				}
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
	public Case getCase(int positionX, int positionY) {
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
				
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Retourne le tableau d entier associe a une grille
	 * @param grille
	 * @return
	 */
	static public int[][] grilleToArray(Grille grille){
		Case[][] tmp = grille.cases;
		int[][] array = new int[9][9];
		for(int i = 0; i< tmp.length;i++){
			for(int j = 0; j < tmp[i].length;j++){
				array[tmp[i][j].getPositionX()][tmp[i][j].getPositionY()] = tmp[i][j].getNombre();
			}
		}
		return array;
	}
	
	/**
	 * Retourne la grille correspondant a un tableau d entier donne
	 * @param array
	 * @return
	 */
	static public Grille arrayToGrille(int[][] array){
		Grille tmpGrille = new Grille();
		
		for(int i = 0; i< array.length;i++){
			for(int j = 0; j < array[i].length;j++){
				tmpGrille.getCase(i, j).setNombre(array[i][j]);
				if(array[i][j] != 0){ //Rend non modifiable les cases pleines
					tmpGrille.getCase(i, j).setModifiable(false);
				}
			}
		}
		return tmpGrille;
	}
	
	/**
	 * Verifie si la grille est valide
	 */
	public String isGrilleValide(){
		for(int i = 0 ; i < 9 ; i++)
		{
			if(!(isColonneValide(i))){
				return "FC"+i;
			}
			if(!(isLigneValide(i))){
				return "FL"+i;
			}
			if(!isRegionValide(i)){
				return "FR"+i;
			}
		}
		return "T";
	}
	
	/**
	 * Verifie si la ligne passee en parametre repond au condition d unicite de chiffre
	 * @param numeroLigne
	 * @return
	 */
	public boolean isLigneValide(int numeroLigne)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int iBcl=0; iBcl<9;iBcl++){
			if(cases[iBcl][numeroLigne].getNombre()!=0){ //Si la case n'est pas vide
				if(list.contains(cases[iBcl][numeroLigne].getNombre())){ //Si la case contient un nombre deja dans la liste
					return false;
				}
				else{
					list.add(cases[iBcl][numeroLigne].getNombre());
				}
			}
		}
		return true;
	}
	
	/**
	 * Verifie si la colonne passee en parametre repond a la condition d unicite de chiffre
	 * @param numeroColonne
	 * @return
	 */
	public boolean isColonneValide(int numeroColonne){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int iBcl=0; iBcl<9;iBcl++){
			if(cases[numeroColonne][iBcl].getNombre()!=0){ //Sila case n'est pas vide
				if(list.contains(cases[numeroColonne][iBcl].getNombre())){ //Si la case contient un nombre deja dans la liste 
					return false;
				}
				else{
					list.add(cases[numeroColonne][iBcl].getNombre());
				}
			}
		}
		return true;
	}
	
	/**
	 * Verifie si une region est valide	
	 * @param numeroRegion doit etre compris entre 1 et 9
	 * @return
	 */
	public boolean isRegionValide(int numeroRegion){
		int xI = 0,xF= 0,yI= 0,yF= 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		xI = (numeroRegion%3)*3;
		yI = (numeroRegion/3)*3;
		xF = xI + 2;
		yF = yI + 2;
		for(int i = xI; i <= xF; i++){
			for(int j = yI; j <= yF; j++){
				if(cases[i][j].getNombre()!=0){ //Si la case n'est pas vide
					if(list.contains(cases[i][j].getNombre())){ //Si la case contient un nombre deja dans la liste
						System.out.println("i : "+i+" j : "+j);
						return false;
					}
					else{
						list.add(cases[i][j].getNombre());
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Methode qui verifie que la grille est rempli
	 * @return
	 */
	public boolean isGrilleFull(){
		for(int i = 0; i < cases.length;i++){
			for(int j = 0; j < cases[i].length; j++){
				if(cases[i][j].getNombre() == 0){
					return false;
				}
			}
		}
		return true;
	}

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
				
		// On notifie la nouvelle grille
		this.setChanged();
		this.notifyObservers();
	}
}
