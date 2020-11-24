package aps.aps.telas;
import java.sql.*;
import aps.aps.cad.conexao;
import javax.swing.JOptionPane;

public class telauser extends javax.swing.JInternalFrame {

    Connection conexaoo = null;
    PreparedStatement pre = null;
    ResultSet result = null;
    
    //construtor
    public telauser() {
        initComponents();
        conexaoo = conexao.conector();
    }
//metodo de consulta
    private void read()
    {
        String sql = "select * from user where iduser=?";
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            pre.setString(1,txtusuid.getText());
            result = pre.executeQuery();
            
            if (result.next()) 
            {
                txtusunome.setText(result.getString(2));
                txtusulogin.setText(result.getString(3));
                txtususenha.setText(result.getString(4));
                txtusuperfil.setSelectedItem(result.getString(5));
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!","OPA",JOptionPane.INFORMATION_MESSAGE);
                //limpam campos
                 txtusunome.setText(null);
                 txtusulogin.setText(null);
                 txtususenha.setText(null);
                 txtusuperfil.setSelectedItem(null);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e,"OPA",JOptionPane.INFORMATION_MESSAGE);
        }
    }
//metodo para adicionar    
    private void create()
    {
        String sql = "insert into user(iduser,nomeuser,loginuser,senhauser,tipo) values (?,?,?,?,?) ";
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            pre.setString(1,txtusuid.getText());
            pre.setString(2,txtusunome.getText());
            pre.setString(3,txtusulogin.getText());
            pre.setString(4,txtususenha.getText());
            pre.setString(5,txtusuperfil.getSelectedItem().toString());
            
 //verifica se todos os campos estão preenhidos
        
         if (txtusuid.getText().isEmpty()|| txtusunome.getText().isEmpty()||txtusulogin.getText().isEmpty()
                 ||txtususenha.getText().isEmpty())
         {
             JOptionPane.showMessageDialog(null, "preencha todos os campos");
         }
         else
         {
//atualiza a tabula
           int adic = pre.executeUpdate();
            
           if (adic>0)
           {
            JOptionPane.showMessageDialog(null, "usuário adicionado");
            //limpam campos
                 txtusuid.setText(null);
                 txtusunome.setText(null);
                 txtusulogin.setText(null);
                 txtususenha.setText(null);
                 txtusuperfil.setSelectedItem(null);
           } 
        }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e,"OPA",JOptionPane.INFORMATION_MESSAGE);
        }
    }
//metodo para alterar
    private void update()
    {
        String sql = "update user set nomeuser=?, loginuser=?, senhauser=?, tipo=? where iduser=? ";
        try 
        {
            pre = conexaoo.prepareStatement(sql);
            
            pre.setString(1,txtusunome.getText());
            pre.setString(2,txtusulogin.getText());
            pre.setString(3,txtususenha.getText());
            pre.setString(4,txtusuperfil.getSelectedItem().toString());
            pre.setString(5,txtusuid.getText());
 //verifica se todos os campos estão preenhidos
        
         if (txtusuid.getText().isEmpty()|| txtusunome.getText().isEmpty()||txtusulogin.getText().isEmpty()
                 ||txtususenha.getText().isEmpty())
         {
             JOptionPane.showMessageDialog(null, "preencha todos os campos");
         }
         else
         {
//atualiza a tabula
           int alt = pre.executeUpdate();
            
           if (alt>0)
           {
            JOptionPane.showMessageDialog(null, "usuário alterado com sucesso!");
            //limpam campos
                 txtusuid.setText(null);
                 txtusunome.setText(null);
                 txtusulogin.setText(null);
                 txtususenha.setText(null);
                 txtusuperfil.setSelectedItem(null);
           } 
        }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e,"OPA",JOptionPane.INFORMATION_MESSAGE);
        }
    }
//metodo pra excluir usuários
    private void delete()
    { 
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir este usuário?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION)
        { 
             String sql = "delete from user where iduser=? ";
            
            try 
            {
                pre = conexaoo.prepareStatement(sql);
                pre.setString(1,txtusuid.getText());
                
                if (txtusuid.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Especifique um id para excluir");
                }
                else
                {
        
                    int dele = pre.executeUpdate();
                
                    if (dele>0)
                    {
                        JOptionPane.showMessageDialog(null," Usuário excluido com sucesso! ");
                    
                        //limpam campos
                            txtusuid.setText(null);
                            txtusunome.setText(null);
                            txtusulogin.setText(null);
                            txtususenha.setText(null);
                            txtusuperfil.setSelectedItem(null);
                    
                    }
                }
            } 
            catch (Exception e)
            {  
                JOptionPane.showMessageDialog(null, e);
            }
             
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusuperfil = new javax.swing.JComboBox<>();
        txtususenha = new javax.swing.JTextField();
        txtusulogin = new javax.swing.JTextField();
        txtusunome = new javax.swing.JTextField();
        txtusuid = new javax.swing.JTextField();
        btcreate = new javax.swing.JButton();
        btdelete = new javax.swing.JButton();
        btread = new javax.swing.JButton();
        btupdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de usuários");
        setPreferredSize(new java.awt.Dimension(396, 432));

        jLabel1.setText("*ID:");

        jLabel2.setText("*NOME:");

        jLabel3.setText("*LOGIN:");

        jLabel4.setText("*SENHA:");

        jLabel5.setText("*PERFIL:");

        txtusuperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "usuário" }));
        txtusuperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuperfilActionPerformed(evt);
            }
        });

        btcreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aps/aps/icones/create.png"))); // NOI18N
        btcreate.setToolTipText("adicionar");
        btcreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btcreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcreateActionPerformed(evt);
            }
        });

        btdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aps/aps/icones/delete.png"))); // NOI18N
        btdelete.setToolTipText("deletar");
        btdelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });

        btread.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aps/aps/icones/read.png"))); // NOI18N
        btread.setToolTipText("pesquisar");
        btread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btread.setPreferredSize(new java.awt.Dimension(80, 80));
        btread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btreadActionPerformed(evt);
            }
        });

        btupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aps/aps/icones/update.png"))); // NOI18N
        btupdate.setToolTipText("modificar");
        btupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btupdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btupdateActionPerformed(evt);
            }
        });

        jLabel6.setText("*Campos obrigatórios");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cadastro de usuários");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btcreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btupdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btdelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusuperfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtususenha)
                            .addComponent(txtusulogin)
                            .addComponent(txtusunome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtusuid, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(111, 111, 111))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btcreate, btdelete, btread, btupdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusunome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtusulogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtususenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtusuperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btread, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btcreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btdelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        setBounds(0, 0, 396, 432);
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuperfilActionPerformed

    private void btreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btreadActionPerformed
      read();
    }//GEN-LAST:event_btreadActionPerformed

    private void btcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcreateActionPerformed
      create();
    }//GEN-LAST:event_btcreateActionPerformed

    private void btupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btupdateActionPerformed
        update();
    }//GEN-LAST:event_btupdateActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
      delete();
    }//GEN-LAST:event_btdeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcreate;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btread;
    private javax.swing.JButton btupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtusuid;
    private javax.swing.JTextField txtusulogin;
    private javax.swing.JTextField txtusunome;
    private javax.swing.JComboBox<String> txtusuperfil;
    private javax.swing.JTextField txtususenha;
    // End of variables declaration//GEN-END:variables
}
