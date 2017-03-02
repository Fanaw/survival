import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;

public class Entite {
	
	public static final int DEFAULT_vie = 10;
	
	
	
	
	protected float x, y,tx,ty;
	protected int largeur, hauteur;
	protected Rectangle bords;
	protected int vie;
	protected boolean enVie = true;
	
	
	
	public Entite(float x, float y, int largeur, int hauteur){
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		bords = new Rectangle(0,0,largeur,hauteur); // CREATION D'UN RECTANGLE QUI FAIT TOUTE L'IMAGE
		vie = DEFAULT_vie;
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(int i = 0 ; i<Fenetre.gEntite.getEntites().size();i++){ // ON PARCOURT TOUTES LES ENTITES
			
			Entite e = Fenetre.gEntite.getEntites().get(i);
			if(e.equals(this)) // SI C'EST L'ENTITE COURANTE ON PASSE A L'ENTITE D'APRES
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) // SINON ON CHECK LA COLLISION DES RECTANGLES
				return true;
		}
		return false;
	}
	
	
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){ // PREVOIR COLLISION AU TICK D'APRES
		return new Rectangle((int) (x + bords.x + xOffset), (int) (y + bords.y + yOffset), bords.width, bords.height);
	}
	
	
	public void subisAttaque(int degat){ // CLASSIQUE
		vie -=degat;
		if(vie<=0){
			enVie = false;
			meurt();
		}
	}
	
	
	//  IMPLEMENTES DANS LES DIFFERENTES ENTITE
	public void meurt(){} 
	public void tick(){}	
	
	
	
	
	
	
	//GETTER SETTER 
	public void dessine(Graphics g, JPanel jf){
		
		
	}
	
	
	
	
	
	
	
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
