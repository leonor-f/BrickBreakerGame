package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.model.game.elements.Brick;

import java.util.List;

import static com.aor.brickbreaker.Constants.RED;
import static com.aor.brickbreaker.Constants.YELLOW;

public class BrickController {

    private List<Brick> bricks;

    public BrickController(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public void getsHit(Brick brick) {
        brick.updateHits();
        switch (brick.getHits()) {
            case 1 -> brick.setColor(YELLOW);
            case 2 -> brick.setColor(RED);
            case 3 -> {
                brick.setDestroyed();
                bricks.remove(brick);
            }
        }
    }
}