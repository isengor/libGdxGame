package com.isenflow.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PlayerInputProcessor implements InputProcessor{

  private Player player;


  public PlayerInputProcessor(Player player){
    this.player = player;
  }

  @Override
  public boolean keyDown(int i) {
    switch (i){
      case Input.Keys.LEFT:{
        player.moveLeft();
        break;
      }
      case Input.Keys.RIGHT: {
        player.moveRight();
        break;
      }
    }
    return false;
  }

  @Override
  public boolean keyUp(int i) {
    player.standStill();
    return false;
  }

  @Override
  public boolean keyTyped(char c) {
    return false;
  }

  @Override
  public boolean touchDown(int i, int i1, int i2, int i3) {
    return false;
  }

  @Override
  public boolean touchUp(int i, int i1, int i2, int i3) {
    return false;
  }

  @Override
  public boolean touchDragged(int i, int i1, int i2) {
    return false;
  }

  @Override
  public boolean mouseMoved(int i, int i1) {
    return false;
  }

  @Override
  public boolean scrolled(int i) {
    return false;
  }

}
