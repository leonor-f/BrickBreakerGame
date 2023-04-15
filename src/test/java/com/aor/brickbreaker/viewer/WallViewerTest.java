package com.aor.brickbreaker.viewer;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Wall;
import com.aor.brickbreaker.viewer.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallViewerTest {
    private Wall wall;
    private WallViewer wallViewer;
    private GUI gui;

    @BeforeEach
    void helper() {
        wall = new Wall(1, 1);
        wallViewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        wallViewer.drawElement(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
}