package com.aor.brickbreaker.gui;

import com.aor.brickbreaker.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.aor.brickbreaker.Constants.*;
import static com.googlecode.lanterna.Symbols.*;

public class LanternaGUI implements GUI {

    private final TerminalScreen screen;

    public LanternaGUI() throws IOException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(fontConfig);
        this.screen = createScreen(terminal);
    }

    public LanternaGUI(TerminalScreen screen) {
        this.screen = screen;
    }

    public TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen terminalScreen;
        terminalScreen = new TerminalScreen(terminal);
        terminalScreen.setCursorPosition(null);
        terminalScreen.startScreen();
        terminalScreen.doResizeIfNecessary();
        return terminalScreen;
    }

    public Terminal createTerminal(AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(WIDTH, HEIGHT);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        defaultTerminalFactory.setForceAWTOverSwing(true);
        defaultTerminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = defaultTerminalFactory.createTerminal();
        ((AWTTerminalFrame) terminal).setTitle("Brick Breaker");
        return terminal;
    }

    public AWTTerminalFontConfiguration loadFont() throws FontFormatException, IOException {
        File fontFile = new File("font/font.ttf");
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 17);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public void drawBall(Position position) {
        drawRectangle(position, '@', WHITE, 1, 1);
    }

    @Override
    public void drawPlatform(Position position, int size) {
        drawRectangle(position, '-', WHITE, size, PLATFORM_HEIGHT);
    }

    @Override
    public void drawWall(Position position) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        tg.putString(position.getX(), position.getY() + 1, " ");
    }

    @Override
    public void drawBrick(int hits, Position position) {
        String color = switch (hits) {
            case 1 -> YELLOW;
            case 2 -> RED;
            default -> GREEN;
        };
        drawRectangle(position, '-', color, BRICK_WIDTH, BRICK_HEIGHT);
    }

    public void drawText(TextGraphics textGraphics, Position position, String text, String color) {
        if (text == " ") {
            textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        } else {
            textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
            textGraphics.enableModifiers(SGR.BOLD);
        }
        textGraphics.putString(position.getX(), position.getY(), text);
    }

    public void drawRectangle(Position position, char c, String color, int width, int height) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.drawRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(width, height), c);
    }

    @Override
    public void drawTitle(Position position, String text, String color) {
        TextGraphics textGraphics = createTextGraphics();
        drawText(textGraphics, position, text, color);
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawInfo(int points, int lives) {
        TextGraphics textGraphics = createTextGraphics();
        drawText(textGraphics, new Position(3, 37), Integer.toString(points), GREEN);
        drawText(textGraphics, new Position(53, 37), Integer.toString(lives) + HEART, YELLOW);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}