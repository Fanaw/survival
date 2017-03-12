import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.*;

public class Joueur extends Creature {
	
	ArrayList<Ressource> ressources_joueur = new ArrayList<Ressource>();
	ArrayList<Ressource> objets_joueur = new ArrayList<Ressource>();
	
	String nom = "Kardha-Chiant" ;
	
	 
	int nourriture = 1000 ;
	int eau = 1000;
	
	static int largeur = 60;
	static int hauteur = 60;
	
	public Joueur(float x, float y) {
		super(x, y, largeur, hauteur);
		bords.x = 5;
		bords.y = 30;
		bords.width =50;
		bords.height = 30;
		vie=100;
	
		objets_joueur.add(new Ressource(0,"bottes",true));
		objets_joueur.add(new Ressource(0,"bouclier",true));
		objets_joueur.add(new Ressource(0,"cape",true));
		objets_joueur.add(new Ressource(0,"casque",true));
	
	}

	
	public void tick() {
		
		getClavier();
		move();
		Fenetre.camera.centrerSurCreature(this);
		attaque();
	}
	
	public void attaque(){
		
		
		Rectangle cb = getCollisionBounds(0, 0); // Création d'un rectangle à une position égale au rectangle rouge de collision
		Rectangle ar = new Rectangle(); // Création d'un carré de 20 servant de zone d'attaque 
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(Fenetre.clavier.degatUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(Fenetre.clavier.degatDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(Fenetre.clavier.degatLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(Fenetre.clavier.degatRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return; // On s'arrête ici car du coup aucune attaque
		}
		
		
		
		for(int i = 0 ; i<Fenetre.gEntite.getEntites().size();i++){
			Entite e = Fenetre.gEntite.getEntites().get(i);
			if(e.equals(this))
				continue; // Passe à l'entité suivante
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.subisAttaque(1);
				return;
			}
		}
	}
	
	
	
	
	private void getClavier(){
		xMove = 0;
		yMove = 0;
		
		if(Fenetre.clavier.up){
			yMove = -vitesse;
			direction = 2;
			
		}
		if(Fenetre.clavier.down){
			yMove = vitesse;
			direction = 3;
			
		}
		if(Fenetre.clavier.left){
			xMove = -vitesse;
			direction = 1;
		}
		if(Fenetre.clavier.right){
			xMove = vitesse;
			direction=0;
			
		}
	}

	
	public void dessine(Graphics g, JPanel jf) {
		
		g.drawImage(Liste.joueur, (int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()), largeur, hauteur, jf);
		
		//Rectangle de collision
		//g.setColor(Color.red);
		//g.fillRect( (int) (x +bords.x - Fenetre.camera.getxOffset()) , (int) (y +bords.y - Fenetre.camera.getyOffset()), bords.width, bords.height  );
	
	}
	

}
