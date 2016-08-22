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
        float lenght;
        float x, y, xInc, yInc;

        lenght = Math.abs(pFinal.getX() - pInicial.getX());

        if (Math.abs(pFinal.getY() - pInicial.getY()) > lenght) {
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
        float dX = pFinal.getX() - pInicial.getX();
        float dY = pFinal.getY() - pInicial.getY();

        float d = 2 * dX - dX; // Valor inicial de d
        float incE = 2 * dY; // Incremento em E
        float incNE = 2 * (dY - dX); // Incremento em NE

        float x = pInicial.getX(), y = pInicial.getY();

        int count = 0; // Contador de iterações

        do {
            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

            // Seta o pontos no jTextArea
            setSolution(jTextAreaSolution, x, y, ++count, String.valueOf(d));

            if (d <= 0) {
                // Escolhe E
                d += incE;
                x += 1;
            } else {
                // Escolhe NE
                d += incNE;
                x += 1;
                y += 1;
            }
        } while (x <= pFinal.getX());
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

    private int getOitante(Ponto p1, Ponto p2) {
        double deltaX = p2.getX() - p1.getX();
        double deltaY = p2.getY() - p1.getY();

        double m = deltaY / deltaX;

        // 1° Oitante
        if ((m >= 0 && m <= 1)) {
            return 1;
        }
        return 1;
    }
}
