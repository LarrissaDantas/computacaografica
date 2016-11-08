package br.edu.uepb.cg.filtros;

import br.edu.uepb.cg.panels.PanelFiltros;
import br.edu.uepb.cg.processamentodeimagem.Normalizacao;
import java.awt.image.BufferedImage;

/**
 *
 * @author Douglas Rafael
 */
public class FiltroSobel {

    PanelFiltros panelFiltros;
    private int[][] imagemMatriz;
    private int imagem[][];
    private int width;
    private int height;

    public FiltroSobel(int imagem[][], int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
    }

    public FiltroSobel() {
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

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                int fatA = 0;
                int fatB = 0;
                int fatC = 0;
                int fatD = 0;
                
                if ((i - 1) >= 0) {
                    fatD += 2 * imagem[i - 1][j];
                }
                if ((i + 1) < getWidth()) {
                    fatC += 2 * imagem[i + 1][j];
                }
                if ((j - 1) >= 0) {
                    fatB += 2 * imagem[i][j - 1];
                }
                if ((j + 1) < getHeight()) {
                    fatA += 2 * imagem[i][j + 1];
                }
                if (((i - 1) >= 0) && ((j - 1) >= 0)) {
                    fatB += imagem[i - 1][j - 1];
                    fatD += imagem[i - 1][j - 1];
                }
                if (((i + 1) < getWidth()) && ((j - 1) >= 0)) {
                    fatB += imagem[i + 1][j - 1];
                    fatC += imagem[i + 1][j - 1];
                }
                if (((i - 1) >= 0) && ((j + 1) < getHeight())) {
                    fatA += imagem[i - 1][j + 1];
                    fatD += imagem[i - 1][j + 1];
                }
                if (((i + 1) < getWidth()) && ((j + 1) < getHeight())) {
                    fatA += imagem[i + 1][j + 1];
                    fatC += imagem[i + 1][j + 1];;
                }

                int aux1 = fatA - fatB;
                int aux2 = fatC - fatD;

                matrizImagem[i][j] = Math.abs(aux1) + Math.abs(aux2);
            }

        }

        return Normalizacao.normalizaImage(matrizImagem);
    }
}
