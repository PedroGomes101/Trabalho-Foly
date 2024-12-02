/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.utils;

import com.iff.livraria.model.EntidadeInterface;
import java.util.List;

/**
 *
 * @author jao
 * @param <Entidade>
 */
public class Comparador<Entidade extends EntidadeInterface>{
    public List<Entidade> lista;
    
    public Comparador(List lista){
        this.lista = lista;
    }
    
    public Entidade find(int id){
        for(Entidade element : lista){
            if(element.getId() == id) return element;
        }
        return null;
    }
    
    public boolean compare(int id){
        for(Entidade element : lista){
            if(element.getId() == id) return true;
        }
        return false;
    }
}
