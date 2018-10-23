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
public class Ocupacion implements java.io.Serializable{
    private Integer codigo;
    private Integer gradoCursado;
    private String institucion;
    private String cargo;
    private String nivelEscolaridad;
    private String programa;
    private Boolean culmino;
    private Integer ultimoGrado;
    private Integer codigoPersona;

    public Ocupacion() {
    }

    public Ocupacion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getGradoCursado() {
        return gradoCursado;
    }

    public void setGradoCursado(Integer gradoCursado) {
        this.gradoCursado = gradoCursado;
    }
    
    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = normalizeText(institucion);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = normalizeText(cargo);
    }

    public String getNivelEscolaridad() {
        return nivelEscolaridad;
    }

    public void setNivelEscolaridad(String nivelEscolaridad) {
        this.nivelEscolaridad = normalizeText(nivelEscolaridad);
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = normalizeText(programa);
    }

    public Boolean isCulmino() {
        return culmino;
    }

    public void setCulmino(Boolean culmino) {
        this.culmino = culmino;
    }

    public Integer getUltimoGrado() {
        return ultimoGrado;
    }

    public void setUltimoGrado(Integer ultimoGrado) {
        this.ultimoGrado = ultimoGrado;
    }

    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
    
    private String normalizeText(String text){
        if(text == null || text.compareTo("") == 0) return null;
        if(text.contains(" ")){
            String[] texts = text.split(" ");
            StringBuilder sb = new StringBuilder();
            for(String texto : texts){
                sb.append(normalizeText(texto));
                sb.append(" ");
            }
            return sb.toString();
        }else{
            if(text.length() > 0){
                String newText = text.toLowerCase();
                return newText.replaceFirst(String.valueOf(newText.charAt(0)), String.valueOf(Character.toUpperCase(newText.charAt(0))));
            }
            return text;
        }
    }
}
