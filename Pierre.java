import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Pierre extends Entite{
	

	private BufferedImage image;
	static int largeur = 200;
	static int hauteur = 200;
	
	public Pierre(float x, float y, BufferedImage img){
		super(x,y,largeur,hauteur);
		image = img;
	}
	
	
	public void meurt(){
		Fenetre.gItem.addItem(Liste.iPierre.nouvelItem((int)x,(int) y));
	}
	
	public void dessine(Graphics g){
		g.drawImage(image, (int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()), largeur, hauteur, null);
		g.setColor(Color.red);
		g.fillRect((int) (x-Fenetre.camera.getxOffset()), (int) (y+largeur - Fenetre.camera.getyOffset()), vie*largeur/10, 20);
	}
}