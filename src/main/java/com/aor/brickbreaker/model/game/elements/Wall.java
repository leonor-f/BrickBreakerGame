package com.aor.brickbreaker.model.game.elements;

import com.aor.brickbreaker.model.Position;

public class Wall extends Element {

    public Wall(int x, int y) {
        super(x, y);
    }

    public Wall(Position position) {
        super(position);
    }
}