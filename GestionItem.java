import java.awt.Graphics;
import java.util.ArrayList;

public class GestionItem {
	
	private ArrayList<Item> items;
	
	public GestionItem(){
		
		items =new ArrayList<Item>();
		
		
	}
	
	public void tick(){ // ON TICK TOUS LES ITEMS DE LA LISTE. SI IL A ETE RAMASSE ON LE SUPPRIME
				
		for(int i =0;i<getItems().size();i++){
			items.get(i).tick();
			if(items.get(i).prendre){
				
				items.remove(i);
					
			}
		}
	}
	
	
	public void dessine(Graphics g){ // ON DESSINE TOUS LES ITEMS
		for(int i =0;i<getItems().size();i++){
			items.get(i).dessine(g);
			
		}
		
	}
	
	public void addItem(Item i){ // AJOUT D'UN ITEM A LA LISTE
		items.add(i);
		
		
		
	}
	public void removeItem(Item i){ // AJOUT D'UN ITEM A LA LISTE
		items.remove(i);
		
		
		
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
