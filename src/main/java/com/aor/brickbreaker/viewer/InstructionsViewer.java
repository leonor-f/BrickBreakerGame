package com.aor.brickbreaker.viewer;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.model.menu.Menu;

import static com.aor.brickbreaker.Constants.*;
import static com.googlecode.lanterna.Symbols.*;

public class InstructionsViewer extends Viewer<Menu> {
    public InstructionsViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {

        gui.drawText(new Position((WIDTH / 2) - 6, 2), "BRICK BREAKER", WHITE);

        gui.drawText(new Position(4, 5), "HOW TO PLAY:", RED);

        gui.drawText(new Position(4, 9), "Press " + ARROW_LEFT + " to move platform left", WHITE);
        gui.drawText(new Position(4, 10), "Press " + ARROW_RIGHT + " to move platform right", WHITE);
        gui.drawText(new Position(4, 11), "You have " + MAX_LIVES + " " + HEART + " (lives until you lose)", WHITE);

        gui.drawText(new Position(4, 15), "You have TWO goals:", RED);
        gui.drawText(new Position(4, 17), "- Do not let the ball fall (you lose " + HEART + ")", WHITE);
        gui.drawText(new Position(4, 18), "- Aim for the bricks (you gain points)", WHITE);

        gui.drawText(new Position(4, 22), "These are the bricks! You must hit them:", RED);

        gui.drawBrick(0, new Position(5, 25));
        gui.drawText(new Position(6, 26), "3 TIMES", WHITE);

        gui.drawBrick(1, new Position(25, 25));
        gui.drawText(new Position(26, 26), "2 TIMES", WHITE);

        gui.drawBrick(2, new Position(45, 25));
        gui.drawText(new Position(46, 26), "1 TIME", WHITE);

        gui.drawText(new Position(4, 30), "Each time you gain 5 points, you receive a booster \n(the platform increases)!", GREEN);

        gui.drawText(new Position(4, HEIGHT - 3), "Press q to go back to the menu", RED);
    }
}