package com.aor.brickbreaker.viewer;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Brick;
import com.aor.brickbreaker.viewer.game.BrickViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BrickViewerTest {
    private Brick brick;
    private BrickViewer brickViewer;
    private GUI gui;

    @BeforeEach
    void helper() {
        brick = new Brick(1, 1);
        brickViewer = new BrickViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        brickViewer.drawElement(brick, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBrick(brick.getHits(), brick.getPosition());
    }
}