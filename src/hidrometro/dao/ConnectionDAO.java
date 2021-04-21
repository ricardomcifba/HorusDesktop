/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrometro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author e127787
 */
public abstract class ConnectionDAO {
    
    private static final String URI = "jdbc:postgresql://emb5015448/Maya";
    private static final String USER = "postgres";	
    private static final String PWD = "qwebasa";
	
    private Connection conn = null;
    
        protected Connection getConnection() throws SQLException{
           
	if(this.conn != null)
            return this.conn;
	this.conn = DriverManager.getConnection(URI,USER,PWD);
	return this.conn;
                
    }
}
