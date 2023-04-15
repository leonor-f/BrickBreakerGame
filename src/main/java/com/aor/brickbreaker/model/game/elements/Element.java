package com.aor.brickbreaker.model.game.elements;

import com.aor.brickbreaker.model.Position;

public abstract class Element {

    private Position position;

    public Element(int x, int y) {
        position = new Position(x, y);
    }

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }
}