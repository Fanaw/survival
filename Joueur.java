import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Joueur extends Creature {
	
	ArrayList<Ressource> ressources_joueur = new ArrayList<Ressource>();
	ArrayList<Ressource> objets_joueur = new ArrayList<Ressource>();
	
	String nom = "AssouB" ;
	
	int pv = 1000 ; 
	int nourriture = 1000 ;
	int eau = 1000;
	
	static int largeur = 100;
	static int hauteur = 100;
	
	public Joueur(float x, float y) {
		super(x, y, largeur, hauteur);
		bords.x = 7;
		bords.y = 65;
		bords.width =50;
		bords.height = 32;
		
		//liste de ressources
		ressources_joueur.add(Liste.ressource_bois);
		ressources_joueur.add(Liste.ressource_metal);
		ressources_joueur.add(Liste.ressource_peau);
		ressources_joueur.add(Liste.ressource_pierre);
		ressources_joueur.add(Liste.ressource_viande);
		ressources_joueur.add(Liste.ressource_peau);
		ressources_joueur.add(Liste.ressource_pierre);
		ressources_joueur.add(Liste.ressource_viande);
		ressources_joueur.add(Liste.ressource_bois);
		ressources_joueur.add(Liste.ressource_metal);
		ressources_joueur.add(Liste.ressource_peau);
		ressources_joueur.add(Liste.ressource_pierre);
		ressources_joueur.add(Liste.ressource_viande);
		
		//liste d'objets
		objets_joueur.add(Liste.objet_botte);
		objets_joueur.add(Liste.objet_bouclier);
		objets_joueur.add(Liste.objet_cape);
		objets_joueur.add(Liste.objet_casque);
		objets_joueur.add(Liste.objet_hache);
		
	
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

	
	public void dessine(Graphics g) {
		
		g.drawImage(Liste.joueur, (int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()), largeur, hauteur, null);
		
		//Rectangle de collision
		//g.setColor(Color.red);
		//g.fillRect( (int) (x +bords.x - Fenetre.camera.getxOffset()) , (int) (y +bords.y - Fenetre.camera.getyOffset()), bords.width, bords.height  );
	
	}
	

}
