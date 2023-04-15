package com.aor.brickbreaker.model.arena;

import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.model.game.elements.Ball;
import com.aor.brickbreaker.model.game.elements.Brick;
import com.aor.brickbreaker.model.game.elements.Platform;
import com.aor.brickbreaker.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.aor.brickbreaker.Constants.HEIGHT;
import static com.aor.brickbreaker.Constants.WIDTH;
import static groovy.test.GroovyTestCase.assertEquals;

public class ArenaTest {

    private Ball ball = new Ball();

    private List<Wall> wall = new ArrayList<>();

    private Platform platform = new Platform();

    private List<Brick> brick = new ArrayList<>();

    private Arena helper;

    @BeforeEach
    public void helper(){
        helper = new Arena();
    }

    @Test
    public void TestConstructor(){
        assertEquals(WIDTH, helper.getWidth());
        assertEquals(HEIGHT, helper.getHeight());
    }

    @Test
    public void TestSetBall(){
        helper.setBall(ball);
        assertEquals(ball, helper.getBall());
    }

    @Test
    public void TestSetWall(){
        helper.setWalls(wall);
        assertEquals(wall, helper.getWalls());
    }

    @Test
    public void TestSetPlatform(){
        helper.setPlatform(platform);
        assertEquals(platform, helper.getPlatform());
    }

    @Test
    public void TestSetBricks(){
        helper.setBricks(brick);
        assertEquals(brick, helper.getBricks());
    }
}
