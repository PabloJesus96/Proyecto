/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Husky Siberiano
 */
public class Examen {
    private int idDetalleDefExamen;
    private int numPreguntas;
    private int taxonomia;
    private String defExamen;
    private String resultadosAprendizaje;

    public Examen(int idDetalleDefExamen, int numPreguntas, int taxonomia, String defExamen, String resultadosAprendizaje) {
        this.idDetalleDefExamen = idDetalleDefExamen;
        this.numPreguntas = numPreguntas;
        this.taxonomia = taxonomia;
        this.defExamen = defExamen;
        this.resultadosAprendizaje = resultadosAprendizaje;
    }
    
    public Examen(){
        this(0, 0, 0, "", "");
    }

   

    public int getIdDetalleDefExamen() {
        return idDetalleDefExamen;
    }

    public void setIdDetalleDefExamen(int idDetalleDefExamen) {
        this.idDetalleDefExamen = idDetalleDefExamen;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }

    public int getTaxonomia() {
        return taxonomia;
    }

    public void setTaxonomia(int taxonomia) {
        this.taxonomia = taxonomia;
    }

    public String getDefExamen() {
        return defExamen;
    }

    public void setDefExamen(String defExamen) {
        this.defExamen = defExamen;
    }

    public String getResultadosAprendizaje() {
        return resultadosAprendizaje;
    }

    public void setResultadosAprendizaje(String resultadosAprendizaje) {
        this.resultadosAprendizaje = resultadosAprendizaje;
    }

    @Override
    public String toString() {
        return "Examen{" + "idDetalleDefExamen=" + idDetalleDefExamen + ", numPreguntas=" + numPreguntas + ", taxonomia=" + taxonomia + ", defExamen=" + defExamen + ", resultadosAprendizaje=" + resultadosAprendizaje + '}';
    }
    
    
}
