package br.edu.uepb.cg.filtros;

import br.edu.uepb.cg.panels.PanelFiltros;
import br.edu.uepb.cg.processamentodeimagem.Normalizacao;
import java.awt.image.BufferedImage;

/**
 *
 * @author Douglas Rafael
 */
public class FiltroPassaAlta {

    PanelFiltros panelFiltros;
    private int[][] imagemMatriz;
    private int imagem[][];
    private int width;
    private int height;

    public FiltroPassaAlta(int imagem[][], int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
    }

    public FiltroPassaAlta() {
    }

    public int[][] getImagemMatriz() {
        return imagemMatriz;
    }

    public void setImagemMatriz(int[][] imagemMatriz) {
        this.imagemMatriz = imagemMatriz;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage run() {
        int matrizImagem[][] = new int[getWidth()][getHeight()];

        // Máscara
        // -1 -1 -1
        // -1  8 -1
        // -1 -1 -1
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {

                int soma = 0;

                // Pixel central multiplicado por 8
                soma += 8 * imagem[i][j];

                //para os demais pixels, multiplica por -1
                if ((i - 1) >= 0) {
                    soma += -1 * imagem[i - 1][j];
                }
                if ((i + 1) < getWidth()) {
                    soma += -1 * imagem[i + 1][j];
                }
                if ((j - 1) >= 0) {
                    soma += -1 * imagem[i][j - 1];
                }
                if ((j + 1) < getHeight()) {
                    soma += -1 * imagem[i][j + 1];
                }
                if (((i - 1) >= 0) && ((j - 1) >= 0)) {
                    soma += -1 * imagem[i - 1][j - 1];
                }
                if (((i + 1) < getWidth()) && ((j - 1) >= 0)) {
                    soma += -1 * imagem[i + 1][j - 1];
                }
                if (((i - 1) >= 0) && ((j + 1) < getHeight())) {
                    soma += -1 * imagem[i - 1][j + 1];
                }
                if (((i + 1) < getWidth()) && ((j + 1) < getHeight())) {
                    soma += -1 * imagem[i + 1][j + 1];
                }

                // na posição atual, faz a soma e divide por 9, o resultado é inserido na posição [i][j]
                matrizImagem[i][j] = (int) (soma / 9);
            }
        }

        return Normalizacao.normalizaImage(matrizImagem);
    }
}
