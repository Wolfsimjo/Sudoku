package Game;

public class Sudoku {
	private Grille grille;
	private Difficulte niveauDifficulte;
	private InterfaceGraphique gui;
	
	public Sudoku(Difficulte niveauDifficulte) {
		super();
		this.setNiveauDifficulte(niveauDifficulte);
	}

	public Sudoku(Grille grille) {
		super();
		this.setGrille(grille);
	}

	public void resetGrille(){
		
	}
	
	public void creerGrille(){
		
	}
	
	public void resoudreGrille(){
		
	}

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public Difficulte getNiveauDifficulte() {
		return niveauDifficulte;
	}

	public void setNiveauDifficulte(Difficulte niveauDifficulte) {
		this.niveauDifficulte = niveauDifficulte;
	}

	public InterfaceGraphique getGui() {
		return gui;
	}

	public void setGui(InterfaceGraphique gui) {
		this.gui = gui;
	}
}
