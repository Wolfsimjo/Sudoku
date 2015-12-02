package controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
		String[] options = {
				"FACILE",
				"MOYEN",
				"DIFFICILE"
		};
		
		int difficulty = JOptionPane.showOptionDialog(
				menu, 
				"Choisissez la difficulté :", 
				"Difficulté", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE,
				null, 
				options, 
				options[0]);
		
		//TODO: Générer grille en fonction de la difficulté
		
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
		String[] options = {
			"Oui",
			"Non",
			"Annuler"
		};
		
		int response = JOptionPane.showOptionDialog(
				menu, 
				"Voulez-vous sauvegarder votre progression avant de quitter ?",
				"Quitter",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]
				);
		
		if (response == 0) {
			sauvegarder();
			// TODO: Ne pas quitter si la sauvegarde n'a pas été effectuée => Changer le retour de sauvegarder()
			System.exit(0);
		} else if (response == 1) {
			System.exit(0);
		}
		
	}

	/**
	 * Afficher les règles
	 */
	private void afficherRegles() {
		// TODO: Générer une fenêtre popup avec les  regles	
		/*
			Les règles du sudoku sont très simples. 
			Un sudoku classique contient neuf lignes et neuf colonnes, donc 81 cases au total.

			Le but du jeu est de remplir ces cases avec des chiffres allant de 1 à 9 en veillant toujours 
			à ce qu'un même chiffre ne figure qu'une seule fois par colonne, 
			une seule fois par ligne, et une seule fois par carré de neuf cases.
		 * */
	}

}
