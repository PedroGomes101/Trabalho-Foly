/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.model;



/**
 *
 * @author jao
 */
public class Livro implements EntidadeInterface{

    
    private int id;
    private String nome;
    private String autor;
    private String descricao;
    private int qtdPaginas;
    private boolean foiLido;
    private Saga saga;
    private String imagem;
    

    public Livro(int id, String nome, String autor,String descricao, int qtdPaginas, boolean foiLido, Saga saga, String imagem) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.qtdPaginas = qtdPaginas;
        this.foiLido = foiLido;
        this.saga = saga;
        this.imagem = imagem;
    }
    
    public Livro(String nome, String autor,String descricao, int qtdPaginas, boolean foiLido, Saga saga, String imagem) {
        this.id = -1;
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.qtdPaginas = qtdPaginas;
        this.foiLido = foiLido;
        this.saga = saga;
        this.imagem = imagem;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public boolean isFoiLido() {
        return foiLido;
    }

    public void setFoiLido(boolean foiLido) {
        this.foiLido = foiLido;
    }

    public Saga getSaga() {
        return saga;
    }

    public void setSaga(Saga saga) {
        this.saga = saga;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
}
