package Game;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Grille {
	private Case[][] cases;
	
	public Grille() {
		this.cases = new Case[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int numeroRegion;
				if (i < 3 && j < 3)
					numeroRegion = 0;
				else if (i >= 3 && i < 6 && j <3)
					numeroRegion = 1;
				else if (i >= 6 && j < 3)
					numeroRegion = 2;
				else if (i < 3 && j >= 3 && j < 6)
					numeroRegion = 3;
				else if (i >= 3 && i < 6 && j >= 3 && j < 6)
					numeroRegion = 4;
				else if (i >= 6 && j >= 3 && j < 6)
					numeroRegion = 5;
				else if (i < 3 && j >= 6)
					numeroRegion = 6;
				else if (i >= 3 && i < 6 && j >= 6)
					numeroRegion = 7;
				else
					numeroRegion = 8;
				
				this.cases[i][j] = new Case(numeroRegion, numeroRegion);
			}
		}
	}
	
	public Grille(Case[][] cases) {
		super();
		this.setCases(cases);
	}
	
	public void draw(Graphics2D g) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.cases[i][j].draw(g, i, j);
			}
		}
		
		float epaisseur = 3;
		Stroke oldStroke = g.getStroke();
		g.setStroke(new BasicStroke(epaisseur));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				g.drawRect(i * 150, j * 150, 150, 150);
			}
		}
		g.setStroke(oldStroke);

	}

	public boolean verifierLigne(int numeroLigne){
		//TODO 
		return false;
	}
	
	public boolean verifierColonne(int numeroColonne){
		//TODO 
		return false;
	}
	
	public boolean verifierRegion(int numeroRegion){
		//TODO 
		return false;
	}

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
}
