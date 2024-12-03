/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.model.dao;

/**
 *
 * @author jao
 */
public class DaoFactory {
    public static LivroDaoJDBC getLivroDaoConnection() throws Exception{
        return new LivroDaoJDBC();
    }
    
    public static UsuarioDaoJDBC getUsuarioDaoConnection() throws Exception{
        return new UsuarioDaoJDBC();
    }
    
    public static SagaDaoJDBC getSagaDaoConnection() throws Exception{
        return new SagaDaoJDBC();
    }
}
