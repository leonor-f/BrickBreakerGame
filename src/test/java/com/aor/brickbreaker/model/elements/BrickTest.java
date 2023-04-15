package com.aor.brickbreaker.model.elements;

import com.aor.brickbreaker.model.game.elements.Brick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.aor.brickbreaker.Constants.*;
import static groovy.test.GroovyTestCase.assertEquals;

public class BrickTest {

    private Brick brick;

    @BeforeEach
    public void helper(){
        brick = new Brick(1, 1);
    }

    @Test
    public void Constructor(){
        assertEquals(1, brick.getPosition().getX());
        assertEquals(1, brick.getPosition().getY());
        assertEquals(0, brick.getHits());
        assertEquals(GREEN, brick.getColor());

        boolean test = true;

        if (brick.getPoints()>MAX_POINTS) {
            test = false;
        }

        if (brick.getPoints()<MIN_POINTS) {
            test = false;
        }

        assertEquals(true, test);
    }

    @Test
    public void setHits(){
        brick.setHits(2);
        assertEquals(2, brick.getHits());
    }

    @Test
    public void updateHits(){
        brick.updateHits();
        assertEquals(1, brick.getHits());
    }

    @Test
    public void setDestroyed(){
        brick.setDestroyed();
        assertEquals(true, brick.isDestroyed());
    }

    @Test
    public void setColor(){
        brick.setColor(RED);
        assertEquals(RED, brick.getColor());
    }
}