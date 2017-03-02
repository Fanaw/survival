import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Tile {
	
	
	
	public static NotSolidTile test =  new NotSolidTile(Liste.herbe,0);
	
	
	
	public static final int largeur = 75, hauteur = 75;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){ // UNE IMAGE ET UN ID( clef )
		this.texture = texture;
		this.id = id;
		
		Liste.tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void dessine(Graphics g,JPanel jf, int x, int y){
		g.drawImage(texture, x, y, largeur, hauteur, jf);
	}
	
		
	public int getId(){
		return id;
	}
	
	public boolean estSolide(){
		return false;
	}
	
	
}
