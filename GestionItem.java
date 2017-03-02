import java.awt.Graphics;
import java.util.ArrayList;

public class GestionItem {
	
	private ArrayList<Item> items;
	
	public GestionItem(){
		
		items =new ArrayList<Item>();
		
		
	}
	
	public void tick(){
		if(items.size()!=0){
		
			for(int i =0;i<getItems().size();i++){
				items.get(i).tick();
				if(items.get(i).prendre){
					
					items.remove(i);
					
				}
			}
		}
	}
	
	public void dessine(Graphics g){
		for(int i =0;i<getItems().size();i++){
			items.get(i).dessine(g);
			
		}
		
	}
	
	public void addItem(Item i){
		items.add(i);
		
		
		
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
