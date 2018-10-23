/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.entities;

/**
 *
 * @author Klac
 */
public class Seccion implements java.io.Serializable{
    
    private String nombre;
    private java.util.List<Pregunta> preguntas;
    private String nombreFormal;
    private Integer sumatoria;
    private TypeTest typeTest;

    public Seccion() {
        preguntas = new java.util.ArrayList<Pregunta>();
    }

    public Seccion(String nombre) {
        this();
        this.nombre = nombre;
    }

    public Seccion(String nombre, java.util.List<Pregunta> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public Seccion(String nombre, String nombreFormal, Integer sumatoria) {
        this.nombre = nombre;
        this.nombreFormal = nombreFormal;
        this.sumatoria = sumatoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public java.util.List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(java.util.List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getNombreFormal() {
        return nombreFormal;
    }

    public void setNombreFormal(String nombreFormal) {
        this.nombreFormal = nombreFormal;
    }

    public Integer getSumatoria() {
        return sumatoria;
    }

    public void setSumatoria(Integer sumatoria) {
        this.sumatoria = sumatoria;
    }

    public TypeTest getTypeTest() {
        return typeTest;
    }

    public void setTypeTest(TypeTest typeTest) {
        this.typeTest = typeTest;
    }
    
}
