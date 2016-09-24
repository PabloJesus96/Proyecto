/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VehiculoDAO;
import dao.VehiculoDAOImp;
import model.Vehiculo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Husky Siberiano
 */
@WebServlet(name = "VehiculoController", urlPatterns = {"/VehiculoController"})
public class VehiculoController extends HttpServlet{
    private final String LISTA_VEHICULOS = "/Lista_vehiculos.jsp";
    private final String AGREGAR_CAMBIAR = "/Vehiculo.jsp";
    private VehiculoDAO dao;
    
    public VehiculoController(){
        dao = new VehiculoDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward="";
        if(action.equalsIgnoreCase("borrar")){
            forward=LISTA_VEHICULOS;
            int idVehiculo=Integer.parseInt(request.getParameter("idVehiculo"));
            dao.eliminarVehiculo(idVehiculo);
            request.setAttribute("vehiculos", dao.desplegarVehiculos());
            
        }else if(action.equalsIgnoreCase("cambiar")){
            forward=AGREGAR_CAMBIAR;
            int idVehiculo= Integer.parseInt(request.getParameter("idVehiculo"));
            Vehiculo vehiculo= dao.elegirVehiculo(idVehiculo);
            request.setAttribute("vehiculo", vehiculo);
            
        }else if(action.equalsIgnoreCase("agregar")){
            forward=AGREGAR_CAMBIAR;
            
        }else{
            forward=LISTA_VEHICULOS;
            request.setAttribute("vehiculos", dao.desplegarVehiculos());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMarca(request.getParameter("marca"));
        vehiculo.setModelo(request.getParameter("modelo"));
        vehiculo.setColor(request.getParameter("color"));
        vehiculo.setSerie(Integer.parseInt(request.getParameter("serie")));
        vehiculo.setTipo(request.getParameter("tipo"));
        String idVehiculo = request.getParameter("idVehiculo");
        if(idVehiculo==null || idVehiculo.isEmpty()){
            dao.agregarVehiculo(vehiculo);
        }else{
            vehiculo.setIdVehiculo(Integer.parseInt(idVehiculo));
            dao.modificarVehiculo(vehiculo);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_VEHICULOS);
        request.setAttribute("vehiculos", dao.desplegarVehiculos());
        view.forward(request, response);
    }
    
    
    
}
