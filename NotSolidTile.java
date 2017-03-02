import java.awt.image.BufferedImage;

public class NotSolidTile extends  Tile{
	
	
	public NotSolidTile(BufferedImage image, int id){
		super(image,id);
		
	}
	
	public boolean estSolide(){
		return false;
	}
	
}
