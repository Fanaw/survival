import java.awt.image.BufferedImage;

public class Liste {
	//Variable d'animation :
	static int k;
		
	
	
	
	//IMAGES :
	
	public static BufferedImage gazon = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 0, 16, 16);
	public static BufferedImage herbe = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 0, 16, 16);
	public static BufferedImage panneau = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 0, 16, 16);
	public static BufferedImage trou = ImageLoader.ImgLoaderSpe("Sprite1.png", 48, 0, 16, 16);
	public static BufferedImage buisson1 = ImageLoader.ImgLoaderSpe("Sprite1.png", 64, 0, 16, 16);
	public static BufferedImage buisson2 = ImageLoader.ImgLoaderSpe("Sprite1.png", 80, 0, 16, 16);
	public static BufferedImage fleurs = ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 0, 16, 16);
	public static BufferedImage terre1 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 0, 16, 16);
	public static BufferedImage terre2 = ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 0, 16, 16);
	public static BufferedImage terre3 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 0, 16, 16);
	public static BufferedImage terre4 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 16, 16, 16);
	public static BufferedImage terre5 = ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 16, 16, 16);
	public static BufferedImage terre6 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 16, 16, 16);
	public static BufferedImage souche1 = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 16, 16, 16);
	public static BufferedImage souche2 = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 16, 16, 16);
	public static BufferedImage souche3 = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 32, 16, 16);
	public static BufferedImage souche4 = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 32, 16, 16);
	public static BufferedImage gazonHerbe = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 16, 16, 16);
	public static BufferedImage gazonUsé = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 32, 16, 16);
	public static BufferedImage arbre1 = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 48, 16, 16);
	public static BufferedImage arbre2 = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 48, 16, 16);
	public static BufferedImage arbre3 = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 48, 16, 16);
	public static BufferedImage arbre4 = ImageLoader.ImgLoaderSpe("Sprite1.png", 48, 48, 16, 16);
	public static BufferedImage arbre5 = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 64, 16, 16);
	public static BufferedImage arbre6 = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 64, 16, 16);
	public static BufferedImage arbre7 = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 64, 16, 16);
	public static BufferedImage arbre8 = ImageLoader.ImgLoaderSpe("Sprite1.png", 48, 64, 16, 16);
	public static BufferedImage arbre9 = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 80, 16, 16);
	public static BufferedImage arbre10 = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 80, 16, 16);
	public static BufferedImage arbre11 = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 80, 16, 16);
	public static BufferedImage arbre12 = ImageLoader.ImgLoaderSpe("Sprite1.png", 48, 80, 16, 16);
	public static BufferedImage arbre13 = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 96, 16, 16);
	public static BufferedImage arbre14 = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 96, 16, 16);
	public static BufferedImage arbre15 = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 96, 16, 16);
	public static BufferedImage arbre16 = ImageLoader.ImgLoaderSpe("Sprite1.png", 48, 96, 16, 16);
	public static BufferedImage arbre17 = ImageLoader.ImgLoaderSpe("Sprite1.png", 0, 112, 16, 16);
	public static BufferedImage arbre18 = ImageLoader.ImgLoaderSpe("Sprite1.png", 16, 112, 16, 16);
	public static BufferedImage arbre19 = ImageLoader.ImgLoaderSpe("Sprite1.png", 32, 112, 16, 16);
	public static BufferedImage arbre20 = ImageLoader.ImgLoaderSpe("Sprite1.png", 48, 112, 16, 16);
	public static BufferedImage maison1 = ImageLoader.ImgLoaderSpe("Sprite1.png", 64, 48, 16, 16);
	public static BufferedImage maison2 = ImageLoader.ImgLoaderSpe("Sprite1.png", 80, 48, 16, 16);
	public static BufferedImage maison3 = ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 48, 16, 16);
	public static BufferedImage maison4 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 48, 16, 16);
	public static BufferedImage maison5 = ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 48, 16, 16);
	public static BufferedImage maison6 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 48, 16, 16);
	public static BufferedImage maison7 = ImageLoader.ImgLoaderSpe("Sprite1.png", 64, 64, 16, 16);
	public static BufferedImage maison8 = ImageLoader.ImgLoaderSpe("Sprite1.png", 80, 64, 16, 16);
	public static BufferedImage maison9 = ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 64, 16, 16);
	public static BufferedImage maison10 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 64, 16, 16);
	public static BufferedImage maison11= ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 64, 16, 16);
	public static BufferedImage maison12 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 64, 16, 16);
	public static BufferedImage maison13= ImageLoader.ImgLoaderSpe("Sprite1.png", 64, 80, 16, 16);
	public static BufferedImage maison14 = ImageLoader.ImgLoaderSpe("Sprite1.png", 80, 80, 16, 16);
	public static BufferedImage maison15= ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 80, 16, 16);
	public static BufferedImage maison16 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 80, 16, 16);
	public static BufferedImage maison17 = ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 80, 16, 16);
	public static BufferedImage maison18 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 80, 16, 16);
	public static BufferedImage maison19 = ImageLoader.ImgLoaderSpe("Sprite1.png", 64, 96, 16, 16);
	public static BufferedImage maison20 = ImageLoader.ImgLoaderSpe("Sprite1.png", 80, 96, 16, 16);
	public static BufferedImage maison21 = ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 96, 16, 16);
	public static BufferedImage maison22 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 96, 16, 16);
	public static BufferedImage maison23 = ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 96, 16, 16);
	public static BufferedImage maison24 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 96, 16, 16);
	public static BufferedImage maison25 = ImageLoader.ImgLoaderSpe("Sprite1.png", 64, 112, 16, 16);
	public static BufferedImage maison26 = ImageLoader.ImgLoaderSpe("Sprite1.png", 80, 112, 16, 16);
	public static BufferedImage maison27 = ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 112, 16, 16);
	public static BufferedImage maison28 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 112, 16, 16);
	public static BufferedImage maison29 = ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 112, 16, 16);
	public static BufferedImage maison30 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 112, 16, 16);	
	public static BufferedImage maison31 = ImageLoader.ImgLoaderSpe("Sprite1.png", 64, 128, 16, 16);
	public static BufferedImage maison32 = ImageLoader.ImgLoaderSpe("Sprite1.png", 80, 128, 16, 16);
	public static BufferedImage maison33 = ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 128, 16, 16);
	public static BufferedImage maison34 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 128, 16, 16);
	public static BufferedImage maison35 = ImageLoader.ImgLoaderSpe("Sprite1.png", 128, 128, 16, 16);
	public static BufferedImage maison36 = ImageLoader.ImgLoaderSpe("Sprite1.png", 144, 128, 16, 16);
	public static BufferedImage maison37 = ImageLoader.ImgLoaderSpe("Sprite1.png", 96, 144, 16, 16);
	public static BufferedImage maison38 = ImageLoader.ImgLoaderSpe("Sprite1.png", 112, 144, 16, 16);
	public static BufferedImage arbre = ImageLoader.ImgLoader("arbre.gif");
	public static BufferedImage bois = ImageLoader.ImgLoader("bois.gif");
	public static BufferedImage pierre = ImageLoader.ImgLoader("pierre.gif");
	public static BufferedImage disparition1 = ImageLoader.ImgLoaderSpe("disparition.gif", 0, 0, 16, 16);
	public static BufferedImage disparition2 = ImageLoader.ImgLoaderSpe("disparition.gif", 16, 0, 16, 16);
	
	
	
	
	
	//TABLEAU REGROUPE LES TILES :
	
		public static Tile[] tiles = new Tile[256];
	
	
	// TILES :
	
	
	public static NotSolidTile TileGazon = new NotSolidTile(gazon,7);
	public static NotSolidTile TileHerbe = new NotSolidTile(herbe,31);
	public static SolidTile TilePanneau = new SolidTile(panneau,67);
	public static SolidTile TileTrou = new SolidTile(trou,201);
	public static SolidTile TileBuisson1 = new SolidTile(buisson1,26);
	public static SolidTile TileBuisson2 = new SolidTile(buisson2,63);
	public static NotSolidTile TileFleurs = new NotSolidTile(fleurs,66);
	public static NotSolidTile TileTerre1 = new NotSolidTile(terre1,28);
	public static NotSolidTile TileTerre2 = new NotSolidTile(terre2,29);
	public static NotSolidTile TileTerre3 = new NotSolidTile(terre3,30);
	public static NotSolidTile TileTerre4 = new NotSolidTile(terre4,37);
	public static NotSolidTile TileTerre5 = new NotSolidTile(terre5,38);
	public static NotSolidTile TileTerre6 = new NotSolidTile(terre6,39);
	public static SolidTile TileSouche1 = new SolidTile(souche1,22);
	public static SolidTile TileSouche2 = new SolidTile(souche2,23);
	public static SolidTile TileSouche3 = new SolidTile(souche3,24);
	public static SolidTile TileSouche4 = new SolidTile(souche4,25);
	public static NotSolidTile TileGazonHerbe = new NotSolidTile(gazonHerbe,27);
	public static NotSolidTile TileGazonUsé = new NotSolidTile(gazonUsé,200);
	public static SolidTile TileArbre1 = new SolidTile(arbre1,12);
	public static SolidTile TileArbre2 = new SolidTile(arbre2,13);
	public static SolidTile TileArbre3 = new SolidTile(arbre3,1);
	public static SolidTile TileArbre4 = new SolidTile(arbre4,2);
	public static SolidTile TileArbre5 = new SolidTile(arbre5,3);
	public static SolidTile TileArbre6 = new SolidTile(arbre6,4);
	public static SolidTile TileArbre7 = new SolidTile(arbre7,5);
	public static SolidTile TileArbre8 = new SolidTile(arbre8,6);
	public static SolidTile TileArbre9 = new SolidTile(arbre9,8);
	public static SolidTile TileArbre10 = new SolidTile(arbre10,9);
	public static SolidTile TileArbre11 = new SolidTile(arbre11,10);
	public static SolidTile TileArbre12 = new SolidTile(arbre12,11);
	public static SolidTile TileArbre13 = new SolidTile(arbre13,14);
	public static SolidTile TileArbre14 = new SolidTile(arbre14,15);
	public static SolidTile TileArbre15 = new SolidTile(arbre15,16);
	public static SolidTile TileArbre16 = new SolidTile(arbre16,17);
	public static SolidTile TileArbre17 = new SolidTile(arbre17,18);
	public static SolidTile TileArbre18 = new SolidTile(arbre18,19);
	public static SolidTile TileArbre19 = new SolidTile(arbre19,20);
	public static SolidTile TileArbre20 = new SolidTile(arbre20,21);
	public static SolidTile TileMaison1 = new SolidTile(maison1,32);
	public static SolidTile TileMaison2 = new SolidTile(maison2,33);
	public static SolidTile TileMaison3 = new SolidTile(maison3,34);
	public static SolidTile TileMaison4 = new SolidTile(maison4,34);
	public static SolidTile TileMaison5 = new SolidTile(maison5,35);
	public static SolidTile TileMaison6 = new SolidTile(maison6,36);
	public static SolidTile TileMaison7= new SolidTile(maison7,40);
	public static SolidTile TileMaison8 = new SolidTile(maison8,41);
	public static SolidTile TileMaison9 = new SolidTile(maison9,42);
	public static SolidTile TileMaison10 = new SolidTile(maison10,42);
	public static SolidTile TileMaison11 = new SolidTile(maison11,43);
	public static SolidTile TileMaison12 = new SolidTile(maison12,44);
	public static SolidTile TileMaison13 = new SolidTile(maison13,40);
	public static SolidTile TileMaison14 = new SolidTile(maison14,41);
	public static SolidTile TileMaison15 = new SolidTile(maison15,45);
	public static SolidTile TileMaison16 = new SolidTile(maison16,46);
	public static SolidTile TileMaison17 = new SolidTile(maison17,43);
	public static SolidTile TileMaison18 = new SolidTile(maison18,44);
	public static SolidTile TileMaison19 = new SolidTile(maison19,47);
	public static SolidTile TileMaison20 = new SolidTile(maison20,48);
	public static SolidTile TileMaison21 = new SolidTile(maison21,49);
	public static SolidTile TileMaison22 = new SolidTile(maison22,49);
	public static SolidTile TileMaison23 = new SolidTile(maison23,50);
	public static SolidTile TileMaison24 = new SolidTile(maison24,51); 
	public static SolidTile TileMaison25 = new SolidTile(maison25,52);
	public static SolidTile TileMaison26 = new SolidTile(maison26,53);
	public static SolidTile TileMaison27 = new SolidTile(maison27,54);
	public static SolidTile TileMaison28 = new SolidTile(maison28,55);
	public static SolidTile TileMaison29 = new SolidTile(maison29,53);
	public static SolidTile TileMaison30 = new SolidTile(maison30,56);
	public static SolidTile TileMaison31 = new SolidTile(maison31,57);
	public static SolidTile TileMaison32 = new SolidTile(maison32,58);
	public static SolidTile TileMaison33 = new SolidTile(maison33,59);
	public static SolidTile TileMaison34 = new SolidTile(maison34,60);
	public static SolidTile TileMaison35 = new SolidTile(maison35,61);
	public static SolidTile TileMaison36 = new SolidTile(maison36,62);
	public static NotSolidTile TileMaison37 = new NotSolidTile(maison37,64);
	public static NotSolidTile TileMaison38 = new NotSolidTile(maison38,65);
	
	
	// TABLEAU REGROUPE ITEM
	
	public static Item[] items = new Item[256];
	
	//ITEM
	
	public static Item iBois = new Item("bois",bois,0);
	public static Item iPierre = new Item("pierre",pierre,1);
	
	

	
	//Ressources
	public static Ressource ressource_bois = new Ressource(10,"bois.png","description bois");
	public static Ressource ressource_metal = new Ressource(10,"metal.png","description metal");
	public static Ressource ressource_pierre = new Ressource(10,"pierre.png","description pierre");

	public static Objet objet_hache = new Objet(0,"hache.png","description hache",3,3,0);
	public static Objet objet_bouclier = new Objet(0,"bouclier.png","description bouclier",3,3,2);
	public static Objet objet_epee = new Objet(0,"casque.png","description epee",0,3,3);
	
	
	//IMAGES ANIMÉES ;
	public static BufferedImage joueur;
	public static BufferedImage monstre1;
	
	public static void animationTick(){
		k++;
		if(k>3 || !Fenetre.j1.mouvement)
			k=0;
		
		joueur = ImageLoader.ImgLoaderSpe("Player.gif", 20*k, 26*Fenetre.j1.direction, 20, 26);
		monstre1 = ImageLoader.ImgLoaderSpe("monstre.gif", 16*Fenetre.m1.direction, 0, 16, 16);
		
	}
	
	

}
