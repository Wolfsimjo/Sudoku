package views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.Case;
import models.Grille;

public class InterfaceJeu extends JPanel implements Observer {

	private static final long serialVersionUID = -894299279968533611L;
	private Grille grille;
	
	private boolean grilleOver;
	
	// Ancienne case sélectionnée
	public Case ancienneCase;
	// Case couramment sélectionnée
	public Case nouvelleCase;
	
	public InterfaceJeu(Grille grille) {
		this.grilleOver = false;
		
		this.grille = grille;
		this.ancienneCase = null;
		this.nouvelleCase = null;
		this.setFocusable(true);
		this.requestFocusInWindow();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image img = new ImageIcon(this.getClass().getResource("/images/Background.png")).getImage();
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		this.grille.draw(g2d);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		
		if (!grilleOver && this.grille.isGrilleFull()) {
			if (this.grille.isGrilleValide().charAt(0) == 'T') {
				this.grilleOver = true;
				JOptionPane.showMessageDialog(
						this, 
						"Vous avez gagné !! Félicitations !",
						"Champions !",
						JOptionPane.INFORMATION_MESSAGE
						);
			}
		}
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
