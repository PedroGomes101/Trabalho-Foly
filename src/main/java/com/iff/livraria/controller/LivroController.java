/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.controller;

import static com.iff.livraria.FakeMain.livroTeste;
import com.iff.livraria.model.Livro;
import com.iff.livraria.model.Usuario;
import com.iff.livraria.model.dao.DaoFactory;
import com.iff.livraria.model.dao.LivroDaoJDBC;
import com.iff.livraria.utils.Comparador;
import java.util.List;

/**
 *
 * @author jao
 */
public class LivroController {
    public static List<Livro> livros;
    
    public static void getLivros(Usuario usuario, Comparador sagaComparador){
        
    }
    
    public static void incluir(Livro livro, Usuario usuario) throws Exception{
        LivroDaoJDBC createBookConn = DaoFactory.getLivroDaoConnection();
        createBookConn.incluir(livro, usuario);
    }
}
