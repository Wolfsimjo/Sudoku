package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Grille;
import views.InterfaceMenu;

public class MenuController implements ActionListener {
	
	InterfaceMenu menu;
	Grille grille;

	public MenuController(InterfaceMenu menu, Grille grille) {
		this.menu = menu;
		this.grille = grille;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		
		if (e.getSource() == menu.getSsMenuNouvellePartie())
			nouvellePartie();
		else if (e.getSource() == menu.getSsMenuOuvrir())
			ouvrir();
		else if (e.getSource() == menu.getSsMenuSauvegarder())
			sauvegarder();
		else if (e.getSource() == menu.getSsMenuQuitter())
			quitter();
		else if (e.getSource() == menu.getSsMenuRegles())
			afficherRegles();
		
	}

	private void nouvellePartie() {
		// TODO Générer une nouvelle grille
		
	}

	private void ouvrir() {
		// TODO ouvrir une grille sauvegardée
		
	}

	private void sauvegarder() {
		// TODO sauvegarde de la grille dans un fichier
		
	}

	private void quitter() {
		sauvegarder();
		System.exit(0);
	}

	private void afficherRegles() {
		// TODO Auto-generated method stub
		
	}

}
