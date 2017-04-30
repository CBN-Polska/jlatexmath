package org.scilab.forge.jlatexmath;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

/**
 *
 * @author Karol Pelc
 */
public class CancelBox extends Box {
    private Box orgBox;
    private int styl;

    public CancelBox(Box orgBox, int styl) {
        this.orgBox = orgBox;
        this.styl = styl;
    }

    @Override
    public void draw(Graphics2D g2, float x, float y) {
        AffineTransform at = g2.getTransform();
        g2.translate(x, y);

        g2.setStroke(new BasicStroke(0.03f));
        if (styl == 0 || styl == 2) {
            Shape linia = new Line2D.Float(0, orgBox.depth, -orgBox.width, -orgBox.height );
            g2.draw(linia);
        }
        if (styl == 1 || styl ==2) {
            Shape linia = new Line2D.Float(0, -orgBox.height, -orgBox.width, orgBox.depth );
            g2.draw(linia);
        }
        g2.setTransform(at);
    }

    @Override
    public int getLastFontId() {
	     return orgBox.getLastFontId();
    }
}
