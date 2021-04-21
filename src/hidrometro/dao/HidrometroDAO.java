/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrometro.dao;

import entidade.Hidrometro;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author e127787
 */
public interface HidrometroDAO {
    
    public void movimento(String hd, String lotacao1, String lotacao2) throws Exception;
    public void recuperacao(String hd, String lacre, String nome) throws Exception;
    public void lacre(String lacre, String hd) throws Exception;
    public Collection<Hidrometro> find() throws Exception;
    public Hidrometro locate(String hd) throws Exception;
    public boolean exists(String hd);
    public String locRastro(String hd) throws SQLException;
}
