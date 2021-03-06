package Game;

import models.Grille;

public class SudokuSolver {
	
	/**
	 * Methode qui resoud la grille
	 * @param grille
	 * @return
	 */
	public Grille resoudreGrille(Grille grille){
		int[][] arrayTmp = Grille.grilleToArray(grille);
		this.firtsAlgo(arrayTmp, 0);
		return Grille.arrayToGrille(arrayTmp);		
	}
	
	/**
	 * Verifie que le nombre passe en parametre n est pas sur la ligne
	 * @param k
	 * @param grille
	 * @param i
	 * @return
	 */
	public boolean absentSurLigne(int k, int grille[][], int i)
	{
	    for(int j=0; j < 9; j++)
	    {
	        if(grille[i][j] == k){
	        	return false;
        	}
	    }
	    return true;
	}

	/**
	 * Verifie que le nombre passe en parametre n est pas sur la colonne
	 * @param k
	 * @param grille
	 * @param j
	 * @return
	 */
	public boolean absentSurColonne(int k, int[][] grille, int j)
	{
	    for(int i=0; i < 9; i++)
	    {
	        if(grille[i][j] == k){
	            return false;
            }
	    }
	    return true;
	}

	/**
	 * Verifie que le nombre n est pas present sur le bloc considere
	 * @param k
	 * @param grille
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean absentSurBloc(int k, int grille[][], int i, int j)
	{
	    int _i = i-(i%3), _j = j-(j%3);
	    for(i=_i; i < _i+3; i++){
	        for(j=_j; j < _j+3; j++){
	            if(grille[i][j] == k){
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	public boolean firtsAlgo(int grille[][], int position)
	{
		if(position == 9*9){//Si on a atteint la fin de la grille
	        return true;
	    }
		
	    int i = position/9, j = position%9;
	    if(grille[i][j] != 0){ //Si la case actuelle contient un chiffre entre 1 et 9
	    	return firtsAlgo(grille, position+1); //On passe a la case suivnte
	    }
	    
	    for(int k=1; k <= 9; k++)
	    {
	        if(absentSurLigne(k,grille,i) && absentSurColonne(k,grille,j) && absentSurBloc(k,grille,i,j)) //Si le nombre peut etre place
	        {
	            grille[i][j] = k; //On affecte le nombre
	            if(firtsAlgo(grille, position+1) )//On passe a la case suivante
	                return true;
	        }
	    }
	    grille[i][j] = 0;
	    return false;
	}
}
