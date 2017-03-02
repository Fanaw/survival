import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;



public class FenetreMenu extends JPanel implements ActionListener   {

	private final int LARGEUR_FENETRE ;
	private final int HAUTEUR_FENETRE ;
	Timer timer;
	private BufferedImage fond;
	private BufferedImage bouton_new_game ;
	private BufferedImage bouton_exit ;
	private int position_curseur = 0 ;
	static Clavier clavier  ;	
	boolean show = true ; 
	Jeu jeu ;
	
	public FenetreMenu(int LARGEUR_FENETRE, int HAUTEUR_FENETRE,Clavier clavier,Jeu jeu){
		
		this.jeu=jeu;
		this.clavier=clavier;
		setSize(LARGEUR_FENETRE,HAUTEUR_FENETRE);

		
		this.HAUTEUR_FENETRE = HAUTEUR_FENETRE;
		this.LARGEUR_FENETRE = LARGEUR_FENETRE;
		
		//Chargement des images
		fond = ImageLoader.ImgLoader("FenetreMenu.png");
		bouton_new_game = ImageLoader.ImgLoader("BoutonNewGame.png");
		bouton_exit = ImageLoader.ImgLoader("BoutonExit.png");
		
		timer = new Timer(100,this);
		timer.start();	
		
	}
	
	public void paint(Graphics g){
		
		g.drawImage(fond,0,0,this);
		g.drawImage(bouton_new_game,(LARGEUR_FENETRE-bouton_new_game.getWidth())/2,(HAUTEUR_FENETRE-bouton_new_game.getHeight())/2,this);
		g.drawImage(bouton_exit,(LARGEUR_FENETRE-bouton_exit.getWidth())/2,(HAUTEUR_FENETRE-bouton_exit.getHeight())/2+300,this);
		
		if(position_curseur==0){
			g.setColor(new Color(100,100,100,127));
			g.fillRoundRect((LARGEUR_FENETRE-bouton_new_game.getWidth())/2,(HAUTEUR_FENETRE-bouton_new_game.getHeight())/2,bouton_new_game.getWidth(),bouton_new_game.getHeight(),10,10);
		}
		if(position_curseur==1){
			g.setColor(new Color(100,100,100,127));
			g.fillRoundRect((LARGEUR_FENETRE-bouton_exit.getWidth())/2,(HAUTEUR_FENETRE-bouton_exit.getHeight())/2+300,bouton_exit.getWidth(),bouton_exit.getHeight(),10,10);
		}
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(show){
			if(clavier.up){
				if(position_curseur>0){
					position_curseur--;
				}
			}
			
			if(clavier.down){
				if(position_curseur<1){
					position_curseur++;
				}
			}	
			
			if(clavier.enter && position_curseur==0){
				jeu.fenetre_JEU.show=true;
				this.show=false;
			}
			
			if(clavier.enter && position_curseur==1){
				System.exit(0);
			}
			
			if(!this.show){
				timer.stop();
			}
			if(this.show){
				timer.start();
			}
			
			addKeyListener(clavier);
			
			repaint();	
		}
	}
	
		  
}

