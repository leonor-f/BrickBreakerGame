package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.model.game.elements.Brick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.aor.brickbreaker.Constants.*;
import static groovy.test.GroovyTestCase.assertEquals;

public class BrickControllerTest {
    
    private List<Brick> bricks = new ArrayList<>();
    private BrickController brickController = new BrickController(new ArrayList<>());

    @BeforeEach
    public void helper(){
        Brick helper = new Brick(1, 1);
        Brick helper1 = new Brick(2, 2);
        bricks.add(helper);
        bricks.add(helper1);
        brickController.setBricks(bricks);
    }

    @Test
    public void getsHit(){
        assertEquals (GREEN, brickController.getBricks().get(0).getColor());
        assertEquals(GREEN, brickController.getBricks().get(1).getColor());

        brickController.getsHit(brickController.getBricks().get(0));
        assertEquals(YELLOW, brickController.getBricks().get(0).getColor());
        assertEquals(GREEN, brickController.getBricks().get(1).getColor());

        brickController.getsHit(brickController.getBricks().get(0));
        assertEquals(RED, brickController.getBricks().get(0).getColor());
        assertEquals(GREEN, brickController.getBricks().get(1).getColor());

        brickController.getsHit(brickController.getBricks().get(0));
        assertEquals(1, brickController.getBricks().size());
        assertEquals(GREEN, brickController.getBricks().get(0).getColor());
    }
}