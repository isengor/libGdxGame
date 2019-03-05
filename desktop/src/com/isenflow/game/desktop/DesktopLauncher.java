package com.isenflow.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.isenflow.game.MyGdxGame;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "Isenwalks";
    config.width = 800;
    config.height = 480;
    new LwjglApplication(new MyGdxGame(), config);
  }
}
