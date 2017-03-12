import java.awt.Rectangle;

public class MonstreAgressif extends Monstre{

	public MonstreAgressif(float x, float y, int largeur, int hauteur){
		super(x,y,largeur,hauteur);
		
		
	}
	
	public void tick(){
		xMove = 0;
		yMove = 0;
		//creation du rectangle d'aggression autour du monstre
		Rectangle ra = new Rectangle((int)x - 250 ,(int)y-250,1000,1000);
		//creation du rectangle du joueur en fonction de sa position
		Rectangle rj = new Rectangle ((int)(Fenetre.j1.x), (int)(Fenetre.j1.y ),Fenetre.j1.largeur , Fenetre.j1.hauteur);
		
		deplacement  = System.currentTimeMillis() - dernierDeplacement;
		if(deplacement > cooldown){
				dernierDeplacement = System.currentTimeMillis(); 
		
		
			if(!ra.intersects(rj)){
				deplacement();
			}else{
				
					if(x>Fenetre.j1.x && x>Fenetre.j1.x+Fenetre.j1.largeur){
						xMove-=vitesse/2;
						direction = 2;
					}else if(x<Fenetre.j1.x && x<= Fenetre.j1.x+Fenetre.j1.largeur){
						xMove+=vitesse/2;
						direction = 3;
					}else if(x>=Fenetre.j1.x && x<=Fenetre.j1.x+Fenetre.j1.largeur)
						xMove=0;
					else
						xMove=0;
						
							
					if(y>Fenetre.j1.y && y>Fenetre.j1.y+Fenetre.j1.hauteur){
						yMove-=vitesse/2;
						direction = 1;
					}else if(y<Fenetre.j1.y && y<Fenetre.j1.y+Fenetre.j1.hauteur){
						yMove+=vitesse/2;
						direction =0;
					}else if(y>=Fenetre.j1.y && y <=Fenetre.j1.y+Fenetre.j1.hauteur)
						yMove=0;
					else
						yMove=0;
				
				
			}
			move();
			attaque();
		}
	}
		
	
	
	
	
}
