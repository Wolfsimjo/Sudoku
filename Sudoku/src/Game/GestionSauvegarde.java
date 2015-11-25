package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Grille;

public class GestionSauvegarde {
	
	public void sauvegarder(Grille grille, File file){	
		ObjectOutputStream oos = null;
		
		try
		{
			final FileOutputStream fichier = new FileOutputStream(file);
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(grille);
			oos.flush();
		} 
		catch (final java.io.IOException e) {
			e.printStackTrace();
		} 
		finally 
		{
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} 
			catch (final IOException ex) {
		    ex.printStackTrace();
		  }
		}
		//TODO
				
	}
	
	public Grille  charger(File file)
	{	
		    ObjectInputStream ois = null;

		    try {
		      final FileInputStream fichier = new FileInputStream(file);
		      ois = new ObjectInputStream(fichier);
		      final Grille uneGrille = (Grille) ois.readObject();
		      return uneGrille;
		    } catch (final java.io.IOException e) {
		      e.printStackTrace();
		    } catch (final ClassNotFoundException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        if (ois != null) {
		          ois.close();
		        }
		      } catch (final IOException ex) {
		        ex.printStackTrace();
		      }
		    }
		return null;
	}
}
