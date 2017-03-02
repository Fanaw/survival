import java.awt.Rectangle;

public class Creature extends Entite{
	
	
	public static final int DEFAULT_SPEED = 20;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	
	
	protected float vitesse;
	protected float xMove, yMove;
	protected int direction;
	protected boolean mouvement;
	

	public Creature(float x, float y, int largeur, int hauteur) {
		super(x,y,largeur,hauteur);
		
		vitesse = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
		
	}
	
	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
		
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bords.x + bords.width) / Tile.largeur;
			
			if(!collisionTile(tx, (int) (y + bords.y) / Tile.hauteur) &&
					!collisionTile(tx, (int) (y + bords.y + bords.height) / Tile.hauteur)){
				x += xMove;
			}else{
				x = tx * Tile.largeur - bords.x - bords.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bords.x) / Tile.largeur;
			
			if(!collisionTile(tx, (int) (y + bords.y) / Tile.hauteur) &&
					!collisionTile(tx, (int) (y + bords.y + bords.height) / Tile.hauteur)){
				x += xMove;
			}else{
				x = tx * Tile.largeur + Tile.largeur - bords.x;
			}
			
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bords.y) / Tile.hauteur;
			
			if(!collisionTile((int) (x + bords.x) / Tile.largeur, ty) &&
					!collisionTile((int) (x + bords.x + bords.width) / Tile.largeur, ty)){
				y += yMove;
			}else{
				y = ty * Tile.hauteur + Tile.hauteur - bords.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bords.y + bords.height) / Tile.hauteur;
			
			if(!collisionTile((int) (x + bords.x) / Tile.largeur, ty) &&
					!collisionTile((int) (x + bords.x + bords.width) / Tile.largeur, ty)){
				y += yMove;
			}else{
				y = ty * Tile.hauteur - bords.y - bords.height - 1;
			}
			
		}
	}
	
	protected boolean collisionTile(int x, int y){
		return Fenetre.monde.getTile(x, y).estSolide();
	}
	
	
	
	//GETTERS & SETTERS :
	
	
	

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getVie() {
		return vie;
	}

	public void seVvie(int vie) {
		this.vie = vie;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}
	
}