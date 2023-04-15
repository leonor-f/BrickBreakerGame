package com.aor.brickbreaker.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class MenuTest {

    private Menu menu;

    @BeforeEach
    public void helper(){
        menu = new Menu();
    }

    @Test
    public void Constructor(){
        assertEquals (3, menu.getNumberEntries());
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Instructions", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }
}