package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import models.Case;
import models.Grille;
import views.InterfaceJeu;

/**
 * @author major
 * Controleur s'occupant de la gestion de la souris
 * 	- Clic sur une case modifiable => sélection
 */
public class GameMouseController implements MouseListener {

	InterfaceJeu ij;
	Grille grille;
	
	/**
	 * Constructeur du controleur
	 * @param ij => La vue associée, ici le JPanel du sudoku
	 * @param grille => Le modèle qu'on va altérer (la grille)
	 */
	public GameMouseController(InterfaceJeu ij, Grille grille) {
		this.ij = ij;
		this.grille = grille;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// Actualisation de la grille en fonction de la case cliquée		
		ij.ancienneCase = ij.nouvelleCase;
		if (ij.ancienneCase != null) {
			ij.ancienneCase.setSelected(false);
			grille.setCase(ij.ancienneCase);
		}
		
		int x = e.getX();
		int y = e.getY();
		int positionX = (int) Math.floor((double)(x - Case.margin) / Case.size);
		int positionY = (int) Math.floor((double)(y - Case.margin) / Case.size);
		ij.nouvelleCase = grille.getCase(positionX, positionY);
		if (ij.nouvelleCase != null) {
			ij.nouvelleCase.setSelected(true);
			grille.setCase(ij.nouvelleCase);
		}
	}

	// Non utilisés
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}

}
