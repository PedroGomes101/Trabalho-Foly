/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jao
 */
public class Saga implements EntidadeInterface{
    private int id;
    private String nome;
    private String autor;
    private String descricao;
    private List<Livro> livros;

    public Saga(int id, String nome, String autor,String descricao, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.livros = livros;
        
    }

    public Saga(int id, String nome, String autor, String descricao) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        
        this.livros = new ArrayList();
    }
    
    private int livrosLidos(){
        int total = 0;
        
        for(Livro livro : this.livros){
            if(livro.foiLido()) total++;
        }
        
        return total;
    }
    
    private int qtdLivros(){
        return livros.size();
    }
    
    
    public void addLivro(Livro livro){
        this.livros.add(livro);
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public int getId(){
        return this.id;
    }
        
}
