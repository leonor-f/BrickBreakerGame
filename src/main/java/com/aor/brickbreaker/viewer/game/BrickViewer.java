package com.aor.brickbreaker.viewer.game;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Brick;

public class BrickViewer implements ElementViewer<Brick> {

    @Override
    public void drawElement(Brick brick, GUI gui) {
        gui.drawBrick(brick.getHits(), brick.getPosition());
    }
}