package br.edu.uepb.cg.transformacao2D;

import br.edu.uepb.cg.dialog.DialogDesenhaObjetos;
import br.edu.uepb.cg.panels.PanelPlanoCartesiano;
import br.edu.uepb.cg.retas.Ponto;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Métodos para transformações 2D
 *
 * @author Douglas e Geovannio
 */
public class Transformacoes2D {

    public Transformacoes2D() {
    }

    /**
     * Aplica translação
     *
     * @param listaPonto
     * @param tx
     * @param ty
     * @param planoCartesiano
     * @param color
     */
    public static void translacao(List<Ponto> listaPonto, double tx, double ty, PanelPlanoCartesiano planoCartesiano, Color color) {
        List<Ponto> listaNewPontos = new ArrayList<>();

        // criar a matriz do objeto
        double[][] matriz = new double[3][listaPonto.size()];
        for (int i = 0; i < listaPonto.size(); i++) {
            matriz[0][i] = listaPonto.get(i).getX(); // Coluna i na linha 0
            matriz[1][i] = listaPonto.get(i).getY(); // Coluna i na linha 1
            matriz[2][i] = 1; // Coluna i na linha 2 = 1
        }

        /**
         * Processo de translação
         */
        double[][] d = null;
        try {
            d = Matriz.multiplicaMatrizes(gerarMatrizTranslacao(tx, ty), matriz);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro na translação. " + e.getMessage());
        }

        // Pega instância do graphics para desenhar no plano cartesiano
        Graphics g = planoCartesiano.getGraphics();
        g.setColor(color);

        g.drawLine(planoCartesiano.getValorCentroX() + (int) d[0][0], planoCartesiano.getValorCentroY() - (int) d[1][0], planoCartesiano.getValorCentroX() + (int) d[0][1], planoCartesiano.getValorCentroY() - (int) d[1][1]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) d[0][1], planoCartesiano.getValorCentroY() - (int) d[1][1], planoCartesiano.getValorCentroX() + (int) d[0][2], planoCartesiano.getValorCentroY() - (int) d[1][2]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) d[0][2], planoCartesiano.getValorCentroY() - (int) d[1][2], planoCartesiano.getValorCentroX() + (int) d[0][3], planoCartesiano.getValorCentroY() - (int) d[1][3]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) d[0][3], planoCartesiano.getValorCentroY() - (int) d[1][3], planoCartesiano.getValorCentroX() + (int) d[0][0], planoCartesiano.getValorCentroY() - (int) d[1][0]);

        for (int i = 0; i < d[0].length; i++) {
            listaNewPontos.add(new Ponto((int) d[0][i], (int) d[1][i], (int) d[2][i]));
        }
        DialogDesenhaObjetos.setLista(listaNewPontos);
    }

    /**
     * Aplica Escala.
     *
     * @param objeto
     * @param sx
     * @param sy
     * @param planoCartesiano
     * @param color
     */
    public static void escala(List<Ponto> objeto, double sx, double sy, PanelPlanoCartesiano planoCartesiano, Color color) {
        List<Ponto> listaNewPontos = new ArrayList<>();

        // criar a matriz do objeto
        double[][] matriz = new double[3][objeto.size()];
        for (int i = 0; i < objeto.size(); i++) {
            matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
            matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
            matriz[2][i] = 1; // Coluna i na linha 2 = 1
        }

        int translacaox = (int) objeto.get(0).getX();
        int translacaoy = (int) objeto.get(0).getY();

        // Translada para origem
        double[][] matrizNaOrigem = translacaoMulti(matriz, -translacaox, -translacaoy);

        /**
         * Processo de escala
         */
        double[][] a = null;
        try {
            a = Matriz.multiplicaMatrizes(gerarMatrizEscala(sx, sy), matrizNaOrigem);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao escalar. " + e.getMessage());
        }

        // Voltar a posicao de origem
        double[][] matrizVoltar = translacaoMulti(a, translacaox, translacaoy);

        // Pega instância do graphics para desenhar no plano cartesiano
        Graphics g = planoCartesiano.getGraphics();
        g.setColor(color);

        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][0], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][0], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][1], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][1]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][1], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][1], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][2], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][2]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][2], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][2], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][3], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][3]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][3], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][3], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][0], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][0]);

        for (int i = 0; i < matrizVoltar[0].length; i++) {
            listaNewPontos.add(new Ponto((int) matrizVoltar[0][i], (int) matrizVoltar[1][i], (int) matrizVoltar[2][i]));
        }
        DialogDesenhaObjetos.setLista(listaNewPontos);
    }

    /**
     * Aplica rotação
     *
     * @param objeto
     * @param angulo
     * @param planoCartesiano
     * @param color
     */
    public static void rotacao(List<Ponto> objeto, int angulo, PanelPlanoCartesiano planoCartesiano, Color color) {
        List<Ponto> listaNewPontos = new ArrayList<>();

        // criar a matriz do objeto
        double[][] matriz = new double[3][objeto.size()];

        // Criando o objeto de matriz da lista.
        for (int i = 0; i < objeto.size(); i++) {
            matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
            matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
            matriz[2][i] = 1; // Coluna j na linha 2 = 1
        }

        // Ponto de origem.
        final int translacaoX = (int) objeto.get(0).getX();
        final int translacaoY = (int) objeto.get(0).getY();

        // translada para origem
        double[][] matrizNaOrigem = translacaoMulti(matriz, -translacaoX, -translacaoY);

        /**
         * Processo de rotação
         */
        double[][] lisPonto = null;
        try {
            lisPonto = Matriz.multiplicaMatrizes(gerarMatrizRotacao(angulo), matrizNaOrigem);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao rotacionar. " + e.getMessage());
        }

        // Voltar a posicao de origem
        double[][] matrizVoltar = translacaoMulti(lisPonto, translacaoX, translacaoY);

        // Pega instância do graphics para desenhar no plano cartesiano
        Graphics g = planoCartesiano.getGraphics();
        g.setColor(color);

        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][0], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][0], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][1], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][1]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][1], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][1], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][2], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][2]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][2], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][2], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][3], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][3]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][3], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][3], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][0], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][0]);

        for (int i = 0; i < matrizVoltar[0].length; i++) {
            listaNewPontos.add(new Ponto((int) matrizVoltar[0][i], (int) matrizVoltar[1][i], (int) matrizVoltar[2][i]));
        }
        DialogDesenhaObjetos.setLista(listaNewPontos);
    }

    /**
     * Aplica reflexão.
     *
     * @param objeto
     * @param eixo
     * @param planoCartesiano
     * @param color
     */
    public static void reflexao(List<Ponto> objeto, String eixo, PanelPlanoCartesiano planoCartesiano, Color color) {
        List<Ponto> listaNewPontos = new ArrayList<>();
        double[][] matriz = new double[3][objeto.size()];

        // Criando o objeto de matriz da lista.
        for (int i = 0; i < objeto.size(); i++) {
            matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
            matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
            matriz[2][i] = 1; // Coluna j na linha 2 = 1
        }

        // Ponto de origem.
        final int translacaoX = (int) objeto.get(0).getX();
        final int translacaoY = (int) objeto.get(0).getY();

        double[][] matrizNaOrigem = translacaoMulti(matriz, -translacaoX, -translacaoY);

        // Fazer a reflexao
        double[][] refletida = null;

        // Verifica se a reflexão será em X
        if (eixo.equals("x")) {
            try {
                refletida = Matriz.multiplicaMatrizes(gerarMatrizReflexaoX(), matriz);
            } catch (Exception e) {
                System.err.println("Ocorreu um erro na reflexão em X. " + e.getMessage());
            }

            // Verifica se a reflexão será em Y
        } else if (eixo.equals("y")) {
            try {
                refletida = Matriz.multiplicaMatrizes(gerarMatrizReflexaoY(), matriz);
            } catch (Exception e) {
                System.err.println("Ocorreu um erro na reflexão em Y. " + e.getMessage());
            }

            // Verifica se a reflexão será em XY
        } else if (eixo.equals("xy")) {
            try {
                refletida = Matriz.multiplicaMatrizes(gerarMatrizReflexaoXY(), matriz);
            } catch (Exception e) {
                System.err.println("Ocorreu um erro na reflexão em XY. " + e.getMessage());
            }

        }

        // Pega instância do graphics para desenhar no plano cartesiano
        Graphics g = planoCartesiano.getGraphics();
        g.setColor(color);

        g.drawLine(planoCartesiano.getValorCentroX() + (int) refletida[0][0], planoCartesiano.getValorCentroY() - (int) refletida[1][0], planoCartesiano.getValorCentroX() + (int) refletida[0][1], planoCartesiano.getValorCentroY() - (int) refletida[1][1]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) refletida[0][1], planoCartesiano.getValorCentroY() - (int) refletida[1][1], planoCartesiano.getValorCentroX() + (int) refletida[0][2], planoCartesiano.getValorCentroY() - (int) refletida[1][2]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) refletida[0][2], planoCartesiano.getValorCentroY() - (int) refletida[1][2], planoCartesiano.getValorCentroX() + (int) refletida[0][3], planoCartesiano.getValorCentroY() - (int) refletida[1][3]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) refletida[0][3], planoCartesiano.getValorCentroY() - (int) refletida[1][3], planoCartesiano.getValorCentroX() + (int) refletida[0][0], planoCartesiano.getValorCentroY() - (int) refletida[1][0]);

        for (int i = 0; i < refletida[0].length; i++) {
            listaNewPontos.add(new Ponto((int) refletida[0][i], (int) refletida[1][i], (int) refletida[2][i]));
        }
        DialogDesenhaObjetos.setLista(listaNewPontos);
    }

    /**
     * Aplica cisalhamento.
     *
     * @param objeto
     * @param x
     * @param y
     * @param planoCartesiano
     * @param color
     */
    public static void cisalhamento(List<Ponto> objeto, double x, double y, PanelPlanoCartesiano planoCartesiano, Color color) {
        List<Ponto> listaNewPontos = new ArrayList<>();
        double[][] matriz = new double[3][objeto.size()];

        for (int i = 0; i < objeto.size(); i++) {
            matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
            matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
            matriz[2][i] = 1; // Coluna i na linha 2 = 1
        }

        int translacaox = (int) objeto.get(0).getX();
        int translacaoy = (int) objeto.get(0).getY();

        // Translada para origem
        double[][] matrizNaOrigem = translacaoMulti(matriz, -translacaox, -translacaoy);
        System.out.println(-translacaox + " " + -translacaoy);

        // Matriz da cisalha
        double[][] a = null;
        try {
            a = Matriz.multiplicaMatrizes(gerarMatrizCisalhamento(x, y), matrizNaOrigem);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao cisalhar. " + e.getMessage());
        }

        // Transladar para a posição inicial
        double[][] matrizVoltar = translacaoMulti(a, translacaox, translacaoy);

        // Pega instância do graphics para desenhar no plano cartesiano
        Graphics g = planoCartesiano.getGraphics();
        g.setColor(color);

        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][0], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][0], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][1], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][1]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][1], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][1], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][2], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][2]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][2], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][2], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][3], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][3]);
        g.drawLine(planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][3], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][3], planoCartesiano.getValorCentroX() + (int) matrizVoltar[0][0], planoCartesiano.getValorCentroY() - (int) matrizVoltar[1][0]);

        for (int i = 0; i < matrizVoltar[0].length; i++) {
            listaNewPontos.add(new Ponto((int) matrizVoltar[0][i], (int) matrizVoltar[1][i], (int) matrizVoltar[2][i]));
        }
        DialogDesenhaObjetos.setLista(listaNewPontos);
    }

    /**
     * Translada uma matriz.
     *
     * @param matriz
     * @param tx
     * @param ty
     * @return
     */
    private static double[][] translacaoMulti(double[][] matriz, double tx, double ty) {
        try {
            double[][] d = Matriz.multiplicaMatrizes(gerarMatrizTranslacao(tx, ty), matriz);
            return d;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro na translação: " + e.getMessage());
        }
        return matriz;
    }

    /**
     * Translada uma matriz.
     * 
     * @param objeto
     * @param tx
     * @param ty
     * @return 
     */
    public List<Ponto> translacaoMulti(List<Ponto> objeto, int tx, int ty) {
        List<Ponto> list = new ArrayList<>();

        double[][] matriz = new double[3][objeto.size()];

        // Criando o objeto de matriz
        for (int i = 0; i < objeto.size(); i++) {
            matriz[0][i] = objeto.get(i).getX(); // Coluna i na linha 0
            matriz[1][i] = objeto.get(i).getY(); // Coluna i na linha 1
            matriz[2][i] = 1; // Coluna i na linha 2 = 1
        }

        double[][] d = null;
        try {
            d = Matriz.multiplicaMatrizes(gerarMatrizTranslacao(tx, ty), matriz);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro na translação: " + e.getMessage());
        }

        for (int i = 0; i < d[0].length; i++) {
            list.add(new Ponto((int) d[0][i], (int) d[1][i], (int) d[2][i]));
        }
        
        return list;
    }

    /*
    *Gerar o matriz de translacao
     */
    /**
     * Gera matriz de translação.
     *
     * @param tx
     * @param ty
     * @return matriz translação.
     */
    private static double[][] gerarMatrizTranslacao(double tx, double ty) {
        double[][] matriz = new double[3][3];

        matriz[0][0] = 1;
        matriz[0][1] = 0;
        matriz[0][2] = tx;

        matriz[1][0] = 0;
        matriz[1][1] = 1;
        matriz[1][2] = ty;

        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de escala.
     *
     * @param sx
     * @param sy
     * @return matriz de escala
     */
    private static double[][] gerarMatrizEscala(double sx, double sy) {
        double[][] matriz = new double[3][3];
        if (sx == 0) {
            sx = 1;
        }
        if (sy == 0) {
            sy = 1;
        }
        matriz[0][0] = sx;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        matriz[0][1] = 0;
        matriz[1][1] = sy;
        matriz[2][1] = 0;

        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de rotação.
     *
     * @param angulo
     * @return matriz rotação
     */
    private static double[][] gerarMatrizRotacao(double angulo) {
        double[][] matriz2D = new double[3][3];

        double sen = Math.sin(Math.toRadians(angulo));
        double cos = Math.cos(Math.toRadians(angulo));

        // Coluna 0
        matriz2D[0][0] = cos;
        matriz2D[1][0] = sen;
        matriz2D[2][0] = 0;

        // Coluna 1
        matriz2D[0][1] = -sen;
        matriz2D[1][1] = cos;
        matriz2D[2][1] = 0;

        // Coluna 2
        matriz2D[0][2] = 0;
        matriz2D[1][2] = 0;
        matriz2D[2][2] = 1;

        return matriz2D;
    }

    /**
     * Gera matriz de reflexao em X.
     *
     * @return matriz reflexão em x
     */
    private static double[][] gerarMatrizReflexaoX() {
        double[][] matriz = new double[3][3];

        // Coluna 0
        matriz[0][0] = 1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        // Coluna 1
        matriz[0][1] = 0;
        matriz[1][1] = -1;
        matriz[2][1] = 0;

        // Coluna 2
        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de reflexao em Y.
     *
     * @return matriz reflexão em Y
     */
    private static double[][] gerarMatrizReflexaoY() {
        double[][] matriz = new double[3][3];

        // Coluna 0
        matriz[0][0] = -1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        // Coluna 1
        matriz[0][1] = 0;
        matriz[1][1] = 1;
        matriz[2][1] = 0;

        // Coluna 2
        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de reflexão em XY
     *
     * @return matriz reflexão em XY
     */
    private static double[][] gerarMatrizReflexaoXY() {
        double[][] matriz = new double[3][3];

        // Coluna 0
        matriz[0][0] = -1;
        matriz[1][0] = 0;
        matriz[2][0] = 0;

        // Coluna 1
        matriz[0][1] = 0;
        matriz[1][1] = -1;
        matriz[2][1] = 0;

        // Coluna 2
        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de cisalhamento.
     *
     * @param a
     * @param b
     * @return matriz de cisalhamento
     */
    private static double[][] gerarMatrizCisalhamento(double a, double b) {
        double[][] matriz = new double[3][3];

        // Coluna 0
        matriz[0][0] = 1;
        matriz[1][0] = b;
        matriz[2][0] = 0;

        // Coluna 1
        matriz[0][1] = a;
        matriz[1][1] = 1;
        matriz[2][1] = 0;

        // Coluna 2
        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }
}
