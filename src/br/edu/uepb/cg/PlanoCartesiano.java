package br.edu.uepb.cg;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Representa um plano cartesiano
 * 
 * @author Geovannio Vinhas
 */
public class PlanoCartesiano extends JPanel {
    public PlanoCartesiano() {
    }

    /**
     * Desenha o plano
     *
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        g.setColor(Color.LIGHT_GRAY);

        int width = super.getWidth();
        int height = super.getHeight();

        // Reta x
        g.drawLine(0, height / 2, width, height / 2); // x1, y1, x2, y2 

        // Reta y
        g.drawLine(width / 2, 0, width / 2, height); // x1, y1, x2, y2 
    }
}
