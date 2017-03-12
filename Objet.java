import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;
import java.util.*;

public class Objet {

	boolean exister ;
	BufferedImage image ;
	String description ;
	int bois,pierre,metal;
	
	public Objet(int nombre,String nomFichierImage,String description, int bois,int pierre,int metal) {
		this.image = ImageLoader.ImgLoader(nomFichierImage);
		
		this.bois=bois;
		this.pierre=pierre;
		this.metal=metal;
		this.description=description;
	}
	
}
