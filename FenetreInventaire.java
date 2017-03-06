import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;
import java.util.*;




public class FenetreInventaire extends JPanel implements ActionListener   {

	private final int LARGEUR_FENETRE ;
	private final int HAUTEUR_FENETRE ;
	private BufferedImage monBuf;
	javax.swing.Timer timer;
	boolean show = false ; 
	Jeu jeu ;
	private BufferedImage fond;
	int xCurseur =  100 ;
	int yCurseur = 300 ;
	int compteurCurseurBefor = 0 ;
	int compteurCurseur = 0 ; 
	int compteurCurseurX = 0;
	int compteurCurseurY = 0;
	static Clavier clavier ;
	
	ArrayList<ImageInventaire> liste_ressources = new ArrayList<ImageInventaire>() ;
	ArrayList<ImageObjet> liste_objets = new ArrayList<ImageObjet>() ;
	//ArrayList<ImageInventaire> liste_nourriture = new ArrayList<ImageInventaire>() ;
	
	boolean afficher_liste_ressources = false;
	boolean afficher_liste_objets = true;
	//boolean afficher_liste_nourriture = false;
		 
	public FenetreInventaire(int LARGEUR_FENETRE, int HAUTEUR_FENETRE,Clavier clavier, Jeu jeu){
		
		this.jeu=jeu;
		this.clavier=clavier;
		setSize(LARGEUR_FENETRE,HAUTEUR_FENETRE);
		this.HAUTEUR_FENETRE = HAUTEUR_FENETRE;
		this.LARGEUR_FENETRE = LARGEUR_FENETRE;
		this.monBuf = new BufferedImage(LARGEUR_FENETRE,HAUTEUR_FENETRE,BufferedImage.TYPE_INT_RGB);
		
		//Init ArrayList
		for(int i=0;i<jeu.fenetre_JEU.j1.ressources_joueur.size();i++){
			liste_ressources.add(new ImageInventaire(jeu.fenetre_JEU.j1.ressources_joueur.get(i),false));
		}
		for(int i=0;i<jeu.fenetre_JEU.j1.objets_joueur.size();i++){
			liste_objets.add(new ImageObjet(jeu.fenetre_JEU.j1.objets_joueur.get(i),false));
		}
		
		//Chargement des images
		fond = jeu.fenetre_JEU.screen ;
		
		timer = new javax.swing.Timer(100,this);
		timer.start();	
				
	}
	
