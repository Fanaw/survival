import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;

public class ImageObjet {
	
	BufferedImage image ; 
	int largeur = 100;
	int hauteur = 100;
	Objet objet ;
	boolean active  ;
	FenetreInventaire fenetre_INVENTAIRE ;

	public ImageObjet (Objet objet, boolean active,FenetreInventaire fi) {
		
		image = ImageLoader.scale(objet.image,largeur,hauteur);
		this.objet=objet;
		this.active=active;
		fenetre_INVENTAIRE=fi;
	
	}
	
	public void dessine(Graphics g, JPanel jp,int x,int y){
		
		
		g.setColor(new Color(30,30,30,127));
		g.fillRoundRect(x,y,largeur,hauteur,10,10);
		g.setColor(new Color(100,100,100,127));
		g.drawRoundRect(x+5,y+5,largeur-10,hauteur-10,10,10);
		g.drawRoundRect(x+4,y+4,largeur-8,hauteur-8,10,10);
		
		g.drawImage(image,x,y,jp);
		
		if(objet.exister==false){
			g.setColor(new Color(30,30,30,200));
			g.fillRoundRect(x,y,largeur,hauteur,10,10);
		}
		
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
			g.drawString(this.objet.description,1130,610);
			g.drawString("bois : "+this.objet.bois,1130,650);
			g.drawString("pierre : "+this.objet.pierre,1130,690);
			g.drawString("metal : "+this.objet.metal,1130,730);
			
		}		
		
		if(fenetre_INVENTAIRE.jeu.clavier.enter && fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[0].nombre>=objet.bois && fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[1].nombre>=objet.pierre && fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[2].nombre>=objet.metal){
		
			objet.exister=true;
			fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[0].nombre-=objet.bois;
			fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[1].nombre-=objet.pierre;
			fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[2].nombre-=objet.metal;
			
		
		}
	}

}
