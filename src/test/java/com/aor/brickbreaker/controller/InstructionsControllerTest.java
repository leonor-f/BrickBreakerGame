package com.aor.brickbreaker.controller;

import com.aor.brickbreaker.Game;
import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.menu.Menu;
import com.aor.brickbreaker.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static groovy.test.GroovyTestCase.assertEquals;

public class InstructionsControllerTest {

    private Game game;
    private InstructionsController instructionsController;
    private Menu menu;
    private MenuState menuState;

    @BeforeEach
    void helper(){
        game = Mockito.mock(Game.class);
        menu = Mockito.mock(Menu.class);
        instructionsController = new InstructionsController(menu);
        menuState = new MenuState(menu);
    }

    @Test
    public void step() throws IOException {
        instructionsController.step(game, GUI.ACTION.QUIT, 1);
        assertEquals(null, game.getState());
    }
}