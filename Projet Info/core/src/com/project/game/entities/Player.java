package com.project.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {

	private Vector2 velocity = new Vector2();;
	
	private float speed = 60 * 2;

	private TiledMapTileLayer collisionLayer;
	
	private int vie;
	
	
	public Player(Sprite sprite, TiledMapTileLayer collisionLayer ){
		super(sprite);
		vie =100; 
		this.collisionLayer = collisionLayer;
	}


	@Override
	public void draw(Batch batch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}
	
	public void update(float delta){
		//save old position
		float oldX = getX(), oldY = getY(), tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
		boolean collisionX = false, collisionY = false;
		
		//move on x
		setX(getX()+velocity.x*delta);
		
		if(velocity.x<0){ // go left
			//top left
			collisionX = collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			//middle left
			if(!collisionX)
			collisionX = collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + (getHeight())/2) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			//bottom left
			if(!collisionX)
			collisionX = collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
		}else if (velocity.x >0){ // go right
			//top right
			collisionX = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			//middle right
			if(!collisionX)
			collisionX = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth), (int)((getY() + (getHeight())/2) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			//bottom right
			if(!collisionX)
			collisionX = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
		}
		
		//react to X collision
		if(collisionX){
			setX(oldX);
			velocity.x=0;
		}
		
		// move on y
		setY(getY()+velocity.y*delta);
		
		if(velocity.y<0){
			//bottom left
			collisionY = collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() ) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			//bottom middle
			if(!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+(getWidth()/2)) / tileWidth), (int)((getY() / tileHeight))).getTile().getProperties().containsKey("blocked");
			
			//bottom right
			if(!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			
		}else if (velocity.y >0){
			//top left
			collisionY = collisionLayer.getCell((int)(getX() / tileWidth), (int)(((getY()+getHeight()) ) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			//top middle
			if(!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+(getWidth()/2)) / tileWidth), (int)(((getY()+getHeight()) / tileHeight))).getTile().getProperties().containsKey("blocked");
			
			//top right
			if(!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+getWidth()) / tileWidth), (int)((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
		}
		//react to y collision
				if(collisionY){
					setY(oldY);
					velocity.y=0;
				}
		
	}


	public Vector2 getVelocity() {
		return velocity;
	}


	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}


	public TiledMapTileLayer getCollisionLayer() {
		return collisionLayer;
	}


	public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
		this.collisionLayer = collisionLayer;
	}


	@Override
	public boolean keyDown(int keycode) {

		switch(keycode){
		case Keys.UP:
			velocity.y= speed;
			break;
		case Keys.DOWN:
			velocity.y= -speed;
			break;
		case Keys.LEFT:
			velocity.x= -speed;
			break;
		case Keys.RIGHT:
			velocity.x= speed;
			break;
		}
		return true;
	}


	@Override
	public boolean keyUp(int keycode) {
		switch(keycode){
		case Keys.UP:
			velocity.y= 0;
			break;
		case Keys.DOWN:
			velocity.y= 0;
			break;
		case Keys.LEFT:
			velocity.x= 0;
			break;
		case Keys.RIGHT:
			velocity.x= 0;
			break;
		}
		return true;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
}
