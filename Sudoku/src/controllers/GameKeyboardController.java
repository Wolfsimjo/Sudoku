package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.Grille;
import views.InterfaceJeu;

/**
 * @author major
 * Controleur s'occupant de la gestion du clavier
 * 	- Entrée d'un chiffre au clavier dans une case
 *  - Utilisation des flèches pour le déplacement sur le sudoku
 */
public class GameKeyboardController implements KeyListener {

	InterfaceJeu ij;
	Grille grille;
	
	/**
	 * Constructeur du controleur
	 * @param ij => La vue associée, ici le JPanel du sudoku
	 * @param grille => Le modèle qu'on va altérer (la grille)
	 */
	public GameKeyboardController(InterfaceJeu ij, Grille grille) {
		this.ij = ij;
		this.grille = grille;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		// Flèche : si on est au bord du sudoku à droite par exemple
		// 			et qu'on utilise la flèche droite => on revient
		//			au début de la ligne
		if (e.getKeyCode() >= 37 && e.getKeyCode() <= 40) {
			ij.ancienneCase = ij.nouvelleCase;
			if (ij.ancienneCase != null) {
				ij.ancienneCase.setSelected(false);
				grille.setCase(ij.ancienneCase);
			}
			
			int x = ij.ancienneCase.getPositionX();
			int y = ij.ancienneCase.getPositionY();
			switch (e.getKeyCode()) {
				case 37:
					if (x > 0)
						x--;
					else
						x=8;
					break;
				case 38:
					if (y > 0)
						y--;
					else
						y=8;
					break;
				case 39:
					if (x < 8)
						x++;
					else
						x=0;
					break;
				case 40:
					if (y < 8)
						y++;
					else
						y=0;
					break;
				default:
					break;
			}
			
			ij.nouvelleCase = grille.getCase(x, y);
			if (ij.nouvelleCase != null) {
				ij.nouvelleCase.setSelected(true);
				grille.setCase(ij.nouvelleCase);
			}
		}
		
		// Chiffre
		else {
			char key = e.getKeyChar();			
			int nb = Character.getNumericValue(key);
			
			// Backspace or del
			if (e.getKeyCode() == 8 || e.getKeyCode() == 127)
				nb = 0;
			
			if (ij.nouvelleCase != null && nb >= 0 && nb <= 9) {
				if (ij.nouvelleCase.isModifiable() && ij.nouvelleCase.isSelected()) {
					ij.nouvelleCase.setNombre(nb);
					grille.setCase(ij.nouvelleCase);
				}
			}
		}
		
	}

	// Non utilisés
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}

}
