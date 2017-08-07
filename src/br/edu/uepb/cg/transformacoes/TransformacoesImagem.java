package br.edu.uepb.cg.transformacoes;

import br.edu.uepb.cg.enums.Eixo;
import br.edu.uepb.cg.panels.PanelMenu2D;
import br.edu.uepb.cg.panels.PanelMenuImagem;
import br.edu.uepb.cg.panels.PanelPlanoCartesiano;
import br.edu.uepb.cg.retas.Ponto;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Stack;
import javax.swing.JPanel;

/**
 * Métodos para transformações 2D.
 *
 * @author Geovannio Vinhas
 * @author Douglas Rafael
 */
public class TransformacoesImagem {

    private static TransformacoesImagem instance;

    private double[][] matrizM;

    private TransformacoesImagem() {
    }

    public static synchronized TransformacoesImagem getInstance() {
        if (instance == null) {
            instance = new TransformacoesImagem();
        }
        return instance;
    }

    /**
     * Aplica translação no objeto passado como parametro e de acordo com os
     * fatores de translação.
     *
     * @param img
     * @param tx
     * @param ty
     */
    public void translacao(Imagem img, double tx, double ty) {
//        int w = img.getWidth() + (int) Math.abs(tx);
//        int h = img.getHeight() + (int) Math.abs(ty);
//        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//        Imagem imgResult = new Imagem();
//
//        try {
//            int x, y;
//            double[][] m_temp = new double[3][1];
//            for (int row = 0; row < img.getWidth(); row++) {
//                for (int col = 0; col < img.getHeight(); col++) {
//                    m_temp[0][0] = row;
//                    m_temp[1][0] = col;
//                    m_temp[2][0] = 1;
//
//                    m_temp = Matriz.multiplicaMatrizes(TransformacoesImagem.getInstance().geraMatrizTranslacao(tx, 0), m_temp);
//                    x = (int) m_temp[0][0];
//                    y = (int) m_temp[1][0];
//
//                    bufferedImage.setRGB(x, y, PanelPlanoCartesiano.getInstance().getCorPixel(img.getMatrizPixel()[row][col]));
//                }
//            }
//
//            imgResult.setMatrizPixel(img.getMatrizPixel());
//            imgResult.setBufferedImage(bufferedImage);
//
//            PanelMenuImagem.imagem = imgResult;
//        } catch (Exception e) {
//            System.err.println("Ocorreu um erro na translação!\n" + e.getMessage());
//        }

        // Atualiza o ponto da imagem com o valor da translação
        img.setPonto(new Ponto(img.getPonto().getX() + tx, img.getPonto().getY() + ty));

        /**
         * Aplica a translação usando o AffineTransform
         */
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(img.getPonto().getX(), -img.getPonto().getY());

        // Chama o método responsável para tratar a imagem e desenhar no plano cartesiano
        PanelPlanoCartesiano.getInstance().drawImage(img, affineTransform);
    }

    /**
     * Aplica rotacao no objeto passado como parametro, de acordo com angulo.
     *
     * @param imagem
     * @param angulo
     */
    public void rotacao(Imagem imagem, double angulo) {
        PanelPlanoCartesiano panel = PanelPlanoCartesiano.getInstance();
        panel.redesenha();

        AffineTransform affineTransform = new AffineTransform();
        BufferedImage rotated;

        double rads = Math.toRadians(angulo);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = imagem.getWidth();
        int h = imagem.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
//            at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = (int) imagem.getPonto().getX();
        int y = (int) imagem.getPonto().getY();

        Graphics2D g2d = (Graphics2D) panel.getGraphics();

        at.rotate(Math.toRadians(angulo), x, y);
        g2d.setTransform(at);
        g2d.drawImage(imagem.getBufferedImage(), panel.getValorCentroX(), panel.getValorCentroY(), null);

//        affineTransform.translate(imagem.getPonto().getX(), -imagem.getPonto().getY());
//        PanelPlanoCartesiano.getInstance().drawImage(imagem, affineTransform);
//        PanelPlanoCartesiano panel = PanelPlanoCartesiano.getInstance();
//        Graphics2D g2d = (Graphics2D) panel.getGraphics();
//        g2d.setTransform(affineTransform);
//        panel.redesenha();
//        
//        g2d.drawImage(imagem.getBufferedImage(), panel.getValorCentroX(), panel.getValorCentroY(), null);
    }

