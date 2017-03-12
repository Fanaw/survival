import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;


public class TelepoTile extends SolidTile {
	Rectangle rtile,rj;
	public TelepoTile(BufferedImage image, int id){
		super(image,id);
		
	}
	
	public void tick(){
		rtile=new Rectangle((int)(xtile),(int)(ytile),16,16);
		rj = new Rectangle ( (int) Fenetre.j1.x-100, (int) Fenetre.j1.y-100,250,250); 
		System.out.println(xtile+" "+ytile);
		System.out.println(Fenetre.j1.x+" "+Fenetre.j1.y);
		if(rtile.intersects(rj)){
			Fenetre.monde=new Monde("world1.txt");
			Fenetre.j1.x=Fenetre.monde.getSpawnX();
			Fenetre.j1.y=Fenetre.monde.getSpawnY();
		}
	}
	
	
	
	
}

