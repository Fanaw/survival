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
	boolean[][] curseur ={{true,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false}} ;
	static Clavier clavier ;
	
	ArrayList<ImageInventaire> liste_ressources = new ArrayList<ImageInventaire>() ;
	ArrayList<ImageInventaire> liste_objets = new ArrayList<ImageInventaire>() ;
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
			liste_objets.add(new ImageInventaire(jeu.fenetre_JEU.j1.objets_joueur.get(i),false));
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
		
		int count_active=0;
		for(int i=0 ; i<4 ; i++){
			for(int j=0 ; j<5 ; j++){
				buffer.setColor(new Color(100,100,100,100));
				buffer.fillRoundRect(100+120*j,300+120*i,100,100,10,10);
				if(afficher_liste_ressources){
					if(5*i+j<liste_ressources.size()){
						liste_ressources.get(5*i+j).dessine(buffer,this,100+120*j,300+120*i);
						
						if (liste_ressources.get(5*i+j).active){
							count_active++;
						}
					}
				}
				if(afficher_liste_objets){
					if(5*i+j<liste_objets.size()){
						liste_objets.get(5*i+j).dessine(buffer,this,100+120*j,300+120*i);
						if (liste_ressources.get(5*i+j).active){
							count_active++;
						}
					}
						
				}
			}
		}
		System.out.println(count_active);
		
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
			
			//on met en evidence l'item en selection
			for(int i=0;i<4;i++){
				for(int j=0;j<5;j++){
					if(afficher_liste_ressources){
						if(curseur[i][j]){
							try{
								liste_ressources.get(5*i+j).active=true;
							}catch(IndexOutOfBoundsException f){}
						}else if(!curseur[i][j]){
							try{
								liste_ressources.get(5*i+j).active=false;
							}catch(IndexOutOfBoundsException f){}
						}if(curseur[i][j] && clavier.up){
							try{
								curseur[i][j]=false;
								curseur[i-1][j]=true;
								clavier.up=false;
							}catch(ArrayIndexOutOfBoundsException f){}	
								
						}if(curseur[i][j] && clavier.down){
							try{
								liste_ressources.get(5*(i+1)+j).active=false;
								curseur[i][j]=false;	
								curseur[i+1][j]=true;														
								clavier.down=false;
							}catch(IndexOutOfBoundsException f){
							}
							
						}else if(curseur[i][j] && clavier.left){
							try{
								curseur[i][j]=false;
								curseur[i][j-1]=true;
								clavier.left=false;
							}catch(ArrayIndexOutOfBoundsException f){
								curseur[i][j]=false;
								curseur[0][0]=true;
								afficher_liste_ressources=false;
								afficher_liste_objets=true;
							}
							
						}else if(curseur[i][j] && clavier.right){
							try{
								liste_ressources.get(5*(i)+j+1).active=false;
								curseur[i][j]=false;
								curseur[i][j+1]=true;								
								clavier.right=false;
							}catch(IndexOutOfBoundsException f){
								curseur[i][j]=false;
								curseur[0][0]=true;
								afficher_liste_ressources=false;
								afficher_liste_objets=true;
							}
						}else if(curseur[i][j]){
							try{
								liste_ressources.get(5*i+j).active=true;
							}catch(IndexOutOfBoundsException f){}
						}else if(!curseur[i][j]){
							try{
								liste_ressources.get(5*i+j).active=false;
							}catch(IndexOutOfBoundsException f){}
						}	
					 }
					 else if(afficher_liste_objets){
						if(curseur[i][j]){
							try{
								liste_objets.get(5*i+j).active=true;
							}catch(IndexOutOfBoundsException f){}
						}if(!curseur[i][j]){
							try{
								liste_objets.get(5*i+j).active=false;
							}catch(IndexOutOfBoundsException f){}
						}if(curseur[i][j] && clavier.up){
							try{
								curseur[i][j]=false;
								curseur[i-1][j]=true;
								clavier.up=false;
							}catch(ArrayIndexOutOfBoundsException f){}	
								
						}if(curseur[i][j] && clavier.down){
							try{
								liste_objets.get(5*(i+1)+j).active=false;
								curseur[i][j]=false;
								curseur[i+1][j]=true;							
								clavier.down=false;
							}catch(IndexOutOfBoundsException f){
							}
							
						}if(curseur[i][j] && clavier.left){
							try{
								curseur[i][j]=false;
								curseur[i][j-1]=true;								
								clavier.left=false;
							}catch(ArrayIndexOutOfBoundsException f){
								curseur[i][j]=false;
								curseur[0][0]=true;
								afficher_liste_objets=false;
								afficher_liste_ressources=true;
							}
							
						}if(curseur[i][j] && clavier.right){
							try{
								liste_objets.get(5*(i)+j+1).active=false;
								curseur[i][j]=false;
								curseur[i][j+1]=true;								
								clavier.right=false;
							}catch(IndexOutOfBoundsException f){
								curseur[i][j]=false;
								curseur[0][0]=true;
								afficher_liste_objets=false;
								afficher_liste_ressources=true;
							}
						}if(curseur[i][j]){
							try{
								liste_ressources.get(5*i+j).active=true;
							}catch(IndexOutOfBoundsException f){}
						}if(!curseur[i][j]){
							try{
								liste_ressources.get(5*i+j).active=false;
							}catch(IndexOutOfBoundsException f){}
						}	
					}			
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
