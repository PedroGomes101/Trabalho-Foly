
package com.iff.livraria.model.dao;

import com.iff.livraria.model.Livro;
import com.iff.livraria.model.Saga;
import com.iff.livraria.model.Usuario;
import com.iff.livraria.utils.Comparador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LivroDaoJDBC {

    private Connection conn;
    private final String nomeDaTabela = "livro";
    
//  private int id;
//  private String nome;
//  private String autor;
//  private String descricao;
//  private int qtdPaginas;
//  private boolean foiLido;
//  private Saga saga;
    
    public LivroDaoJDBC() throws Exception{
       this.conn = ConnFactory.getConnection();
    }
    
    public void incluir(Livro entidade) throws Exception {
    
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO "+ nomeDaTabela+ "(nome, autor, descricao, qtd_paginas, foi_lido, saga) VALUES(?, ?, ?, ?, ?, ?)");
            
            ps.setString (1, entidade.getNome());
            ps.setString (2, entidade.getAutor());
            ps.setString (3, entidade.getDescricao());
            ps.setInt    (4, entidade.getQtdPaginas());
            ps.setBoolean(5, entidade.foiLido());
            ps.setInt    (6, entidade.getSaga().getId());
            ps.execute();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void editar(Livro entidade) throws Exception {
    
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE "+ nomeDaTabela + "SET nome=?, autor=?, descricao=?, qtd_paginas=?, foi_lido=? WHERE id=?");
            
            ps.setString (1, entidade.getNome());
            ps.setString (2, entidade.getAutor());
            ps.setString (3, entidade.getDescricao());
            ps.setInt    (4, entidade.getQtdPaginas());
            ps.setBoolean(5, entidade.foiLido());
            ps.setInt    (6, entidade.getSaga().getId());
            ps.execute();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public void excluir(Livro entidade) throws Exception {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM " + nomeDaTabela + " WHERE id=?");
            ps.setInt(1, entidade.getId());
            ps.execute();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public List<Livro> listar(Comparador<Saga> sagas, Usuario usuario) throws Exception {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + nomeDaTabela + " WHERE usuario=?");
            ps.setInt(1, usuario.getId());
            
            ResultSet rs = ps.executeQuery();
            List<Livro> lista = new ArrayList();
            
            while (rs.next()) {
                Saga saga = sagas.find(rs.getInt("saga"));
                Livro c = new Livro(
                        rs.getInt    ("id"),
                        rs.getString ("nome"),
                        rs.getString ("autor"),
                        rs.getString ("descricao"),
                        rs.getInt    ("qtd_paginas"),
                        rs.getBoolean("foi_lido"),
                        saga,
                        rs.getString ("imagem")
                );
                
                saga.addLivro(c);
                lista.add(c);
            }
            return lista;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }


    }
}
