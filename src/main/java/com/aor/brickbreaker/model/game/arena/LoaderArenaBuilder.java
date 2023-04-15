package com.aor.brickbreaker.model.game.arena;

import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.model.game.elements.Ball;
import com.aor.brickbreaker.model.game.elements.Brick;
import com.aor.brickbreaker.model.game.elements.Platform;
import com.aor.brickbreaker.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

import static com.aor.brickbreaker.Constants.*;

public class LoaderArenaBuilder extends ArenaBuilder {

    public LoaderArenaBuilder() {}

    @Override
    protected List<Wall> createWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        for (int c = 0; c < WIDTH - 1; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, HEIGHT - 1)));
        }
        for (int r = 1; r < HEIGHT - 2; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall(new Position(WIDTH - 1, r)));
        }
        return walls;
    }

    @Override
    protected Ball createBall() {
        return new Ball();
    }

    @Override
    protected List<Brick> createBricks() {
        ArrayList<Brick> bricks = new ArrayList<>();
        int position;

        for (int i = 0; i < 5; i++) {
            position = 0;
            for (int j = 0; j < WIDTH / BRICK_WIDTH; j++) {
                bricks.add(new Brick(new Position(j + 1 + position, i + BRICK_HEIGHT + 4)));
                position += BRICK_WIDTH;
            }
        }
        return bricks;
    }

    @Override
    protected Platform createPlatform() {
        return new Platform();
    }
}
