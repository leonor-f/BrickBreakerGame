package com.aor.brickbreaker.controller;

import com.aor.brickbreaker.Game;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.menu.Menu;
import com.aor.brickbreaker.states.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller<Menu> {
    public InstructionsController(Menu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
    }
}
