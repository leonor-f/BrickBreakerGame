package com.aor.brickbreaker.states;

import com.aor.brickbreaker.controller.game.ArenaController;
import com.aor.brickbreaker.viewer.game.GameViewer;
import com.aor.brickbreaker.controller.Controller;
import com.aor.brickbreaker.model.game.arena.Arena;
import com.aor.brickbreaker.viewer.Viewer;

public class GameState extends State<Arena>{
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}