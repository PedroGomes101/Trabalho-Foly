/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria;

import com.iff.livraria.controller.LivroController;
import com.iff.livraria.controller.SagaController;
import com.iff.livraria.controller.SecaoController;
import com.iff.livraria.controller.UsuarioController;
import com.iff.livraria.model.Livro;
import com.iff.livraria.model.Saga;
import com.iff.livraria.model.Usuario;

import static com.iff.livraria.controller.SecaoController.usr;
/**
 *
 * @author jao
 */
public class FakeMain {
    
    public static Saga sagaTeste = new Saga("Saga Teste", "Autor Teste", "Descriçao de Teste");
    public static Livro livroTeste = new Livro("Livro Teste", "Autor Teste", "Descrição de Teste", 666, true, null, "imagem/imagem1.png");
    public static Usuario usuarioTeste = new Usuario("nomeTeste", "nomeDeUsuarioTeste");
    public static String senhaTeste = "senha_teste";
    
    public static void main(String args[]){
        try{
            iniciarTeste();
            
            System.out.println(SecaoController.sagas.size());
            System.out.println(SecaoController.livros.size());
            
            
 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void iniciarTeste() throws Exception{
        limparTestes();
        
        SecaoController.cadastrarUsuario(usuarioTeste.getNome(), usuarioTeste.getNomeDeUsuario(), senhaTeste);
        SecaoController.login(usuarioTeste.getNomeDeUsuario(), senhaTeste);
        
        for(int i = 0; i < 4; i++){
            String nomeSaga = "Saga Teste" + i;
            sagaTeste.setNome(nomeSaga);
            SagaController.incluir(sagaTeste, usr);
        }
        
        SecaoController.buscar();
        livroTeste.setSaga(SecaoController.sagas.get(0));
        for(int i = 0; i < 10; i++){
            String nomeLivro = "Livro Teste" + i;
            livroTeste.setNome(nomeLivro);
            LivroController.incluir(livroTeste, usr);
        }
        
        SecaoController.buscar();
    }
    
    public static void limparTestes() throws Exception{
        UsuarioController.delete(usuarioTeste);
    }
}
