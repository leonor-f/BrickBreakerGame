package com.aor.brickbreaker.model.elements;

import com.aor.brickbreaker.model.game.elements.Ball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class BallTest {

    private Ball ball;

    @BeforeEach
    public void helper(){
        this.ball=new Ball();
    }

    @Test
    public void ballDirection(){
        assertEquals (1, ball.getDirectionX());
        assertEquals(1, ball.getDirectionY());
    }

    @Test
    public void setDirection(){
        ball.setDirectionY(-1);
        assertEquals(-1, ball.getDirectionY());

        ball.setDirectionX(2);
        assertEquals(2, ball.getDirectionX());
    }

    @Test
    public void setDestroyedBrick(){
        ball.setDestroyedBrick();
        assertEquals(true, ball.isDestroyedBrick());
    }
}