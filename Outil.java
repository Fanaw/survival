import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Outil {// CODE POUR LIRE UN FICHIER ET RESSORTIR UNE VARIABLE TEXTE
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int rechercherNombreRessource(String nom){
		
		if(Fenetre.j1.ressources_joueur.size()>0){
			for(int i = 0; i < Fenetre.j1.ressources_joueur.size();i++){
				if(Fenetre.j1.ressources_joueur.get(i).nom==nom)
					return Fenetre.j1.ressources_joueur.get(i).nombre;
		
			}
			
		}
		return 0;
	}
	public static void setNombreRessource(String nom,int n){
		
		if(Fenetre.j1.ressources_joueur.size()>0){
			for(int i = 0; i < Fenetre.j1.ressources_joueur.size();i++){
				if(Fenetre.j1.ressources_joueur.get(i).nom==nom)
					Fenetre.j1.ressources_joueur.get(i).nombre-=n;
		
			}
			
		}
		
	}

}
