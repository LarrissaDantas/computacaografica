package br.edu.uepb.cg.panels;

import br.edu.uepb.cg.App;
import br.edu.uepb.cg.enums.RasterizacaoEnum;
import br.edu.uepb.cg.retas.Ponto;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JTextArea;

/**
 * Representa o menu para manipulação da rasterização de reta
 *
 * @author Douglas Rafael
 */
public class PanelMenuRasterizacao extends javax.swing.JPanel {

    private static PanelMenuRasterizacao instance;

    private Ponto pontoInicial, pontoFinal;
    private Color color;
    private RasterizacaoEnum tipoAlgoritimo;

    public static PanelMenuRasterizacao getInstance() {
        if (instance == null) {
            instance = new PanelMenuRasterizacao();
        }
        return instance;
    }

    /**
     * Construtor
     */
    public PanelMenuRasterizacao() {
        initComponents();
    }

    public Ponto getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(Ponto pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public Ponto getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(Ponto pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public RasterizacaoEnum getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(RasterizacaoEnum tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public JTextArea getTextAreaResult() {
        return textAreaResult;
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
        jPanel4 = new javax.swing.JPanel();
        rbDDA = new javax.swing.JRadioButton();
        rbPontoMedio = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pontoInicialX = new javax.swing.JSpinner();
        pontoInicialY = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pontoFinalX = new javax.swing.JSpinner();
        pontoFinalY = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        panelCor = new javax.swing.JPanel();
        btResolve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResult = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmos de Rasterização da Reta"));

        buttonGroupAlgoritmos.add(rbDDA);
        rbDDA.setSelected(true);
        rbDDA.setText("DDA (Digital Differential Analyser)");
        rbDDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDDAActionPerformed(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbPontoMedio);
        rbPontoMedio.setText("Bresenham (Ponto Médio)");
        rbPontoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPontoMedioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbPontoMedio)
                    .addComponent(rbDDA))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbDDA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(rbPontoMedio)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pontos"));

        jLabel2.setText("Inicial:");

        jLabel3.setText("Final:");

        pontoInicialX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoInicialX.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        pontoInicialX.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoInicialX.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoInicialX.setPreferredSize(new java.awt.Dimension(30, 25));

        pontoInicialY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoInicialY.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        pontoInicialY.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoInicialY.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoInicialY.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("X");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Y");

        pontoFinalX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoFinalX.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        pontoFinalX.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoFinalX.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoFinalX.setPreferredSize(new java.awt.Dimension(30, 25));

        pontoFinalY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoFinalY.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        pontoFinalY.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoFinalY.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoFinalY.setPreferredSize(new java.awt.Dimension(30, 25));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(42, 42, 42))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pontoInicialX, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(pontoFinalX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pontoInicialY, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(pontoFinalY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pontoInicialX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pontoInicialY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pontoFinalY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pontoFinalX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cor da Reta"));

        panelCor.setBackground(new java.awt.Color(213, 33, 33));
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
        btResolve.setText("Desenhar Reta");
        btResolve.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desenharReta(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Iterações"));

        textAreaResult.setColumns(20);
        textAreaResult.setRows(5);
        jScrollPane1.setViewportView(textAreaResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btResolve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbDDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDDAActionPerformed

    private void rbPontoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPontoMedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPontoMedioActionPerformed

    private void openColorChooser(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openColorChooser
        Color newColor = JColorChooser.showDialog(
                PanelMenuRasterizacao.this,
                "Selecione uma nova cor...",
                panelCor.getBackground());

        if (newColor != null) {
            panelCor.setBackground(newColor);
        }
    }//GEN-LAST:event_openColorChooser

    /**
     * Trata o evento click do botão desenhar reta
     *
     * @param evt
     */
    private void desenharReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desenharReta
        // Limpa o textArea de result
        textAreaResult.setText("");

        // Seta a cor selecionada no jPanel 
        setColor(panelCor.getBackground());

        // Seta as coordenadas dos pontos e seta no obejto Ponto
        setPontoInicial(new Ponto((float) pontoInicialX.getValue(), (float) pontoInicialY.getValue()));
        setPontoFinal(new Ponto((float) pontoFinalX.getValue(), (float) pontoFinalY.getValue()));

        // Seta o tipo de algoritmo selecionado
        if (rbDDA.isSelected()) {
            setTipoAlgoritimo(RasterizacaoEnum.DDA);
        } else if (rbPontoMedio.isSelected()) {
            setTipoAlgoritimo(RasterizacaoEnum.PONTO_MEDIO);
        }
        App.runResult(this);
    }//GEN-LAST:event_desenharReta


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btResolve;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCor;
    private javax.swing.JSpinner pontoFinalX;
    private javax.swing.JSpinner pontoFinalY;
    private javax.swing.JSpinner pontoInicialX;
    private javax.swing.JSpinner pontoInicialY;
    private javax.swing.JRadioButton rbDDA;
    private javax.swing.JRadioButton rbPontoMedio;
    private javax.swing.JTextArea textAreaResult;
    // End of variables declaration//GEN-END:variables
}
