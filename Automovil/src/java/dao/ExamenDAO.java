/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Examen;
import java.util.List;

/**
 *
 * @author Husky Siberiano
 */
public interface ExamenDAO {
    void agregarExamen(Examen examen);
    void modificarExamen(Examen examen);
    void eliminarExamen(int idDetalleDefExamen);
    List<Examen>desplegarExamenes();
    Examen elegirExamen(int idDetalleDefExamen);

    
}
