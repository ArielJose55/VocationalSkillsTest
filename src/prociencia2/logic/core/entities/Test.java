/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.entities;

import java.util.List;

/**
 *
 * @author Klac
 */
public class Test implements java.io.Serializable{
    
    private Integer codigo;
    private String nombre;
    private Integer codigoEstudiante;
    private java.util.List<Seccion> secciones;
    

    public Test() {
        secciones = new java.util.ArrayList<Seccion>();
    }

    public Test(Integer codigo){
        this();
        this.codigo = codigo;
    }
    
    public Test(Integer codigo,String nombre) {
        this(codigo);
        this.nombre = nombre;
    }

    public Test(Integer codigo, String nombre, Integer codigoEstudiante) {
        this(codigo, nombre);
        this.codigoEstudiante = codigoEstudiante;
    }

    public Test(Integer codigo, String nombre, Integer codigoEstudiante, List<Seccion> secciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoEstudiante = codigoEstudiante;
        this.secciones = secciones;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public java.util.List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(java.util.List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public Integer getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }
    
}
