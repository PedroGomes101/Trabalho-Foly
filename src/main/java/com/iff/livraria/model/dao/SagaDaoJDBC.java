/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.model.dao;

import com.iff.livraria.model.Saga;
import com.iff.livraria.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jao
 */
public class SagaDaoJDBC {
    Connection conn;
    private final String nomeDaTabela = "saga";
//    private int id;
//    private String nome;
//    private String autor;
//    private String descricao;
//    private List<Livro> livros;
//
//    public Saga(int id, String nome, String autor, List<Livro> livros) {
//        this.id = id;
//        this.nome = nome;
//        this.autor = autor;
//        this.livros = livros;
//    }
//
//    public Saga(int id, String nome, String autor) {
//        this.id = id;
//        this.nome = nome;
//        this.autor = autor;
//        
//        this.livros = new ArrayList();
//    }

    public SagaDaoJDBC() throws Exception{
        this.conn = ConnFactory.getConnection();
    }
    
    public List<Saga> listarSagas(Usuario usuario) throws Exception{
        
        List<Saga> lista = new ArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM "+ nomeDaTabela +" WHERE usuario =?");
            ps.setInt(1, usuario.getId());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(
                    new Saga(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("autor"),
                        rs.getString("descricao")
                    )
                );
            }
        }
        finally{
            if(conn != null){
                conn.close();
            }
            return lista;
        }
    }
}
