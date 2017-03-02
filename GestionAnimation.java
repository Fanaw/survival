import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class GestionAnimation {

	private ArrayList<AnimationMort> anims;
	
	public GestionAnimation(){
		
		anims = new ArrayList<AnimationMort>();
		
	}
	
	public void dessine(Graphics g,JPanel jf){ // ON DESSINE TOUS LES anims
		for(int i =0;i<getAnims().size();i++){
			anims.get(i).dessine(g,jf);
			
		}
		
	}
	
	public void addAnim(AnimationMort i){ // AJOUT D'UN Anim A LA LISTE
		anims.add(i);
		
		
		
	}
	public void removeAnim(AnimationMort i){ // AJOUT D'UN Anim A LA LISTE
		anims.remove(i);
		
		
		
	}

	public ArrayList<AnimationMort> getAnims() {
		return anims;
	}

	public void setAnims(ArrayList<AnimationMort> anims) {
		this.anims = anims;
	}

	
	
}
