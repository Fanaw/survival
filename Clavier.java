import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

	
	boolean[] keys, toutJusteAppuie, nePeutPasAppuie;
	boolean up,down,left,right,shift,degatUp,degatDown,degatLeft,degatRight,enter,inventaire,exit,equipe;
	public Clavier(){
		keys = new boolean[256];
		toutJusteAppuie = new boolean[keys.length];
		nePeutPasAppuie = new boolean[keys.length];
	}
	
	public void tick(){
		int compteur = 0;
		
		for(int i = 0;i < keys.length;i++){
			
			
			if(nePeutPasAppuie[i] && !keys[i]){
				nePeutPasAppuie[i] = false;
			}else if(toutJusteAppuie[i]){
				nePeutPasAppuie[i] = true;
				toutJusteAppuie[i] = false;
			}
			
			
			if(!nePeutPasAppuie[i] && keys[i]){
				toutJusteAppuie[i] = true;
			}
			
		}
		
		
		
		up=keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_DOWN];
		left=keys[KeyEvent.VK_LEFT];
		right=keys[KeyEvent.VK_RIGHT];
		
		degatUp=keys[KeyEvent.VK_UP];
		degatDown=keys[KeyEvent.VK_DOWN];
		degatLeft=keys[KeyEvent.VK_LEFT];
		degatRight=keys[KeyEvent.VK_RIGHT];
		
		enter=keys[KeyEvent.VK_ENTER];
		inventaire=keys[KeyEvent.VK_P];
		exit=keys[KeyEvent.VK_M];
		equipe=keys[KeyEvent.VK_E];
		
		
		
		
		
		shift=keys[KeyEvent.VK_SHIFT];
		
		
		
		
		
		if(shift)
			Fenetre.j1.vitesse=80;
		else
			Fenetre.j1.vitesse=Creature.DEFAULT_SPEED;
		
		
		for(int i =0;i<keys.length;i++){
			if(up ||down || right || left)
			compteur++;
		}
		if(compteur>0)
			Fenetre.j1.mouvement=true;
		else
			Fenetre.j1.mouvement=false;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()]=false; 
		
	}
	
	public boolean keyToutJusteAppuie(int keyCode){
		return toutJusteAppuie[keyCode];
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
