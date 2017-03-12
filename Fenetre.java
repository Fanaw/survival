import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Fenetre extends JPanel implements ActionListener {
	static int LARGEUR_FENETRE;
	static int HAUTEUR_FENETRE;
	Timer timer;
	static int x;
	boolean show = false ; 
	BufferedImage screen ;
	Jeu jeu ;
	static Camera camera;
	static GestionEntite gEntite;
	static Clavier clavier;
	static Joueur j1;
	static Monde monde;
	static GestionItem gItem;
	static Monstre m1;
	static GestionAnimation gAnim;
	
	
	public Fenetre(int LARGEUR_FENETRE, int HAUTEUR_FENETRE,Clavier clavier, Jeu jeu){
		
		this.jeu=jeu;
		this.clavier=clavier;
		setSize(LARGEUR_FENETRE,HAUTEUR_FENETRE);
		
		this.HAUTEUR_FENETRE = HAUTEUR_FENETRE;
		this.LARGEUR_FENETRE = LARGEUR_FENETRE;
		
		monde = new Monde("world2.txt");
		j1 = new Joueur(monde.getSpawnX(),monde.getSpawnY());
		m1 = new MonstreAgressif(1000,800,50,50);
		camera = new Camera(0,0);
		
		
		gEntite = new GestionEntite();
		
		gEntite.addEntite(new Arbre(300,600,Liste.arbre));
		gEntite.addEntite(new Arbre(200,400,Liste.arbre));
		gEntite.addEntite(new Arbre(1000,500,Liste.arbre));
		gEntite.addEntite(new Arbre(1500,300,Liste.arbre));
		gEntite.addEntite(new Arbre(800,600,Liste.arbre));
		gEntite.addEntite(new Arbre(350,1000,Liste.arbre));
		gEntite.addEntite(new Pierre(200,400,Liste.pierre));
		gEntite.addEntite(new Pierre(100,300,Liste.pierre));
		gEntite.addEntite(new Pierre(200,800,Liste.pierre));
		gEntite.addEntite(j1);
		gEntite.addEntite(m1);
		
		
		gAnim = new GestionAnimation();
		
		gItem = new GestionItem();
		
		
		timer = new Timer(100,this);
		timer.start();	
	}
	
	
	public void paint(Graphics g){
			
		//Buffer :
		BufferedImage monBuf = new BufferedImage(LARGEUR_FENETRE,HAUTEUR_FENETRE,BufferedImage.TYPE_INT_RGB);
		Graphics Buffer = monBuf.getGraphics();
		
		
		Buffer.setColor(Color.white);
		Buffer.fillRect(0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE);
		monde.dessine(Buffer, this);
		//j1.dessine(Buffer);
		gItem.dessine(Buffer);
		gEntite.dessine(Buffer,this);
		gAnim.dessine(Buffer,this);
				
		//Dessine le  Buffer :
		g.drawImage(monBuf,0,0, this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		addKeyListener(clavier);
			
		if(show){	
			if(clavier.inventaire){
				System.out.println("je dois afficher l'inventaire");
				jeu.fenetre_INVENTAIRE.show=true;
				this.show=false;
				
			}
			monde.tick();		
			gEntite.tick();
			gItem.tick();
			Liste.animationTick();
			
			screen=ImageLoader.screen(this);
			
			repaint();	
		}
	}
	
			
	
}
