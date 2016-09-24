/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ExamenDAO;
import dao.ExamenDaoImp;
import model.Examen;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Husky Siberiano
 */
public class ExamenController extends HttpServlet{
    private final String LISTA_EXAMENES = "/lista_examenes.jsp";
    private final String AGREGAR_MODIFICAR = "/examen.jsp";
    private ExamenDAO dao;
    
    public ExamenController(){
        dao = new ExamenDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        if(action.equalsIgnoreCase("borrar")){
            forward=LISTA_EXAMENES;
            int idDetalleDefExamen=Integer.parseInt(request.getParameter("idDetalleDefExamen"));
            dao.eliminarExamen(idDetalleDefExamen);
            request.setAttribute("examenes", dao.desplegarExamenes());
        
        }else if (action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_MODIFICAR;
            int idDetalleDefExamen=Integer.parseInt(request.getParameter("idDetalleDefExamen"));
            Examen examen=dao.elegirExamen(idDetalleDefExamen);
            request.setAttribute("examen", examen);
        
        }else if(action.equalsIgnoreCase("agregar")){
            forward=AGREGAR_MODIFICAR;
        }else{
            forward= LISTA_EXAMENES;
            request.setAttribute("examenes", dao.desplegarExamenes());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Examen examen = new Examen();
        examen.setNumPreguntas(Integer.parseInt(request.getParameter("numPreguntas")));
        examen.setTaxonomia(Integer.parseInt(request.getParameter("taxonomia")));
        examen.setDefExamen(request.getParameter("defExamen"));
        examen.setResultadosAprendizaje(request.getParameter("resultadosAprendizaje"));
        String idDetalleDefExamen = request.getParameter("idDetalleDefExamen");
        if(idDetalleDefExamen==null || idDetalleDefExamen.isEmpty()){
            dao.agregarExamen(examen);
    }else{
            examen.setIdDetalleDefExamen(Integer.parseInt(idDetalleDefExamen));
            dao.modificarExamen(examen);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_EXAMENES);
        request.setAttribute("examenes", dao.desplegarExamenes());
        view.forward(request, response);
    }
    
    
}
