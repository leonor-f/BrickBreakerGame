package com.aor.brickbreaker.model.game.arena;

import com.aor.brickbreaker.model.game.elements.Ball;
import com.aor.brickbreaker.model.game.elements.Brick;
import com.aor.brickbreaker.model.game.elements.Platform;
import com.aor.brickbreaker.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {

    public Arena createArena() {
        Arena arena = new Arena();
        arena.setPlatform(createPlatform());
        arena.setBall(createBall());
        arena.setWalls(createWalls());
        arena.setBricks(createBricks());
        return arena;
    }

    protected abstract List<Brick> createBricks();

    protected abstract Platform createPlatform();

    protected abstract List<Wall> createWalls();

    protected abstract Ball createBall();
}