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
    private void openTexFindow(String latex) {
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY)
                .setSize(16)
                .setWidth(TeXConstants.UNIT_PIXEL, 256f, TeXConstants.ALIGN_CENTER)
                .setIsMaxWidth(true).setInterLineSpacing(TeXConstants.UNIT_PIXEL, 20f)
                .build();

        JFrame frame = new JFrame(latex.substring(0, Math.min(100, latex.length())));
        final JLabel label = new JLabel(icon);
        label.setMaximumSize(new Dimension(100, 300));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }
    
    /**
     * Should give "!=0!=0" but was incorrectly given "!=0!=00".
     */
    private void testNeqNeq() {
        openTexFindow("$\\neq 0$$\\neq 0$");
    }
    
    /**
     * Was given java.lang.StackOverflowError if that exactly tex was called
     * without any previous latex calls. This tex must be called first on clean
     * JLatexmath memory (no other previous texformula creations).
     */
    private void testNeq() {
        openTexFindow("$\\neq 0\\underbrace{a}_{\\neq 0} $");
    }

    private void test() {
        testNeq();
        testNeqNeq();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new JLatexMathVerify().test();
    }

}
