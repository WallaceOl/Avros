/*
 * Copyright (C) 2015 Allsoft
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.allsoft.avros.interfaces;

import br.com.allsoft.avros.exceptions.ValorInvalidoMoedaException;
import br.com.allsoft.avros.dao.ClienteDAO;
import br.com.allsoft.avros.factory.JDBCInsere;
import br.com.allsoft.avros.dao.OrcamentoDAO;
import br.com.allsoft.avros.dao.SessaoDAO;
import br.com.allsoft.avros.formulas.Moeda;
import br.com.allsoft.avros.formulas.VerificaCpf;
import br.com.allsoft.avros.relatorios.Relatorio;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Luana
 */
public class IfrmCadSessao extends javax.swing.JInternalFrame {

    //Variáveis
    OrcamentoDAO orcamento = new OrcamentoDAO();
    ClienteDAO cliente = new ClienteDAO();

    double vsessao;
    String pagamento;

    //Métodos
    private void atualizaValor() {
        int sessoes = orcamento.getSessoes();
        double valor = orcamento.getValor();

        //para facilitar a visualização do valor, trocamos
        //os pontos por virgula (padrão brasileiro
        DecimalFormat df = new DecimalFormat("0.00");
        vsessao = valor / sessoes;

        if (ftxtDesconto.isVisible()) {
            double desconto;
            desconto = Double.parseDouble(ftxtDesconto.getText().replace(",", "."));

            vsessao = vsessao - desconto;
        }

        String sessao = df.format(vsessao);

        sessao = sessao.replace(".", ",");

        lblValor.setText("R$ " + sessao);
    }

