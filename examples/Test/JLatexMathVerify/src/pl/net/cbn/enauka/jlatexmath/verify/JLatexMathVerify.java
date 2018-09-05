package pl.net.cbn.enauka.jlatexmath.verify;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

/**
 *
 *
 * @since 2018-09-05, 11:16:19
 * @author Artur Jackowski
 */
public class JLatexMathVerify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String latex = "$\\neq 0";

        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY)
                .setSize(16)
                .setWidth(TeXConstants.UNIT_PIXEL, 256f, TeXConstants.ALIGN_CENTER)
                .setIsMaxWidth(true).setInterLineSpacing(TeXConstants.UNIT_PIXEL, 20f)
                .build();

        JFrame frame = new JFrame();
        final JLabel label = new JLabel(icon);
        label.setMaximumSize(new Dimension(100, 300));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

}
