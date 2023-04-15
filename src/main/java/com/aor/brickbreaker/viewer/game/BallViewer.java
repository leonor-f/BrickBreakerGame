package com.aor.brickbreaker.viewer.game;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Ball;

public class BallViewer implements ElementViewer<Ball>{

    @Override
    public void drawElement(Ball element, GUI gui) {
        gui.drawBall(element.getPosition());
    }
}
