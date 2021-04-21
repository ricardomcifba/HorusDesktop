/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrometro.dao.sql;

import entidade.Hidrometro;
import entidade.Lotacoes;
import hidrometro.dao.ConnectionDAO;
import hidrometro.dao.HidrometroDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author E127787
 */
public class HidrometroDAOSQL extends ConnectionDAO implements HidrometroDAO {
    

    private static final String INSERT_MOV = "select med_registrar_movimentacao(?,?,?,?::character,now()::timestamp)";
    //private static final String INSERT_MOV = "insert into tmp_movihd(hidrometro,lot_origem, data, lot_destino) values (?,?,now(),?)";
    //subistituir pela função med_registrar_movimentacao
    //med_registrar_movimentacao(hidrometro,lot_origem,lot_destino,metodo)
    private static final String INSERT_REC = 
        "insert into med_recuperacaohidrometro(hidrometro,data,codigo_lacre,responsavel,updated) values (?,current_date,?,?,now())";
         
    private static final String APAGA_MOV = "delete from tmp_movihd where  hidrometro = ? ,lot_origem = ?lot_destino =?";
    //apaga registro inserido errado na tabela
    private static final String INSERT_LACRE = "update dof_hidrometro set hidrometro = ?, lacre_inmetro = ? where hidrometro = ?";
    private static final String SELECT = "select hidrometro from dof_hidrometro where hidrometro = ? ";
    private static final String LOTACAO = "select sigla from med_rastreio r\n" +
"join med_lotacaohidrometro lh on r.destino = lh.id\n" +
" where identificador = ? and tipo_rastreavel = 1 and datahora < now() order by datahora desc limit 1;";
        
    @Override
    public void movimento(String hd, String lotacao1, String lotacao2) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(INSERT_MOV);
        pStmt.setString(1, hd );
        pStmt.setString(2, Lotacoes.lotacao(lotacao1));
        pStmt.setString(3, Lotacoes.lotacao(lotacao2));
        pStmt.setString(4,  "B");
        System.out.println(pStmt);
        ResultSet rSet = pStmt.executeQuery();
        //pStmt.executeUpdate();
    }

    @Override
    public void lacre(String lacre, String hd) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(INSERT_LACRE);
        pStmt.setString(1, hd );
        pStmt.setString(2,lacre);
        pStmt.setString(3, hd );
        System.out.println(pStmt);
        pStmt.executeUpdate();
    }

    @Override
    public Collection<Hidrometro> find() throws Exception {
        return null;
        	
    }


    @Override
    public void recuperacao(String hd, String lacre, String nome) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(INSERT_REC);
        pStmt.setString(1, hd );
        pStmt.setString(2,lacre);
        pStmt.setString(3, nome );
        pStmt.executeUpdate();
    }
    
    public Hidrometro locate(String hd) throws SQLException{
        Hidrometro hidrometro = null;
	PreparedStatement pStmt = this.getConnection().prepareStatement(SELECT);
	pStmt.setString(1, hd );
        ResultSet rSet = pStmt.executeQuery();
		
	while(rSet.next()){
            String  hd1 = rSet.getString("hidrometro");
                hidrometro = new Hidrometro("",hd1);
	}
	rSet.close();
	pStmt.close();
	return hidrometro;
        
    }

    @Override
    public boolean exists(String hd) {
        try {
            if(locate(hd)!=null)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(HidrometroDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String locRastro(String hd) throws SQLException{
        String lotacao = null;
        PreparedStatement pStmt = this.getConnection().prepareStatement(LOTACAO);
	pStmt.setString(1, hd );
        ResultSet rSet = pStmt.executeQuery();
		
	while(rSet.next()){
              lotacao = rSet.getString("sigla");
                
	}
	rSet.close();
	pStmt.close();
	return lotacao;
    }
    
    


    
}
