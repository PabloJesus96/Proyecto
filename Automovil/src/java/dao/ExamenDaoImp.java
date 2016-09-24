/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.UtilDB;

/**
 *
 * @author Husky Siberiano
 */
public class ExamenDaoImp implements ExamenDAO{
    public Connection connection;
    
    public ExamenDaoImp(){
        connection= UtilDB.getConnection();
    }

    @Override
    public void agregarExamen(Examen examen) {
        String sql= "INSERT INTO examenes"
                + " (num_preguntas, taxonomia, def_examen, resultados_aprendizaje)"
                + "VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, examen.getNumPreguntas());
            ps.setInt(2, examen.getTaxonomia());
            ps.setString(3, examen.getDefExamen());
            ps.setString(4, examen.getResultadosAprendizaje());
            ps.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    }

    

    @Override
    public void eliminarExamen(int idDetalleDefExamen) {
         String sql = "DELETE FROM examenes WHERE id_examen=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDetalleDefExamen);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    }

    @Override
    public void modificarExamen(Examen examen) {
        String sql = "UPDATE examenes SET "
                + " num_preguntas=?, taxonomia=?, def_examen=?, resultados_aprendizaje=? WHERE id_examen=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, examen.getNumPreguntas());
            ps.setInt(2, examen.getTaxonomia());
            ps.setString(3, examen.getDefExamen());
            ps.setString(4, examen.getResultadosAprendizaje());
            ps.setInt(5, examen.getIdDetalleDefExamen());
            ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    }

    @Override
    public List<Examen> desplegarExamenes() {
        List<Examen> examenes =new ArrayList<Examen>();
        try{
            Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM examenes");
            while(rs.next()){
                Examen examen = new Examen(
                rs.getInt("id_examen"),
                        rs.getInt("num_preguntas"),
                rs.getInt("taxonomia"),
                rs.getString("def_examen"),
                rs.getString("resultados_aprendizaje"));
                examenes.add(examen);
                
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return examenes;
    }

    @Override
    public Examen elegirExamen(int idDetalleDefExamen) {
        Examen examen = null;
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM examenes WHERE id_examen=?");
            ps.setInt(1, idDetalleDefExamen);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                examen = new Examen(
                rs.getInt("id_examen"),
                rs.getInt("num_preguntas"),
                rs.getInt("taxonomia"),
                rs.getString("def_examen"),
                rs.getString("resultados_aprendizaje"));
                
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
            return examen;
    }
}
    
