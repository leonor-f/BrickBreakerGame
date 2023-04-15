package com.aor.brickbreaker.controller.game;

import com.aor.brickbreaker.controller.Controller;
import com.aor.brickbreaker.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena model) {
        super(model);
    }
}
