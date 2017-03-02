import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

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
	
	public void dessine(Graphics g, JPanel jp){
		g.drawImage(image, (int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()), largeur, hauteur, jp);
		g.setColor(Color.red);
		g.fillRect((int) (x-Fenetre.camera.getxOffset()), (int) (y+largeur - Fenetre.camera.getyOffset()), vie*largeur/10, 20);
	}
}
