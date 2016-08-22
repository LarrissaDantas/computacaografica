package br.edu.uepb.cg;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JTextField;

/**
 *
 * @author geovanniovinhas
 */
public class PlanoCartesiano extends JPanel {
    private final int PLANO_LARGURA = 600;
    private final int PLANO_ALTURA  = 720;
    
    private JTextField coordX = new JTextField(20);
    private JTextField coordY = new JTextField(20);
    private int x, y;

    public PlanoCartesiano() {
        setSize(600, 600);
    }

    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        g.setColor(Color.black);
        
        int width = super.getWidth();
        int height = super.getHeight();

        // Reta x
        g.drawLine(0, height/2, width, height/2); // x1, y1, x2, y2 
        System.out.println(height/2); // y
        System.out.println(width/2); // x
        
        // Reta y
        g.drawLine(width/2, 0, width/2, height); // x1, y1, x2, y2 

        //g.setColor(Color.BLACK);
        //g.drawRect(300-100, (300+100)-100, 50, 100);
    }

}
