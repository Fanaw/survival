import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class GestionEntite {
	
	private ArrayList<Entite> entites;
	
	public GestionEntite(){
		
		
		setEntites(new ArrayList<Entite>());
		
		
		
	}
	
	public void tick(){ // POUR TOUTES LES ENTITE ON TICK ET ON REGARDE SI ELLE EST EN VIE, SI C'EST PAS LE CAS ON LA RETIRE DE LA LISTE
		for(int i =0; i<getEntites().size();i++){
			Entite e = getEntites().get(i);
			e.tick();
			if(!e.enVie)
				entites.remove(e);
				
			
		}
		
	}
	
	public void dessine(Graphics g,JPanel jf){ // POUR TOUTES LES ENTITES ON DESSINE
		
		for(int i =0; i<getEntites().size();i++){
			Entite e = getEntites().get(i);
			e.dessine(g,jf);
			
				
		}
		
		
		
		
	}
	
	public void addEntite(Entite e){ // AJOUTER UNE ENTITE A LA LISTE entites
		entites.add(e);
	}
	
	
	// GETTER SETTER
	
	public ArrayList<Entite> getEntites() {
		return entites;
	}

	public void setEntites(ArrayList<Entite> entites) {
		this.entites = entites;
	}
	
	
	

}
