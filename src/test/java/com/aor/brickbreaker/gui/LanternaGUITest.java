package com.aor.brickbreaker.gui;

import com.aor.brickbreaker.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.aor.brickbreaker.Constants.*;
import static com.googlecode.lanterna.Symbols.HEART;

class LanternaGUITest {

    private TerminalScreen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void helper() {
        screen = Mockito.mock(TerminalScreen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawBall() {
        gui.drawBall(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(WHITE));
        Mockito.verify(tg, Mockito.times(1)).drawRectangle(new TerminalPosition(1, 1), new TerminalSize(1, 1), '@');
    }

    @Test
    void drawPlatform() {
        gui.drawPlatform(new Position(1, 1), 1);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(WHITE));
        Mockito.verify(tg, Mockito.times(1)).drawRectangle(new TerminalPosition(1, 1), new TerminalSize(1, PLATFORM_HEIGHT), '-');
    }

    @Test
    void drawBrick() {
        gui.drawBrick(1, new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(YELLOW));
        Mockito.verify(tg, Mockito.times(1)).drawRectangle(new TerminalPosition(1, 1), new TerminalSize(BRICK_WIDTH, BRICK_HEIGHT), '-');

        gui.drawBrick(2, new Position(1, 2));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(RED));
        Mockito.verify(tg, Mockito.times(1)).drawRectangle(new TerminalPosition(1, 2), new TerminalSize(BRICK_WIDTH, BRICK_HEIGHT), '-');

        gui.drawBrick(0, new Position(1, 3));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(GREEN));
        Mockito.verify(tg, Mockito.times(1)).drawRectangle(new TerminalPosition(1, 3), new TerminalSize(BRICK_WIDTH, BRICK_HEIGHT), '-');
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, " ");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", WHITE);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(WHITE));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void drawRectangle() {
        gui.drawRectangle(new Position(1, 1), 'r', GREEN, 1, 1);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(GREEN));
        Mockito.verify(tg, Mockito.times(1)).drawRectangle(new TerminalPosition(1, 1), new TerminalSize(1, 1), 'r');
    }

    @Test
    void drawTitle() {
        gui.drawTitle(new Position(1, 1), "Hello World", WHITE);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(WHITE));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void drawInfo() {
        gui.drawInfo(1, 1);

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(GREEN));
        Mockito.verify(tg, Mockito.times(1)).putString(3, 37, Integer.toString(1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString(YELLOW));
        Mockito.verify(tg, Mockito.times(1)).putString(53, 37, Integer.toString(1) + HEART);
    }
}