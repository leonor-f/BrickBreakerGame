package com.aor.brickbreaker.viewer.menu;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.Position;
import com.aor.brickbreaker.viewer.Viewer;
import com.aor.brickbreaker.model.menu.Menu;

import static com.aor.brickbreaker.Constants.*;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", WHITE);

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? RED : WHITE);

    }
}
