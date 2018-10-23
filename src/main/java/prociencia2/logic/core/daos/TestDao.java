/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.daos;

import java.sql.SQLException;
import prociencia2.logic.core.entities.Seccion;
import prociencia2.logic.core.entities.Test;
import prociencia2.logic.core.util.connections.ConnectionPool;

/**
 *
 * @author Klac
 */
public class TestDao {
    
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia2/logic/core/daos/sentencias");

    public TestDao() {
    }
    
    public void addTest(java.sql.Connection connection,Test test) throws java.sql.SQLException{
        try{
             java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Test_add"),java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
             sentencia.setString(1, test.getNombre());
             sentencia.setInt(2, test.getCodigoEstudiante());
             sentencia.executeUpdate();
             java.sql.ResultSet rs = sentencia.getGeneratedKeys();
             int codigoTest = 0;
             while(rs.next()) codigoTest = rs.getInt(1);
             if(codigoTest <= 0){
                 rs.close();
                 sentencia.close();
                 throw new java.sql.SQLException("No se pudo vincular el test al estudiante");
             }
             java.sql.Statement statement = connection.createStatement();
             
             for(Seccion seccion : test.getSecciones()){
                 statement.execute(RB.getString("Seccion_add")+" ('"+seccion.getNombreFormal()+"','"+seccion.getNombre()+"','"+seccion.getSumatoria()+"','"+codigoTest+"')");
             }
             statement.close();
             rs.close();
             sentencia.close();
        }catch(java.sql.SQLException ex){
            throw ex;
        }
    }
    
    public void addTest(java.sql.Statement sentencia,Test test, int codigoEstudiante) throws java.sql.SQLException{
        try{
             sentencia.execute(createTextTest(test, codigoEstudiante), java.sql.Statement.RETURN_GENERATED_KEYS);
             java.sql.ResultSet rs = sentencia.getGeneratedKeys();
             int codigoTest = 0;
             while(rs.next()) codigoTest = rs.getInt(1);
             if(codigoTest <= 0){
                 rs.close();
                 sentencia.close();
                 throw new java.sql.SQLException("No se pudo vincular el test al estudiante");
             }
             
             for(Seccion seccion : test.getSecciones()){
                 sentencia.execute(RB.getString("Seccion_add")+" ('"+seccion.getNombreFormal()+"','"+seccion.getNombre()+"','"+seccion.getSumatoria()+"','"+codigoTest+"')");
             }
             rs.close();
        }catch(java.sql.SQLException ex){
            throw ex;
        }
    }
    
    public java.util.List<Test> getTesOfStudent(int codigStudent) throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();            connection.setAutoCommit(false);
            java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Test_getForStudent"));
            sentencia.setInt(1, codigStudent);
            java.sql.ResultSet rs = sentencia.executeQuery();
            java.util.List<Test> tests = new java.util.ArrayList<Test>();
            SeccionDao seccionDao = new SeccionDao();
            while(rs.next()){
                Test test = new Test(rs.getInt(1), rs.getString(2),rs.getInt(3));
                test.setSecciones(seccionDao.getListSeccionOfTest(test.getCodigo()));
                tests.add(test);
            }
            
            rs.close();
            sentencia.close();
            return tests;
        }finally{
            if(connection != null){
                ConnectionPool.getConexionPool().devolverConexion(connection);
            }
        }
    }
    
    private String createTextTest(Test text, int codigoEstudiante){
        StringBuilder sb = new StringBuilder(RB.getString("Test_Insert"));
        sb.append(" ('");  sb.append(text.getNombre());
        sb.append("','");   sb.append(codigoEstudiante);
        sb.append("')");
        return sb.toString();
    }
    
}
