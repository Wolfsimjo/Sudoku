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
import Game.SudokuSolver;
import models.Case;
import models.Grille;
import views.InterfaceMenu;

/**
 * @author major
 * Controleur qui s'occupe de la gestion du JMenu
 */
public class MenuController implements ActionListener {
	
	private InterfaceMenu menu;
	private Grille grille;

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
		else if(e.getSource() == menu.getSsMenuResoudre())
			demandeResoudre();
		else if(e.getSource() == menu.getSsMenuResolution())
			resoudre();
		
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
				"Choisissez la difficult\u00e9 :", 
				"Difficult\u00e9", 
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
				difficulty = Difficulte.DIFFICILE;
				break;
			default:
				break;
		}
		
		// Génération d'une grille aléatoire en fonction du niveau de difficulté
		if (difficulty != null) {
			int[][] grilleArray = GrilleStore.choixGrille(difficulty);
			
			if (grilleArray != null) {
				Grille newGrille = Grille.arrayToGrille(grilleArray);
				this.grille.setCases(newGrille.getCases());
			} else {
				JOptionPane.showMessageDialog(menu, "Vous n'\u00eates pas connect\u00e9 \u00e0 Internet", "Warning", JOptionPane.WARNING_MESSAGE);
			}
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
				JOptionPane.showMessageDialog(menu, "Mauvais format de fichier", "Warning", JOptionPane.WARNING_MESSAGE);
				
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
		String regle = "Les r\u00e8gles du sudoku sont tr\u00e8s simples.\r\n"+ 
			"Un sudoku classique contient neuf lignes et neuf colonnes, soit 81 cases au total.\r\n"+
			"Le but du jeu est de remplir ces cases avec des chiffres allant de 1 \u00e0 9 en veillant\r\n"+
			"toujours \u00e0 ce qu'un m\u00eame chiffre ne figure qu'une seule fois par colonne, une seule\r\n"+
			"fois par ligne et une seule fois par carr\u00e9 de neuf cases.\r\n";
		
		JOptionPane.showMessageDialog(menu, regle);
	}
	
	/**
	 * Passe en mode solveur
	 */
	private void demandeResoudre(){
		JOptionPane.showMessageDialog(menu, 
				"Veuillez rentrer une grille \u00e0 r\u00e9soudre et s\u00e9lectionner \"Lancer ex\u00e9cution\" dans le menu r\u00e9soudre.");
		this.menu.getMenuResoudre().setEnabled(true);
		this.grille.setCases(new Grille().getCases()); //Remise � zero de la grille
	}
	
	/**
	 * Lance la resolution
	 */
	private void resoudre(){
		this.menu.getMenuResoudre().setEnabled(false);
		int[][] tmparray = Grille.grilleToArray(grille);
		new SudokuSolver().firtsAlgo(tmparray, 0);  //Lancement de l'algorithme de resolution
		this.grille.setCases(Grille.arrayToGrille(tmparray).getCases());
	}
}
