package com.aor.brickbreaker.model;

import com.aor.brickbreaker.model.game.elements.Ball;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    @Test
    public void Constructor(){
        Position helper = new Position(1,1);
        int x= helper.getX();
        int y= helper.getY();

        assertEquals(1, x);
        assertEquals(1, y);
    }

    @Test
    public void setX(){
        Position helper = new Position(1, 1);
        helper.setX(3);

        assertEquals(3, helper.getX());
    }

    @Test
    public void setY(){
        Position helper = new Position(1, 1);
        helper.setY(3);

        assertEquals(3, helper.getY());
    }

    @Test
    public void equals(){
        Position helper = new Position(1, 1);
        Position random = new Position(1, 1);

        assertEquals(true, helper.equals(random));

        helper.setX(helper.getX()-2);

        assertEquals(false, helper.equals(random));

        Ball nothing = new Ball();

        assertEquals(false, nothing.equals(random));
    }
}