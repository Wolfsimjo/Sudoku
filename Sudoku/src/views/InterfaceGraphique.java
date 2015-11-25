package views;

import javax.swing.JFrame;

import controllers.GameKeyboardController;
import controllers.GameMouseController;
import models.Grille;

public class InterfaceGraphique extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private InterfaceMenu menu;
	private InterfaceJeu ij;
	
	public InterfaceGraphique (InterfaceJeu ij) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sudoku");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		
		this.menu = new InterfaceMenu();
		this.setJMenuBar(this.menu);
		
		this.ij = ij;
		this.setContentPane(ij);

		this.setVisible(true);
		
	}
	
	public void addControllers(GameKeyboardController gk, GameMouseController gm) {
		this.ij.addKeyListener(gk);
		this.ij.addMouseListener(gm);
	}
	
	public static void main(String[] args) {
		
		Grille model = new Grille();
		InterfaceJeu ij = new InterfaceJeu(model);
		InterfaceGraphique ig = new InterfaceGraphique(ij);
		GameKeyboardController gk = new  GameKeyboardController(ij, model);
		GameMouseController gm = new GameMouseController(ij, model);
		
		model.addObserver(ij);
		ig.addControllers(gk, gm);
	}
}
