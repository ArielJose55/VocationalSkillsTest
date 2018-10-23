/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia2.logic.core.util.questionario;

import prociencia2.logic.core.entities.Pregunta;
import prociencia2.logic.core.entities.Seccion;
import prociencia2.logic.core.entities.Test;
import prociencia2.logic.core.entities.TypeTest;

/**
 *
 * @author Klac
 */
public class ReaderXMLQuestionario {
    
    public static Test getTestAptitudes() throws Exception{
        final Test test = new Test(null,"Aptitudes Vocacionales");
        java.util.List<Seccion> secciones = new java.util.ArrayList<Seccion>();
        org.jdom2.Document documento = new org.jdom2.input.SAXBuilder().build(ReaderXMLQuestionario.class.getResource("Questionario.xml"));
        org.jdom2.Element root = documento.getRootElement();
        org.jdom2.Element tests = root.getChild(test.getNombre().toLowerCase().replaceAll(" ", "_"), org.jdom2.Namespace.NO_NAMESPACE);
//        System.out.println(tests.getAttributes());
        for(org.jdom2.Element section : tests.getChildren()){
            Seccion seccion = new Seccion(section.getAttributeValue("nombre"));
            seccion.setTypeTest(TypeTest.APTITUDES);
            java.util.List<Pregunta> preguntas = new java.util.ArrayList<Pregunta>();
            for(org.jdom2.Element question: section.getChildren()){
                Pregunta pregunta = new Pregunta();
                if(question.getName().compareTo("clave") != 0){
                    pregunta.setPregunta(question.getTextNormalize());
                    preguntas.add(pregunta);
                }else
                    seccion.setNombreFormal(question.getTextNormalize());
//                System.out.println(question.getTextNormalize());
            }
            seccion.setPreguntas(preguntas);
            secciones.add(seccion);
        }
        test.setSecciones(secciones);
        return test;
    }
    
//    getQualifiedName() == getName == test
//    getAttributeValue("tipo") == Intereres Profesionales
    
    
    public static Test getTestIntereses() throws Exception{
        final Test test = new Test(null,"Intereres Ocupacionales");
        java.util.List<Seccion> secciones = new java.util.ArrayList<Seccion>();
        org.jdom2.Document documento = new org.jdom2.input.SAXBuilder().build(ReaderXMLQuestionario.class.getResource("Questionario.xml"));
        org.jdom2.Element root = documento.getRootElement();
        org.jdom2.Element tests = root.getChild(test.getNombre().toLowerCase().replaceAll(" ", "_"), org.jdom2.Namespace.NO_NAMESPACE);
//        System.out.println(tests.getAttributes());
        for(org.jdom2.Element section : tests.getChildren()){
            Seccion seccion = new Seccion(section.getAttributeValue("nombre"));
            seccion.setTypeTest(TypeTest.INTERESES);
            java.util.List<Pregunta> preguntas = new java.util.ArrayList<Pregunta>();
            for(org.jdom2.Element question: section.getChildren()){
                Pregunta pregunta = new Pregunta();
                if(question.getName().compareTo("clave") != 0){
                    pregunta.setPregunta(question.getTextNormalize());
                    preguntas.add(pregunta);
                }else
                    seccion.setNombreFormal(question.getTextNormalize());
//                System.out.println(question.getTextNormalize());
            }
            seccion.setPreguntas(preguntas);
            secciones.add(seccion);
        }
        test.setSecciones(secciones);
        return test;
    } 
}