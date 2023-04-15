package com.aor.brickbreaker.viewer;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.aor.brickbreaker.Constants.*;
import static com.googlecode.lanterna.Symbols.*;
import static com.googlecode.lanterna.Symbols.HEART;

public class InstructionsViewerTest {

    private InstructionsViewer instructionsViewer;
    private GUI gui;
    private Menu menu;

    @BeforeEach
    void helper() {
        menu = Mockito.mock(Menu.class);
        instructionsViewer = new InstructionsViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElements() {
        instructionsViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position((WIDTH / 2) - 6, 2), "BRICK BREAKER", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 5), "HOW TO PLAY:", RED);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 9), "Press " + ARROW_LEFT + " to move platform left", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 10), "Press " + ARROW_RIGHT + " to move platform right", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 11), "You have " + MAX_LIVES + " " + HEART + " (lives until you lose)", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 15), "You have TWO goals:", RED);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 17), "- Do not let the ball fall (you lose " + HEART + ")", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 18), "- Aim for the bricks (you gain points)", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 22), "These are the bricks! You must hit them:", RED);
        Mockito.verify(gui, Mockito.times(1)).drawBrick(0, new Position(5, 25));
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 26), "3 TIMES", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawBrick(1, new Position(25, 25));
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(26, 26), "2 TIMES", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawBrick(2, new Position(45, 25));
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(46, 26), "1 TIME", WHITE);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, 30), "Each time you gain 5 points, you receive a booster \n(the platform increases)!", GREEN);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(4, HEIGHT - 3), "Press q to go back to the menu", RED);
    }
}