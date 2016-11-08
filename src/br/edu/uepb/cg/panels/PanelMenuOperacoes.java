package br.edu.uepb.cg.panels;

import br.edu.uepb.cg.enums.OperacoesEnum;
import javax.swing.JRadioButton;

/**
 * Representa o menu para manipulação da circunferência
 *
 * @author Douglas Rafael
 */
public class PanelMenuOperacoes extends javax.swing.JPanel {

    private static PanelMenuOperacoes instance;
    private OperacoesEnum tipoAlgoritimo;

    public static PanelMenuOperacoes getInstance() {
        if (instance == null) {
            instance = new PanelMenuOperacoes();
        }
        return instance;
    }

    /**
     * Construtor
     */
    public PanelMenuOperacoes() {
        initComponents();
    }

    public OperacoesEnum getTipoAlgoritimo() {
        if (rbAdicao.isSelected()) {
            tipoAlgoritimo = OperacoesEnum.ADICAO;
        } else if (rbSubstracao.isSelected()) {
            tipoAlgoritimo = OperacoesEnum.SUBSTRACAO;
        } else if (rbMultiplicacao.isSelected()) {
            tipoAlgoritimo = OperacoesEnum.MULTIPLICACAO;
        } else if (rbDivisao.isSelected()) {
            tipoAlgoritimo = OperacoesEnum.DIVISAO;
        } else if (rbAND.isSelected()) {
            tipoAlgoritimo = OperacoesEnum.AND;
        } else if (rbOR.isSelected()) {
            tipoAlgoritimo = OperacoesEnum.OR;
        } else if (rbXOR.isSelected()) {
            tipoAlgoritimo = OperacoesEnum.XOR;
        }
        
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(OperacoesEnum tipoAlgoritimo) {
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

        buttonGroupFiltros = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        rbAdicao = new javax.swing.JRadioButton();
        rbSubstracao = new javax.swing.JRadioButton();
        rbMultiplicacao = new javax.swing.JRadioButton();
        rbDivisao = new javax.swing.JRadioButton();
        rbOR = new javax.swing.JRadioButton();
        rbXOR = new javax.swing.JRadioButton();
        rbAND = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Operações"));

        buttonGroupFiltros.add(rbAdicao);
        rbAdicao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbAdicao.setSelected(true);
        rbAdicao.setText("Adição");
        rbAdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosSelect(evt);
            }
        });

        buttonGroupFiltros.add(rbSubstracao);
        rbSubstracao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbSubstracao.setText("Substração");
        rbSubstracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosSelect(evt);
            }
        });

        buttonGroupFiltros.add(rbMultiplicacao);
        rbMultiplicacao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbMultiplicacao.setText("Multiplicação");
        rbMultiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosSelect(evt);
            }
        });

        buttonGroupFiltros.add(rbDivisao);
        rbDivisao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbDivisao.setText("Divisão");
        rbDivisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosSelect(evt);
            }
        });

        buttonGroupFiltros.add(rbOR);
        rbOR.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbOR.setText("OR");
        rbOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosSelect(evt);
            }
        });

        buttonGroupFiltros.add(rbXOR);
        rbXOR.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbXOR.setText("XOR");
        rbXOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosSelect(evt);
            }
        });

        buttonGroupFiltros.add(rbAND);
        rbAND.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rbAND.setText("AND");
        rbAND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosSelect(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAdicao)
                            .addComponent(rbSubstracao)
                            .addComponent(rbMultiplicacao)
                            .addComponent(rbDivisao)
                            .addComponent(rbOR)
                            .addComponent(rbAND)
                            .addComponent(rbXOR))
                        .addGap(0, 89, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAdicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSubstracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbMultiplicacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDivisao)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbOR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAND)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbXOR)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(505, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filtrosSelect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrosSelect
        JRadioButton radio = (JRadioButton) evt.getSource();
        PanelOperacoes.getInstance().setTitle("Operação de " + radio.getText());
        PanelOperacoes.panelImgOutput.repaint();
    }//GEN-LAST:event_filtrosSelect


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFiltros;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbAND;
    private javax.swing.JRadioButton rbAdicao;
    private javax.swing.JRadioButton rbDivisao;
    private javax.swing.JRadioButton rbMultiplicacao;
    private javax.swing.JRadioButton rbOR;
    private javax.swing.JRadioButton rbSubstracao;
    private javax.swing.JRadioButton rbXOR;
    // End of variables declaration//GEN-END:variables
}
