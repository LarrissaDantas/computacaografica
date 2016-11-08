package br.edu.uepb.cg.panels;

import br.edu.uepb.cg.retas.Ponto;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

/**
 * Representa um plano cartesiano
 *
 * @author Geovannio Vinhas
 */
public class PanelPlanoCartesiano extends JPanel {

    private static float altura, largura;

    public static PanelPlanoCartesiano instance;

    public static PanelPlanoCartesiano getInstance() {
        if (instance == null) {
            instance = new PanelPlanoCartesiano();
        }
        return instance;
    }

    public PanelPlanoCartesiano() {
        
    }

    /**
     * Desenha o plano
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        g.setColor(Color.LIGHT_GRAY);

        int width = this.getWidth();
        int height = this.getHeight();

        // Reta x
        g.drawLine(0, height / 2, width, height / 2); // x1, y1, x2, y2 

        // Reta y
        g.drawLine(width / 2, 0, width / 2, height); // x1, y1, x2, y2 
    }

    /**
     * Redesenha o plano cartesiano. Útil quando se quer apagar os objetos
     * desenhado nele e desenhar novos.
     */
    public void redesenha() {
        if (instance != null) {
            instance.getGraphics().clearRect(0, 0, this.getLargura(), this.getAltura());
            this.paint(this.getGraphics()); // Desenha o plano cartesiano novamente
        }
    }

    /**
     * Desenha o eixo Z no plano cartesiano.
     */
    public void desenhaEixoZ() {
        if (instance != null) {
            Graphics g = instance.getGraphics();
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(0, getAltura(), getLargura(), 0);
        }
    }

    public int getLargura() {
        return this.getWidth();
    }

    public int getAltura() {
        return this.getHeight();
    }

    public int getValorCentroX() {
        return getLargura() / 2;
    }

    public int getValorCentroY() {
        return getAltura() / 2;
    }
}
