/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.daos;

import prociencia2.logic.core.entities.Ocupacion;
import prociencia2.logic.core.entities.Persona;
import prociencia2.logic.core.util.connections.ConnectionPool;

/**
 *
 * @author Klac
 */
public class PersonaDao {
    
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia2/logic/core/daos/sentencias");

    public PersonaDao() {
    }
    
    public void registrarPersona(Persona persona) throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();
            connection.setAutoCommit(false);
            java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Persona_add"), java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, persona.getNombreCompleto());
            sentencia.setDate(2, persona.getFechaNacimiento());
            sentencia.setDate(3, persona.getFechaRegistro());
            sentencia.setString(4, persona.getSexo().toString());
            sentencia.setBoolean(5, Boolean.FALSE);
            sentencia.setInt(6, persona.getEnteroDeOcupacion(persona.getTipoOcupacion()));
            sentencia.setString(7, persona.getLugar());
            sentencia.executeUpdate();
            java.sql.ResultSet rs = sentencia.getGeneratedKeys();
            int i = 0;
            while(rs.next()){
               i = rs.getInt(1);
            }
            if(i <= 0){
                rs.close();
                sentencia.close();
                throw new java.sql.SQLException("No se pudo añadir al estudiante en la base de datos");
            }
            rs.close();
            sentencia.close();
            persona.getOcupacion().setCodigoPersona(i);
            new OcupacionDao().registrar(connection, persona.getOcupacion());
            
