package br.edu.uepb.cg.transformacoes;

import br.edu.uepb.cg.processamentodeimagem.Normalizacao;
import java.awt.image.BufferedImage;

/**
 *
 * @author geovanniovinhas
 */
public class Logaritmo {
    private int[][] imagem;
    private int width;
    private int height;
    private float constanteA;

    public Logaritmo(int[][] imagem, int width, int height, float constanteA) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.constanteA = constanteA;
    }

    public int[][] getImagem() {
        return imagem;
    }

    public void setImagem(int[][] imagem) {
        this.imagem = imagem;
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

    public float getConstanteA() {
        return constanteA;
    }

    public void setConstanteA(float constanteA) {
        this.constanteA = constanteA;
    }
    
    public BufferedImage run(){
        int matrizImagem[][] = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrizImagem[i][j] = (int)(constanteA * (Math.log(imagem[i][j] + 1)));
            }
        }
        return Normalizacao.normalizaImage(matrizImagem);
    }
}
