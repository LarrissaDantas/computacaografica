package br.edu.uepb.cg.transformacao2D;

import br.edu.uepb.cg.panels.PanelPlanoCartesiano;
import br.edu.uepb.cg.retas.Circunferencia;
import br.edu.uepb.cg.retas.Ponto;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Cria animação do sistema solar
 *
 * @author Douglas Rafael
 */
public final class SistemaSolar {

    public static Thread threadAnimation;

    private final double RAIO_SOL = 60D;
    private final double RAIO_ORBITA_INI = 400D;
    private final double RAIO_ORBITA_FIM = 200D;
    private final double RAIO_TERRA = 20D;

    private final PanelPlanoCartesiano planoCartesiano;
    private final Graphics2D g;
    private Ellipse2D orbita;
    private Ellipse2D sol;
    private Ellipse2D terra;

    private final int centroX;
    private final int centroY;

    private List<Ponto> pontosOrbita;

    public SistemaSolar() {
        planoCartesiano = PanelPlanoCartesiano.getInstance();
        g = (Graphics2D) planoCartesiano.getGraphics();
        centroX = planoCartesiano.getValorCentroX();
        centroY = planoCartesiano.getValorCentroY();

        pontosOrbita = new LinkedList<>();
        populaSistemaSolar();
    }

    public void populaSistemaSolar() {
        planoCartesiano.redesenha();

        /**
         * Desenha a orbita e pega os seus pontos
         */
        g.setColor(Color.RED);
        Circunferencia.funcaoElipse(200, 100, Color.RED, planoCartesiano);
        preparaPonto();

        /**
         * Desenha o sol e a terra
         */
        desenhaSol();
        desenhaTerra();
    }

    /**
     * Desenha o Sol
     */
    private void desenhaSol() {
        g.setColor(Color.YELLOW);
        sol = new Ellipse2D.Double(centroX - RAIO_SOL / 2, centroY - RAIO_SOL / 2, RAIO_SOL, RAIO_SOL);
        g.fill(sol);
    }

    /**
     * Desenha Terra
     */
    private void desenhaTerra() {
        g.setColor(Color.BLUE);
        // Posição inicial da terra (0,200)
        terra = new Ellipse2D.Double(centroX - RAIO_TERRA / 2, centroY - RAIO_TERRA / 2, RAIO_TERRA, RAIO_TERRA);
        g.draw(terra);
    }

    private void desenhaOrbita() {
        g.setColor(Color.RED);
        orbita = new Ellipse2D.Double(centroX - RAIO_ORBITA_INI / 2, centroY - RAIO_ORBITA_FIM / 2, RAIO_ORBITA_INI, RAIO_ORBITA_FIM);
        g.draw(orbita);
    }

    private void refresh() {
        planoCartesiano.redesenha();
        desenhaOrbita();
        desenhaSol();
    }

    private void preparaPonto() {
        // Pega a lista de pontos da órbita da metade de cima
        for (int i = 200; i >= -200; i--) {
            for (int j = 0; j <= 100; j++) {
                if (pontoExiste(new Ponto(centroX + i, centroY + j, 0), Circunferencia.listaPontos)) {
                    pontosOrbita.add(new Ponto(centroX + i, centroY + j, 0));
                }
            }
        }

        // Pega a lista de pontos da órbita da metade de baixo
        for (int i = -200; i <= 200; i++) {
            for (int j = 0; j >= -100; j--) {
                if (pontoExiste(new Ponto(centroX + i, centroY + j, 0), Circunferencia.listaPontos)) {
                    pontosOrbita.add(new Ponto(centroX + i, centroY + j, 0));
                }
            }
        }
    }

    /**
     * Aplica a animação da terra dando a volta na orbita
     */
    public void startAnimation() {
        Collections.reverse(pontosOrbita);
        threadAnimation = new Thread() {
            int i = 0;

            @Override
            public void run() {
                for (Ponto p : pontosOrbita) {
                    try {
                        refresh();
                        terra.setFrame(p.getX() - RAIO_TERRA / 2, p.getY() - RAIO_TERRA / 2, RAIO_TERRA, RAIO_TERRA);
                        g.setColor(Color.BLUE);
                        g.fill(terra);

                        sleep(50);
                        i += 1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        threadAnimation.start();
    }

    /**
     * Verifica se o dado um ponto ele esta contido na lista de ponto passada
     * como parametro
     *
     * @param p
     * @param lista
     * @return
     */
    public boolean pontoExiste(Ponto p, List<Ponto> lista) {
        for (Ponto ponto : lista) {
            if (ponto.getX() == p.getX() && ponto.getY() == p.getY()) {
                return true;
            }
        }
        return false;
    }
}
