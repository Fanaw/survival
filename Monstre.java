import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;

public class Monstre extends Creature {
	
	
	long deplacement,dernierDeplacement = 800,cooldown=100;
	
	
	public Monstre(float x, float y, int largeur, int hauteur) {
		super(x,y,largeur,hauteur);
		System.out.println("Monstre Cree");
		
		
		
	}
	
	public void tick(){
		
		deplacement  = System.currentTimeMillis() - dernierDeplacement;
		 if(deplacement > cooldown){
				dernierDeplacement = System.currentTimeMillis(); 
				
			deplacement();
			move();
			attaque();
		 }
	}
	
	public void meurt(){
		AnimationMort a = new AnimationMort((int)x,(int)y);
		a.t1=System.currentTimeMillis();
		Fenetre.gAnim.addAnim(a);
		
	}
	
	
	public void attaque(){
		//creation du rectangle d'attaque autour du monstre
		Rectangle ra = new Rectangle((int)x -largeur/2 ,(int)y-hauteur/2,largeur*2,hauteur*2);
		//creation du rectangle du joueur en fonction de sa position
		Rectangle rj = new Rectangle ((int)(Fenetre.j1.x), (int)(Fenetre.j1.y ),Fenetre.j1.largeur , Fenetre.j1.hauteur);
		System.out.println("TOUCH�");
		if(ra.intersects(rj)){
			Fenetre.j1.subisAttaque(1);
			
		}
		
		
		
	}
	
	
	
	
	
	
	public void deplacement(){
		
		 
		
		
		
			
		
			int random = (int)(Math.random()*4);
			 direction = random;
			 if(random == 0){
				 xMove =0;
				 yMove +=vitesse;
				
			 }else if(random == 1){
				 xMove=0;
				 yMove-=vitesse;
				 
				 
			 }else if(random == 2){
				 xMove-=vitesse;
				 yMove=0;
				 
			 }else{
				 xMove+=vitesse;
				 yMove=0;
				 
			 }
	
		
		
		
		
		
		
		
	}
	
	public void dessine(Graphics g, JPanel jf){
		System.out.println("Dessin");
		g.drawImage(Liste.monstre1, (int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()), largeur, hauteur, jf);
		g.setColor(Color.red);
		g.fillRect((int) (x-Fenetre.camera.getxOffset()), (int) (y+largeur - Fenetre.camera.getyOffset()), vie*largeur/10, 20);
	}
	
	
	
	

}
