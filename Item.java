import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Item {
	
	protected float x,y;
	protected int largeur = 60, hauteur = 60;
	protected BufferedImage image;
	protected String nom;
	protected int id;
	protected boolean prendre=false;
	protected String iNom;
	protected boolean ajout;
	
	protected Rectangle bords;
	
	public Item(String nom, BufferedImage image, int id){ // CREE UN ITEM AVEC UN NOM,IAMGE et ID ( clef )
		this.nom=nom;
		this.image=image;
		this.id=id;
		
		Liste.items[id]=this; // ON L'AJOUTE AU TABLEAU 1D DE LISTE, COMME CA PAS BESOIN DE CREE MILLE FOIS LE MEME
		
		bords = new Rectangle((int)x,(int)y,largeur,hauteur); // ON DEFINI UN RECTANGLE DE COLLISION QUI PREND TOUTE L'IMAGE
		
	}
	
	public void tick(){
		if(Fenetre.j1.getCollisionBounds(0,0).intersects(bords)){ // SI LE JOUEUR EST EN COLLISION AVEC L'ITEM, PRENDRE = true
			prendre = true;
			
			for(int i =0; i<3;i++){
				
				if(Fenetre.j1.ressources_joueur[i].nom == nom){
					Fenetre.j1.ressources_joueur[i].ajouterRessource();
					ajout = true;
				}
			}
			
			ajout = false;
			
		}
	}
	
	public Item nouvelItem(int x, int y){ // ON CREE LE MEME ITEM MAIS A UNE COORDONNE PRECISE
		Item i = new Item(nom,image,id);
		i.setPosition(x,y);
		return i;
	}
	
	
	public void dessine(Graphics g){ // DESSINE RELATIVEMENT A L'OFFSET.   ICI A SES PROPRES COORDONNES
		g.drawImage(image,(int) (x-Fenetre.camera.getxOffset() ),(int) (y-Fenetre.camera.getyOffset() ), largeur, hauteur ,null);
	}
	
	public void dessine(Graphics g, int x, int y){// ---------- . ICI A DES COORDONNES PRECISE ( POUR L'INVENTAIRE PAR EXEMPLE )
		g.drawImage(image,(int) (x-Fenetre.camera.getxOffset() ),(int) (y-Fenetre.camera.getyOffset() ), largeur, hauteur ,null);
	}
	public void setPosition(int x, int y){ // SETTER + ACTUALISATION DU RECTANGLE CONTACTE
		this.x=x;
		this.y=y;
		bords.x=x;
		bords.y=y;
	}

}
