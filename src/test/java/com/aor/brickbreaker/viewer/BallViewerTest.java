package com.aor.brickbreaker.viewer;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Ball;
import com.aor.brickbreaker.viewer.game.BallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BallViewerTest {
    private Ball ball;
    private BallViewer ballViewer;
    private GUI gui;

    @BeforeEach
    void helper() {
        ball = new Ball();
        ballViewer = new BallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        ballViewer.drawElement(ball, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBall(ball.getPosition());
    }
}