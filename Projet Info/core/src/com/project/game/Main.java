package com.project.game;

import com.badlogic.gdx.Game;
import com.project.game.screens.Splash;

public class Main extends Game {
	
	
	public void create () {
		setScreen(new Splash());
	}

	public void render () {
		super.render();
	}
	
	public void resize(int width,int height){
		super.resize(width, height);
	}
	
	public void pause(){
		super.pause();
	}
	
	public void resume(){
		super.resume();
	}
	
	public void dispose () {
		super.dispose();
	}
}
