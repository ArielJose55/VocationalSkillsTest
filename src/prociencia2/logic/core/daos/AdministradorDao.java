
package prociencia2.logic.core.daos;

import prociencia2.logic.core.util.connections.ConnectionPool;
//        java.sql.Connection connection = null;
//        try{
//            connection = ConnectionPool.getConexionPool().getConnection();
//        }finally{
//            if(connection != null){
//                ConnectionPool.getConexionPool().devolverConexion(connection);
//            }
//        }
/**
 *
 * @author Klac
 */
public class AdministradorDao {
    
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia2/logic/core/daos/sentencias");

    public AdministradorDao() {
    }
    
    public boolean verificarUsuario(String passwork) throws java.sql.SQLException {
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            int row;
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Administrador_verifica"));
            sentencia.setString(1, passwork);
            java.sql.ResultSet rs = sentencia.executeQuery();
            rs.last();
            row = rs.getRow();
            rs.close();
            sentencia.close();
            return row == 1;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    public boolean changedPasswordTutor(String password)throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            int row;
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Administrador_ConfiPassTutor"));
            sentencia.setString(1, password);
            row = sentencia.executeUpdate();
            sentencia.close();
            return row == 1;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    public String getPassTutor()throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            java.sql.Statement sentencia = conexion.createStatement();
            java.sql.ResultSet rs = sentencia.executeQuery(RB.getString("Administrador_Tutor"));
            rs.last();
            if(rs.getRow() == 1){
                String pass = rs.getString(1);
                rs.close();
                sentencia.close();
                return pass;
            }
            rs.close();
            sentencia.close();
            throw new java.sql.SQLException("Resulset Vacio");
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    
    
    public boolean updatePassword(String passworkOld,String passwork) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            int i;
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Administrador_ConfiPass"));
            sentencia.setString(1, passwork);
            sentencia.setString(2, passworkOld);
            i = sentencia.executeUpdate();
            sentencia.close();
            return i == 1;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
}
