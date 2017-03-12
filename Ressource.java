import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;

public class Ressource {
	
	int largeur = 100;
	int hauteur = 100;
	int nombre ;
	boolean equipable;
	String nom;
	BufferedImage image ;
	boolean active  ;
	

	public Ressource(int nombre,String nom,boolean equipable) {
		this.nom=nom;
		this.image = ImageLoader.scale(ImageLoader.ImgLoader(nom+".png"),largeur,hauteur);
		this.nombre=nombre;
		this.equipable = equipable;
		
		
	}
	
	
	
	public void ajouterRessource() {
		nombre++;
	}
	
	public void supprimerRessource() {
		nombre--;
	}
	
	public void dessine(Graphics g, JPanel jp,int x,int y){
		
		
		g.setColor(new Color(30,30,30,127));
		g.fillRoundRect(x,y,largeur,hauteur,10,10);
		g.setColor(new Color(100,100,100,127));
		g.drawRoundRect(x+5,y+5,largeur-10,hauteur-10,10,10);
		g.drawRoundRect(x+4,y+4,largeur-8,hauteur-8,10,10);
		
		g.drawImage(image,x,y,jp);
		
		if(nombre==0){
			g.setColor(new Color(30,30,30,200));
			g.fillRoundRect(x,y,largeur,hauteur,10,10);
		}
			
		/*
		if (true) {
				
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
		*/
		Font police = new Font("Tahoma", Font.BOLD, 20);
		g.setFont(police);
		
		g.setColor(new Color(20,20,20));
		g.fillOval(x+62,y+65,35,35);
		g.setColor(new Color(100,100,100,127));
		g.drawOval(x+65,y+68,29,29);
		g.setColor(new Color(200,200,200,127));		
		g.drawString(""+nombre,x+74,y+91);
		
			
		
	}
	
	public String description(){
		if(nom=="casque")
			return this.nom+Recette.casque.descriptionRecette();
		if(nom=="bottes")
			return this.nom+Recette.bottes.descriptionRecette();
		if(nom=="cape")
			return this.nom+Recette.cape.descriptionRecette();
		if(nom=="bouclier")
			return this.nom+Recette.bouclier.descriptionRecette();
		if(nom=="viande")
			return " Cette viande te chatouillera le palet ... ! ";
		else
			return "AUCUNE DESCRIPTION DISPONIBLE";
	
	}
	
	public boolean recetteComplete(){
		if(nom=="casque" && Outil.rechercherNombreRessource("bois")>=Recette.casque.bois && Outil.rechercherNombreRessource("pierre")>=Recette.casque.pierre){
			Outil.setNombreRessource("bois",Recette.casque.bois);
			Outil.setNombreRessource("pierre",Recette.casque.pierre);
			return true;
		}
		if(nom=="bottes" &&  Outil.rechercherNombreRessource("bois")>=Recette.bottes.bois && Outil.rechercherNombreRessource("pierre")>=Recette.bottes.pierre){
			Outil.setNombreRessource("bois",Recette.bottes.bois);
			Outil.setNombreRessource("pierre",Recette.bottes.pierre);
			return true;
		}
		if(nom=="bouclier" &&  Outil.rechercherNombreRessource("bois")>=Recette.bouclier.bois && Outil.rechercherNombreRessource("pierre")>=Recette.bouclier.pierre){
			Outil.setNombreRessource("bois",Recette.bouclier.bois);
			Outil.setNombreRessource("pierre",Recette.bouclier.pierre);
			return true;
		}
		if(nom=="cape" &&  Outil.rechercherNombreRessource("bois")>=Recette.cape.bois && Outil.rechercherNombreRessource("pierre")>=Recette.cape.pierre){
			Outil.setNombreRessource("bois",Recette.cape.bois);
			Outil.setNombreRessource("pierre",Recette.cape.pierre);
			return true;
		}
		else
			return false;
	
	
	}
	
	
	
	
	
}
