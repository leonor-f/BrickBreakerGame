package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.model.game.elements.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.aor.brickbreaker.Constants.*;
import static groovy.test.GroovyTestCase.assertEquals;

public class PlatformControllerTest {

    private Platform platform;
    private Arena arena;
    private PlatformController platformController;

    @BeforeEach
    public void helper() {
        platform = new Platform();
        arena = new Arena();
        arena.setPlatform(platform);
        platformController = new PlatformController(arena);
    }

    @Test
    public void moveRight() {
        platformController.moveRight();
        assertEquals(PLATFORM_X + 1, platformController.getPlatform().getPosition().getX());
        assertEquals(PLATFORM_Y, platformController.getPlatform().getPosition().getY());

        platformController.moveRight();
        assertEquals(PLATFORM_X + 2, platformController.getPlatform().getPosition().getX());
        assertEquals(PLATFORM_Y, platformController.getPlatform().getPosition().getY());
    }

    @Test
    public void moveLeft() {
        platformController.moveLeft();
        assertEquals(PLATFORM_X - 1, platformController.getPlatform().getPosition().getX());
        assertEquals(PLATFORM_Y, platformController.getPlatform().getPosition().getY());

        platformController.moveLeft();
        assertEquals(PLATFORM_X - 2, platformController.getPlatform().getPosition().getX());
        assertEquals(PLATFORM_Y, platformController.getPlatform().getPosition().getY());
    }

    @Test
    public void lostLife() {
        assertEquals(3, platformController.getPlatform().getLives());

        platformController.lostLife();
        assertEquals(2, platformController.getPlatform().getLives());

        platformController.lostLife();
        assertEquals(1, platformController.getPlatform().getLives());
    }

    @Test
    public void updateSize() {
        assertEquals(PLATFORM_WIDTH, platformController.getPlatform().getSize());

        platformController.updateSize();
        assertEquals(PLATFORM_WIDTH + PLATFORM_SIZE_BOOSTER, platformController.getPlatform().getSize());

        platformController.updateSize();
        assertEquals(PLATFORM_WIDTH + 2 * PLATFORM_SIZE_BOOSTER, platformController.getPlatform().getSize());
    }

    @Test
    public void updateScore() {
        int points = 6;
        platformController.updateScore(points);

        assertEquals(2, platform.getScore());
    }
}