package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.MenuController;

public class InterfaceMenu extends JMenuBar{
	
	private static final long serialVersionUID = 1L;
	private JMenu menuRegles;
	private JMenuItem ssMenuNouvellePartie;
	private JMenu menuJeu;
	private JMenuItem ssMenuOuvrir;
	private JMenuItem ssMenuSauvegarder;
	private JMenuItem ssMenuQuitter;
	private JMenuItem ssMenuRegles;
	private JMenu menuResoudre;
	private JMenuItem ssMenuResoudre;
	private JMenuItem ssMenuResolution;
	
	public InterfaceMenu() {
		
		this.menuJeu = new JMenu("Jeu");
		this.menuRegles = new JMenu("Regles");
		this.menuResoudre = new JMenu("Resoudre");
		
		this.ssMenuNouvellePartie = new JMenuItem("Nouvelle Partie");
		this.ssMenuResoudre = new JMenuItem("Resoudre grille");
		this.ssMenuOuvrir = new JMenuItem("Ouvrir");
		this.ssMenuSauvegarder = new JMenuItem("Sauvegarder");
		this.ssMenuQuitter = new JMenuItem("Quitter");
		this.ssMenuRegles = new JMenuItem("Voir");
		
		this.ssMenuResolution = new JMenuItem("Lancer resolution");
		
		this.menuJeu.add(this.ssMenuNouvellePartie);
		this.menuJeu.add(this.ssMenuResoudre);
		this.menuJeu.add(this.ssMenuOuvrir);
		this.menuJeu.add(this.ssMenuSauvegarder);
		this.menuJeu.add(this.ssMenuQuitter);
		this.menuRegles.add(this.ssMenuRegles);
		
		this.menuResoudre.add(ssMenuResolution);
		
		this.add(this.menuJeu);
		this.add(this.menuRegles);
		this.add(this.menuResoudre);
		
		this.menuResoudre.setEnabled(false);
	
	}

	public void addMenuController(MenuController mc) {
		this.ssMenuNouvellePartie.addActionListener(mc);
		this.ssMenuOuvrir.addActionListener(mc);
		this.ssMenuSauvegarder.addActionListener(mc);
		this.ssMenuQuitter.addActionListener(mc);
		this.ssMenuResoudre.addActionListener(mc);
		
		this.ssMenuRegles.addActionListener(mc);
		this.ssMenuResolution.addActionListener(mc);
	}

	public JMenuItem getSsMenuRegles() {
		return ssMenuRegles;
	}

	public JMenuItem getSsMenuNouvellePartie() {
		return ssMenuNouvellePartie;
	}

	public JMenu getMenuJeu() {
		return menuJeu;
	}

	public JMenuItem getSsMenuOuvrir() {
		return ssMenuOuvrir;
	}

	public JMenuItem getSsMenuSauvegarder() {
		return ssMenuSauvegarder;
	}

	public JMenuItem getSsMenuQuitter() {
		return ssMenuQuitter;
	}

	public JMenuItem getSsMenuResoudre() {
		return ssMenuResoudre;
	}

	public void setSsMenuResoudre(JMenuItem ssMenuResoudre) {
		this.ssMenuResoudre = ssMenuResoudre;
	}

	public JMenuItem getSsMenuResolution() {
		return ssMenuResolution;
	}

	public void setSsMenuResolution(JMenuItem ssMenuResolution) {
		this.ssMenuResolution = ssMenuResolution;
	}

	public JMenu getMenuResoudre() {
		return menuResoudre;
	}
}
