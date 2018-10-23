/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.daos;

import prociencia2.logic.core.entities.Ocupacion;
import prociencia2.logic.core.util.connections.ConnectionPool;

/**
 *
 * @author Klac
 */
public class OcupacionDao {
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia2/logic/core/daos/sentencias");

    public OcupacionDao() {
    }
    
    public boolean registrar(java.sql.Connection connection, Ocupacion ocupacion) throws java.sql.SQLException{
        try{
            java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Ocupacion_registro"));
            checkNull(sentencia, 1, ocupacion.getGradoCursado());
            checkNull(sentencia, 2, ocupacion.getInstitucion());
            checkNull(sentencia, 3, ocupacion.getCargo());
            checkNull(sentencia, 4, ocupacion.getNivelEscolaridad());
            checkNull(sentencia, 5, ocupacion.getPrograma());
            checkNull(sentencia, 6, ocupacion.isCulmino());
            checkNull(sentencia, 7, ocupacion.getUltimoGrado());
            sentencia.setInt(8, ocupacion.getCodigoPersona());
            boolean i = sentencia.execute();
            sentencia.close();
            return i;
        }catch(java.sql.SQLException ex){
            throw ex;
        }
    }
    
    public Ocupacion getOcupacion(int codigoEstudiante) throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();
            java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Ocupacion_get"));
            sentencia.setInt(1, codigoEstudiante);
            java.sql.ResultSet rs = sentencia.executeQuery();
            Ocupacion ocupacion = new Ocupacion();
            while(rs.next()){
                ocupacion.setCodigo(getWasNullInteger(rs, 1));
                ocupacion.setGradoCursado(getWasNullInteger(rs, 2));
                ocupacion.setInstitucion(getWasNullString(rs, 3));
                ocupacion.setCargo(getWasNullString(rs, 4));
                ocupacion.setNivelEscolaridad(getWasNullString(rs, 5));
                ocupacion.setPrograma(getWasNullString(rs, 6));
                ocupacion.setCulmino(getWasNullBoolean(rs, 7));
                ocupacion.setUltimoGrado(getWasNullInteger(rs, 8));
                ocupacion.setCodigoPersona(codigoEstudiante);
            }
            rs.close();
            sentencia.close();
            return ocupacion;
        }finally{
            if(connection != null){
                ConnectionPool.getConexionPool().devolverConexion(connection);
            }
        }
    }
    
    //---------------------------------------------------------------------------------------------------------------------------
    
    private Integer getWasNullInteger(java.sql.ResultSet rs, int column) throws java.sql.SQLException{
        Integer i = rs.getInt(column);
        return rs.wasNull() ? null: i ;
    }
    
    private String getWasNullString(java.sql.ResultSet rs, int column) throws java.sql.SQLException{
        String i = rs.getString(column);
        return rs.wasNull() ? null:i;
    }
    
    private Boolean getWasNullBoolean(java.sql.ResultSet rs, int column) throws java.sql.SQLException{
        Boolean i = rs.getBoolean(column);
        return rs.wasNull()? null: i;
    }
    
    private void checkNull(java.sql.PreparedStatement sentencia,int column,Integer entero) throws java.sql.SQLException{
        if(entero == null){
            sentencia.setNull(column, java.sql.Types.INTEGER);
        }else{
            sentencia.setInt(column, entero);
        }
    }
    
    private void checkNull(java.sql.PreparedStatement sentencia,int column,Boolean bool) throws java.sql.SQLException{
        if(bool == null){
            sentencia.setNull(column, java.sql.Types.BIT);
        }else{
            sentencia.setBoolean(column,bool);
        }
    }
    
    private void checkNull(java.sql.PreparedStatement sentencia,int column , String text) throws java.sql.SQLException{
        if(text == null || text.compareTo("") == 0){
            sentencia.setNull(column, java.sql.Types.VARCHAR);
        }else{
            sentencia.setString(column, text);
        }
    }
}
