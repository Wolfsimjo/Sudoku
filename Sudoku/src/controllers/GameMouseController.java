package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import models.Case;
import models.Grille;
import views.InterfaceJeu;

public class GameMouseController implements MouseListener {

	InterfaceJeu ij;
	Grille grille;
	
	public GameMouseController(InterfaceJeu ij, Grille grille) {
		this.ij = ij;
		this.grille = grille;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
