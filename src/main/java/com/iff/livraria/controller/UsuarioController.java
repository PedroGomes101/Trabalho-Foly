/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.controller;

import com.iff.livraria.model.Usuario;

/**
 *
 * @author jao
 */
public class UsuarioController {
    public static Usuario user;
    
    private static boolean atualizado = false;
    
    public static void atualizaUsuario(String nome, String nomeDeUsuario){
        nome = nome.trim();
        nomeDeUsuario = nomeDeUsuario.trim();
        
        if(!nome.isEmpty()) {
            user.setNome(nome);
            atualizado = true;
        }
        
        if(!nomeDeUsuario.isEmpty()){
            user.setNomeDeUsuario(nomeDeUsuario);
            atualizado = true;
        }
    }
    
    public static boolean foiAtualizado(){
        return atualizado;
    }
}
