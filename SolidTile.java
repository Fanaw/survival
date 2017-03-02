import java.awt.image.BufferedImage;

public class SolidTile extends  Tile{
	
	
	public SolidTile(BufferedImage image, int id){
		super(image,id);
		
	}
	
	public boolean estSolide(){
		return true;
	}
	
}