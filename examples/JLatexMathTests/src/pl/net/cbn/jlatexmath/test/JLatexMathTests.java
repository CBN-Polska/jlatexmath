package pl.net.cbn.jlatexmath.test;

import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import org.scilab.forge.jlatexmath.TeXConstants; 
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

/**
 * 
 *
 * @since 2017-07-05, 10:20:55
 * @author Artur Jackowski
 */
public class JLatexMathTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String latex="\\frac{a}{b}";
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();
	
	icon.setInsets(new Insets(5, 5, 5, 5));
	
	BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = image.createGraphics();
	g2.setColor(Color.white);
	g2.fillRect(0,0,icon.getIconWidth(),icon.getIconHeight());
	JLabel jl = new JLabel();
	jl.setForeground(new Color(0, 0, 0));
	icon.paintIcon(jl, g2, 0, 0);
	File file = new File("/tmp/aaa/Example1.png");
        ImageIO.write(image, "png", file.getAbsoluteFile());
    }
}