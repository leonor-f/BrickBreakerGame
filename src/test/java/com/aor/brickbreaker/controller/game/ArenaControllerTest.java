package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.model.game.elements.Ball;
import com.aor.brickbreaker.model.game.elements.Brick;
import com.aor.brickbreaker.model.game.elements.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.aor.brickbreaker.Constants.*;

import static groovy.test.GroovyTestCase.assertEquals;

public class ArenaControllerTest {

    private ArenaController arenaController;
    private Ball ball;
    private Platform platform;
    private BallController ballController;
    private PlatformController platformController;

    @BeforeEach
    public void helper() {
        Arena arena = new Arena();
        ball = new Ball();
        platform = new Platform();
        arena.setBall(ball);
        arena.setPlatform(platform);
        arenaController = new ArenaController(arena);
        ArrayList<Brick> bricks = new ArrayList<>();
        Brick brick1 = new Brick(0, 0);
        bricks.add(brick1);
        Brick brick2 = new Brick(brick1.getPosition().getX() + BRICK_WIDTH, 1);
        bricks.add(brick2);
        Brick brick3 = new Brick(brick2.getPosition().getX() + BRICK_WIDTH, 2);
        bricks.add(brick3);
        Brick brick4 = new Brick(brick3.getPosition().getX() + BRICK_WIDTH, 3);
        bricks.add(brick4);
        arenaController.setBricks(bricks);
        ballController = new BallController(arena);
        ballController.setArenaController(arenaController);
        platformController = new PlatformController(arena);
    }

    @Test
    public void dropBooster() {
        double a1 = platform.getScore();
        assertEquals(0.0, a1);
        assertEquals(PLATFORM_WIDTH, platform.getSize());

        arenaController.dropBooster(6);
        assertEquals(PLATFORM_WIDTH + PLATFORM_SIZE_BOOSTER, platform.getSize());

        int aux = platform.getSize();
        arenaController.dropBooster(9);
        assertEquals(aux, platform.getSize());

    }

    @Test
    public void didHitPlatformFalse() {
        ball.setPosition(platform.getPosition().getX() - 4, platform.getPosition().getY());
        platform.setPosition(platform.getPosition());

        assertEquals(false, arenaController.didHitPlatform());
    }

    @Test
    public void didHitPlatformTrue() {
        ball.setPosition(platform.getPosition().getX(), platform.getPosition().getY() - PLATFORM_HEIGHT);
        platform.setPosition(platform.getPosition());

        assertEquals(true, arenaController.didHitPlatform());
    }

    @Test
    public void didHitBrickFalse() {
        Brick brick1 = arenaController.getBricks().get(0);
        Brick brick2 = arenaController.getBricks().get(1);
        ball.setPosition(brick2.getPosition().getX(), brick1.getPosition().getY());

        assertEquals(false, arenaController.didHitBrick());
    }

    @Test
    public void didHitBrickTrue() {
        Brick brick1 = arenaController.getBricks().get(0);
        ball.setPosition(brick1.getPosition().getX(), brick1.getPosition().getY() + BRICK_HEIGHT);

        assertEquals(true, arenaController.didHitBrick());
    }

    @Test
    public void lostLife() {
        ball.setPosition(new Position(0, PLATFORM_Y + 1));
        platform.setLives(2);

        ballController.setBall(ball);
        platformController.setPlatform(platform);

        arenaController.lostLife();

        assertEquals(new Position(platform.getPosition().getX() + platform.getSize() / 2, BALL_Y), ball.getPosition());
        assertEquals(1, ball.getDirectionX());
        assertEquals(-1, ball.getDirectionY());
        assertEquals(1, platform.getLives());

        ball.setPosition(new Position(0, PLATFORM_Y));
        ball.setDirectionX(1);
        ball.setDirectionY(1);
        platform.setLives(2);

        ballController.setBall(ball);
        platformController.setPlatform(platform);

        arenaController.lostLife();

        assertEquals(new Position(0, PLATFORM_Y), ball.getPosition());
        assertEquals(1, ball.getDirectionX());
        assertEquals(1, ball.getDirectionY());
        assertEquals(2, platform.getLives());
    }
}