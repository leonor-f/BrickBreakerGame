package com.aor.brickbreaker.states;

import com.aor.brickbreaker.controller.Controller;
import com.aor.brickbreaker.controller.InstructionsController;
import com.aor.brickbreaker.model.menu.Menu;
import com.aor.brickbreaker.viewer.InstructionsViewer;
import com.aor.brickbreaker.viewer.Viewer;

public class InstructionsState extends State<Menu>{

    public InstructionsState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new InstructionsController(getModel());
    }
}