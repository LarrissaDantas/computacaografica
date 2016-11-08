package br.edu.uepb.cg.retas;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Classe que impementa os algoritmos de rasterização da reta.
 *
 * @author Douglas Rafael, Sérgio Martins e Geovannio Vinhas
 */
public class Rasterizacao {

    static float lenght, media;
    static float x, y, xInc, yInc;

    public Rasterizacao() {
    }

    /**
     * Algoritmo DDA (Digital Differential Analyser)
     *
     * @param pInicial Ponto inicial
     * @param pFinal Ponto Final
     * @param cor Cor da reta
     * @param panel Panel onde a reta será desenhada
     * @param jTextAreaSolution jTextArea para exibir solução
     */
    public static void dda(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());
        media = Math.abs(pFinal.getY() - pInicial.getY()) / Math.abs(pFinal.getX() - pInicial.getX());

        double x1 = pInicial.getX();
        double y1 = pInicial.getY();

        double x2 = pFinal.getX();
        double y2 = pFinal.getY();
        if (0.0 <= media && media <= 1.0 && (x1 < x2)) {
            desenhaPrimeiroOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }
        if (1.0 < media && media <= Double.POSITIVE_INFINITY && (y1 < y2)) {
            desenhaSegundoOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }
        if (-1.0 > media && media > Double.NEGATIVE_INFINITY && (y1 < y2)) {
            desenhaTerceiroOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }
        if (0.0 >= media && media >= -1.0 && (x2 < x1)) {
            desenhaQuartoOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }
        if (0.0 <= media && media <= 1.0 && (x2 < x1)) {
            desenhaQuintoOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }
        if (1.0 < media && media <= Double.POSITIVE_INFINITY && (y2 < y1)) {
            desenhaSextoOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }
        if (-1.0 > media && media >= Double.NEGATIVE_INFINITY && (y2 < y1)) {
            desenhaSetimoOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }
        if (0.0 > media && media > -1 && (y2 < y1)) {
            desenhaOitavoOctante(pInicial, pFinal, cor, panel, jTextAreaSolution);
        }

    }

    /**
     * Desenha no primeiro octante.
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaPrimeiroOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) >= lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        do {
            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

            // Seta o pontos no jTextArea
            setSolution(jTextAreaSolution, x, y, ++count, null);

            x += xInc;
            y += yInc;
        } while (x <= pFinal.getX());
    }

    /**
     * Desenha no segundo octante.
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaSegundoOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) > lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        if (x == pFinal.getX()) {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (y <= pFinal.getY());
        } else if (x < 0 && pFinal.getX() < 0) {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (x <= pFinal.getX());
        } else {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (x <= pFinal.getX());
        }
    }

    /**
     * Desenha no terceiro octante
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaTerceiroOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) >= lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        do {
            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

            // Seta o pontos no jTextArea
            setSolution(jTextAreaSolution, x, y, ++count, null);

            x += xInc;
            y += yInc;
        } while (x <= pFinal.getX());
    }

    /**
     * Desenha no quarto octante.
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaQuartoOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) >= lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        do {
            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

            // Seta o pontos no jTextArea
            setSolution(jTextAreaSolution, x, y, ++count, null);

            x += xInc;
            y += yInc;
        } while (x <= pFinal.getX());
    }

    /**
     * Desenha no quinto octante.
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaQuintoOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) >= lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        do {
            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

            // Seta o pontos no jTextArea
            setSolution(jTextAreaSolution, x, y, ++count, null);

            x += xInc;
            y += yInc;
        } while (x <= pFinal.getX());
    }

    /**
     * Desenha no sexto octante.
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaSextoOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) > lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        if (x == pFinal.getX()) {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (y <= pFinal.getY());
        } else if (x < 0 && pFinal.getX() < 0) {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (x <= pFinal.getX());
        } else {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (x <= pFinal.getX());
        }
    }

    /**
     * Desenha no sétimo octante.
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaSetimoOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) > lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        if (x == pFinal.getX()) {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (y <= pFinal.getY());
        } else if (x < 0 && pFinal.getX() < 0) {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (x <= pFinal.getX());
        } else {
            do {
                /**
                 * Desenha o ponto da reta
                 */
                Graphics g = panel.getGraphics();
                g.setColor(cor);
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, null);

                x += xInc;
                y += yInc;
            } while (x <= pFinal.getX());
        }
    }

    /**
     * Desenha no oitavo octante.
     *
     * @param pInicial
     * @param pFinal
     * @param cor
     * @param panel
     * @param jTextAreaSolution
     */
    public static void desenhaOitavoOctante(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) >= lenght) {
            lenght = Math.abs(pFinal.getY() - pInicial.getY());
        }

        xInc = (pFinal.getX() - pInicial.getX()) / lenght;
        yInc = (pFinal.getY() - pInicial.getY()) / lenght;

        x = pInicial.getX();
        y = pInicial.getY();

        int count = 0; // Conta as iterações

        do {
            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

            // Seta o pontos no jTextArea
            setSolution(jTextAreaSolution, x, y, ++count, null);

            x += xInc;
            y += yInc;
        } while (x <= pFinal.getX());
    }

    /**
     * Algoritmo do ponto médio
     *
     * @param pInicial Ponto inicial
     * @param pFinal Ponto Final
     * @param cor Cor da reta
     * @param panel Panel onde a reta será desenhada
     * @param jTextAreaSolution jTextArea para exibir solução
     */
    public static void pontoMedio(Ponto pInicial, Ponto pFinal, Color cor, JPanel panel, JTextArea jTextAreaSolution) {

        float dX = Math.abs(pFinal.getX() - pInicial.getX());
        float dY = Math.abs(pFinal.getY() - pInicial.getY());
        boolean inclinacao = false;

        // Trantando os octantes
        if (dY > dX) {
            inclinacao = true;

            // swap nos pontos P(x,y) passa a ser P(y,x)
            pInicial.swap();
            pFinal.swap();

            // swap no dX, dY
            float temp = dY;
            dY = dX;
            dX = temp;
        }

        if (pInicial.getX() > pFinal.getX()) {
            // Swap dos pontos
            Ponto pTemp = pInicial;
            pInicial = pFinal;
            pFinal = pTemp;
        }

        int incY = 1;
        if (pInicial.getY() > pFinal.getY()) {
            incY = -1;
        }
        // Fim do tratamento dos octantes

        float d = (Math.abs(dY - dX)) * 2;
        float incE = dY * 2;
        float incNE = (dY - dX) * 2;

        x = pInicial.getX();
        y = pInicial.getY();
        int count = 0;

        for (; x <= pFinal.getX(); ++x) {
            if (d <= 0) {
                d += incE;
            } else {
                d += incNE;
                y += incY;
            }

            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            if (inclinacao) {
                g.fillRect(Math.round(centralizaPonto(y, x, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);
                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, y, x, ++count, String.valueOf(d));
            } else {
                g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);
                // Seta o pontos no jTextArea
                setSolution(jTextAreaSolution, x, y, ++count, String.valueOf(d));
            }
        }
    }

    /**
     * Centraliza os pontos no plano de acordo com o tamanho do jPanel
     *
     * @param x Coordenada x do ponto
     * @param y Coordenada y do ponto
     * @param panel JPanel onde o ponto é desenhado
     * @return Ponto o ponto com as coordenadas centralizadas
     */
    private static Ponto centralizaPonto(float x, float y, JPanel panel) {
        float xTemp = (float) (x + (panel.getWidth() / 2));
        float yTemp = (float) ((panel.getHeight() / 2) - y);
        return new Ponto(xTemp, yTemp);
    }

    /**
     * Popula o jTextArea com a solução do problema.
     * 
     * @param jTextArea
     * @param x
     * @param y
     * @param count
     * @param d 
     */
    private static void setSolution(JTextArea jTextArea, float x, float y, int count, String d) {
        String solution = "";

        solution += jTextArea.getText();
        solution += String.format("%02d", count);
        solution += " - ";
        if (d != null) {
            solution += " d = " + new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.ENGLISH)).format((float) x) + " | ";
        }
        solution += "(";
        solution += new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.ENGLISH)).format(x);
        solution += ", ";
        solution += new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.ENGLISH)).format(y);
        solution += ")\n";
        jTextArea.setText(solution.toString());
    }
}
