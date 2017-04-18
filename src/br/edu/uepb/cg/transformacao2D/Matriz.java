package br.edu.uepb.cg.transformacao2D;

/**
 * Fornece métodos para operações em matrizes.
 *
 * @author Geovannio Vinhas
 * @author Douglas Rafael
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
        double[][] matrizResultado = new double[matrizA.length][matrizB[0].length];

        if (matrizA[0].length != matrizB.length) {
            throw new Exception("O tamanho das matrizes são incompatíveis para a operação!");
        }

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
                for (int k = 0; k < matrizA[0].length; k++) {
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        
        return matrizResultado;
    }
    
    /**
     * Imprime valores da matriz passada como parâmetro.
     * 
     * @param matriz 
     * @param title 
     */
    public static void printMatriz(double[][] matriz, String title) {
        System.out.println("======== " + title.toUpperCase() + " ======== ");
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
