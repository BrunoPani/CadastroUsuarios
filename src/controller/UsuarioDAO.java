/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import javax.swing.JOptionPane;
import modelOuEntidades.Usuario;

/**
 *
 * @author teclab
 */
public class UsuarioDAO {
    private Connection conexao;
    
    public UsuarioDAO(){
        
        this.conexao = ModuleConexao.conectar();
    }
    
    public void cadastrarUsuario(Usuario obj){
        //primeiro passo é criar o comando sql
        
        
        try {
            String sql = "insert into usuarios(nome, login, senha, perfil) values (?,?,?,?)";
        //segundo passo conectat o banco de dados e organizar o comando sql
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getLogin());
            stm.setString(3, obj.getSenha());
            stm.setString(4, obj.getPerfil());
            
            //terceiro passo executar o comando sql
            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:"+ erro);
            
        }
        
    }
}