    /**
     * Aplica escala no objeto passado como parametro, de acordo com os fatores
     * de escala.
     *
     * @param matrizObjeto
     * @param sx
     * @param sy
     * @return double[][] - Matriz resultado.
     */
    public void escala(Imagem imagem, double sx, double sy) {
//        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
//
//        // Fatores de translação.
//        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0];
//
//        try {
//            // (Matriz translação posição inicial) X (Matriz Escala)
//            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizEscala(sx, sy));
//
//            // (Matriz M) X (Matriz translação para origem)
//            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));
//
//            // (Matriz M) X (Matriz objeto)
//            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);
//
//            // Atualiza matriz objeto global.
//            PanelMenu2D.matrizObjeto = matrizResult;
//        } catch (Exception e) {
//            System.err.println("Ocorreu um erro na escala!");
//        }

        /**
         * Aplica a translação usando o AffineTransform
         */
        PanelPlanoCartesiano panel = PanelPlanoCartesiano.getInstance();
        AffineTransform affineTransform = new AffineTransform();

//        affineTransform.translate(0, 0);
//        affineTransform.scale(sx, sy);
//        affineTransform.scale(sx, sy);
//        affineTransform.translate(panel.getValorCentroX() + imagem.getPonto().getX(), panel.getValorCentroY());
//        affineTransform.translate(panel.getValorCentroX(), panel.getValorCentroY() - imagem.getBufferedImage().getHeight()); // origem
//        affineTransform.translate(imagem.getPonto().getX(), -imagem.getPonto().getY());
//        affineTransform.translate(imagem.getPonto().getX(), panel.getValorCentroY() - imagem.getBufferedImage().getHeight()); // origem
        // Chama o método responsável para tratar a imagem e desenhar no plano cartesiano
        panel.redesenha();
        Graphics2D g2d = (Graphics2D) panel.getGraphics();
//        g2d.setTransform(affineTransform);

        BufferedImage bufferedImg = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int row = 0; row < imagem.getBufferedImage().getWidth(); row++) {
            for (int col = 0; col < imagem.getBufferedImage().getHeight(); col++) {
                // Prepara a imagem para ser desenhada no jpanel
                bufferedImg.setRGB(row, col, panel.getCorPixel(imagem.getMatrizPixel()[row][col]));
            }
        }
        imagem.setBufferedImage(bufferedImg);
        
        AffineTransform at = new AffineTransform();
        at.scale(sx, sy);
        double fatorX = (sx > 1) ? (imagem.getBufferedImage().getHeight() * sx)/2 : 0;
        double fatorY = imagem.getBufferedImage().getHeight() * sy;
        System.out.println("X:" + fatorX + " Y:" +fatorY);
        
