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
public class SagaController {
    public static List<Saga> sagas;
    
    public static void get(Usuario usuario, Comparador sagaComparador){
        
    }
    
    public static void incluir(Saga saga, Usuario usuario) throws Exception{
        SagaDaoJDBC createSagaConn = DaoFactory.getSagaDaoConnection();
        createSagaConn.incluir(saga, usuario);
    }
}
