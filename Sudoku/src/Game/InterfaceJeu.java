package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class InterfaceJeu extends JPanel {

	private static final long serialVersionUID = -894299279968533611L;
	Grille grille;
	
	public InterfaceJeu() {
		
		this.grille = new Grille();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		this.grille.draw(g2d);
	}
}
