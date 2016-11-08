package br.edu.uepb.cg.panels;

import br.edu.uepb.cg.App;
import static br.edu.uepb.cg.dialog.DialogDesenhaObjetos.listaGLOBAL;
import br.edu.uepb.cg.enums.TransformacoesEnum;
import br.edu.uepb.cg.retas.Ponto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JColorChooser;

/**
 * Representa o menu para manipulação das transformações 2D
 *
 * @author Douglas Rafael e Geovannio
 */
public class PanelMenu2D extends javax.swing.JPanel {

    private static PanelMenu2D instance;

    private Rectangle2D.Double rect;
    private double valorX, valorY; // usando na translacao, escala, cisalhamento
    private Ponto ponto;
    private double angulo; // usado na  rotacao
    private String eixo; // usado na reflexao

    private Color color;
    private TransformacoesEnum tipoAlgoritimo;

    public static PanelMenu2D getInstance() {
        if (instance == null) {
            instance = new PanelMenu2D();
        }
        return instance;
    }

    /**
     * Construtor
     */
    private PanelMenu2D() {
        initComponents();

        setColor(Color.BLUE);
        panelDados2.setVisible(false);
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValorY() {
        return valorY;
    }

    public void setValorY(double valorY) {
        this.valorY = valorY;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double raio) {
        this.angulo = raio;
    }

    public Rectangle2D.Double getRect() {
        return rect;
    }

    public void setRect(Rectangle2D.Double rect) {
        this.rect = rect;
    }

    public String getEixo() {
        return eixo;
    }

    public void setEixo(String eixo) {
        this.eixo = eixo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public TransformacoesEnum getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(TransformacoesEnum tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlgoritmos = new javax.swing.ButtonGroup();
        buttonGroupReflexao = new javax.swing.ButtonGroup();
        buttonGroupObjetos = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        rbTranslacao = new javax.swing.JRadioButton();
        rbRotacao = new javax.swing.JRadioButton();
        rbEscala = new javax.swing.JRadioButton();
        rbReflexao = new javax.swing.JRadioButton();
        rbCisalhamento = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        panelCor = new javax.swing.JPanel();
        btResolve = new javax.swing.JButton();
        panelDados1 = new javax.swing.JPanel();
        valorDado1 = new javax.swing.JSpinner();
        lbDado1 = new javax.swing.JLabel();
        lbDado2 = new javax.swing.JLabel();
        valorDado2 = new javax.swing.JSpinner();
        panelDados2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        panelObjeto = new javax.swing.JPanel();
        spinnerX = new javax.swing.JSpinner();
        spinnerY = new javax.swing.JSpinner();
        radioRect = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btResolve1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Transformações"));

        buttonGroupAlgoritmos.add(rbTranslacao);
        rbTranslacao.setSelected(true);
        rbTranslacao.setText("Translação");
        rbTranslacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbRotacao);
        rbRotacao.setText("Rotação");
        rbRotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbEscala);
        rbEscala.setText("Escala");
        rbEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbReflexao);
        rbReflexao.setText("Reflexão");
        rbReflexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbCisalhamento);
        rbCisalhamento.setText("Cisalhamento");
        rbCisalhamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbRotacao)
                    .addComponent(rbTranslacao)
                    .addComponent(rbEscala)
                    .addComponent(rbReflexao)
                    .addComponent(rbCisalhamento))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbTranslacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbEscala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbRotacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbReflexao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCisalhamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cor do Objeto"));

        panelCor.setBackground(java.awt.Color.blue);
        panelCor.setToolTipText("Click para selecionar uma nova cor");
        panelCor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openColorChooser(evt);
            }
        });

        javax.swing.GroupLayout panelCorLayout = new javax.swing.GroupLayout(panelCor);
        panelCor.setLayout(panelCorLayout);
        panelCorLayout.setHorizontalGroup(
            panelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCorLayout.setVerticalGroup(
            panelCorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btResolve.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btResolve.setText("Aplicar Transformação");
        btResolve.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicaTransformacao(evt);
            }
        });

        panelDados1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        valorDado1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorDado1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        valorDado1.setMaximumSize(new java.awt.Dimension(30, 25));
        valorDado1.setMinimumSize(new java.awt.Dimension(30, 25));
        valorDado1.setPreferredSize(new java.awt.Dimension(30, 25));

        lbDado1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDado1.setText("X");

        lbDado2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDado2.setText("Y");

        valorDado2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorDado2.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        valorDado2.setMaximumSize(new java.awt.Dimension(30, 25));
        valorDado2.setMinimumSize(new java.awt.Dimension(30, 25));
        valorDado2.setPreferredSize(new java.awt.Dimension(30, 25));

        javax.swing.GroupLayout panelDados1Layout = new javax.swing.GroupLayout(panelDados1);
        panelDados1.setLayout(panelDados1Layout);
        panelDados1Layout.setHorizontalGroup(
            panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(valorDado1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(valorDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(panelDados1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbDado1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDado2)
                .addGap(63, 63, 63))
        );
        panelDados1Layout.setVerticalGroup(
            panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados1Layout.createSequentialGroup()
                .addGroup(panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDado1)
                    .addComponent(lbDado2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorDado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorDado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDados2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        buttonGroupReflexao.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Reflexão em X");

        buttonGroupReflexao.add(jRadioButton2);
        jRadioButton2.setText("Reflexão em Y");

        buttonGroupReflexao.add(jRadioButton3);
        jRadioButton3.setText("Reflexão em X e Y");

        javax.swing.GroupLayout panelDados2Layout = new javax.swing.GroupLayout(panelDados2);
        panelDados2.setLayout(panelDados2Layout);
        panelDados2Layout.setHorizontalGroup(
            panelDados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDados2Layout.setVerticalGroup(
            panelDados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton3))
        );

        panelObjeto.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar Objeto"));

        spinnerX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinnerX.setModel(new javax.swing.SpinnerNumberModel(100, null, null, 1));
        spinnerX.setMaximumSize(new java.awt.Dimension(30, 25));
        spinnerX.setMinimumSize(new java.awt.Dimension(30, 25));
        spinnerX.setPreferredSize(new java.awt.Dimension(30, 25));

        spinnerY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinnerY.setModel(new javax.swing.SpinnerNumberModel(100, null, null, 1));
        spinnerY.setMaximumSize(new java.awt.Dimension(30, 25));
        spinnerY.setMinimumSize(new java.awt.Dimension(30, 25));
        spinnerY.setPreferredSize(new java.awt.Dimension(30, 25));

        buttonGroupObjetos.add(radioRect);
        radioRect.setSelected(true);
        radioRect.setText("Retângulo");

        jLabel1.setText("Largura");

        jLabel2.setText("Altura");

        javax.swing.GroupLayout panelObjetoLayout = new javax.swing.GroupLayout(panelObjeto);
        panelObjeto.setLayout(panelObjetoLayout);
        panelObjetoLayout.setHorizontalGroup(
            panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObjetoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(spinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelObjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioRect)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelObjetoLayout.setVerticalGroup(
            panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelObjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioRect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btResolve1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btResolve1.setText("Criar Objeto");
        btResolve1.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarObjeto(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btResolve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelObjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btResolve1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btResolve1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDados2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que abre e seta a cor do JColorChooser no objeto contido no plano
     * cartesiano.
     *
     * @param evt
     */
    private void openColorChooser(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openColorChooser
        Color newColor = JColorChooser.showDialog(PanelMenu2D.this,
                "Selecione uma nova cor...",
                panelCor.getBackground());

        if (newColor != null) {
            // Seta a cor selecionada no jPanel 
            panelCor.setBackground(newColor);
            setColor(panelCor.getBackground());
        }
    }//GEN-LAST:event_openColorChooser

    /**
     * Aplica a transformação selecionada.
     *
     * @param evt
     */
    private void aplicaTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicaTransformacao
        setColor(panelCor.getBackground());

        /**
         * Seta o tipo de algoritmo selecionado e seus parametros necessários
         */
        if (rbTranslacao.isSelected()) {
            setTipoAlgoritimo(TransformacoesEnum.TRANSLACAO);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
        } else if (rbEscala.isSelected()) {
            setTipoAlgoritimo(TransformacoesEnum.ESCALA);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());

        } else if (rbRotacao.isSelected()) {
            setTipoAlgoritimo(TransformacoesEnum.ROTACAO);
            setAngulo((double) valorDado1.getValue());

        } else if (rbReflexao.isSelected()) {
            setTipoAlgoritimo(TransformacoesEnum.REFLEXAO);
            if (jRadioButton1.isSelected()) {
                setEixo("x");
            } else if (jRadioButton2.isSelected()) {
                setEixo("y");
            } else if (jRadioButton3.isSelected()) {
                setEixo("xy");
            }
        } else if (rbCisalhamento.isSelected()) {
            setTipoAlgoritimo(TransformacoesEnum.CISALHAMENTO);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
        }

        App.runResult(this);
    }//GEN-LAST:event_aplicaTransformacao

    /**
     * Prepara o menu de acordo com o tipo de transformação selecionada
     *
     * @param evt
     */
    private void selectedTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedTransformacao
        panelDados1.setVisible(true);
        panelDados2.setVisible(false);
        
        valorDado1.setValue(0D);
        valorDado2.setValue(0D);

        if (rbRotacao.isSelected()) {
            lbDado1.setText("Ângulo");
            lbDado2.setVisible(false);
            valorDado2.setVisible(false);
        } else if (rbReflexao.isSelected()) {
            panelDados1.setVisible(false);
            panelDados2.setVisible(true);
        } else {
            lbDado1.setText("X");
            lbDado2.setVisible(true);
            valorDado2.setVisible(true);
        }
    }//GEN-LAST:event_selectedTransformacao

    private void aplicarObjeto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarObjeto
        desenharObjeto();
    }//GEN-LAST:event_aplicarObjeto


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btResolve;
    private javax.swing.JButton btResolve1;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.ButtonGroup buttonGroupObjetos;
    private javax.swing.ButtonGroup buttonGroupReflexao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDado1;
    private javax.swing.JLabel lbDado2;
    private javax.swing.JPanel panelCor;
    private javax.swing.JPanel panelDados1;
    private javax.swing.JPanel panelDados2;
    private javax.swing.JPanel panelObjeto;
    private javax.swing.JRadioButton radioRect;
    private javax.swing.JRadioButton rbCisalhamento;
    private javax.swing.JRadioButton rbEscala;
    private javax.swing.JRadioButton rbReflexao;
    private javax.swing.JRadioButton rbRotacao;
    private javax.swing.JRadioButton rbTranslacao;
    private javax.swing.JSpinner spinnerX;
    private javax.swing.JSpinner spinnerY;
    private javax.swing.JSpinner valorDado1;
    private javax.swing.JSpinner valorDado2;
    // End of variables declaration//GEN-END:variables

    private void desenharObjeto() {
        listaGLOBAL = new ArrayList<>();

        if (radioRect.isSelected()) {
            int width = (int) spinnerX.getValue();
            int height = (int) spinnerY.getValue();

            listaGLOBAL.add(new Ponto(0, 0)); // A
            listaGLOBAL.add(new Ponto(width, 0)); // B
            listaGLOBAL.add(new Ponto(width, height)); // C
            listaGLOBAL.add(new Ponto(0, height)); // D

            /**
             * Pega a instancia do plano cartesiano para limpa-lo
             */
            PanelPlanoCartesiano panelPlanoCartesiano = PanelPlanoCartesiano.getInstance();
            panelPlanoCartesiano.redesenha();

            // pega instancia do PanelMenu2D para acessar a cor selecionada
            PanelMenu2D menu2D = PanelMenu2D.getInstance();

            // Pega a instancia do graphics para desenhar no plano cartesiano    
            Graphics g2D = (Graphics) panelPlanoCartesiano.getGraphics();
            g2D.setColor(menu2D.getColor());

            // Desenha o retangulo
            g2D.drawRect(panelPlanoCartesiano.getValorCentroX(), panelPlanoCartesiano.getValorCentroY() - height, width, height);
        }
    }
}
