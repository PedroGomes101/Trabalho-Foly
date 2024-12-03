/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iff.livraria.utils;

import com.iff.livraria.model.EntidadeInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author jao
 */
public class UtilDatabase {
    public static void  setIntOrNullByEntityId(PreparedStatement ps, int posicaoDoParametro,EntidadeInterface entidade) throws SQLException{
       if(entidade == null){
           ps.setNull(posicaoDoParametro, Types.INTEGER);
       }else{       
           ps.setInt(posicaoDoParametro, entidade.getId());
       }
               
    }
}
