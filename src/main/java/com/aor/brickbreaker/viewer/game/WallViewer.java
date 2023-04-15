package com.aor.brickbreaker.viewer.game;

import com.aor.brickbreaker.model.game.elements.Wall;
import com.aor.brickbreaker.gui.GUI;

public class WallViewer implements ElementViewer<Wall>{

    @Override
    public void drawElement(Wall element, GUI gui) {
        gui.drawWall(element.getPosition());
    }
}
