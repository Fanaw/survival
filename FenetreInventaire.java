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
	
	boolean afficher_liste_ressources = false;
	boolean afficher_liste_objets = true;
	
	boolean arme_equipe,armure_equipe,casque_equipe,bouclier_equipe ;
		 
	public FenetreInventaire(int LARGEUR_FENETRE, int HAUTEUR_FENETRE,Clavier clavier, Jeu jeu){
		
		this.jeu=jeu;
		this.clavier=clavier;
		setSize(LARGEUR_FENETRE,HAUTEUR_FENETRE);
		this.HAUTEUR_FENETRE = HAUTEUR_FENETRE;
		this.LARGEUR_FENETRE = LARGEUR_FENETRE;
		this.monBuf = new BufferedImage(LARGEUR_FENETRE,HAUTEUR_FENETRE,BufferedImage.TYPE_INT_RGB);
		
		//Init ArrayList
		for(int i=0;i<3;i++){
			liste_ressources.add(new ImageInventaire(jeu.fenetre_JEU.j1.ressources_joueur[i],false));
		}
		for(int i=0;i<3;i++){
			liste_objets.add(new ImageObjet(jeu.fenetre_JEU.j1.objets_joueur[i],false,this));
		}
		
		//Chargement des images
		fond = jeu.fenetre_JEU.screen ;
		
		timer = new javax.swing.Timer(100,this);
		timer.start();	
				
	}
	
	public void paint(Graphics g){
		
		Graphics buffer = monBuf.getGraphics();
		
		//afficher le screen en fond
		buffer.drawImage(fond,0,0,this);
		
		//barre grise en haut
		buffer.setColor(new Color(150,150,150,200));
		buffer.fillRect(0,0,LARGEUR_FENETRE,HAUTEUR_FENETRE);
		
		Font police = new Font("Tahoma", Font.BOLD, 20);
		buffer.setFont(police);
		
		//affichage du "defileur"
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
	
		//affichage de la grille de fond et des ressources/objet
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
		
		//affichage du curseur
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
		
		//affichage du nom joueur
		police = new Font("Tahoma", Font.ITALIC, 50);
		buffer.setFont(police);
		buffer.setColor(new Color(200,200,200,240));
		buffer.drawString(jeu.fenetre_JEU.j1.nom,LARGEUR_FENETRE/2-100,150);
		
		//rectangle equipement
		Graphics2D g2d = (Graphics2D)buffer;         
		GradientPaint gp = new GradientPaint(0, 0,  new Color(100,100,100,127), 1000, 0,new Color(30,30,30,127), true);                
		g2d.setPaint(gp);
		g2d.fillRoundRect(1100,300,720,220,20,20);
		
		buffer.setColor( new Color(100,100,100,127));
		buffer.drawRoundRect(1105,305,710,210,20,20);
		buffer.drawRoundRect(1104,304,712,212,20,20);
		
		buffer.setFont(new Font("Tahoma", Font.ITALIC, 30));
		buffer.setColor(new Color(200,200,200,240));
		buffer.drawString("Equipement :",1130,340);
		
		for(int i=0;i<4;i++){
			buffer.setColor(new Color(200,200,200,100));
			buffer.drawRoundRect(1130+i*120,400,100,100,10,10);
			buffer.drawRoundRect(1131+i*120,401,98,98,10,10);
			buffer.drawRoundRect(1132+i*120,402,96,96,10,10);
		}
		
		//affichage du perso et rectangle d'info joueur
		buffer.drawImage(ImageLoader.ImgLoader("persoInventaire.png"),740,300,this);
		
		g2d.setPaint(gp);
		g2d.fillRoundRect(720,660,340,100,20,20);
		
		buffer.setFont(new Font("Tahoma", Font.ITALIC, 20));
		buffer.setColor(new Color(200,200,200,240));
		buffer.drawString("Degats : "+jeu.fenetre_JEU.j1.degat+"  Resistance : "+jeu.fenetre_JEU.j1.resistance,750,700);
		
		g.drawImage(monBuf,0,0,this);	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(show){
			if(afficher_liste_objets){
				
				compteurCurseurBefor=compteurCurseur;
				
				if(clavier.keyToutJusteAppuie(KeyEvent.VK_UP) && compteurCurseurY>0 && compteurCurseur>0 && compteurCurseur<liste_objets.size()) {
					yCurseur-=120;
					compteurCurseur-=5;
					compteurCurseurY-=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_DOWN) && compteurCurseurY<3 && compteurCurseur>=0 && compteurCurseur<liste_objets.size()-5) {
					yCurseur+=120;
					compteurCurseur+=5;
					compteurCurseurY+=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_LEFT) && compteurCurseurX>0 && compteurCurseur>0 && compteurCurseur<liste_objets.size()) {
					xCurseur-=120;
					compteurCurseur-=1;
					compteurCurseurX-=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_RIGHT) && compteurCurseurX<4 && compteurCurseur>=0 && compteurCurseur<liste_objets.size()-1) {
					xCurseur+=120;
					compteurCurseur+=1;
					compteurCurseurX+=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_LEFT)) {
					xCurseur =  100 ;
					yCurseur = 300 ;
					compteurCurseur = 0 ; 
					compteurCurseurX = 0;
					compteurCurseurY = 0;
					afficher_liste_objets = false ;
					afficher_liste_ressources = true ;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_RIGHT)) {
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
				
				if(clavier.keyToutJusteAppuie(KeyEvent.VK_UP) && compteurCurseurY>0 && compteurCurseur>0 && compteurCurseur<liste_ressources.size()) {
					yCurseur-=120;
					compteurCurseur-=5;
					compteurCurseurY-=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_DOWN) && compteurCurseurY<3 && compteurCurseur>=0 && compteurCurseur<liste_ressources.size()-5) {
					yCurseur+=120;
					compteurCurseur+=5;
					compteurCurseurY+=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_LEFT) && compteurCurseurX>0 && compteurCurseur>0 && compteurCurseur<liste_ressources.size()) {
					xCurseur-=120;
					compteurCurseur-=1;
					compteurCurseurX-=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_RIGHT) && compteurCurseurX<4 && compteurCurseur>=0 && compteurCurseur<liste_ressources.size()-1) {
					xCurseur+=120;
					compteurCurseur+=1;
					compteurCurseurX+=1;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_LEFT)) {
					xCurseur =  100 ;
					yCurseur = 300 ;
					compteurCurseur = 0 ; 
					compteurCurseurX = 0;
					compteurCurseurY = 0;
					afficher_liste_objets = true ;
					afficher_liste_ressources = false ;
				}else if(clavier.keyToutJusteAppuie(KeyEvent.VK_RIGHT)) {
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
