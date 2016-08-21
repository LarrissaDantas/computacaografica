package br.edu.uepb.cg;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JTextField;


/**
 *
 * @author geovanniovinhas
 */
public class PlanoCartesiano extends JPanel {
    JPanel panel = new JPanel();
	JTextField coordX =  new JTextField(20);
	JTextField coordY =  new JTextField(20);
	int x,y;
        
     public PlanoCartesiano() {
		add(panel);
		panel.add(coordX,"NORTH");
		panel.add(coordY,"NORTH");
		panel.setVisible(true);
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				String x0 = Integer.toString(e.getX());
				String y0 = Integer.toString((e.getY()));
				
				 x = (e.getX()-300);
				 y = ((-e.getY())+300);
				coordX.setText(x + "  " + x0);
				coordY.setText(y + "  " + y0);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		
		});;
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		this.setBackground(Color.white);
		
		g.setColor(Color.black);
		g.drawLine(40, 300, 500, 300);
		
		g.setColor(Color.black);
		g.drawLine(300, 40, 300, 500);
		
		
		
		
		//g.setColor(Color.BLACK);
		//g.drawRect(300-100, (300+100)-100, 50, 100);

	}

}
