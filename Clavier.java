import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

	
	boolean[] keys;
	boolean up,down,left,right,shift,degatUp,degatDown,degatLeft,degatRight,enter,inventaire,exit;
	public Clavier(){
		keys = new boolean[256];
	}
	
	public void tick(){
		int compteur = 0;
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

	@Override
	public void keyTyped(KeyEvent e) {}

}
