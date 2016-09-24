/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Vehiculo;
import util.UtilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Husky Siberiano
 */
public class VehiculoDAOImp implements VehiculoDAO{
    public Connection connection;
    
    public VehiculoDAOImp(){
        connection=UtilDB.getConnection();
    }
   

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        String sql= "INSERT INTO vehiculos"
                + " (marca, modelo, color, serie, tipo) "
                +"VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getColor());
            ps.setInt(4, vehiculo.getSerie());
            ps.setString(5, vehiculo.getTipo());
            ps.executeUpdate();
            
        }catch(SQLException e){
               e.printStackTrace();
        }
    }

    @Override
    public void eliminarVehiculo(int idVehiculo) {
        String sql = "DELETE FROM vehiculos WHERE idvehiculo=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idVehiculo);
            ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    }

    
    @Override
    public void modificarVehiculo(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculos SET "
                + " marca=?, modelo=?, color=?, serie=?, tipo=? WHERE idvehiculo=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getColor());
            ps.setInt(4, vehiculo.getSerie());
            ps.setString(5, vehiculo.getTipo());
            ps.setInt(6, vehiculo.getIdVehiculo());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    }

    @Override
    public List<Vehiculo> desplegarVehiculos() {
       List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
       try{
           Statement s=connection.createStatement();
           ResultSet rs= s.executeQuery("SELECT * FROM vehiculos");
           while(rs.next()){
               Vehiculo vehiculo = new Vehiculo(
               rs.getInt("idvehiculo"),
               rs.getString("marca"),
               rs.getString("modelo"),
               rs.getString("color"),
               rs.getInt("serie"),
               rs.getString("tipo"));
               vehiculos.add(vehiculo);
           }
       }catch(SQLException e){
           e.printStackTrace();
           
       }
       return vehiculos;
    }

    @Override
    public Vehiculo elegirVehiculo(int idVehiculo) {
        Vehiculo vehiculo=null;
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehiculos WHERE idvehiculo=?");
            ps.setInt(1, idVehiculo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                vehiculo = new Vehiculo(
                    rs.getInt("idvehiculo"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("color"),
                    rs.getInt("serie"),
                    rs.getString("tipo"));     
            }
        }catch(SQLException e){
            e.printStackTrace();
                    
                    }
        return vehiculo;
    }


    
}
