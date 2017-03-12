import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.Graphics;
import javax.imageio.*;



public class Jeu extends JFrame implements ActionListener{

	Clavier clavier = new Clavier();
	private final int LARGEUR_FENETRE =1800 ;
	private final int HAUTEUR_FENETRE = 1000;
	Fenetre fenetre_JEU = new Fenetre(LARGEUR_FENETRE,HAUTEUR_FENETRE,clavier,this);
	FenetreMenu fenetre_MENU = new FenetreMenu(LARGEUR_FENETRE,HAUTEUR_FENETRE,clavier,this);
	FenetreInventaire fenetre_INVENTAIRE = new FenetreInventaire(LARGEUR_FENETRE,HAUTEUR_FENETRE,clavier,this);
	static boolean showInv;
	
	public Jeu() {
		
		this.setLayout(null);
		this.setSize(LARGEUR_FENETRE,HAUTEUR_FENETRE);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
				
		
		Timer timer = new Timer(100,this);
		timer.start();	
				
		addKeyListener(clavier);
		
		//this.add(fenetre_INVENTAIRE);
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
	
		if(fenetre_INVENTAIRE.show){
			this.add(fenetre_INVENTAIRE);
			showInv=true;
		}if(fenetre_JEU.show){
			this.add(fenetre_JEU);
			showInv=false;
		}if(fenetre_MENU.show){
			this.add(fenetre_MENU);
			showInv=false;
		}
		
		if(fenetre_INVENTAIRE.show==false){
			this.remove(fenetre_INVENTAIRE);
			fenetre_INVENTAIRE.xCurseur=100;
			fenetre_INVENTAIRE.yCurseur=300;
		}if(fenetre_JEU.show==false){
			this.remove(fenetre_JEU);
		}if(fenetre_MENU.show==false){
			this.remove(fenetre_MENU);
		}
		
		clavier.tick();
	}

	public static void main(String[] args){
			new Jeu();
	}

}
