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
import com.iff.livraria.model.dao.UsuarioDaoJDBC;
import com.iff.livraria.utils.Comparador;
import com.iff.livraria.utils.exception.UserNameExistsException;
import com.iff.livraria.utils.exception.UserNotFoundException;
import java.util.List;

/**
 *
 * @author jao
 */
public class SecaoController {
    public static Usuario usr;
    public static List<Saga> sagas;
    public static List<Livro> livros;
    
    public static void buscar() throws Exception{
        sagas = getSagas(usr);
        livros = getLivros(usr, sagas);
    }
    
    public static void cadastrarUsuario(String nome, String nomeDeUsuario, String senha) throws UserNameExistsException, Exception{
        nomeDeUsuario = nomeDeUsuario.trim();
        nome = nome.trim();
        senha = senha.trim();
        
        Usuario tempUsr = new Usuario(nome, nomeDeUsuario);
        
        try{
            UsuarioDaoJDBC usrNameExistsConn = DaoFactory.getUsuarioDaoConnection();
            
            if(usrNameExistsConn.existeNomeUsuario(tempUsr.getNomeDeUsuario())) 
                throw new UserNameExistsException("");
            
            UsuarioDaoJDBC createNewUsrConn = DaoFactory.getUsuarioDaoConnection();
            createNewUsrConn.cadastar(tempUsr, senha);
        }
        finally{
            
        }
    }
    
    public static void login(String nomeDeUsuario, String senha) throws UserNotFoundException, Exception{
        nomeDeUsuario = nomeDeUsuario.trim();
        senha = senha.trim();
        
       
        UsuarioDaoJDBC usrLoginConn = DaoFactory.getUsuarioDaoConnection();

        Usuario usuario = usrLoginConn.getUsuarioPorLogin(nomeDeUsuario, senha);

        if(usuario == null) throw new UserNotFoundException("Nome de usuário ou senha incorretos!");

        usr = usuario;
        
        
    }
    private static List<Saga> getSagas(Usuario usuario) throws Exception{
        List<Saga> lista = null;
        
        try{
            SagaDaoJDBC sagaConn = DaoFactory.getSagaDaoConnection();
            lista = sagaConn.listarSagas(usuario);
            
        }finally{
            
            return lista;
        }
    }
    
    private static List<Livro> getLivros(Usuario usuario, List<Saga> sagaLista){
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
