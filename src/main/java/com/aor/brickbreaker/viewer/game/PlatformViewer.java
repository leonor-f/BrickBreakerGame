package com.aor.brickbreaker.viewer.game;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Platform;

public class PlatformViewer implements ElementViewer<Platform>{
    @Override
    public void drawElement(Platform element, GUI gui) {
        gui.drawPlatform(element.getPosition(), element.getSize());
    }
}
