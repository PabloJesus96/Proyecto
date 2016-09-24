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
public class Vehiculo {
    private int idVehiculo;
    private String marca;
    private String modelo;
    private String color;
    private int serie;
    private String tipo;

    public Vehiculo(int idVehiculo, String marca, String modelo, String color, int serie, String tipo) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.serie = serie;
        this.tipo = tipo;
    }
    
    public Vehiculo(){
        this(0, "", "", "", 0, "");
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", serie=" + serie + ", tipo=" + tipo + '}';
    }
    
    
    
}
