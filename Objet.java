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

	boolean equipe,exister ;
	BufferedImage image ;
	String description ;
	int bois,pierre,metal;
	String categorie ;
	int degat_supp,resistance_supp ;
	
	public Objet(int degat_supp, int resistance_supp, String categorie,int nombre,String nomFichierImage,String description, int bois,int pierre,int metal) {
		this.image = ImageLoader.ImgLoader(nomFichierImage);
		this.equipe=false;
		this.exister=false;
		this.bois=bois;
		this.pierre=pierre;
		this.metal=metal;
		this.description=description;
		this.categorie=categorie;
		this.resistance_supp=resistance_supp;
		this.degat_supp=degat_supp;
	}
	
}
