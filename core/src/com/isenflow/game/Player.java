package com.isenflow.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;

public class Player  {

  // Constant rows and columns of the sprite sheet
  private static final int FRAME_COLS = 9, FRAME_ROWS = 4;

  private Animation<TextureRegion> standingAnimation;
  private Animation<TextureRegion> movingLeftAnimation;
  private Animation<TextureRegion> movingRightAnimation;
  private Animation<TextureRegion> movingForwardAnimation;
  private Animation<TextureRegion> movingBackwardAnimation;
  private Animation<TextureRegion> currentAnimation;
  private Texture sprites;

  private int x, y;
  private int state;

  public Player(int x, int y) {
    this.x = x;
    this.y = y;

    // Load the sprite sheet as a Texture
    sprites = new Texture(Gdx.files.internal("core/assets/player.png"));


    // Use the split utility method to create a 2D array of TextureRegions. This is
    // possible because this sprite sheet contains frames of equal size and they are
    // all aligned.
    TextureRegion[][] tmp = TextureRegion.split(sprites,
            sprites.getWidth() / FRAME_COLS,
            sprites.getHeight() / FRAME_ROWS);

    // Place the regions into a 1D array in the correct order, starting from the top
    // left, going across first. The Animation constructor requires a 1D array.
    TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
    int index = 0;
    for (int i = 0; i < FRAME_ROWS; i++) {
      for (int j = 0; j < FRAME_COLS; j++) {
        walkFrames[index++] = tmp[i][j];
      }
    }

    // Initialize the Animation with the frame interval and array of frames
    currentAnimation = standingAnimation = new Animation<TextureRegion>(0.1f, walkFrames[18]);
    movingForwardAnimation = new Animation<TextureRegion>(0.1f, Arrays.copyOfRange(walkFrames, 0, 8));
    movingLeftAnimation = new Animation<TextureRegion>(0.1f, Arrays.copyOfRange(walkFrames, 9, 17));
    movingBackwardAnimation = new Animation<TextureRegion>(0.1f, Arrays.copyOfRange(walkFrames, 18, 26));
    movingRightAnimation = new Animation<TextureRegion>(0.1f, Arrays.copyOfRange(walkFrames, 27, 35));

    // Instantiate a SpriteBatch for drawing and reset the elapsed animation
    // time to 0
  }

  public void standStill() {
    currentAnimation = standingAnimation;
  }

  public void moveRight() {
    //currentAnimation = movingRightAnimation;
    x += 200 * Gdx.graphics.getDeltaTime();
  }

  public void moveLeft() {
    //currentAnimation = movingLeftAnimation;
    x -= 200 * Gdx.graphics.getDeltaTime();
    System.out.println("moving left");
  }

  public void moveBackward() {
    currentAnimation = movingBackwardAnimation;
    y += 200 * Gdx.graphics.getDeltaTime();
  }

  public void moveForward(){
    currentAnimation = movingForwardAnimation;
    y -= 200 * Gdx.graphics.getDeltaTime();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getState(){
    return state;
  }

  public Animation<TextureRegion> getAnimation(){
    return currentAnimation;
  }

}
