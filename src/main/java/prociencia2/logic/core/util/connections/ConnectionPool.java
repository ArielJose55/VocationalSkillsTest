/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.util.connections;

import java.sql.Connection;
import java.sql.Driver;

/**
 *
 * @author Klac
 */
public class ConnectionPool {
    
    private static ConnectionPool poolConexion=null;
    private final java.util.ResourceBundle rs=java.util.ResourceBundle.getBundle("prociencia2/logic/core/util/connections/basicConnection");
//    private final java.sql.Connection connectionTable;
    
    private ConnectionPool() throws java.sql.SQLException {
       
        maxConex=Byte.parseByte(rs.getString("max_con"));
        minConex=Byte.parseByte(rs.getString("min_con"));
        cantConex=Byte.parseByte(rs.getString("cant_ins"));
        try {
            Class.forName(rs.getString("driver"));
        } catch (ClassNotFoundException ex) {
        }
        libres=new java.util.ArrayList<java.sql.Connection>();
        usadas=new java.util.ArrayList<java.sql.Connection>();
        instanciarConexiones(cantConex);
//        connectionTable = java.sql.DriverManager.getConnection(rs.getString("urldatabase")+rs.getString("database"), rs.getString("user"), "DNcqTVNL6syynbv4");
    }
    
    public static ConnectionPool getConexionPool() throws java.sql.SQLException{
        if(poolConexion==null){
            poolConexion=new ConnectionPool();
        }
        return poolConexion;
    }
    
    public java.sql.Connection getConnection() throws java.sql.SQLException{
        if(libres.isEmpty()){
            if(!instanciarMas()){
                throw new RuntimeException();
            }
        }
        java.sql.Connection aux=libres.remove(0);
        usadas.add(aux);
       
        return aux;
    }
    
    private void instanciarConexiones(byte cantidad) throws java.sql.SQLException{
  
        java.sql.Connection con;
        for (byte i = 0; i <cantidad; i++) {
            con= java.sql.DriverManager.getConnection(rs.getString("urldatabase")+rs.getString("database"), rs.getString("user"), "");
            libres.add(con);
        }
    }


    
    private boolean instanciarMas() throws java.sql.SQLException{
        byte cantActual=(byte) (libres.size() + usadas.size());
        
        byte x=(byte) Math.min(maxConex-cantActual, cantConex);
        
        if(x>0){
            instanciarConexiones(x);
        }
        return x>0;
    } 
    
    public void devolverConexion(java.sql.Connection conexion){
        boolean de=usadas.remove(conexion);
        if(de){
            libres.add(conexion);
        }
    }
    
    {
        Runtime.getRuntime().addShutdownHook(new ThreadClose());
    }
    
    private class ThreadClose extends Thread{

        @Override
        public void run() {
            try {
                for (java.sql.Connection connection : libres) {
                    connection.close();
                }
                for (java.sql.Connection connection : usadas) {
                    connection.close();
                }
            } catch (java.sql.SQLException e) {}
        }
        
    }
    
    private final byte maxConex;
    private final byte minConex;
    private final byte cantConex;
    private final java.util.ArrayList<java.sql.Connection> libres;
    private final java.util.ArrayList<java.sql.Connection> usadas;
}
