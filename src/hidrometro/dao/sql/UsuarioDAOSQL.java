/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrometro.dao.sql;

import entidade.Usuario;
import hidrometro.dao.ConnectionDAO;
import hidrometro.dao.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author e127787
 */
public class UsuarioDAOSQL extends ConnectionDAO implements UsuarioDAO {

    private static final String SELECT_USU = "SELECT id, nome, unidade FROM tmp_medlogin";    

        
    @Override
    public Collection<Usuario> find() throws Exception {
        List<Usuario> usuarios = new ArrayList<Usuario>();
	Usuario usuario = null;
	PreparedStatement pStmt = this.getConnection().prepareStatement(SELECT_USU);
	ResultSet rSet = pStmt.executeQuery();
		
	while(rSet.next()){
            String id = rSet.getString("id");
            String nome = rSet.getString("nome");
            String unidade = rSet.getString("unidade");
            usuario = new Usuario(id, nome, unidade);
            usuarios.add(usuario);
	}
	rSet.close();
	pStmt.close();
        return usuarios;
    }
}