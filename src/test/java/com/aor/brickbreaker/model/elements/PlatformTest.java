package com.aor.brickbreaker.model.elements;

import com.aor.brickbreaker.model.game.elements.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.aor.brickbreaker.Constants.*;
import static groovy.test.GroovyTestCase.assertEquals;

public class PlatformTest {

    private Platform platform;

    @BeforeEach
    public void helper(){
        platform = new Platform();
    }

    @Test
    public void Constructor(){
        assertEquals (0.0, platform.getScore());
        assertEquals(MAX_LIVES, platform.getLives());
        assertEquals(PLATFORM_WIDTH, platform.getSize());
    }

    @Test
    public void setScore(){
        platform.setScore(2);
        assertEquals(2, platform.getScore());
    }

    @Test
    public void setLives(){
        platform.setLives(2);
        assertEquals(2, platform.getLives());
    }

    @Test
    public void setSize(){
        platform.setSize(MAX_PLATFORM_SIZE);
        assertEquals(MAX_PLATFORM_SIZE, platform.getSize());

        platform.setSize(MAX_PLATFORM_SIZE+3);
        assertEquals(MAX_PLATFORM_SIZE, platform.getSize());

        platform.setSize(PLATFORM_WIDTH-5);
        assertEquals(MAX_PLATFORM_SIZE, platform.getSize());
    }
}