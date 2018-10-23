/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.daos;

import java.sql.SQLException;
import prociencia2.logic.core.entities.Seccion;
import prociencia2.logic.core.util.connections.ConnectionPool;

/**
 *
 * @author Klac
 */
public class SeccionDao {
    
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia2/logic/core/daos/sentencias");

    public SeccionDao() {
    }
    
    public java.util.List<Seccion> getListSeccionOfTest(int codigoTest) throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();
            java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Secion_getFotTest"));
            sentencia.setInt(1, codigoTest);
            java.sql.ResultSet rs = sentencia.executeQuery();
            java.util.List<Seccion> list = new java.util.ArrayList<Seccion>();
            while(rs.next()){
                Seccion secion = new Seccion(rs.getString(2),rs.getString(1),rs.getInt(3));
                list.add(secion);
            }
            rs.close();
            sentencia.close();
            return list;
        }finally{
            if(connection != null){
                ConnectionPool.getConexionPool().devolverConexion(connection);
            }
        }
    }
}
