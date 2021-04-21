/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import hidrometro.dao.sql.HidrometroDAOSQL;
import java.sql.SQLException;

/**
 *
 * @author e127787
 */
public class Main {
    
    public static void main (String [] args) throws SQLException{
        
        HidrometroDAOSQL hd = new HidrometroDAOSQL();
        System.out.println(Lotacoes.lotacao("MOV-UML"));
        System.out.println(hd.locRastro("Y14N224635"));
        System.out.println(Lotacoes.lotacao("MOV-UML").equals(hd.locRastro("A15S318238")));
        
        //Retornando lotacao destino com número, ir em movimentação e fazer "Se nao pertencer a FCOM"
        
    }
    
}
