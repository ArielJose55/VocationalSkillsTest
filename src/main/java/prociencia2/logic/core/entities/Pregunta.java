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
public class Pregunta implements java.io.Serializable{
    
    private String pregunta;
    private Byte respuesta;

    public Pregunta() {
    }

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    public Pregunta(String pregunta, Byte respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Byte getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Byte respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return pregunta+":";
    }
    
}
