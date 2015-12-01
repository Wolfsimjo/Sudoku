package views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import models.Case;
import models.Grille;

public class InterfaceJeu extends JPanel implements Observer {

	private static final long serialVersionUID = -894299279968533611L;
	private Grille grille;
	
	// Ancienne case sélectionnée
	public Case ancienneCase;
	// Case couramment sélectionnée
	public Case nouvelleCase;
	
	public InterfaceJeu(Grille grille) {
		
		this.grille = grille;
		this.ancienneCase = null;
		this.nouvelleCase = null;
		this.setFocusable(true);
		this.requestFocusInWindow();
				
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		this.grille.draw(g2d);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

	public Case getAncienneCase() {
		return ancienneCase;
	}

	public void setAncienneCase(Case ancienneCase) {
		this.ancienneCase = ancienneCase;
	}

	public Case getNouvelleCase() {
		return nouvelleCase;
	}

	public void setNouvelleCase(Case nouvelleCase) {
		this.nouvelleCase = nouvelleCase;
	}
	
}
