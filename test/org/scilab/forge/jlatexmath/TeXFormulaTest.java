package org.scilab.forge.jlatexmath;

import org.junit.jupiter.api.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TeXFormulaTest {

    @Test
    public void testEN_4379() throws IOException {
        TeXIcon icon1 = renderTeXFormula("150:10");
        renderTeXFormula("8{:}0");
        TeXIcon icon3 = renderTeXFormula("150:10");
        assertEquals(icon1.getIconWidth(), icon3.getIconWidth(),()->"rendering 8{:}0 modifies spacing around : operator in next rendering");
    }

    private TeXIcon renderTeXFormula(String latex) throws IOException {
        TeXIcon icon = createTexIcon(latex);
//        saveToFile(icon);
        return icon;
    }

    private TeXIcon createTexIcon(String latex) {
        TeXFormula formula = new TeXFormula(latex);
        return formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 18);
    }

    private void saveToFile(TeXIcon icon) throws IOException {
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        File file = File.createTempFile("/tex-formula-test", ".png", new File("/tmp/"));
        ImageIO.write(image, "png", file.getAbsoluteFile());
    }
}