/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps.aps.cad;
import java.sql.*;
/**
 *
 * @author Ruty
 */
public class conexao { //estabelece conexão
    
    public static Connection conector()
    {
        java.sql.Connection conexao = null; //variavel recebendo estado da conexao
      
        String driver = "com.mysql.jdbc.Driver"; //invoca o driver
        
        //informaçoes sobre o banco de dados
        String url = "jdbc:mysql://localhost:3306/aps"; //caminho
        String user = "root";//usuario
        String password ="root";//senha
        
        //finalmente estabelencendo conexao
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
            //*caso dê tudo certo ele retorna a conexao
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}
