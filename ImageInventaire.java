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
			
		
		g.setColor(new Color(20,20,20));
		g.fillOval(x+70,y+70,35,35);
		g.setColor(new Color(100,100,100,127));
		g.drawOval(x+73,y+73,29,29);
		g.setColor(new Color(200,200,200,127));	
		g.setFont(new Font("Tahoma", Font.ITALIC, 13));	
		g.drawString(""+ressource.nombre,x+82,y+92);
		
		if(active){
				
			Graphics2D g2d = (Graphics2D)g;         
			GradientPaint gp = new GradientPaint(0, 0,  new Color(100,100,100,127), 1000, 0,new Color(30,30,30,127), true);                
			g2d.setPaint(gp);
			g2d.fillRoundRect(1100,540,720,220,20,20);
			
			g.setColor( new Color(100,100,100,127));
			g.drawRoundRect(1105,545,710,210,20,20);
			g.drawRoundRect(1104,544,712,212,20,20);
			
			g.setFont(new Font("Tahoma", Font.ITALIC, 30));
			g.setColor(new Color(200,200,200,240));
			g.drawString(this.ressource.description,1130,650);
			
		}
		
	}

}
