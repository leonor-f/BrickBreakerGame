package com.aor.brickbreaker.viewer;

import com.aor.brickbreaker.gui.GUI;
import com.aor.brickbreaker.model.game.elements.Platform;
import com.aor.brickbreaker.viewer.game.PlatformViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlatformViewerTest {
    private Platform platform;
    private PlatformViewer platformViewer;
    private GUI gui;

    @BeforeEach
    void helper() {
        platform = new Platform();
        platformViewer = new PlatformViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        platformViewer.drawElement(platform, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlatform(platform.getPosition(), platform.getSize());
    }
}