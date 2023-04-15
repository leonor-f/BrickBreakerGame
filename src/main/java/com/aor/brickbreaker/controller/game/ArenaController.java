package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.model.game.elements.Brick;
import com.aor.brickbreaker.states.MenuState;
import com.aor.brickbreaker.Game;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.model.menu.Menu;

import java.io.IOException;
import java.util.List;

import static com.aor.brickbreaker.Constants.*;

public class ArenaController extends GameController {

    private final BallController ballController;
    private final PlatformController platformController;
    private BrickController brickController;
    private List<Brick> bricks = getModel().getBricks();
    private double auxScore = 0;

    public ArenaController(Arena arena) {
        super(arena);
        this.ballController = new BallController(arena);
        this.platformController = new PlatformController(arena);
        ballController.setArenaController(this);
        brickController = new BrickController(bricks);
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public double getAuxScore() {
        return auxScore;
    }

    public void setAuxScore(double auxScore) {
        this.auxScore = auxScore;
    }

    public boolean didHitPlatform() {
        int ballY = ballController.getBall().getPosition().getY();
        int ballX = ballController.getBall().getPosition().getX();
        int platformX = platformController.getPlatform().getPosition().getX();
        int platformSize = platformController.getPlatform().getSize();

        return ballY == PLATFORM_Y - PLATFORM_HEIGHT && ballX >= platformX && ballX <= platformX + platformSize;
    }

    public void hitPlatform() {
        int ballX = ballController.getBall().getPosition().getX();
        int platformX = platformController.getPlatform().getPosition().getX();
        int platformSize = platformController.getPlatform().getSize();

        int ballXDir = ballController.getBall().getDirectionX();
        double distFromCenter;
        int nextDirX;
        distFromCenter = (double) (ballX - platformX) / platformSize;

        if (distFromCenter > 0.5 && ballXDir < 0)
            nextDirX = 1;
        else if (distFromCenter < 0.5 && ballXDir > 0)
            nextDirX = -1;
        else
            nextDirX = ballXDir;

        ballController.hitPlatform(nextDirX);
    }

    public boolean didHitBrick() {
        int ballY = ballController.getBall().getPosition().getY();
        int ballX = ballController.getBall().getPosition().getX();

        for (Brick brick : bricks) {
            int brickX = brick.getPosition().getX();
            int brickY = brick.getPosition().getY();

            if (ballY == brickY + BRICK_HEIGHT && ballX >= brickX && ballX <= brickX + BRICK_WIDTH && !brick.isDestroyed()) {
                ballController.hitBrick();
                brickController.getsHit(brick);
                platformController.updateScore(brick.getPoints());
                dropBooster(platformController.getPlatform().getScore());
                bricks = brickController.getBricks();
                return true;
            }
        }
        return false;
    }

    public void lostLife() {
        if (ballController.getBall().getPosition().getY() > PLATFORM_Y) {
            platformController.lostLife();
            ballController.resetBall();
        }
    }

    public void dropBooster(double score) {
        if (score >= N_POINTS_TO_DROP_BOOSTER + getAuxScore() &&
                platformController.getPlatform().getSize() + PLATFORM_SIZE_BOOSTER <= MAX_PLATFORM_SIZE) {
            setAuxScore(getAuxScore() + N_POINTS_TO_DROP_BOOSTER);
            platformController.updateSize();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getPlatform().getLives() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            ballController.step(game, GUI.ACTION.NONE, time);
            lostLife();
            platformController.step(game, action, time);
        }
    }
}