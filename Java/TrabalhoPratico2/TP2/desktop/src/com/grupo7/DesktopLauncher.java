package com.grupo7;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
// import com.grupo7.FishingDerbyClone;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("FishingDerbyClone");
		config.setWindowedMode(800, 600);
		config.setResizable(false);
		config.setWindowIcon("assets/gameIcon.png");
		config.useVsync(true);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new FishingDerbyClone(), config);
	}
}
