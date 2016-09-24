/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Vehiculo;
import java.util.List;

/**
 *
 * @author Husky Siberiano
 */
public interface VehiculoDAO {
    void agregarVehiculo(Vehiculo vehiculo);
    void modificarVehiculo(Vehiculo vehiculo);
    void eliminarVehiculo(int idVehiculo);
    List<Vehiculo>desplegarVehiculos();
    Vehiculo elegirVehiculo(int idVehiculo);
}
