package com.isenflow.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame extends ApplicationAdapter {
  // Objects used
  Player player;
  PlayerInputProcessor inputProcessor;

  SpriteBatch spriteBatch;

  // A variable for tracking elapsed time for the animation
  float stateTime;

  @Override
  public void create() {
    player = new Player(200,200);
    inputProcessor = new PlayerInputProcessor(player);
    Gdx.input.setInputProcessor(inputProcessor);
    spriteBatch = new SpriteBatch();
    stateTime = 0f;
  }

  @Override
  public void render() {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
    stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

    // Get current frame of animation for the current stateTime
//    TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
    TextureRegion keyFrame = player.getAnimation().getKeyFrame(stateTime, true);

    spriteBatch.begin();
    spriteBatch.draw(keyFrame, player.getX(), player.getY()); // Draw current frame at (50, 50)
    spriteBatch.end();
  }

  @Override
  public void dispose() { // SpriteBatches and Textures must always be disposed
    spriteBatch.dispose();
  }
}