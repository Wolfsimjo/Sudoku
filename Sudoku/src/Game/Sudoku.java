package Game;

import controllers.GameKeyboardController;
import controllers.GameMouseController;
import controllers.MenuController;
import models.Grille;
import views.InterfaceGraphique;
import views.InterfaceJeu;
import views.InterfaceMenu;

public class Sudoku {
	
	public static void main(String[] args) {
		// Modèle
		Grille model = new Grille();
		
		// Vues
		InterfaceJeu ij = new InterfaceJeu(model);
		InterfaceMenu menu = new InterfaceMenu();
		InterfaceGraphique ig = new InterfaceGraphique(ij, menu);
		
		// Controleurs
		GameKeyboardController gk = new  GameKeyboardController(ij, model);
		GameMouseController gm = new GameMouseController(ij, model);
		MenuController mc = new MenuController(menu, model);
		
		model.addObserver(ij);
		ig.addControllers(gk, gm, mc);
	}
	
}
