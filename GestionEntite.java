import java.awt.Graphics;
import java.util.ArrayList;

public class GestionEntite {
	
	private ArrayList<Entite> entites;
	
	public GestionEntite(){
		
		
		setEntites(new ArrayList<Entite>());
		
		
		
	}
	
	public void tick(){
		for(int i =0; i<getEntites().size();i++){
			Entite e = getEntites().get(i);
			e.tick();
			if(!e.enVie)
				entites.remove(e);
				
			
		}
		
	}
	
	public void dessine(Graphics g){
		
		for(int i =0; i<getEntites().size();i++){
			Entite e = getEntites().get(i);
			e.dessine(g);
		}
		
		
		
		
	}
	
	public void addEntite(Entite e){
		entites.add(e);
	}

	public ArrayList<Entite> getEntites() {
		return entites;
	}

	public void setEntites(ArrayList<Entite> entites) {
		this.entites = entites;
	}
	

}
