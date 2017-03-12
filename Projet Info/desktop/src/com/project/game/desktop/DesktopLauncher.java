package com.project.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.project.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Askiri";
		config.vSyncEnabled = true;
		config.useGL30 = true;
		config.width=1280;
		config.height=720;
		new LwjglApplication(new Main(), config);
	}
}
