package com.aor.brickbreaker.viewer.game;

import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.model.game.elements.Element;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.viewer.Viewer;

import java.text.DecimalFormat;
import java.util.List;

import static com.aor.brickbreaker.Constants.*;
import static com.googlecode.lanterna.Symbols.*;

public class GameViewer extends Viewer<Arena> {

    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getBall(), new BallViewer());
        drawElement(gui, getModel().getPlatform(), new PlatformViewer());
        drawElements(gui, getModel().getBricks(), new BrickViewer());

        DecimalFormat df = new DecimalFormat("#,###.0");

        gui.drawText(new Position(1, 1), "Lives: " + getModel().getPlatform().getLives() + HEART, YELLOW);
        gui.drawText(new Position(WIDTH - 14, 1), "Score: " + df.format(getModel().getPlatform().getScore()), GREEN);
        gui.drawText(new Position(1, HEIGHT - 3), "Press q to exit", RED);
        gui.drawText(new Position(1, HEIGHT - 2), ARROW_LEFT + " Move platform left ", RED);
        gui.drawText(new Position(WIDTH - 22, HEIGHT - 2), "Move platform right " + ARROW_RIGHT, RED);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.drawElement(element, gui);
    }
}
