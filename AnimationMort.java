import java.awt.Graphics;
import javax.swing.*;

public class AnimationMort {
	
	int x,y;
	static long t1,cooldown=100;
	
	public AnimationMort(int x, int y){
		this.x = x;
		this.y=y;
		
			
	}
	
	
	public void dessine(Graphics g, JPanel jf){
		
		
		if(System.currentTimeMillis() - t1 <cooldown){
			g.drawImage(Liste.disparition1, (int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()),50,50, jf); 
			System.out.println("HOP1");
		}
		if(System.currentTimeMillis() -t1 <cooldown*3 && System.currentTimeMillis() - t1 >cooldown ){
			g.drawImage(Liste.disparition2,(int) (x - Fenetre.camera.getxOffset()) , (int) (y - Fenetre.camera.getyOffset()),50,50, jf); 
			System.out.println("HOP2");
		}
		
		
	}
	
	

}
