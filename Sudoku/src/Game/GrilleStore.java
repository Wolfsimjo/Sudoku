package Game;

import java.util.ArrayList;
import java.util.Random;

public class GrilleStore {
	private ArrayList<int[][]> listFacile = new ArrayList<int[][]>();
	private ArrayList<int[][]> listMoyen = new ArrayList<int[][]>();
	private ArrayList<int[][]> listDifficile = new ArrayList<int[][]>();
	
	//Ensemble de grille facile
	private int[][]  grilleFacile1=
		{
	        {8,0,0, 0,0,0, 0,6,0},
	        {0,2,0, 7,1,0, 0,0,0},
	        {0,0,3, 8,6,0, 7,9,0},
	        
	        {4,0,7, 3,0,0, 2,1,0},
	        {9,0,5, 6,0,7, 8,0,4},
	        {0,3,8, 0,0,1, 6,0,5},
	        
	        {0,8,4, 0,7,2, 9,0,0},
	        {0,0,0, 0,9,3, 0,8,0},
	        {0,9,0, 0,0,0, 0,0,7}
	    };
	private int[][]  grilleFacile2=
		{
	        {9,0,0, 2,5,0, 7,0,6},
	        {0,4,0, 0,0,8, 1,0,0},
	        {2,0,0, 6,4,0, 0,8,9},
	        
	        {0,9,6, 3,2,0, 0,0,0},
	        {0,0,0, 0,0,0, 0,0,0},
	        {0,0,0, 0,6,7, 2,3,0},
	        
	        {1,3,0, 0,7,9, 0,0,8},
	        {0,0,8, 5,0,0, 0,9,0},
	        {5,0,9, 0,3,2, 0,0,1}
	    };
	private int[][]  grilleFacile3=
		{
	        {0,3,0, 0,8,0, 0,0,0},
	        {9,0,0, 0,0,1, 0,3,7},
	        {4,8,7, 9,3,6, 5,0,0},
	        
	        {0,0,0, 0,1,0, 0,0,8},
	        {0,1,4, 3,0,7, 2,6,0},
	        {7,0,0, 0,6,0, 0,0,0},
	        
	        {0,0,6, 8,5,3, 7,4,2},
	        {5,4,0, 1,0,0, 0,0,6},
	        {0,0,0, 0,2,0, 0,5,0}
	    };
	private int[][]  grilleFacile4=
		{
	        {0,8,0, 4,0,0, 0,5,0},
	        {7,0,0, 2,8,0, 1,3,4},
	        {0,4,0, 0,0,0, 7,8,2},
	        
	        {0,0,0, 0,7,3, 0,0,1},
	        {0,0,0, 8,0,5, 0,0,0},
	        {9,0,0, 6,1,0, 0,0,0},
	        
	        {4,3,9, 0,0,0, 0,1,0},
	        {2,6,8, 0,4,1, 0,0,9},
	        {0,1,0, 0,0,2, 0,4,0}
	    };
	
	//Ensemble de grille moyenne
	private int[][]  grilleMoyen1=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };
	private int[][]  grilleMoyen2=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };
	private int[][]  grilleMoyen3=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };
	private int[][]  grilleMoyen4=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };
	
	//Ensemble de grille difficile
	private int[][]  grilleDifficile1=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };
	private int[][]  grilleDifficile2=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };
	private int[][]  grilleDifficile3=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };
	private int[][]  grilleDifficile4=
		{
	        {9,0,0, 1,0,0, 0,0,5},
	        {0,0,5, 0,9,0, 2,0,1},
	        {8,0,0, 0,4,0, 0,0,0},
	        
	        {0,0,0, 0,8,0, 0,0,0},
	        {0,0,0, 7,0,0, 0,0,0},
	        {0,0,0, 0,2,6, 0,0,9},
	        
	        {2,0,0, 3,0,0, 0,0,6},
	        {0,0,0, 2,0,0, 9,0,0},
	        {0,0,1, 9,0,4, 5,7,0}
	    };

	public GrilleStore(){
		listFacile.add(grilleFacile1);
		listFacile.add(grilleFacile2);
		listFacile.add(grilleFacile3);
		listFacile.add(grilleFacile4);
		
		listMoyen.add(grilleMoyen1);
		listMoyen.add(grilleMoyen2);
		listMoyen.add(grilleMoyen3);
		listMoyen.add(grilleMoyen4);
		
		listDifficile.add(grilleDifficile1);
		listDifficile.add(grilleDifficile2);
		listDifficile.add(grilleDifficile3);
		listDifficile.add(grilleDifficile4);
	}
	
	public int[][] choixGrille(Difficulte dif){
		int[][] tmpArray = null;
		Random de = new Random();
		
		switch(dif){
			case FACILE:
				tmpArray = listFacile.get(de.nextInt(listFacile.size()));
				break;
			case MOYEN:
				tmpArray = listMoyen.get(de.nextInt(listMoyen.size()));
				break;
			case DIFICILLE:
				tmpArray = listDifficile.get(de.nextInt(listDifficile.size()));
				break;
		}
		return tmpArray;
	}
}
