package controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Game.Difficulte;
import Game.GestionSauvegarde;
import Game.GrilleStore;
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
				"Facile",
				"Moyen",
				"Difficile"
		};
		
		// Affichage d'un menu popup pour le choix de la difficulté
		int result = JOptionPane.showOptionDialog(
				menu, 
				"Choisissez la difficulté :", 
				"Difficulté", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE,
				null, 
				options, 
				options[0]);
		
		Difficulte difficulty;
		switch (result) {
			case 0:
				difficulty = Difficulte.FACILE; 
				break;
			case 1:
				difficulty = Difficulte.MOYEN;
				break;
			case 2:
				difficulty = Difficulte.DIFICILLE;
				break;
			default:
				difficulty = Difficulte.FACILE;
				break;
		}
		
		// Génération d'une grille aléatoire en fonction du niveau de difficulté
		GrilleStore gs = new GrilleStore();
		Grille newGrille = Grille.arrayToGrille(gs.choixGrille(difficulty));
		this.grille.setCases(newGrille.getCases());
		
	}

	/**
	 * Ouvrir une partie sauvegardée
	 */
	private void ouvrir() {
		JFileChooser dialogue = new JFileChooser(new File("."+File.separator));
		dialogue.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			Grille newGrille = GestionSauvegarde.charger(dialogue.getSelectedFile());
			this.grille.setCases(newGrille.getCases());
		}
	}

	/**
	 * Sauvegarder la partie en cours
	 */
	private boolean sauvegarder() {
		
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
			else if(reponse == JFileChooser.CANCEL_OPTION){
				return false;
			}
		}catch(HeadlessException he){
		          he.printStackTrace();
		          return false;
		}
		// TODO sauvegarde de la grille dans un fichier
		return true;
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
		
		// Oui => Quitter et sauvegarder
		// Non => Quitter sans sauvegarder
		// Annuler => Ne fais rien
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
		String regle = "Les règles du sudoku sont très simples.\r\n"+ 
			"Un sudoku classique contient neuf lignes et neuf colonnes, soit 81 cases au total.\r\n"+
			"Le but du jeu est de remplir ces cases avec des chiffres allant de 1 à 9 en veillant toujours\r\n"+
			"à ce qu'un même chiffre ne figure qu'une seule fois par colonne, \r\n"+
			"une seule fois par ligne, et une seule fois par carré de neuf cases.\r\n";
		
		JOptionPane.showMessageDialog(menu, regle);
	}

}
