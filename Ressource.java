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

	public Ressource(int nombre,String nomFichierImage) {
		this.image = ImageLoader.ImgLoader(nomFichierImage);
		this.nombre=nombre;
	}
	
	public void ajouterRessource() {
		nombre++;
	}
	
	public void supprimerRessource() {
		nombre--;
	}
}
