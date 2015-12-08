package views;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import controllers.GameKeyboardController;
import controllers.GameMouseController;
import controllers.MenuController;
import models.Case;
import models.Grille;

public class InterfaceGraphique extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private InterfaceMenu menu;
	private InterfaceJeu ij;
	
	public static int windowSizeX = 1000;
	public static int windowSizeY = 1000;
	
	public InterfaceGraphique (InterfaceJeu ij, InterfaceMenu menu) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sudoku");
		this.setSize(windowSizeX, windowSizeY);
		this.setLocationRelativeTo(null);
		
		this.menu = menu;
		this.setJMenuBar(this.menu);
		
		this.ij = ij;
		this.setContentPane(ij);
		
		this.setVisible(true);

		this.addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				JFrame newFrame = (JFrame) e.getSource();
				windowSizeX = newFrame.getWidth();
				windowSizeY = newFrame.getHeight();
				
				if (windowSizeX > windowSizeY)
					Case.size = (int) (windowSizeY / 14.286);
				else
					Case.size = (int) (windowSizeX / 14.286);
				
				Case.fontSize = (int) (Case.size / 2.8);
				Case.marginHorizontal = (int) (windowSizeX - 9*Case.size) / 2;
				Case.marginVertical = (int) (windowSizeY - 9*Case.size) / 2;
			}
			
			// Non utilisés
			@Override
			public void componentMoved(ComponentEvent e) {}
			@Override
			public void componentShown(ComponentEvent e) {}			
			@Override
			public void componentHidden(ComponentEvent e) {}
		});		
	}
	
	public void addControllers(GameKeyboardController gk, GameMouseController gm, MenuController mc) {
		this.ij.addKeyListener(gk);
		this.ij.addMouseListener(gm);
		this.menu.addMenuController(mc);
	}
}
