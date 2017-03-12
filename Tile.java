import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Tile {
	
	
	float xtile,ytile;
	
	
	
	
	public static final int largeur = 50, hauteur = 50;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){ // UNE IMAGE ET UN ID( clef )
		this.texture = texture;
		this.id = id;
		
		Liste.tiles[id] = this;
	}
	
	public void tick(){
		
	}
	public void dessine2(Graphics g,JPanel jp){}
	
	public void dessine(Graphics g,JPanel jf, int x, int y){
		xtile=x+Fenetre.camera.getxOffset();
		ytile=y+Fenetre.camera.getyOffset();
		g.drawImage(texture, x, y, largeur, hauteur, jf);
	}
	
		
	public int getId(){
		return id;
	}
	
	public boolean estSolide(){
		return false;
	}
	
	
}
