package com.aor.brickbreaker.states;

import com.aor.brickbreaker.controller.Controller;
import com.aor.brickbreaker.controller.menu.MenuController;
import com.aor.brickbreaker.model.menu.Menu;
import com.aor.brickbreaker.viewer.Viewer;
import com.aor.brickbreaker.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}