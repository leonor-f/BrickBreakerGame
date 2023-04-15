package com.aor.brickbreaker.model.game.elements;

import com.aor.brickbreaker.model.Position;

import static com.aor.brickbreaker.Constants.*;

public class Ball extends Element {

    private int directionX, directionY, brickHits = 0;
    private boolean destroyedBrick = false;

    public Ball(Position position, int directionX, int directionY){
        super(position);
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public Ball(){
        super(BALL_X, BALL_Y);
        this.directionX = 1;
        this.directionY = 1;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public boolean isDestroyedBrick() {
        return destroyedBrick;
    }

    public void setDestroyedBrick() {
        this.destroyedBrick = true;
    }

}