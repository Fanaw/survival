import java.awt.Graphics;

import javax.swing.JPanel;

public class Monde {

	int largeur, hauteur;
	private int spawnX,spawnY;
	private int[][] tiles;
	
	public Monde(String nom){
		chargerMonde(nom);
		
	}
	
	public void tick(){
		for(int y = 0;y < hauteur;y++){
			for(int x = 0;x < largeur;x++){
				getTile(x, y).tick();
			}
		}
		
	}
	
	public void dessine(Graphics g,JPanel jf){ // ON DESSINE LES TILES RELATIVEMENT A L'OFFSET
		
		
		
		
		for(int y = (int) ((Fenetre.j1.y-Fenetre.HAUTEUR_FENETRE/2)/Tile.hauteur ) - 5;y < (int) ((Fenetre.j1.y+Fenetre.j1.hauteur+Fenetre.HAUTEUR_FENETRE/2)/Tile.hauteur ) +8;y++){
			for(int x =(int) ((Fenetre.j1.x-Fenetre.LARGEUR_FENETRE/2)/Tile.largeur) - 20;x < (int) ((Fenetre.j1.x+Fenetre.j1.largeur+Fenetre.LARGEUR_FENETRE/2)/Tile.largeur) + 20;x++){
				
				
				
				getTile(x, y).dessine(g,jf,(int) (x * Tile.largeur - Fenetre.camera.getxOffset()),(int)(y * Tile.hauteur - Fenetre.camera.getyOffset()) );
				
			}
		}
		
		
		
		
		
		
	}
	
	public Tile getTile(int x, int y){
		if(x<0 | y<0 || x>=largeur || y>=hauteur) //Etre sur que x et y soient dans les limites de la map
			return Liste.TileGazon;
		
		
		Tile t = Liste.tiles[tiles[x][y]];
		if(t == null)
			return Liste.TileHerbe;
		return t;
	}
	
	private void chargerMonde(String nom){
		
		String file = Outil.loadFileAsString(nom);
		String[] tokens = file.split("\\s+");
		largeur = Outil.parseInt(tokens[0]);
		hauteur = Outil.parseInt(tokens[1]);
		setSpawnX(Outil.parseInt(tokens[2]));
		setSpawnY(Outil.parseInt(tokens[3]));
		
		tiles = new int[largeur][hauteur];
		for(int y = 0;y < hauteur;y++){
			for(int x = 0;x < largeur;x++){
				tiles[x][y] = Outil.parseInt(tokens[(x + y * largeur) + 4]);
			}
		}
	}

	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	
}
