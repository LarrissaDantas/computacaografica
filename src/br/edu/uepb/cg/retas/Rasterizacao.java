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
            setSolution(jTextAreaSolution, x, y, ++count);

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
        float x = pInicial.getX(), y = pInicial.getY();

        /**
         * Análise dos 8 octantes com relação a variação de dx e dy
         */
        int incX1 = 0, incY1 = 0, incX2 = 0, incY2 = 0;
        if (dX > 0) { // X cresce
            incX1 = incX2 = 1;
        } else if (dX < 0) { // X decresce
            incX1 = incX2 = -1;
        }

        if (dY > 0) { // Y cresce
            incY1 = 1;
        } else if (dX < 0) { // Y decresce
            incY1 = -1;
        }

        float eixoMaior, eixoMenor;
        if (Math.abs(dX) >= Math.abs(dY)) {
            eixoMaior = Math.abs(dX);
            eixoMenor = Math.abs(dY);
        } else {
            eixoMaior = Math.abs(dY);
            eixoMenor = Math.abs(dX);

            if (dY > 0) // Y cresce
            {
                incY2 = 1;
            } else if (dY < 0) // Y decresce
            {
                incY2 = -1;
            }
            incX2 = 0;
        }
        
        float numerador = eixoMaior / 2;

        for (int i = 1; i <= eixoMaior + 1; i++) {
            /**
             * Desenha o ponto da reta
             */
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(Math.round(centralizaPonto(x, y, panel).getX()), Math.round(centralizaPonto(x, y, panel).getY()), 1, 1);

            // Seta o pontos no jTextArea
            setSolution(jTextAreaSolution, x, y, i);

            numerador += eixoMenor;
            if (numerador > eixoMaior) {
                numerador -= eixoMaior;
                x = incX1;
                y = incY1;
            } else {
                x = incX2;
                y = incY2;
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
    private static Ponto centralizaPonto(double x, double y, JPanel panel) {
        float xTemp = (float) (x + (panel.getWidth() / 2));
        float yTemp = (float) ((panel.getHeight() / 2) - y);
        return new Ponto(xTemp, yTemp);
    }

    /**
     *
     * @param jTextArea
     */
    private static void setSolution(JTextArea jTextArea, double x, double y, int count) {
        String solution = "";

        solution += jTextArea.getText();
        solution += String.format("%02d", count);
        solution += " - (";
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
