package com.project.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import tween.SpriteAccessor;

public class Splash implements Screen {

	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager tweenManager;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		batch.begin();
		splash.draw(batch);
		batch.end();

		tweenManager.update(delta);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	
		
		batch = new SpriteBatch();

		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());

		splash = new Sprite(new Texture("wallpaper.png"));

		Tween.set(splash, SpriteAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(splash, SpriteAccessor.ALPHA, 3f).target(1).repeatYoyo(1, 2f).setCallback(new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Play());
			}
		}).start(tweenManager);
		
		Gdx.input.setInputProcessor(new InputMultiplexer(new InputAdapter() {

			@Override
			public boolean keyDown(int keycode) {
				switch(keycode) {
				case Keys.SPACE:
					((Game) Gdx.app.getApplicationListener()).setScreen(new Play());
					break;
				}
				return false;
			}


		}));

		tweenManager.update(Float.MIN_VALUE); // update once avoid short flash of splash before animation
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
		splash.getTexture().dispose();
	}

}
