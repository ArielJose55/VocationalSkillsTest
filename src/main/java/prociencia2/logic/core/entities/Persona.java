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
public class Persona implements java.io.Serializable{
    
    private Integer codigo;
    private String nombreCompleto;
    private java.sql.Date fechaNacimiento;
    private java.sql.Date fechaRegistro;
    private Character sexo;
    private OcupacionEnum tipoOcupacion;
    private String lugar;
    private Boolean procesado;
    private Ocupacion ocupacion;
    private Test testAptitudes;
    private Test testIntereses;

    public Persona() {
    }

    public Persona(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Persona(Integer codigo, String nombreCompleto) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = normalizeText(nombreCompleto);
    }

    public java.sql.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public java.sql.Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(java.sql.Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }
    
    public OcupacionEnum getTipoOcupacion() {
        return tipoOcupacion;
    }
    
    public int getEnteroDeOcupacion(OcupacionEnum enumOcupacion){
        switch(enumOcupacion){
            case ESTUDIANTE: return 1;
            case EMPLEADO: return 2;
            default: return 3;
        }
    }
    
    public String getStringDeOcupacion(OcupacionEnum enumOcupacion){
        switch(enumOcupacion){
            case ESTUDIANTE: return "Estudiante";
            case EMPLEADO: return "Empleado";
            default: return "Otro";
        }
    }

    public OcupacionEnum getOcupacionDeEntero(int enteroOcupacion){
        switch(enteroOcupacion){
            case 1: return OcupacionEnum.ESTUDIANTE;
            case 2: return OcupacionEnum.EMPLEADO;
            case 3: return OcupacionEnum.OTRO;
            default: throw new RuntimeException("El entero no corresponde a una ocupación");
        }
    }
    
    public void setTipoOcupacion(OcupacionEnum tipoOcupacion) {
        this.tipoOcupacion = tipoOcupacion;
    }
    
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = normalizeText(lugar);
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    public Test getTestAptitudes() {
        return testAptitudes;
    }

    public void setTestAptitudes(Test testAptitudes) {
        this.testAptitudes = testAptitudes;
    }

    public Test getTestIntereses() {
        return testIntereses;
    }

    public void setTestIntereses(Test testIntereses) {
        this.testIntereses = testIntereses;
    }
    
    @Override
    public String toString() {
        return nombreCompleto;
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
