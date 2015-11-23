package Game;

import javax.swing.JFrame;

public class InterfaceGraphique extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private InterfaceMenu menu;
	
	public InterfaceGraphique () {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sudoku");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		
		this.menu = new InterfaceMenu();
		this.setJMenuBar(this.menu);
		
		InterfaceJeu ij = new InterfaceJeu();
		this.setContentPane(ij);

		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		InterfaceGraphique ig = new InterfaceGraphique();
	}
}
