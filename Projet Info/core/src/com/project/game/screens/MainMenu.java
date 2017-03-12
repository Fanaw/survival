package com.project.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;


public class MainMenu implements Screen {
 
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonPlay, buttonExit;
	private BitmapFont white;
	private Label heading;
	
	@Override
	public void show() {
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
	
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up= skin.getDrawable("button.up");
		textButtonStyle.down= skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX =1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font=white;
		textButtonStyle.fontColor=Color.BLACK;
		
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.background=skin.getDrawable("button.up");
		labelStyle.font=white;
		labelStyle.fontColor=Color.BLACK;
		
		heading = new Label("Menu", labelStyle);
		heading.setFontScale(2);
		
		buttonExit = new TextButton("EXIT", textButtonStyle);
		buttonExit.pad(20);
		
		buttonPlay = new TextButton("PLAY" , textButtonStyle);
		buttonPlay.pad(20);

		table.add(heading);
		table.add(buttonPlay);
		table.add(buttonExit);
		
		table.add(heading).spaceBottom(100).row();
		table.add(buttonPlay).spaceBottom(15).row();
		table.add(buttonExit);
		
		stage.addActor(table);
		
		Gdx.input.setInputProcessor(new InputMultiplexer(new InputAdapter() {

			@Override
			public boolean keyDown(int keycode) {
				switch(keycode) {
				case Keys.ESCAPE:
					((Game) Gdx.app.getApplicationListener()).setScreen(new Play());
					break;
				}
				return false;
			}


		}));

		
		
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	
		
		stage.act(delta);
		
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
