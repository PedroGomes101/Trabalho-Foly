/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.model.dao;

import com.iff.livraria.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author jao
 */
public class UsuarioDaoJDBC {
    private Connection conn;
    private final String nomeDaTabela = "usuario";
    
    public UsuarioDaoJDBC() throws Exception{
        this.conn = ConnFactory.getConnection();
    }
    
    public void cadastar(Usuario usuario, String senha) throws Exception{
        
        try{
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO " + nomeDaTabela + "(nome, nome_de_usuario, senha) values (?, ?, ?);");
        
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getNomeDeUsuario());
            ps.setString(3, senha);

            ps.execute();
        }
        finally{
            if(conn != null){
                conn.close();
            }
        }
    }
    
//    public boolean existeNomeUsuario(Usuario usuario) throws Exception{
//        
//        boolean existe = true; 
//        try{
//            PreparedStatement ps = conn.prepareStatement(
//                "SELECT * FROM " + nomeDaTabela + "WHERE");
//        
//            
//        }
//        finally{
//            if(conn != null){
//                conn.close();
//            }
//        }
//    };
}
