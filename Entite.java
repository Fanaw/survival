import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Entite {
	
	public static final int DEFAULT_vie = 10;
	
	
	
	
	protected float x, y;
	protected int largeur, hauteur;
	protected Rectangle bords;
	protected int vie;
	protected boolean enVie = true;
	
	
	public Entite(float x, float y, int largeur, int hauteur){
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		bords = new Rectangle(0,0,largeur,hauteur);
		vie = DEFAULT_vie;
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(int i = 0 ; i<Fenetre.gEntite.getEntites().size();i++){
			Entite e = Fenetre.gEntite.getEntites().get(i);
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){ // PREVOIR COLLISION 
		return new Rectangle((int) (x + bords.x + xOffset), (int) (y + bords.y + yOffset), bords.width, bords.height);
	}
	
	
	public void subisAttaque(int degat){
		vie -=degat;
		if(vie<=0){
			enVie = false;
			meurt();
		}
	}
	
	public void meurt(){
		
	}
	
	
	
	
	
	
	
	//GETTER SETTER 
	public void dessine(Graphics g){
		
		
		
	}
	
	public void tick(){}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

}
