package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.Game;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.model.game.elements.Ball;
import com.aor.brickbreaker.model.game.elements.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.imageio.IIOException;

import static com.aor.brickbreaker.Constants.*;
import static groovy.test.GroovyTestCase.assertEquals;

public class BallControllerTest {

    private BallController ballController;
    private Ball ball;
    private Arena arena;

    @BeforeEach
    public void helper() {
        arena = new Arena();
        ballController = new BallController(arena);
        ball = new Ball();
    }

    @Test
    public void hitWall() {
        ball.setDirectionX(1);
        ballController.setBall(ball);
        ballController.hitWall();

        assertEquals(-1, ballController.getBall().getDirectionX());

        ballController.hitWall();
        assertEquals(1, ballController.getBall().getDirectionX());
    }

    @Test
    public void hitUp() {
        ball.setDirectionY(1);
        ballController.setBall(ball);
        ballController.hitUp();
        assertEquals(1, ballController.getBall().getDirectionY());

        ball.setDirectionY(-1);
        ballController.hitUp();
        assertEquals(1, ballController.getBall().getDirectionY());
    }

    @Test
    public void hitPlatform() {
        ball.setDirectionY(1);
        ball.setDirectionX(1);
        ballController.setBall(ball);
        ballController.hitPlatform(ball.getDirectionX());

        assertEquals(1, ballController.getBall().getDirectionX()); // x should not change direction
        assertEquals(-1, ballController.getBall().getDirectionY()); // Y should invert its direction
    }

    @Test
    public void hitBrick() {
        ball.setDirectionY(1);
        ball.setDirectionX(1);
        ballController.setBall(ball);
        ballController.hitBrick();

        assertEquals(-1, ballController.getBall().getDirectionY()); // Y should invert its direction
        assertEquals(1, ballController.getBall().getDirectionX()); // X direction should keep the same
    }

    @Test
    public void didHitRightTrue() {
        ball.setPosition(WIDTH - 2, 0);
        ballController.setBall(ball);

        assertEquals(true, ballController.getBall().getPosition().getX() >= WIDTH - 2);
    }

    @Test
    public void didHitRightFalse() {
        ball.setPosition(0, 0);
        ballController.setBall(ball);

        assertEquals(false, ballController.getBall().getPosition().getX() >= WIDTH - 2);
    }

    @Test
    public void didHitLeftTrue() {
        ball.setPosition(1, 0);
        ballController.setBall(ball);

        assertEquals(true, ballController.getBall().getPosition().getX() <= 1);
    }

    @Test
    public void didHitLeftFalse() {
        ball.setPosition(2, 0);
        ballController.setBall(ball);

        assertEquals(false, ballController.getBall().getPosition().getX() <= 1);
    }

    @Test
    public void didHitUpTrue() {
        ball.setPosition(0, 2);
        ballController.setBall(ball);

        assertEquals(true, ballController.getBall().getPosition().getY() <= 2);
    }

    @Test
    public void didHitUpFalse() {
        ball.setPosition(0, 3);
        ballController.setBall(ball);

        assertEquals(false, ballController.getBall().getPosition().getY() <= 2);
    }

    @Test
    public void resetBall() {
        ball.setPosition(new Position(0, 0));
        ball.setDirectionX(0);
        ball.setDirectionY(0);
        ballController.setBall(ball);

        arena.setPlatform(new Platform());
        arena.setBall(ball);
        ballController.setArenaController(new ArenaController(arena));
        ArenaController arenaController = ballController.getArenaController();

        ballController.resetBall();

        assertEquals(new Position(arenaController.getModel().getPlatform().getPosition().getX() + (arenaController.getModel().getPlatform().getSize()) / 2, BALL_Y), ball.getPosition());
        assertEquals(1, ball.getDirectionX());
        assertEquals(-1, ball.getDirectionY());
    }

    @Test
    public void step() throws IIOException {
        ball.setPosition(new Position(0, 0));
        ball.setDirectionX(0);
        ball.setDirectionY(0);
        ball.setDestroyedBrick();
        ballController.setBall(ball);
        arena.setBall(ball);
        arena.setPlatform(new Platform());

        Game game = Mockito.mock(Game.class);

        ArenaController arenaController = new ArenaController(arena);
        ballController.setArenaController(arenaController);

        ballController.step(game, GUI.ACTION.RIGHT, 1);
        assertEquals(new Position(0, 1), ball.getPosition());

        ballController.step(game, GUI.ACTION.LEFT, 1);
        assertEquals(new Position(0, 2), ball.getPosition());

        ball.setPosition(new Position(0, 0));

        ballController.step(game, GUI.ACTION.UP, 1);
        assertEquals(new Position(0, 1), ball.getPosition());

        ballController.step(game, GUI.ACTION.DOWN, 1);
        assertEquals(new Position(0, 2), ball.getPosition());
    }
}