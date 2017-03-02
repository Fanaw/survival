import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;

public class ImageInventaire {
	
	BufferedImage image ; 
	int largeur = 100;
	int hauteur = 100;
	Ressource ressource ;
	boolean active  ;

	public ImageInventaire (Ressource ressource, boolean active) {
		
		image = ImageLoader.scale(ressource.image,largeur,hauteur);
		this.ressource=ressource;
		this.active=active;
	
	}
	
	public void dessine(Graphics g, JPanel jp,int x,int y){
		
		
		g.setColor(new Color(30,30,30,127));
		g.fillRoundRect(x,y,largeur,hauteur,10,10);
		g.setColor(new Color(100,100,100,127));
		g.drawRoundRect(x+5,y+5,largeur-10,hauteur-10,10,10);
		g.drawRoundRect(x+4,y+4,largeur-8,hauteur-8,10,10);
		
		g.drawImage(image,x,y,jp);
		
		if(ressource.nombre==0){
			g.setColor(new Color(30,30,30,200));
			g.fillRoundRect(x,y,largeur,hauteur,10,10);
		}
			
		
		if (active) {
				
			g.setColor(Color.white);
			g.drawRoundRect(x,y,largeur,hauteur,10,10);
			g.drawRoundRect(x+1,y+1,largeur-2,hauteur-2,10,10);
			g.drawRoundRect(x+2,y+2,largeur-4,hauteur-4,10,10);
			g.drawRoundRect(x+3,y+3,largeur-6,hauteur-6,10,10);
			
			int[] xPoints = {x,x+20,x};
			int[] yPoints = {y,y,y+20};
			g.fillPolygon(xPoints,yPoints,3);
			
			int[] xPoints2 = {x+largeur,x+largeur-20,x+largeur};
			int[] yPoints2 = {y,y,y+20};
			g.fillPolygon(xPoints2,yPoints2,3);
			
			int[] xPoints3 = {x,x+20,x};
			int[] yPoints3 = {y+hauteur,y+hauteur,y+hauteur-20};
			g.fillPolygon(xPoints3,yPoints3,3);
			
			int[] xPoints4 = {x+largeur,x+largeur-20,x+largeur};
			int[] yPoints4 = {y+hauteur,y+hauteur,y+hauteur-20};
			g.fillPolygon(xPoints4,yPoints4,3);
			
			
		}
		
		
		g.setColor(new Color(20,20,20));
		g.fillOval(x+70,y+70,35,35);
				g.setColor(new Color(100,100,100,127));
		g.drawOval(x+73,y+73,29,29);
		g.setColor(new Color(200,200,200,127));		
		g.drawString(""+ressource.nombre,x+82,y+92);
		
			
		
	}

}
