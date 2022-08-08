/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author teclab
 */
public class ModuleConexao {
    public static Connection conectar(){
        Connection conexao = null;
        //criando driver correspondente ao banco de dados
        String driver = "com.mysql.cj.jdbc.Driver";
        //armazenando informações referente ao banco de dados
        String url = "jdbc:mysql://localhost:3306/cadastrousuario?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String senha=  "root";
        
        //estabelecer a conexão com o banco
        try {
        Class.forName(driver);
        conexao = DriverManager.getConnection(url, user, senha);
        return conexao;

        } catch (Exception e) {
            //a linha abaixo serve de apoio para esclarecer o erro
            System.out.println(e);
            return null;
        }
    }
    
    public static Connection desconectar(){
        Connection conexao =null;
        try {
            conexao.close();
        } catch (Exception e) {
        }
        return conexao;
    }
}
