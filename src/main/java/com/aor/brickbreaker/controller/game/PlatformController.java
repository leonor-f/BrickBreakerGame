package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.Game;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.model.game.elements.Platform;

import java.io.IOException;

import static com.aor.brickbreaker.Constants.*;

public class PlatformController extends GameController {

    private Platform platform = getModel().getPlatform();

    public PlatformController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.LEFT && canPlatformMoveLeft(getModel().getPlatform().getPosition()))
            moveLeft();
        if (action == GUI.ACTION.RIGHT && canPlatformMoveRight(getModel().getPlatform().getPosition()))
            moveRight();
    }

    public void moveLeft() {
        getModel().getPlatform().setPosition(getModel().getPlatform().getPosition().getX() - 1, PLATFORM_Y);
    }

    public void moveRight() {
        getModel().getPlatform().setPosition(getModel().getPlatform().getPosition().getX() + 1, PLATFORM_Y);
    }

    private boolean canPlatformMoveLeft(Position position) {
        return position.getX() > 1;
    }

    private boolean canPlatformMoveRight(Position position) {
        return !(position.getX() > WIDTH - getModel().getPlatform().getSize() - 2);
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public void updateScore(int points) {
        getModel().getPlatform().updateScore((double) points / MIN_HITS_TO_DESTROY);
    }

    public void updateSize() {
        getModel().getPlatform().updateSize();
    }

    public void lostLife() {
        getModel().getPlatform().updateLives();
    }
}