package views;

import javax.swing.JFrame;

import controllers.GameKeyboardController;
import controllers.GameMouseController;
import controllers.MenuController;
import models.Grille;

public class InterfaceGraphique extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private InterfaceMenu menu;
	private InterfaceJeu ij;
	
	public InterfaceGraphique (InterfaceJeu ij, InterfaceMenu menu) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sudoku");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		
		this.menu = menu;
		this.setJMenuBar(this.menu);
		
		this.ij = ij;
		this.setContentPane(ij);

		this.setVisible(true);
		
	}
	
	public void addControllers(GameKeyboardController gk, GameMouseController gm, MenuController mc) {
		this.ij.addKeyListener(gk);
		this.ij.addMouseListener(gm);
		this.menu.addMenuController(mc);
	}
	
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
