package com.aor.brickbreaker.model.game.elements;

import static com.aor.brickbreaker.Constants.*;

public class Platform extends Element {

    private double score;
    private int lives, size;

    public Platform() {
        super(PLATFORM_X, PLATFORM_Y);
        score = 0.0;
        lives = MAX_LIVES;
        size = PLATFORM_WIDTH;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size<=MAX_PLATFORM_SIZE && size>=PLATFORM_WIDTH) {
            this.size = size;
        }
    }

    public void updateScore(double points) {
        this.score += points;
    }

    public void updateLives() {
        this.lives -= 1;
    }

    public void updateSize() {
        this.size += PLATFORM_SIZE_BOOSTER;
    }
}