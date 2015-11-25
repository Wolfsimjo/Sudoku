package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InterfaceMenu extends JMenuBar{
	
	private static final long serialVersionUID = 1L;
	private JMenu menuRegles;
	private JMenuItem ssMenuNouvellePartie;
	private JMenu menuJeu;
	private JMenuItem ssMenuOuvrir;
	private JMenuItem ssMenuSauvegarder;
	private JMenuItem ssMenuQuitter;
	
	public InterfaceMenu() {
		
		this.menuJeu = new JMenu("Jeu");
		this.menuRegles = new JMenu("Règles");
		
		this.ssMenuNouvellePartie = new JMenuItem("Nouvelle Partie");
		this.ssMenuOuvrir = new JMenuItem("Ouvrir");
		this.ssMenuSauvegarder = new JMenuItem("Sauvegarder");
		this.ssMenuQuitter = new JMenuItem("Quitter");
		
		this.menuJeu.add(this.ssMenuNouvellePartie);
		this.menuJeu.add(this.ssMenuOuvrir);
		this.menuJeu.add(this.ssMenuSauvegarder);
		this.menuJeu.add(this.ssMenuQuitter);
		
		this.add(this.menuJeu);
		this.add(this.menuRegles);
	
	}

}
