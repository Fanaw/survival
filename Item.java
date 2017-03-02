import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Item {
	
	protected float x,y;
	protected int largeur = 100, hauteur = 100;
	protected BufferedImage image;
	protected String nom;
	protected int id;
	protected boolean prendre=false;
	
	
	protected Rectangle bords;
	
	public Item(String nom, BufferedImage image, int id){
		this.nom=nom;
		this.image=image;
		this.id=id;
		
		Liste.items[id]=this;
		
		bords = new Rectangle((int)x,(int)y,largeur,hauteur);
		
	}
	
	public void tick(){
		if(Fenetre.j1.getCollisionBounds(0,0).intersects(bords))
			prendre = true;
		
	}
	
	public Item nouvelItem(int x, int y){
		Item i = new Item(nom,image,id);
		i.setPosition(x,y);
		return i;
	}
	
	
	public void dessine(Graphics g){
		g.drawImage(image,(int) (x-Fenetre.camera.getxOffset() ),(int) (y-Fenetre.camera.getyOffset() ), largeur, hauteur ,null);
	}
	
	public void dessine(Graphics g, int x, int y){
		g.drawImage(image,(int) (x-Fenetre.camera.getxOffset() ),(int) (y-Fenetre.camera.getyOffset() ), largeur, hauteur ,null);
	}
	public void setPosition(int x, int y){
		this.x=x;
		this.y=y;
		bords.x=x;
		bords.y=y;
	}

}
