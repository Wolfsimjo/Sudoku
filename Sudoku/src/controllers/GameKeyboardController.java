package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.Grille;
import views.InterfaceJeu;

public class GameKeyboardController implements KeyListener {

	InterfaceJeu ij;
	Grille grille;
	
	public GameKeyboardController(InterfaceJeu ij, Grille grille) {
		this.ij = ij;
		this.grille = grille;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		// Chiffre
		if (e.getKeyCode() >= 96 && e.getKeyCode() <=105) {
			char key = e.getKeyChar();			
			int nb = Character.getNumericValue(key);
			
			if (ij.nouvelleCase != null) {
				if (ij.nouvelleCase.isModifiable() && ij.nouvelleCase.isSelected()) {
					ij.nouvelleCase.setNombre(nb);
					grille.setCase(ij.nouvelleCase);
				}
			}
		}
		// Flèche
		else if (e.getKeyCode() >= 37 && e.getKeyCode() <= 40) {
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
					break;
				case 38:
					if (y > 0)
						y--;
					break;
				case 39:
					if (x < 8)
						x++;
					break;
				case 40:
					if (y < 8)
						y++;
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
		
	}

	// Non utilisé
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}

}
