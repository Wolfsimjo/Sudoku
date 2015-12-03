package controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

import Game.Difficulte;
import Game.GestionSauvegarde;
import Game.GrilleStore;
import models.Case;
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

		Difficulte difficulty = null;
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
				break;
		}
		
		// Génération d'une grille aléatoire en fonction du niveau de difficulté
		if (difficulty != null) {
			GrilleStore gs = new GrilleStore();
			Grille newGrille = Grille.arrayToGrille(gs.choixGrille(difficulty));
			this.grille.setCases(newGrille.getCases());
		}
		
	}

	/**
	 * Ouvrir une partie sauvegardée
	 */
	private void ouvrir() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Sudoku Grid", "sg");
		JFileChooser dialogue = new JFileChooser(new File("."+File.separator));
		dialogue.setFileFilter(filter);
		dialogue.setFileHidingEnabled(true);
		dialogue.setAcceptAllFileFilterUsed(false);
		dialogue.setFileSelectionMode(JFileChooser.FILES_ONLY);
		dialogue.setDialogTitle("Ouvrir une grille");
		
		if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			Grille newGrille;
			try {
				newGrille = GestionSauvegarde.charger(dialogue.getSelectedFile());
				for (Case[] ligne : newGrille.getCases()) {
					for (Case c : ligne) {
						c.setSelected(false);
						newGrille.setCase(c);
					}
				}
				this.grille.setCases(newGrille.getCases());
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(menu, "Wrong file format.", "Warning", JOptionPane.WARNING_MESSAGE);
				
			}
		}
	}

	/**
	 * Sauvegarder la partie en cours
	 */
	private boolean sauvegarder() {
		
		try{
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "Sudoku Grid", "sg");
		   JFileChooser chooser = new JFileChooser();
		   chooser.setFileFilter(filter);
		   chooser.setFileHidingEnabled(true);
		   chooser.setAcceptAllFileFilterUsed(false);
		   chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		   chooser.setDialogTitle("Sauvegarder une grille");
			
		   //Dossier Courant
		   chooser.setCurrentDirectory(new  File("."+File.separator)); 
		            
		   //Affichage et récupération de la réponse de l'utilisateur
		   int reponse = chooser.showDialog(chooser,"Enregistrer sous");
		     
		   //Si l'utilisateur clique sur OK
			if(reponse == JFileChooser.APPROVE_OPTION){
			  //Récupération du chemin du fichier
				File file = chooser.getSelectedFile();
				if (!FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("sg")) //Verifie l extension du fichier
				{
				    file = new File(file.getParentFile(), FilenameUtils.getBaseName(file.getName())+".sg"); //Ajoute la bonne extension
				}
			  GestionSauvegarde.sauvegarder(grille, file);
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
			boolean saved = sauvegarder();
			if (saved)
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
