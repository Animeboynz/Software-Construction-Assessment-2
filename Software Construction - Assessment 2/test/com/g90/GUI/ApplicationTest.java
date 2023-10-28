package com.g90.GUI;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ApplicationTest {

    @Test
    public void testWillAppFitInScreenWidth() {
        Application app = new Application();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        boolean widthOK = (int) size.getWidth() >= app.screenWidth;
        assertTrue("Screen width too low", widthOK);
    }
    
    @Test
    public void testWillAppFitInScreenHeight() {
        Application app = new Application();

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        boolean heightOK = (int) size.getHeight() >= app.screenHeight;
        assertTrue("Screen height too low", heightOK);
    }
}
