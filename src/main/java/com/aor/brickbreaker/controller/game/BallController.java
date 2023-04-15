package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.Game;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.model.game.elements.Ball;

import javax.imageio.IIOException;

import static com.aor.brickbreaker.Constants.*;

public class BallController extends GameController {

    private Ball ball = getModel().getBall();
    private long start;
    private ArenaController arenaController;

    public BallController(Arena arena) {
        super(arena);
    }

    public void move() {
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;

        if (elapsedTime > 1000) {
            if (didHitLeft() || didHitRight())
                hitWall();
            if (didHitUp())
                hitUp();

            ball.setPosition(ball.getPosition().getX() + ball.getDirectionX(),
                    ball.getPosition().getY() + ball.getDirectionY());
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IIOException {
        if (arenaController.didHitPlatform())
            arenaController.hitPlatform();
        if (!ball.isDestroyedBrick())
            arenaController.didHitBrick();
        move();
    }

    public void setArenaController(ArenaController arenaController) {
        this.arenaController = arenaController;
    }

    public ArenaController getArenaController() {
        return arenaController;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void hitWall() {
        ball.setDirectionX(-ball.getDirectionX());
    }

    public void hitUp() {
        ball.setDirectionY(1);
    }

    private boolean didHitRight() {
        return ball.getPosition().getX() >= WIDTH - 2;
    }

    private boolean didHitLeft() {
        return ball.getPosition().getX() <= 1;
    }

    private boolean didHitUp() {
        return ball.getPosition().getY() <= 2;
    }

    public void hitPlatform(int xDir) {
        ball.setDirectionY(-ball.getDirectionY());
        ball.setDirectionX(xDir);
    }

    public void hitBrick() {
        ball.setDirectionY(-ball.getDirectionY());
    }

    public void resetBall() {
        ball.setPosition(new Position(getModel().getPlatform().getPosition().getX() + (getModel().getPlatform().getSize()) / 2, BALL_Y));
        ball.setDirectionX(1);
        ball.setDirectionY(-1);
        start = System.currentTimeMillis();
    }
}