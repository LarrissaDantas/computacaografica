/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uepb.cg.filtros;

import br.edu.uepb.cg.processamentodeimagem.Normalizacao;
import java.awt.image.BufferedImage;

/**
 *
 * @author netoe
 */
public class FiltroAltoReforco {

    private int[][] imagem;

    private int width;
    private int height;
    private double coeficienteW;
    private double coeficienteA;

    public FiltroAltoReforco(int[][] imagem, double coeficienteA, int width, int height) {
        this.imagem = imagem;
        this.width = width;
        this.height = height;
        this.coeficienteA = coeficienteA;
        this.coeficienteW = (9 * coeficienteA) - 1;
    }

    public FiltroAltoReforco() {
    }

    public double getCoeficienteW() {
        return coeficienteW;
    }

    public void setCoeficienteW(double coeficienteW) {
        this.coeficienteW = coeficienteW;
    }

    public double getCoeficienteA() {
        return coeficienteA;
    }

    public void setCoeficienteA(double coeficienteA) {
        this.coeficienteA = coeficienteA;
    }

    public int[][] getImagemMatriz() {
        return imagem;
    }

    public void setImagemMatriz(int[][] imagemMatriz) {
        this.imagem = imagemMatriz;
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
        int CoeficienteDeNormalizacao = 0;
        int matrizImagem[][] = new int[getWidth()][getHeight()];
        
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                CoeficienteDeNormalizacao = CoeficienteDeNormalizacao + imagem[i][j];
            }
        }

        // Máscara
        // -1/9 -1/9 -1/9
        // -1/9  w/9 -1/9
        // -1/9 -1/9 -1/9
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {

                int soma = 0;

                // Pixel central multiplicado por 8
                soma += this.coeficienteW * imagem[i][j];

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
