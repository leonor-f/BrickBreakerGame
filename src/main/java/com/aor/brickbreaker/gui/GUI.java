package com.aor.brickbreaker.gui;

import com.aor.brickbreaker.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    enum ACTION {
        LEFT, RIGHT, QUIT, UP, DOWN, CHOOSE, NONE, SELECT
    }

    TextGraphics createTextGraphics();

    int getWidth();

    void clear() throws IOException;

    void refresh() throws IOException;

    void close() throws IOException;

    void drawBall(Position position);

    void drawPlatform(Position position, int size);

    void drawInfo(int points, int lives);

    void drawWall(Position position);

    void drawBrick(int points, Position position);

    void drawTitle(Position position, String text, String color);

    void drawText(Position position, String text, String color);
}