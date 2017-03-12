import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;

public class Ressource {

	int nombre ;
	BufferedImage image ;
	String description ;
	String nom ;

	public Ressource(String nom ,int nombre,String nomFichierImage, String description ) {
		this.image = ImageLoader.ImgLoader(nomFichierImage);
		this.nombre=nombre;
		this.description=description;
		this.nom =nom;
	}
	
	public void ajouterRessource() {
		nombre++;
	}
	
	public void supprimerRessource() {
		nombre--;
	}
}
