

public class Recette{
	int bois,pierre;
	public Recette(int bois,int pierre) {
		this.bois=bois;
		this.pierre=pierre;
	}
	
	public String descriptionRecette(){
		return " : bois manquant = " + (bois-Outil.rechercherNombreRessource("bois")) + " // pierre manquante = " +(pierre-Outil.rechercherNombreRessource("pierre"));
	}
	
	
	
	public static Recette casque = new Recette(1,0);
	public static Recette cape = new Recette(2,0);
	public static Recette bottes = new Recette(3,0);
	public static Recette bouclier = new Recette(4,1);
	
}

