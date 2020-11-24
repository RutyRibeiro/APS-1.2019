
package aps.aps.telas;

import java.sql.*;
import aps.aps.cad.conexao;
import javax.swing.JOptionPane;


public class telacasos extends javax.swing.JInternalFrame 
{    
    Connection conexaoo = null;
    PreparedStatement pre = null;
    ResultSet result = null;
    
     public telacasos() {
        initComponents();
        conexaoo = conexao.conector();
    }

     private void create()
    {
        String sql = "insert into casos(nome,cidade,data) values (?,?,?) ";
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            pre.setString(1,txtcasnome.getText());
            pre.setString(2,txtcascidade.getSelectedItem().toString());
            pre.setString(3,txtcasdata.getText());
            
            
 //verifica se todos os campos estão preenhidos
        
         if (txtcasnome.getText().isEmpty()|| txtcasdata.getText().isEmpty())
         {
             JOptionPane.showMessageDialog(null, "preencha todos os campos");
         }
         else
         {
//adiciona os dados na tabela
           int adic = pre.executeUpdate();
            
           if (adic>0)
           {
                JOptionPane.showMessageDialog(null, "Ocorrencia adicionada");
                //limpam campos
                    txtcasnome.setText(null);
                    txtcasdata.setText(null);
                 
           } 
          }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e,"OPA",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcasnome = new javax.swing.JTextField();
        txtcascidade = new javax.swing.JComboBox<>();
        txtcasdata = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btcascreate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastro de casos de meningite em São Paulo");

        jLabel1.setText("NOME:");

        jLabel2.setText("*CIDADE:");

        jLabel3.setText("*DATA:");

        txtcascidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mauá", "Campinas", "Suzano", "Barueri", "Osasco" }));

        txtcasdata.setText("AAAA/MM/DD");

        jLabel4.setText("*campos obrigatórios");

        btcascreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aps/aps/icones/create.png"))); // NOI18N
        btcascreate.setToolTipText("adicionar");
        btcascreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btcascreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcascreateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cadastro de Casos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcasdata, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcascidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtcasnome, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel5)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btcascreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcasnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcascidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcasdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btcascreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        setBounds(0, 0, 431, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void btcascreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcascreateActionPerformed
       create();
    }//GEN-LAST:event_btcascreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcascreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> txtcascidade;
    private javax.swing.JTextField txtcasdata;
    private javax.swing.JTextField txtcasnome;
    // End of variables declaration//GEN-END:variables
}
