package Game;

import java.util.ArrayList;
import java.util.Random;

import models.Grille;

public class SudokuMaker {
	public Grille creerGrille(){
		//TODO
		return null;
	}
	
	public int[][] remplirZone(int tailleZone, int tailleGrille){
		int array[][] = new int[tailleZone][tailleZone];
		Random rand = new Random();
		ArrayList<Integer> listNombre = new ArrayList<Integer>();
		
		for(int i =0;i<tailleGrille;i++)
	    {
	        listNombre.add(i+1);
	    }
		System.out.println(listNombre.toString());
		for(int i = 0 ; i < array.length;i++){
			for(int j=0; j <array[i].length;j++)
			{
				int choix = rand.nextInt(listNombre.size());
				array[i][j] = listNombre.get(choix);
				listNombre.remove(choix);
			}
		}
		return array;
	}
	
	public int[][] remplirGrille(int tailleGrille){
		int array[][] = new int[tailleGrille][tailleGrille];
		int arrayTempo[][];
		for(int i = 0 ; i < array.length;i++){
			for(int j=0; j <array[i].length;j++)
			{
				array[i][j] = 0;
			}
		}
		
		//Remplir zone 1
		arrayTempo = remplirZone(3, tailleGrille);
		for(int i = 0 ; i < arrayTempo.length;i++){
			for(int j=0; j <arrayTempo[i].length;j++)
			{
				array[i][j] = arrayTempo[i][j];
			}
		}
		
		//Remplir zone 2
		arrayTempo = remplirZone(3, tailleGrille);
		int endOf = arrayTempo.length+3;
		for(int i = 3 ; i < endOf;i++){
			for(int j=3; j <endOf;j++)
			{
				array[i][j] = arrayTempo[i-3][j-3];
			}
		}
		
		//Remplir zone 3
		arrayTempo = remplirZone(3, tailleGrille);
		int endOf2 = arrayTempo.length+6;
		for(int i = 6 ; i < endOf2;i++){
			for(int j=6; j <endOf2;j++)
			{
				array[i][j] = arrayTempo[i-6][j-6];
			}
		}
		new SudokuSolver().firtsAlgo(array, 0);
		return array;
	}
}