	public void paint(Graphics g){
		
		Graphics buffer = monBuf.getGraphics();
		
		buffer.drawImage(fond,0,0,this);
		
		buffer.setColor(new Color(150,150,150,200));
		buffer.fillRect(0,0,LARGEUR_FENETRE,HAUTEUR_FENETRE);
		
		Font police = new Font("Tahoma", Font.BOLD, 20);
		buffer.setFont(police);
		
		if(afficher_liste_ressources){
			buffer.setColor(new Color(80,80,80,127));
		}
		if(!afficher_liste_ressources){
			buffer.setColor(new Color(30,30,30,127));
			buffer.drawString("Objets",240,265);
		}
		buffer.drawLine(240,280,340,280);
		buffer.drawLine(240,279,340,279);
		buffer.drawLine(240,278,340,278);
		buffer.drawLine(240,277,340,277);
		buffer.drawLine(240,276,340,276);
		
		
		if(afficher_liste_objets){
			buffer.setColor(new Color(80,80,80,127));
		}
		if(!afficher_liste_objets){
			buffer.setColor(new Color(30,30,30,127));
			buffer.drawString("Ressources",380,265);
		}
		buffer.drawLine(380,280,480,280);
		buffer.drawLine(380,279,480,279);
		buffer.drawLine(380,278,480,278);
		buffer.drawLine(380,277,480,277);
		buffer.drawLine(380,276,480,276);
		
		police = new Font("Tahoma", Font.BOLD, 10);
		buffer.setFont(police);
	
		for(int i=0 ; i<4 ; i++){
			for(int j=0 ; j<5 ; j++){
				buffer.setColor(new Color(100,100,100,100));
				buffer.fillRoundRect(100+120*j,300+120*i,100,100,10,10);
				if(afficher_liste_ressources){
					if(5*i+j<liste_ressources.size()){
						liste_ressources.get(5*i+j).dessine(buffer,this,100+120*j,300+120*i);
					}
				}
				if(afficher_liste_objets){
					if(5*i+j<liste_objets.size()){
						liste_objets.get(5*i+j).dessine(buffer,this,100+120*j,300+120*i);
					}
				}
			}
		}
		
		int largeur = 100 ;
		int hauteur = 100 ;
		
		buffer.setColor(Color.white);
		buffer.drawRoundRect(xCurseur,yCurseur,largeur,hauteur,10,10);
		buffer.drawRoundRect(xCurseur+1,yCurseur+1,largeur-2,hauteur-2,10,10);
		buffer.drawRoundRect(xCurseur+2,yCurseur+2,largeur-4,hauteur-4,10,10);
		buffer.drawRoundRect(xCurseur+3,yCurseur+3,largeur-6,hauteur-6,10,10);
		
		int[] xPoints = {xCurseur,xCurseur+20,xCurseur};
		int[] yPoints = {yCurseur,yCurseur,yCurseur+20};
		buffer.fillPolygon(xPoints,yPoints,3);
		
		int[] xPoints2 = {xCurseur+largeur,xCurseur+largeur-20,xCurseur+largeur};
		int[] yPoints2 = {yCurseur,yCurseur,yCurseur+20};
		buffer.fillPolygon(xPoints2,yPoints2,3);
		
		int[] xPoints3 = {xCurseur,xCurseur+20,xCurseur};
		int[] yPoints3 = {yCurseur+hauteur,yCurseur+hauteur,yCurseur+hauteur-20};
		buffer.fillPolygon(xPoints3,yPoints3,3);
		
		int[] xPoints4 = {xCurseur+largeur,xCurseur+largeur-20,xCurseur+largeur};
		int[] yPoints4 = {yCurseur+hauteur,yCurseur+hauteur,yCurseur+hauteur-20};
		buffer.fillPolygon(xPoints4,yPoints4,3);
		
		buffer.setColor(new Color(100,100,100,200));
		buffer.fillRect(0,0,LARGEUR_FENETRE,HAUTEUR_FENETRE/5);
		buffer.fillRect(0,4*HAUTEUR_FENETRE/5,LARGEUR_FENETRE,HAUTEUR_FENETRE/5);
		
		police = new Font("Tahoma", Font.ITALIC, 50);
		buffer.setFont(police);
		buffer.setColor(new Color(200,200,200,240));
		buffer.drawString(jeu.fenetre_JEU.j1.nom,LARGEUR_FENETRE/2-100,150);
		
		buffer.setColor(new Color(218,29,29,240));
		buffer.fillRoundRect(150,100,jeu.fenetre_JEU.j1.pv/6,15,20,20);
				
		g.drawImage(monBuf,0,0,this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(show){
			if(afficher_liste_objets){
				
				compteurCurseurBefor=compteurCurseur;
				
				if(clavier.up && compteurCurseurY>0 && compteurCurseur>0 && compteurCurseur<liste_objets.size()) {
					yCurseur-=120;
					compteurCurseur-=5;
					compteurCurseurY-=1;
				}else if(clavier.down && compteurCurseurY<3 && compteurCurseur>=0 && compteurCurseur<liste_objets.size()-5) {
					yCurseur+=120;
					compteurCurseur+=5;
					compteurCurseurY+=1;
				}else if(clavier.left && compteurCurseurX>0 && compteurCurseur>0 && compteurCurseur<liste_objets.size()) {
					xCurseur-=120;
					compteurCurseur-=1;
					compteurCurseurX-=1;
				}else if(clavier.right && compteurCurseurX<4 && compteurCurseur>=0 && compteurCurseur<liste_objets.size()-1) {
					xCurseur+=120;
					compteurCurseur+=1;
					compteurCurseurX+=1;
				}else if(clavier.left) {
					xCurseur =  100 ;
					yCurseur = 300 ;
					compteurCurseur = 0 ; 
					compteurCurseurX = 0;
					compteurCurseurY = 0;
					afficher_liste_objets = false ;
					afficher_liste_ressources = true ;
				}else if(clavier.right) {
					xCurseur =  100 ;
					yCurseur = 300 ;
					compteurCurseur = 0 ; 
					compteurCurseurX = 0;
					compteurCurseurY = 0;
					afficher_liste_objets = false ;
					afficher_liste_ressources = true ;
					
				}
				
				liste_objets.get(compteurCurseur).active=true; 
				    
				if(compteurCurseur!=compteurCurseurBefor){
					liste_objets.get(compteurCurseurBefor).active=false; 
				}
			}
			
			else if(afficher_liste_ressources){
				
				compteurCurseurBefor=compteurCurseur;
				
				if(clavier.up && compteurCurseurY>0 && compteurCurseur>0 && compteurCurseur<liste_ressources.size()) {
					yCurseur-=120;
					compteurCurseur-=5;
					compteurCurseurY-=1;
				}else if(clavier.down && compteurCurseurY<3 && compteurCurseur>=0 && compteurCurseur<liste_ressources.size()-5) {
					yCurseur+=120;
					compteurCurseur+=5;
					compteurCurseurY+=1;
				}else if(clavier.left && compteurCurseurX>0 && compteurCurseur>0 && compteurCurseur<liste_ressources.size()) {
					xCurseur-=120;
					compteurCurseur-=1;
					compteurCurseurX-=1;
				}else if(clavier.right && compteurCurseurX<4 && compteurCurseur>=0 && compteurCurseur<liste_ressources.size()-1) {
					xCurseur+=120;
					compteurCurseur+=1;
					compteurCurseurX+=1;
				}else if(clavier.left) {
					xCurseur =  100 ;
					yCurseur = 300 ;
					compteurCurseur = 0 ; 
					compteurCurseurX = 0;
					compteurCurseurY = 0;
					afficher_liste_objets = true ;
					afficher_liste_ressources = false ;
				}else if(clavier.right) {
					xCurseur =  100 ;
					yCurseur = 300 ;
					compteurCurseur = 0 ; 
					compteurCurseurX = 0;
					compteurCurseurY = 0;
					afficher_liste_objets = true ;
					afficher_liste_ressources = false ;
					
				}   
				
				liste_ressources.get(compteurCurseur).active=true;
				
				if(compteurCurseur!=compteurCurseurBefor){
					liste_ressources.get(compteurCurseurBefor).active=false;
				}
				
			}
			
			
			
			
			if(clavier.exit){
				jeu.fenetre_JEU.show=true;
				this.show=false;
			}
			
			fond = jeu.fenetre_JEU.screen ;
			
			
			addKeyListener(clavier);
			
			repaint();
		}	
	}
		  
}
