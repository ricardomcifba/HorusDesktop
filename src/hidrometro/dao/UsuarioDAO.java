/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrometro.dao;

import entidade.Usuario;
import java.util.Collection;

/**
 *
 * @author e127787
 */
public interface UsuarioDAO {
    
    public Collection<Usuario> find() throws Exception;
    
}
