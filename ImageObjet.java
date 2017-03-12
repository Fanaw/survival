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
			
			if(!objet.exister){
				g.drawString(this.objet.description,1130,610);
				g.drawString("bois necessaire: "+this.objet.bois+"  bois en stock: "+this.fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[0].nombre,1130,650);
				g.drawString("pierre necessaire: "+this.objet.pierre+"  pierre en stock: "+this.fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[1].nombre,1130,690);
				g.drawString("metal necessaire: "+this.objet.metal+"  metal en stock: "+this.fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[2].nombre,1130,730);
			}else if(objet.exister){
				g.drawString(this.objet.description,1130,610);
				g.drawString("degat supplementaire : +"+objet.degat_supp,1130,650);
				g.drawString("resistance supplementaire : +"+objet.resistance_supp,1130,690);
			}
			
			
			if(objet.exister==false && fenetre_INVENTAIRE.jeu.clavier.enter && fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[0].nombre>=objet.bois && fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[1].nombre>=objet.pierre && fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[2].nombre>=objet.metal){
			
				objet.exister=true;
				fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[0].nombre-=objet.bois;
				fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[1].nombre-=objet.pierre;
				fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.ressources_joueur[2].nombre-=objet.metal;
				
			}
			
			if(objet.exister){
				if(objet.categorie=="arme"){
					if(fenetre_INVENTAIRE.jeu.clavier.keyToutJusteAppuie(KeyEvent.VK_E)){
						if(!objet.equipe && !fenetre_INVENTAIRE.arme_equipe){
							objet.equipe=true;
							fenetre_INVENTAIRE.arme_equipe=true;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat+=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance+=objet.resistance_supp;
						}
						else if(objet.equipe && fenetre_INVENTAIRE.arme_equipe){
							objet.equipe=false;
							fenetre_INVENTAIRE.arme_equipe=false;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat-=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance-=objet.resistance_supp;
						}				
					}
				}else if(objet.categorie=="armure"){
					if(fenetre_INVENTAIRE.jeu.clavier.keyToutJusteAppuie(KeyEvent.VK_E)){
						if(!objet.equipe && !fenetre_INVENTAIRE.armure_equipe){
							objet.equipe=true;
							fenetre_INVENTAIRE.armure_equipe=true;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat+=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance+=objet.resistance_supp;
						}
						else if(objet.equipe && fenetre_INVENTAIRE.armure_equipe){
							objet.equipe=false;
							fenetre_INVENTAIRE.armure_equipe=false;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat-=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance-=objet.resistance_supp;
						}				
					}
				}else if(objet.categorie=="casque"){
					if(fenetre_INVENTAIRE.jeu.clavier.keyToutJusteAppuie(KeyEvent.VK_E)){
						if(!objet.equipe && !fenetre_INVENTAIRE.casque_equipe){
							objet.equipe=true;
							fenetre_INVENTAIRE.casque_equipe=true;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat+=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance+=objet.resistance_supp;
						}
						else if(objet.equipe && fenetre_INVENTAIRE.casque_equipe){
							objet.equipe=false;
							fenetre_INVENTAIRE.casque_equipe=false;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat-=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance-=objet.resistance_supp;
						}
					}
				}else if(objet.categorie=="bouclier"){
					if(fenetre_INVENTAIRE.jeu.clavier.keyToutJusteAppuie(KeyEvent.VK_E)){
						if(!objet.equipe && !fenetre_INVENTAIRE.bouclier_equipe){
							objet.equipe=true;
							fenetre_INVENTAIRE.bouclier_equipe=true;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat+=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance+=objet.resistance_supp;
						}
						else if(objet.equipe && fenetre_INVENTAIRE.bouclier_equipe){
							objet.equipe=false;
							fenetre_INVENTAIRE.bouclier_equipe=false;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.degat-=objet.degat_supp;
							fenetre_INVENTAIRE.jeu.fenetre_JEU.j1.resistance-=objet.resistance_supp;
						}
					}
				}
			}
			
		}		
		
		if(objet.equipe){
			if(objet.categorie=="arme"){
				g.drawImage(image,1130,400,jp);
			}else if(objet.categorie=="armure"){
				g.drawImage(image,1130+120,400,jp);
			}else if(objet.categorie=="casque"){
				g.drawImage(image,1130+2*120,400,jp);
			}else if(objet.categorie=="bouclier"){
				g.drawImage(image,1130+3*120,400,jp);
			}
		}
		
	}

}
