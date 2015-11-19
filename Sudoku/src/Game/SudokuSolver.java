package Game;

public class SudokuSolver {
	public Grille resoudreGrille(Grille grille){
		//TODO
		return grille;		
	}
	
	
	public boolean absentSurLigne (int k, int grille[][], int i)
	{
	    for (int j=0; j < 9; j++)
	    {
	        if (grille[i][j] == k)
	            {return false;}
	    }
	    return true;
	}

	public boolean absentSurColonne (int k, int[][] grille, int j)
	{
	    for (int i=0; i < 9; i++)
	    {
	        if (grille[i][j] == k){
	            return false;}
	    }
	    return true;
	}

	public boolean absentSurBloc (int k, int grille[][], int i, int j)
	{
	    int _i = i-(i%3), _j = j-(j%3);  // ou encore : _i = 3*(i/3), _j = 3*(j/3);
	    for (i=_i; i < _i+3; i++){
	        for (j=_j; j < _j+3; j++){
	            if (grille[i][j] == k){
	                return false;}
	        }
	    }
	    return true;
	}
	
	public boolean firtsAlgo(int grille[][], int position)
	{
		  if (position == 9*9)
		        return true;
		    int i = position/9, j = position%9;
		    if (grille[i][j] != 0)
		        return firtsAlgo(grille, position+1);
		    for (int k=1; k <= 9; k++)
		    {
		        if (absentSurLigne(k,grille,i) && absentSurColonne(k,grille,j) && absentSurBloc(k,grille,i,j))
		        {
		            grille[i][j] = k;
		            if ( firtsAlgo (grille, position+1) )
		                return true;
		        }
		    }
		    grille[i][j] = 0;
		    return false;
	}
}
