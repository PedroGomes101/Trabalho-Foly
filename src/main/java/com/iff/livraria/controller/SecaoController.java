/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.controller;

import com.iff.livraria.model.Livro;
import com.iff.livraria.model.Saga;
import com.iff.livraria.model.Usuario;
import com.iff.livraria.model.dao.DaoFactory;
import com.iff.livraria.model.dao.LivroDaoJDBC;
import com.iff.livraria.model.dao.SagaDaoJDBC;
import com.iff.livraria.utils.Comparador;
import java.util.List;

/**
 *
 * @author jao
 */
public class SecaoController {
    public static Usuario usr;
    public static List<Saga> sagas;
    public static List<Livro> livros;
    
    public SecaoController(Usuario usuario) throws Exception{
        usr = usuario;
        sagas = getSagas(usr);
        livros = getLivros(usr, sagas);
    }
    
    private List<Saga> getSagas(Usuario usuario) throws Exception{
        List<Saga> lista = null;
        
        try{
            SagaDaoJDBC sagaConn = DaoFactory.getSagaDaoConnection();
            lista = sagaConn.listarSagas(usuario);
            
        }finally{
            
            return lista;
        }
    }
    
    private List<Livro> getLivros(Usuario usuario, List<Saga> sagaLista){
        List<Livro> lista = null;
        Comparador<Saga> comparador = new Comparador(sagaLista);
        try{
            LivroDaoJDBC sagaConn = DaoFactory.getLivroDaoConnection();
            lista = sagaConn.listarLivros( usuario, comparador );
            
        }finally{
            
            return lista;
        }
    }
}
