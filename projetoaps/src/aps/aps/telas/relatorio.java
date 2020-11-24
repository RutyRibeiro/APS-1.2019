
package aps.aps.telas;

import java.sql.*;
import aps.aps.cad.conexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class relatorio extends javax.swing.JInternalFrame 
{
    Connection conexaoo = null;
    PreparedStatement pre = null;
    ResultSet result = null;
    
    public relatorio() {
        initComponents();
        conexaoo = conexao.conector();
    }

    private void pesquisarnome()
    {
        String sql = "select * from casos where nome like ?";
        
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            //pega o conteúdo da caixa de pesquisa
            pre.setString(1,txtpesqnome.getText()+"%");
            result = pre.executeQuery();
            
            tabelacasos.setModel(DbUtils.resultSetToTableModel(result));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
   /** private void pesquisarcidade()
    {
        String sql = "select * from casos where cidade=?";
        
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            //pega o conteúdo da caixa de pesquisa
            pre.setString(1,txtpesqcidade.getSelectedItem().toString());
            result = pre.executeQuery();
            
            tabelacasos.setModel(DbUtils.resultSetToTableModel(result));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    * **/
    
    private void pesquisarid()
    {
        String sql = "select * from casos where idcaso like ?";
        
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            //pega o conteúdo da caixa de pesquisa
            pre.setString(1,txtpesqid.getText()+"%");
            result = pre.executeQuery();
            
            tabelacasos.setModel(DbUtils.resultSetToTableModel(result));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     private void pesquisarano()
    {
        String sql = "select * from casos where year(data)=?";
        
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            //pega o conteúdo da caixa de pesquisa
            pre.setString(1,txtpesqdata.getText());
            result = pre.executeQuery();
            
            tabelacasos.setModel(DbUtils.resultSetToTableModel(result));
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtpesqnome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelacasos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpesqcidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtpesqdata = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpesqid = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Relátorio de casos de Meningite no Estado de São Paulo");

        txtpesqnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesqnomeKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Relatório de casos");

        tabelacasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelacasos);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Filtrar por:");

        jLabel4.setText("Nome:");

        jLabel5.setText("Cidade:");

        txtpesqcidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mauá", "Osasco", "Barueri", "campinas", "Suzano" }));
        txtpesqcidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesqcidadeKeyReleased(evt);
            }
        });

        jLabel7.setText("Data:");

        txtpesqdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesqdataKeyReleased(evt);
            }
        });

        jLabel9.setText("ID: ");

        txtpesqid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesqidKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(10, 10, 10)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtpesqdata, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtpesqid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtpesqcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtpesqnome, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpesqnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpesqcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesqdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtpesqid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
        );

        setBounds(0, 0, 538, 575);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpesqnomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesqnomeKeyReleased
      pesquisarnome();
    }//GEN-LAST:event_txtpesqnomeKeyReleased

    private void txtpesqcidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesqcidadeKeyReleased
        
    }//GEN-LAST:event_txtpesqcidadeKeyReleased

    private void txtpesqidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesqidKeyReleased
        pesquisarid();
    }//GEN-LAST:event_txtpesqidKeyReleased

    private void txtpesqdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesqdataKeyReleased
        pesquisarano();
    }//GEN-LAST:event_txtpesqdataKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelacasos;
    private javax.swing.JComboBox<String> txtpesqcidade;
    private javax.swing.JTextField txtpesqdata;
    private javax.swing.JTextField txtpesqid;
    private javax.swing.JTextField txtpesqnome;
    // End of variables declaration//GEN-END:variables
}
