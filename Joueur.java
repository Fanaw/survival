import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.*;

public class Joueur extends Creature {
	
	Ressource[] ressources_joueur = new Ressource[3];
	Objet[] objets_joueur = new Objet[3];
	
	String nom = "Kardha-Chiant" ; 
	
	 
	int nourriture = 1000 ;
	int eau = 1000;
	int pv=1000;
	int degat=100;
	int resistance=100;
	
	static int largeur = 60;
	static int hauteur = 60;
	
	public Joueur(float x, float y) {
		super(x, y, largeur, hauteur);
		bords.x = 5;
		bords.y = 30;
		bords.width =50;
		bords.height = 32;
		
		//liste de ressources
		ressources_joueur[0]=Liste.ressource_bois;
		ressources_joueur[1]=Liste.ressource_pierre;
		ressources_joueur[2]=Liste.ressource_metal;
		
		//liste d'objets
		objets_joueur[0]=Liste.objet_hache;
		objets_joueur[1]=Liste.objet_epee;
		objets_joueur[2]=Liste.objet_bouclier;
		
	
	}

	
	public void tick() {
		
		getClavier();
		move();
		Fenetre.camera.centrerSurCreature(this);
		attaque();
	}
	
	public void attaque(){
		
		
		Rectangle cb = getCollisionBounds(0, 0); // Cr�ation d'un rectangle � une position �gale au rectangle rouge de collision
		Rectangle ar = new Rectangle(); // Cr�ation d'un carr� de 20 servant de zone d'attaque 
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
			return; // On s'arr�te ici car du coup aucune attaque
		}
		
		
		
		for(int i = 0 ; i<Fenetre.gEntite.getEntites().size();i++){
			Entite e = Fenetre.gEntite.getEntites().get(i);
			if(e.equals(this))
				continue; // Passe � l'entit� suivante
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.subisAttaque(degat);
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
	
	}
	

}
