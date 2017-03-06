import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;
import java.util.*;

public class Ressource {

	int nombre ;
	BufferedImage image ;
	String description ;
	
	public Ressource(int nombre,String nomFichierImage,String description) {
		this.image = ImageLoader.ImgLoader(nomFichierImage);
		this.nombre=nombre;
		this.description=description;
	}
	
	public void ajouterRessource() {
		nombre++;
	}
	
	public void supprimerRessource() {
		nombre--;
	}
}
