package controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

import Game.GestionSauvegarde;
import models.Grille;
import views.InterfaceMenu;

/**
 * @author major
 * Controleur qui s'occupe de la gestion du JMenu
 */
public class MenuController implements ActionListener {
	
	InterfaceMenu menu;
	Grille grille;

	/**
	 * On initialise le controleur avec le menu et la grille
	 * @param menu
	 * @param grille
	 */
	public MenuController(InterfaceMenu menu, Grille grille) {
		this.menu = menu;
		this.grille = grille;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		

		// Exécute la fonction correspondante au menu sélectionné
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

	/**
	 * Lancement d'une nouvelle partie
	 */
	private void nouvellePartie() {
		// TODO Générer une nouvelle grille

	}

	/**
	 * Ouvrir une partie sauvegardée
	 */
	private void ouvrir() {
		// TODO ouvrir une grille sauvegardée
		JFileChooser dialogue = new JFileChooser(new File("."+File.separator));
		dialogue.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		    grille = GestionSauvegarde.charger(dialogue.getSelectedFile());
		   
		}
	}

	/**
	 * Sauvegarder la partie en cours
	 */
	private void sauvegarder() {
		
		try{
		   JFileChooser chooser = new JFileChooser();
		   //Dossier Courant
		   chooser.setCurrentDirectory(new  File("."+File.separator)); 
		            
		   //Affichage et récupération de la réponse de l'utilisateur
		   int reponse = chooser.showDialog(chooser,"Enregistrer sous");
		     
		   //Si l'utilisateur clique sur OK
			if(reponse == JFileChooser.APPROVE_OPTION){
			  //Récupération du chemin du fichier
			  GestionSauvegarde.sauvegarder(grille, chooser.getSelectedFile());
			}
		}catch(HeadlessException he){
		          he.printStackTrace();
		}
		// TODO sauvegarde de la grille dans un fichier
	}

	/**
	 * Quitter le jeu
	 */
	private void quitter() {
		sauvegarder();
		System.exit(0);
	}

	/**
	 * Afficher les règles
	 */
	private void afficherRegles() {
		// TODO Auto-generated method stub
		
	}

}
