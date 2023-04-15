package com.aor.brickbreaker.controller.menu;

import com.aor.brickbreaker.model.game.arena.LoaderArenaBuilder;
import com.aor.brickbreaker.Game;
import com.aor.brickbreaker.controller.Controller;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.menu.Menu;
import com.aor.brickbreaker.states.GameState;
import com.aor.brickbreaker.states.InstructionsState;


import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu){super(menu);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder().createArena()));
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsState(null));
            default:
                break;
        }
    }
}
