package com.iff.livraria.controller;

import com.iff.livraria.model.Usuario;
import com.iff.livraria.model.dao.DaoFactory;
import com.iff.livraria.model.dao.UsuarioDaoJDBC;
import com.iff.livraria.utils.exception.UserNameExistsException;
import com.iff.livraria.utils.exception.UserNotFoundException;

public class UsuarioController {
    
    
    public static void delete(Usuario usuario) throws UserNotFoundException, Exception{
        
        UsuarioDaoJDBC usrDeleteConn = DaoFactory.getUsuarioDaoConnection();

        usrDeleteConn.delete(usuario);
        
    }
}
