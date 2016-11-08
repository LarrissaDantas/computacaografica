package br.edu.uepb.cg.retas;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Algoritmos para desenhar circunferências
 *
 * @author geovanniovinhas
 */
public class Circunferencia {

    public static int x, y, d_old, x_dif, y_dif;
    public static List<Ponto> listaPontos;

    public Circunferencia() {
        listaPontos = new ArrayList<>();
    }

    /**
     * Algoritmo da função explicita
     *
     * @param raio
     * @param cor
     * @param panel
     */
    public static void funcaoExplicita(int raio, Color cor, JPanel panel) {

        for (int i = -raio; i < raio; i++) {

            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(i + (panel.getWidth() / 2), (panel.getHeight() / 2) - ((int) Math.sqrt(raio * raio - i * i)), 1, 1);
            g.fillRect(i + (panel.getWidth() / 2), (panel.getHeight() / 2) - (-1 * (int) Math.sqrt(raio * raio - i * i)), 1, 1);
        }

    }

    /**
     * Algoritmo da função trigonométrica
     *
     * @param raio
     * @param cor
     * @param panel
     */
    public static void funcaoTrigonometria(int raio, Color cor, JPanel panel) {
        for (int i = -raio; i <= raio; i++) {
            Graphics g = panel.getGraphics();
            g.setColor(cor);
            g.fillRect(((int) (raio * (double) Math.cos(Math.toRadians(i)))) + (panel.getWidth() / 2), (panel.getHeight() / 2) - ((int) (raio * (double) Math.sin(Math.toRadians(i)))), 1, 1);
            imprima(((int) (raio * (double) Math.cos(Math.toRadians(i)))), -((int) (raio * (double) Math.sin(Math.toRadians(i)))), cor, panel);
        }
    }

    /**
     * Algoritmo do ponto médio
     *
     * @param raio
     * @param cor
     * @param panel
     */
    public static void funcaoPontoMedio(int raio, Color cor, JPanel panel) {
        Graphics g = panel.getGraphics();
        g.setColor(cor);
        x = 0;
        y = raio;
        d_old = 1 - raio;
        g.fillRect(x + (panel.getWidth() / 2), (panel.getHeight() / 2) - y, 1, 1);
        imprima(x, y, cor, panel);
        while (y > x) {
            if (d_old < 0) {
                d_old += 2 * x + 3;
            } else {
                d_old += 2 * x - 2 * y + 5;
                y--;
            }
            x++;
            imprima(x, y, cor, panel);
        }

    }

    /**
     * Algoritmo da função elipse
     *
     * @param a
     * @param b
     * @param cor
     * @param panel
     */
    public static void funcaoElipse(int a, int b, Color cor, JPanel panel) {
        x = 0;
        y = 0;
        double d1;
        double d2;

        /* Valores iniciais */
        x = 0;
        y = b;
        d1 = b * b - a * a * b + a * a / 4.0;

        imprimaElipse(x, y, cor, panel);

        while (a * a * (y - 0.5) > b * b * (x + 1)) {

            if (d1 < 0) {
                d1 = d1 + b * b * (2 * x + 3);
                x++;
            } else {
                d1 = d1 + b * b * (2 * x + 3) + a * a * (-2 * y + 2);
                x++;
                y--;
            }
            imprimaElipse(x, y, cor, panel);
        }

        d2 = b * b * (x + 0.5) * (x + 0.5) + a * a * (y - 1) * (y - 1) - a * a * b * b;
        while (y > 0) {

            if (d2 < 0) {
                d2 = d2 + b * b * (2 * x + 2) + a * a * (-2 * y + 3);
                x++;
                y--;
            } else {
                d2 = d2 + a * a * (-2 * y + 3);
                y--;
            }
            imprimaElipse(x, y, cor, panel);
        }

    }

    /**
     * Desenha nos oitantes
     *
     * @param x
     * @param y
     * @param cor
     * @param panel
     */
    static void imprima(int x, int y, Color cor, JPanel panel) {
        Graphics g = panel.getGraphics();
        g.setColor(cor);

        g.fillRect(x + (panel.getWidth() / 2), (panel.getHeight() / 2) - y, 1, 1);
        g.fillRect(x + (panel.getWidth() / 2), (panel.getHeight() / 2) + y, 1, 1);
        g.fillRect(-x + (panel.getWidth() / 2), (panel.getHeight() / 2) - y, 1, 1);
        g.fillRect(-x + (panel.getWidth() / 2), (panel.getHeight() / 2) + y, 1, 1);

        g.fillRect(y + (panel.getWidth() / 2), (panel.getHeight() / 2) - x, 1, 1);
        g.fillRect(y + (panel.getWidth() / 2), (panel.getHeight() / 2) + x, 1, 1);
        g.fillRect(-y + (panel.getWidth() / 2), (panel.getHeight() / 2) - x, 1, 1);
        g.fillRect(-y + (panel.getWidth() / 2), (panel.getHeight() / 2) + x, 1, 1);
    }

    /**
     * Imprime os pontos da elipse
     *
     * @param x
     * @param y
     * @param cor
     * @param panel
     */
    static void imprimaElipse(int x, int y, Color cor, JPanel panel) {
        Graphics g = panel.getGraphics();
        g.setColor(cor);

        g.fillRect(x + (panel.getWidth() / 2), (panel.getHeight() / 2) - y, 1, 1);
        g.fillRect(x + (panel.getWidth() / 2), (panel.getHeight() / 2) + y, 1, 1);
        g.fillRect(-x + (panel.getWidth() / 2), (panel.getHeight() / 2) - y, 1, 1);
        g.fillRect(-x + (panel.getWidth() / 2), (panel.getHeight() / 2) + y, 1, 1);

        if(listaPontos == null) {
            listaPontos = new ArrayList<>();
        }
        listaPontos.add(new Ponto(x + (panel.getWidth() / 2), (panel.getHeight() / 2) - y));
        listaPontos.add(new Ponto(x + (panel.getWidth() / 2), (panel.getHeight() / 2) + y));
        listaPontos.add(new Ponto(-x + (panel.getWidth() / 2), (panel.getHeight() / 2) - y));
        listaPontos.add(new Ponto(-x + (panel.getWidth() / 2), (panel.getHeight() / 2) + y));
    }

}
