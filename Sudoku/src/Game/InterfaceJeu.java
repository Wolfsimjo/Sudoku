package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class InterfaceJeu extends JPanel {

	private static final long serialVersionUID = -894299279968533611L;
	private Grille grille;
	
	// Ancienne case sélectionnée
	private Case ancienneCase;
	// Case couramment sélectionnée
	private Case nouvelleCase;
	
	public InterfaceJeu() {
		
		this.grille = new Grille();
		this.ancienneCase = null;
		this.nouvelleCase = null;
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		this.addMouseListener(ml);
		this.addKeyListener(kl);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		this.grille.draw(g2d);
	}
	
	MouseListener ml = new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ancienneCase = nouvelleCase;
			if (ancienneCase != null) {
				ancienneCase.setSelected(false);
				grille.setCase(ancienneCase);
			}
			
			int x = e.getX();
			int y = e.getY();
			nouvelleCase = grille.getCase(x, y);
			if (nouvelleCase != null) {
				nouvelleCase.setSelected(true);
				grille.setCase(nouvelleCase);
			}
			repaint();
		}
		
		// Non utilisés //
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
	};
	
	KeyListener kl = new KeyListener() {
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			char key = arg0.getKeyChar();
			int nb = Character.getNumericValue(key);
			
			if (nouvelleCase != null) {
				if (nouvelleCase.isModifiable() && nouvelleCase.isSelected()) {
					nouvelleCase.setNombre(nb);
					grille.setCase(nouvelleCase);
					repaint();
				}
			}
		}
		
		// Non utilisés //
		@Override
		public void keyTyped(KeyEvent arg0) {}
		@Override
		public void keyReleased(KeyEvent arg0) {}
	};

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