        at.translate((int)(panel.getValorCentroX() - fatorX), (int) (panel.getValorCentroY() - fatorY));
//        g2d.setTransform(at);


        
//        g2d.drawImage(imagem.getBufferedImage(), (int)(panel.getValorCentroX() - at.getScaleX() - bufferedImg.getWidth()), (int) (panel.getValorCentroY() - at.getScaleY()), null);
        g2d.drawImage(imagem.getBufferedImage(), at, null);

//        PanelPlanoCartesiano.getInstance().drawImage(imagem, affineTransform);
    }

    /**
     * Aplica reflexão no objeto passado como parametro, de acordo com o eixo
     * escolhido
     *
     * @param matrizObjeto
     * @param eixo
     * @return double[][] - Matriz resultado.
     */
    public double[][] reflexao(double[][] matrizObjeto, String eixo) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
        eixo = eixo.toUpperCase();

        try {
            matrizResult = Matriz.multiplicaMatrizes(geraMatrizReflexao(eixo), matrizObjeto);
            // Atualiza matriz objeto global.
            PanelMenu2D.matrizObjeto = matrizResult;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro na reflexão em: " + eixo + "!");
        }

        return matrizResult;
    }

    /**
     * Aplica cisalhamento no objeto passado como parametro, de acordo com os
     * fatores a e b.
     *
     * @param matrizObjeto
     * @param cx
     * @param cy
     * @return double[][] - Matriz resultado.
     */
    public double[][] cisalhamento(double[][] matrizObjeto, double cx, double cy) {
        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];

        // Fatores de translação.
        double tx = matrizObjeto[0][0], ty = matrizObjeto[1][0];

        try {
            // (Matriz translação posição inicial) X (Matriz Cisalhamento)
            matrizM = Matriz.multiplicaMatrizes(geraMatrizTranslacao(tx, ty), geraMatrizCisalhamento(cx, cy));

            // (Matriz M) X (Matriz translação para origem)
            matrizM = Matriz.multiplicaMatrizes(matrizM, geraMatrizTranslacao(-tx, -ty));

            // (Matriz M) X (Matriz objeto)
            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);

            // Atualiza matriz objeto global.
            PanelMenu2D.matrizObjeto = matrizResult;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro no cisalhamento!");
        }

        return matrizResult;
    }

    /**
     * Aplica as opeçãoes compostas.
     *
     * @param listaDeTransformacoes
     * @param matrizObjeto
     * @return double[][] - Matriz resultado.
     */
    public double[][] composta(Stack<double[][]> listaDeTransformacoes, double[][] matrizObjeto) {
        Stack<double[][]> listaDeTransformacoesCopy = (Stack<double[][]>) listaDeTransformacoes.clone();

        double[][] matrizResult = new double[matrizObjeto.length][matrizObjeto[0].length];
        matrizM = listaDeTransformacoesCopy.pop();

        try {
            while (!listaDeTransformacoesCopy.isEmpty()) {
                matrizM = Matriz.multiplicaMatrizes(matrizM, listaDeTransformacoesCopy.pop());
            }

            matrizResult = Matriz.multiplicaMatrizes(matrizM, matrizObjeto);

            // Atualiza matriz objeto global.
            PanelMenu2D.matrizObjeto = matrizResult;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro nas transformações compostas!");
        }

        return matrizResult;
    }

    /**
     * Gera matriz de translação.
     *
     * @param tx
     * @param ty
     * @return double[][] - matriz translação.
     */
    public double[][] geraMatrizTranslacao(double tx, double ty) {
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
     * @return double[][] - matriz de escala.
     */
    public double[][] geraMatrizEscala(double sx, double sy) {
        double[][] matriz = new double[3][3];
        sx = (sx == 0) ? 1 : sx;
        sy = (sy == 0) ? 1 : sy;

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
     * @return double[][] - matriz rotação.
     */
    public double[][] geraMatrizRotacao(double angulo) {
        double[][] matriz = new double[3][3];

        double sen = Math.sin(Math.toRadians(angulo));
        double cos = Math.cos(Math.toRadians(angulo));

        // Coluna 0
        matriz[0][0] = cos;
        matriz[1][0] = sen;
        matriz[2][0] = 0;

        // Coluna 1
        matriz[0][1] = -sen;
        matriz[1][1] = cos;
        matriz[2][1] = 0;

        // Coluna 2
        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }

    /**
     * Gera matriz de reflexão em torno do eixo passado como par"ametro X, Y ou
     * XY.
     *
     * @return double[][] - matriz reflexão.
     */
    public double[][] geraMatrizReflexao(String eixo) {
        double[][] matriz = new double[3][3];

        eixo = eixo.toUpperCase();

        // Rotação em XY
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

        // Rotação em X
        if (eixo.equals(Eixo.X.getValue())) {
            matriz[0][0] = 1;
        } else if (eixo.equals(Eixo.Y.getValue())) {
            matriz[1][1] = 1;
        }

        return matriz;
    }

    /**
     * Gera matriz de cisalhamento.
     *
     * @param cx
     * @param cy
     * @return matriz de cisalhamento.
     */
    public double[][] geraMatrizCisalhamento(double cx, double cy) {
        double[][] matriz = new double[3][3];

        // Coluna 0
        matriz[0][0] = 1;
        matriz[1][0] = cy;
        matriz[2][0] = 0;

        // Coluna 1
        matriz[0][1] = cx;
        matriz[1][1] = 1;
        matriz[2][1] = 0;

        // Coluna 2
        matriz[0][2] = 0;
        matriz[1][2] = 0;
        matriz[2][2] = 1;

        return matriz;
    }
}
