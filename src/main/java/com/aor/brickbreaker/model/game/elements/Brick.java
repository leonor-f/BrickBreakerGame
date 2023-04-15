package com.aor.brickbreaker.model.game.elements;

import com.aor.brickbreaker.model.Position;

import static com.aor.brickbreaker.Constants.*;

public class Brick extends Element {

    private boolean destroyed;
    private int points;
    private int hits;
    private String color;

    public Brick(int x, int y) {
        super(x, y);
        destroyed = false;
        points = getRandomPoints();
        hits = 0;
        color = GREEN;
    }

    public Brick(Position position) {
        super(position);
        destroyed = false;
        points = getRandomPoints();
        hits = 0;
        color = GREEN;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        this.destroyed = true;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void updateHits() {
        this.hits += 1;
    }

    public int getRandomPoints() {
        return (int) Math.floor(Math.random() * (MAX_POINTS - MIN_POINTS) + MIN_POINTS);
    }
}