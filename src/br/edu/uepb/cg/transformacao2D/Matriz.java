package br.edu.uepb.cg.transformacao2D;

/**
 * Métodos para operações de matrizes
 * 
 * @author Geovannio
 */
public class Matriz {

    /**
     * Realiza multiplicação de matriz e retorna uma nova com o resultado.
     * 
     * @param matrizA
     * @param matrizB
     * @return
     * @throws Exception 
     */
    public static double[][] multiplicaMatrizes(double[][] matrizA, double[][] matrizB) throws Exception {
        //Metodo que multiplica matrizes 

        int colunaB = matrizB[0].length;
        if (matrizA[0].length == matrizB.length) {

            double[][] matrizResultado = new double[3][matrizB[0].length];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < colunaB; j++) {
                    for (int k = 0; k < 3; k++) {
                        matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }
            return matrizResultado;
        } else {
            throw new Exception("Erro ao multiplicar a matriz.");
        }
    }

    public static double[][] multiplicaMatrizes3D(double[][] matrizA, double[][] matrizB) throws Exception {
        //Metodo que multiplica matrizes da aplicao 3D

        int coluna = matrizB[0].length;
        if (matrizA[0].length == matrizB.length) {
            double[][] matrizResultado = new double[4][matrizB[0].length];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < coluna; j++) {
                    for (int k = 0; k < 4; k++) {
                        matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }
            return matrizResultado;
        } else {
            throw new Exception("Erro ao multiplicar a matriz.");
        }
    }
}