    /**
     * Creates new form ifrmPagamentos
     *
     * @param orcamento orçamento do qual a nova sessão fará parte
     * @param cliente cliente que fará a sessão
     */
    public IfrmCadSessao(OrcamentoDAO orcamento, ClienteDAO cliente) {
        this.orcamento = orcamento;
        this.cliente = cliente;

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jXGraph1 = new org.jdesktop.swingx.JXGraph();
        imagePainter1 = new org.jdesktop.swingx.painter.ImagePainter();
        compoundPainter1 = new org.jdesktop.swingx.painter.CompoundPainter();
        checkerboardPainter1 = new org.jdesktop.swingx.painter.CheckerboardPainter();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXEditorPane1 = new org.jdesktop.swingx.JXEditorPane();
        jXRootPane1 = new org.jdesktop.swingx.JXRootPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jXTree1 = new org.jdesktop.swingx.JXTree();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rdoCartao = new javax.swing.JRadioButton();
        rdoDinheiro = new javax.swing.JRadioButton();
        lblDesconto = new javax.swing.JLabel();
        lblValorDesconto = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblOrcCod = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        ftxtDesconto = new javax.swing.JFormattedTextField();
        btnAgendar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dateData = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
        spnHorario = new javax.swing.JSpinner(sm);
        jSeparator1 = new javax.swing.JSeparator();

        jLabel6.setText("jLabel6");

        jScrollPane1.setViewportView(jXTable1);

        javax.swing.GroupLayout jXGraph1Layout = new javax.swing.GroupLayout(jXGraph1);
        jXGraph1.setLayout(jXGraph1Layout);
        jXGraph1Layout.setHorizontalGroup(
            jXGraph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        jXGraph1Layout.setVerticalGroup(
            jXGraph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jXEditorPane1);

        jScrollPane3.setViewportView(jXTree1);

        jXLabel1.setText("jXLabel1");

        setClosable(true);
        setIconifiable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(ClsEstilo.tituloFonte);
        jLabel1.setForeground(ClsEstilo.tituloCor);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agendar sessão");

        jLabel2.setFont(ClsEstilo.labelFonte);
        jLabel2.setForeground(ClsEstilo.labelCor);
        jLabel2.setText("Nome");

        jLabel3.setFont(ClsEstilo.labelFonte);
        jLabel3.setForeground(ClsEstilo.labelCor);
        jLabel3.setText("CPF");
        jLabel3.setToolTipText("");

        jLabel4.setFont(ClsEstilo.labelFonte);
        jLabel4.setForeground(ClsEstilo.labelCor);
        jLabel4.setText("Orçamento código");

        jLabel5.setFont(ClsEstilo.labelDestaqueFonte);
        jLabel5.setForeground(ClsEstilo.labelDestaqueCor);
        jLabel5.setText("Valor da sessão: ");
        jLabel5.setToolTipText("");

        jLabel7.setFont(ClsEstilo.labelFonte);
        jLabel7.setForeground(ClsEstilo.labelCor);
        jLabel7.setText("Pagamento");

        rdoCartao.setFont(ClsEstilo.labelFonte);
        rdoCartao.setForeground(ClsEstilo.labelCor);
        rdoCartao.setText("Cartão");

        rdoDinheiro.setFont(ClsEstilo.labelFonte);
        rdoDinheiro.setForeground(ClsEstilo.labelCor);
        rdoDinheiro.setText("Dinheiro");

        lblDesconto.setBackground(ClsEstilo.formbg);
        lblDesconto.setFont(ClsEstilo.linkFonte);
        lblDesconto.setForeground(ClsEstilo.linkCor);
        lblDesconto.setText("Fornecer desconto");
        lblDesconto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblDesconto.setOpaque(true);
        lblDesconto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDescontoMouseClicked(evt);
            }
        });

        lblValorDesconto.setFont(ClsEstilo.labelFonte);
        lblValorDesconto.setForeground(ClsEstilo.labelCor);
        lblValorDesconto.setText("Valor:    R$ ");

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/allsoft/avros/img/logopequeno.png"))); // NOI18N

        lblValor.setFont(ClsEstilo.labelDestaqueFonte);
        lblValor.setForeground(ClsEstilo.labelDinheiroCor);
        lblValor.setText("R$ 0,00");

        lblOrcCod.setFont(ClsEstilo.labelFonte);
        lblOrcCod.setForeground(ClsEstilo.textoInputCor);
        lblOrcCod.setText("000");

        lblNome.setFont(ClsEstilo.labelFonte);
        lblNome.setForeground(ClsEstilo.textoInputCor);
        lblNome.setText("Fulano da Silva");

        lblCpf.setFont(ClsEstilo.labelFonte);
        lblCpf.setForeground(ClsEstilo.textoInputCor);
        lblCpf.setText("000.000.000-00");

        MaskFormatter dateMask = new MaskFormatter();
        dateMask.setPlaceholderCharacter('0') ;
        dateMask.install(ftxtDesconto);
        ftxtDesconto.setForeground(ClsEstilo.textoInputCor);
        ftxtDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftxtDesconto.setText("0,00");
        ftxtDesconto.setFont(ClsEstilo.textoInputFonte);
        ftxtDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtDescontoKeyPressed(evt);
            }
        });

        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        jLabel8.setText("Data");

        jLabel9.setText("Horário");

        JSpinner.DateEditor de = new JSpinner.DateEditor(spnHorario, "HH:mm");
        de.getTextField().setEditable( false );
        spnHorario.setEditor(de);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOrcCod))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCpf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoCartao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoDinheiro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgendar)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValorDesconto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spnHorario))
                                .addComponent(lblDesconto, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblOrcCod))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoCartao)
                            .addComponent(rdoDinheiro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(dateData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spnHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDesconto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorDesconto)
                    .addComponent(ftxtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblValor)
                    .addComponent(btnAgendar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Container a = this.getContentPane();
        a.setBackground(ClsEstilo.formbg);
        
        Dimension dim = this.getParent().getSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 + 50);

        lblValorDesconto.setVisible(false);
        ftxtDesconto.setVisible(false);

        lblOrcCod.setText(String.valueOf(orcamento.getId()));
        lblNome.setText(cliente.getNome());
        lblCpf.setText(VerificaCpf.imprimeCpf(cliente.getCpf()));

        if ("Cartão".equalsIgnoreCase(orcamento.getTipoPagamento())) {
            rdoCartao.setSelected(true);
            pagamento = "Cartão";
        } else if (orcamento.getTipoPagamento().equalsIgnoreCase("Dinheiro")) {
            rdoDinheiro.setSelected(true);
            pagamento = "Dinheiro";
        } else {
            pagamento = "Não especificado";
        }

        atualizaValor();

    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        FrmPrincipal.bPreAgendarSessao = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void lblDescontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDescontoMouseClicked
        lblValorDesconto.setVisible(true);
        ftxtDesconto.setVisible(true);
    }//GEN-LAST:event_lblDescontoMouseClicked

    private void ftxtDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtDescontoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            atualizaValor();
            ftxtDesconto.transferFocus();
        }
    }//GEN-LAST:event_ftxtDescontoKeyPressed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        SessaoDAO sessao = new SessaoDAO();

        Date horaUtil = new Date();
        Date dataUtil = dateData.getDate();

        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try {
            horaUtil = format.parse(spnHorario.getValue().toString());
        } catch (ParseException ex) {
            Logger.getLogger(IfrmCadSessao.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.sql.Time horaSql = new java.sql.Time(horaUtil.getTime());

        sessao.setHora(horaSql);

        try {
            sessao.setDesconto(Moeda.retornaDouble(ftxtDesconto.getText()));
        } catch (ValorInvalidoMoedaException ex) {
            Logger.getLogger(IfrmCadSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.setIdOrcamento(orcamento.getId());
        sessao.setValor(vsessao);
        sessao.setPagamento(pagamento);
        sessao.setData(dataSql);

        try {
            int id = (JDBCInsere.inserirSessao(sessao));
            sessao.setId(id);
            System.out.println(id);
            Relatorio relatorio = new Relatorio();
            relatorio.criaRelatorio(cliente.getCpf(), sessao.getId(), "sessaoAgend");
            
        } catch (SQLException | IOException | JRException ex) {
            Logger.getLogger(IfrmCadSessao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAgendarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private org.jdesktop.swingx.painter.CheckerboardPainter checkerboardPainter1;
    private org.jdesktop.swingx.painter.CompoundPainter compoundPainter1;
    private org.jdesktop.swingx.JXDatePicker dateData;
    private javax.swing.JFormattedTextField ftxtDesconto;
    private org.jdesktop.swingx.painter.ImagePainter imagePainter1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private org.jdesktop.swingx.JXEditorPane jXEditorPane1;
    private org.jdesktop.swingx.JXGraph jXGraph1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXRootPane jXRootPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXTree jXTree1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOrcCod;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorDesconto;
    private javax.swing.JRadioButton rdoCartao;
    private javax.swing.JRadioButton rdoDinheiro;
    private javax.swing.JSpinner spnHorario;
    // End of variables declaration//GEN-END:variables
}
