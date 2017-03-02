import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;

public class ImageLoader {
	
	
	
	public static BufferedImage ImgLoader(String img){
		try{
			return ImageIO.read(ImageLoader.class.getResource(img));
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public static BufferedImage ImgLoaderSpe(String img,int x,int y, int l, int h){
		try{
			return ImageIO.read(ImageLoader.class.getResource(img)).getSubimage(x,y,l,h);
			
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage scale(BufferedImage source, int width, int height) { 
		/* On crée une nouvelle image aux bonnes dimensions. */ 
		BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); 
	  
		/* On dessine sur le Graphics de l'image bufferisée. */ 
		Graphics2D g = buf.createGraphics(); 
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
		g.drawImage(source, 0, 0, width, height, null); 
		g.dispose(); 
	  
		/* On retourne l'image bufferisée, qui est une image. */ 
		return buf; 
	}
	
	public static BufferedImage screen(JPanel panel){
		
		BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height,BufferedImage.TYPE_INT_ARGB);

		panel.paint(bufImage.createGraphics());
		
		return bufImage;
		
	}


}
