package test.java;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import org.scilab.forge.jlatexmath.*;

/**
 * 
 *
 * @since 2025-08-01 18:58:53
 * @author Mateusz Uliński
 */
public class LatexViewer extends JFrame {

    public LatexViewer() {
        setTitle("LaTeX Viewer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Hardkodowana formuła
        String latex = """
                       $\\underbrace{3 \\cdot 3 \\cdot 3}_{\\raisebox{-5em}{\\text{aaaaaaaaaaaaaaaaaaaaaaa}}$
                       """;

        // Tworzenie formuły
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);

        // Tworzenie obrazu
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        g2.setColor(Color.WHITE); // Tło
        g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
        icon.paintIcon(new JLabel(), g2, 0, 0);
        g2.dispose();

        // Wstawienie obrazu do GUI
        JLabel label = new JLabel(new ImageIcon(image));
        add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LatexViewer().setVisible(true);
        });
    }
}