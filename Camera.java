public class Camera {
	
	
	private float xOffset, yOffset;
	
	public Camera(float xOffset, float yOffset){
		
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centrerSurCreature(Creature c){
		
		if(c.getX()<=Fenetre.LARGEUR_FENETRE/2 &&  ( c.getY()> Fenetre.HAUTEUR_FENETRE/2 && c.getY()<=((Fenetre.monde.hauteur-1)*Tile.hauteur-Fenetre.HAUTEUR_FENETRE/2)) ){ // Coté gauche
			xOffset=0;
			yOffset=c.getY() - Fenetre.HAUTEUR_FENETRE / 2 + c.getHauteur() / 2;
		}else if (c.getY()<=Fenetre.HAUTEUR_FENETRE/2 && (c.getX()>Fenetre.LARGEUR_FENETRE/2 && c.getX()<=((Fenetre.monde.largeur-1)*Tile.hauteur-Fenetre.LARGEUR_FENETRE/2 )) ){// Coté haut
			xOffset = c.getX() - Fenetre.LARGEUR_FENETRE / 2 + c.getLargeur() / 2;
			yOffset = 0;
		}else if(c.getX()<=Fenetre.LARGEUR_FENETRE/2 && c.getY()<=Fenetre.HAUTEUR_FENETRE/2){ // Coin haut gauche
			xOffset = 0;
			yOffset = 0;
		}else if (c.getY()> ((Fenetre.monde.hauteur-1)*Tile.hauteur-Fenetre.HAUTEUR_FENETRE/2) && (c.getX()>Fenetre.LARGEUR_FENETRE/2 && c.getX()<=((Fenetre.monde.largeur-1)*Tile.hauteur-Fenetre.LARGEUR_FENETRE/2 )) ){// Coté bas
			xOffset = c.getX() - Fenetre.LARGEUR_FENETRE / 2 + c.getLargeur() / 2;
			yOffset = Fenetre.monde.hauteur*Tile.hauteur - Fenetre.HAUTEUR_FENETRE;
		}else if (c.getY()> ((Fenetre.monde.hauteur-1)*Tile.hauteur-Fenetre.HAUTEUR_FENETRE/2) && c.getX()<= Fenetre.LARGEUR_FENETRE/2 ){//Coin bas gauche 
			xOffset =0;
			yOffset = Fenetre.monde.hauteur*Tile.hauteur - Fenetre.HAUTEUR_FENETRE;
		}else if (c.getY()> ((Fenetre.monde.hauteur-1)*Tile.hauteur-Fenetre.HAUTEUR_FENETRE/2) && c.getX()>((Fenetre.monde.largeur-1)*Tile.hauteur-Fenetre.LARGEUR_FENETRE/2 )){//Coin bas droite 
			xOffset =Fenetre.monde.largeur*Tile.largeur - Fenetre.LARGEUR_FENETRE;;
			yOffset = Fenetre.monde.hauteur*Tile.hauteur - Fenetre.HAUTEUR_FENETRE;
		}else if ( (c.getY()>Fenetre.HAUTEUR_FENETRE/2 && c.getY()<=((Fenetre.monde.hauteur-1)*Tile.hauteur-Fenetre.HAUTEUR_FENETRE/2)) && c.getX()>((Fenetre.monde.largeur-1)*Tile.hauteur-Fenetre.LARGEUR_FENETRE/2 )){ //Coté droit
			xOffset = Fenetre.monde.largeur*Tile.largeur - Fenetre.LARGEUR_FENETRE;
			yOffset = c.getY() - Fenetre.HAUTEUR_FENETRE / 2 + c.getHauteur() / 2;
		}else if (c.getY()<=Fenetre.HAUTEUR_FENETRE/2 && c.getX()>((Fenetre.monde.largeur-1)*Tile.hauteur-Fenetre.LARGEUR_FENETRE/2 )){ // Coin haut droite
			xOffset = Fenetre.monde.largeur*Tile.largeur - Fenetre.LARGEUR_FENETRE;
			yOffset = 0;
		}
		
			else{  // Partout en dehors des zonnes spécifiées
			xOffset = c.getX() - Fenetre.LARGEUR_FENETRE / 2 + c.getLargeur() / 2;
			yOffset=c.getY() - Fenetre.HAUTEUR_FENETRE / 2 + c.getHauteur() / 2;
		}
		
	}
	
	public void move(float x, float y){
		xOffset += x;
		yOffset += y;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}