package com.aor.brickbreaker.model.game.arena;

import com.aor.brickbreaker.model.game.elements.Ball;
import com.aor.brickbreaker.model.game.elements.Brick;
import com.aor.brickbreaker.model.game.elements.Platform;
import com.aor.brickbreaker.model.game.elements.Wall;

import java.util.List;

import static com.aor.brickbreaker.Constants.*;

public class Arena {
    private final int width;
    private final int height;

    private Platform platform;
    private List<Wall> walls;
    private List<Brick> bricks;
    private Ball ball;

    public Arena() {
        this.width = WIDTH;
        this.height = HEIGHT;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}