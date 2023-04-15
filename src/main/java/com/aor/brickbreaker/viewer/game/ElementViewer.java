package com.aor.brickbreaker.viewer.game;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Element;

public interface ElementViewer<T extends Element> {

    void drawElement(T element, GUI gui);
}