            TestDao testDao = new TestDao();
            persona.getTestAptitudes().setCodigoEstudiante(i);
            persona.getTestIntereses().setCodigoEstudiante(i);
            testDao.addTest(connection, persona.getTestAptitudes());
            testDao.addTest(connection, persona.getTestIntereses());
            
        }catch(java.sql.SQLException ex){
            if(connection != null){
                connection.rollback();
            }
            throw ex;
        }finally{
            if(connection != null){
                connection.setAutoCommit(true);
                ConnectionPool.getConexionPool().devolverConexion(connection);
            }
        }
    }
    
    public java.util.List<Persona> getListAllEstudiante() throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();
            java.sql.Statement sentencia = connection.createStatement();
            final java.util.List<Persona> list = new java.util.ArrayList<Persona>();
            java.sql.ResultSet rs = sentencia.executeQuery(RB.getString("Persona_All"));
            while(rs.next()){
                Persona persona = new Persona(rs.getInt(1), rs.getString(2));
                persona.setFechaNacimiento(rs.getDate(3));
                persona.setFechaRegistro(rs.getDate(4));
                persona.setSexo(rs.getString(5).charAt(0));
                persona.setProcesado(rs.getBoolean(6));
                persona.setTipoOcupacion(persona.getOcupacionDeEntero(rs.getInt(7)));
                persona.setLugar(rs.getString(8));
                list.add(persona);
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
    
    public java.util.List<java.sql.Date> getFechas() throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            java.util.List<java.sql.Date> lista = new java.util.ArrayList<java.sql.Date>();
            java.sql.Statement sentencia = conexion.createStatement(); java.sql.ResultSet rs = sentencia.executeQuery(RB.getString("Persona_getFechas"));
            while(rs.next()){
                lista.add(rs.getDate(1));
            }
            rs.close();
            sentencia.close();
            return lista;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    public void registrarPersona(java.util.List<Persona> personas) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            conexion.setAutoCommit(false);
            java.sql.Statement sentencia = conexion.createStatement();
            java.sql.Statement sentencia2 = conexion.createStatement();
            for(Persona person: personas){ 
                sentencia.execute(getCompleteStatementPerson(person),java.sql.Statement.RETURN_GENERATED_KEYS);
                java.sql.ResultSet rs = sentencia.getGeneratedKeys();
                rs.next();
                int codigo = rs.getInt(1);
                sentencia.execute(getCompleteStatementOcupation(person.getOcupacion(), codigo));
//                sentencia.execute(getCompleteStatementTest(person.getPrueba(), codigo));
                new TestDao().addTest(sentencia, person.getTestAptitudes(), codigo);
                new TestDao().addTest(sentencia, person.getTestIntereses(), codigo);
                rs.close();
            }        
            conexion.commit();
            sentencia2.close();
            sentencia.close();
            
        }catch(java.sql.SQLException ex){
            if(conexion != null)
                conexion.rollback();
            throw ex;
        }finally{
            if(conexion != null){
                conexion.setAutoCommit(true);
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    public void uptateProcessPerson(java.util.List<Persona> list) throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();
            java.sql.Statement sentencia = connection.createStatement();
            sentencia.execute(getCompleteStatementProcees(list));
            sentencia.close();
        }finally{
            if(connection != null){
                 ConnectionPool.getConexionPool().devolverConexion(connection);
            }
        }
    }
    
    public void removeEstudiantes(Integer[] codes) throws java.sql.SQLException{
       
        java.sql.Connection conexion = null;
        
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            conexion.setAutoCommit(false);
            java.sql.Statement sentencia = conexion.createStatement();
            for(Integer code : codes){
                 sentencia.executeUpdate(RB.getString("Persona_Delete")+code);
            }
            conexion.commit();
            sentencia.close();
        }catch(java.sql.SQLException ex){
            if(conexion != null)
                conexion.rollback();
            throw ex;
        }finally{
            if(conexion != null){
                conexion.setAutoCommit(true);
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
//    --------------------------------------------------------------------------------------------------------------------------
 
    private String getCompleteStatementPerson(Persona persona){
        StringBuilder sb = new StringBuilder(RB.getString("Persona_Insert"));
        sb.append(" ('");      sb.append(persona.getNombreCompleto());
        sb.append("','");      sb.append(persona.getFechaNacimiento());
        sb.append("','");      sb.append(persona.getFechaRegistro());
        sb.append("','");      sb.append(persona.getSexo());
        sb.append("',b'0','"); sb.append(persona.getEnteroDeOcupacion(persona.getTipoOcupacion()));
        sb.append("','");   sb.append(persona.getLugar());
        sb.append("')");
        return sb.toString();
    }
    
    private String getCompleteStatementOcupation(Ocupacion ocupacion , int codigoStudent){
        StringBuilder sb = new StringBuilder(RB.getString("Ocupacion_Insert"));
        sb.append(" (");    sb.append(checkNull(ocupacion.getGradoCursado()));
        sb.append(",");     sb.append(checkNull(ocupacion.getInstitucion()));
        sb.append(",");     sb.append(checkNull(ocupacion.getCargo()));
        sb.append(",");     sb.append(checkNull(ocupacion.getNivelEscolaridad()));
        sb.append(",");     sb.append(checkNull(ocupacion.getPrograma()));
        sb.append(",");     sb.append(checkNull(ocupacion.isCulmino()));
        sb.append(",");     sb.append(checkNull(ocupacion.getUltimoGrado()));
        sb.append(",");     sb.append(checkNull(codigoStudent));
        sb.append(")");
        return sb.toString();
    }
    
    private String getCompleteStatementProcees(java.util.List<Persona> list){
        StringBuilder sb = new StringBuilder(RB.getString("Persona_Uptate_ALL"));
        for(int i = 0; i < list.size() ; i++){
            sb.append(" codigo = ");
            sb.append(list.get(i).getCodigo());
            if(i != list.size() - 1)
                sb.append(" OR");
        }
        return sb.toString();
    }
    
    
    private String checkNull(Integer entero){
        if(entero == null){
            return "NULL";
        }else{
            return "'"+entero.intValue()+"'";
        }
    }
    
    private String checkNull(Boolean bool){
        if(bool == null){
            return "NULL";
        }else{
            return "b'"+((bool.booleanValue())? "1" : "0")+"'";
        }
    }
    
    private String checkNull(String text){
        if(text == null || text.compareTo("") == 0){
            return "NULL";
        }else{
            return "'"+text+"'";
        }
    }
}
