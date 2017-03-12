import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Pierre extends Entite{
	

	private BufferedImage image;
	static int largeur = 100;
	static int hauteur = 100;
	
	public Pierre(float x, float y, BufferedImage img){
		super(x,y,largeur,hauteur);
		image = img;
	}
	
	
	public void meurt(){
		Fenetre.gItem.addItem(Liste.iPierre.nouvelItem((int)x+largeur/3,(int) y+hauteur/3));
	}
	
	public void dessine(Graphics g, JPanel jp){
		g.drawImage(image, (int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()), largeur, hauteur, jp);
		//g.setColor(Color.red);
		//g.fillRect((int) (x-Fenetre.camera.getxOffset()), (int) (y+largeur - Fenetre.camera.getyOffset()), vie*largeur/10, 20);
	}
}
