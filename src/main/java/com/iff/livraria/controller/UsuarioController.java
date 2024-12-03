/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.controller;

import com.iff.livraria.model.Usuario;
import com.iff.livraria.model.dao.DaoFactory;
import com.iff.livraria.model.dao.UsuarioDaoJDBC;
import com.iff.livraria.utils.exception.UserNameExistsException;
import com.iff.livraria.utils.exception.UserNotFoundException;

/**
 *
 * @author jao
 */
public class UsuarioController {
    public static Usuario usr;
    
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
}
