<%-- 
    Document   : Lista_vehiculos
    Created on : 23-sep-2016, 6:15:49
    Author     : Husky Siberiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Vehiculos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Color</th>
                    <th>Serie</th>
                    <th>Tipo</th>
                </tr>
            </thead>
            <tbody>
                <core:forEach items="${vehiculos}" var="vehiculo">
                    <tr>
                        <td>${vehiculo.idVehiculo}</td>
                        <td>${vehiculo.marca}</td>
                        <td>${vehiculo.modelo}</td>
                        <td>${vehiculo.color}</td>
                        <td>${vehiculo.serie}</td>
                        <td>${vehiculo.tipo}</td>
                        <td>
                            <a href="VehiculoController?action=cambiar&idVehiculo=${vehiculo.idVehiculo}">Cambiar</a>
                        </td>
                        <td>
                            <a href="VehiculoController?action=borrar&idVehiculo=${vehiculo.idVehiculo}">Borrar</a>
                        </td>
                    </tr>
                </core:forEach>
            </tbody>
        </table>
        <p>
            <a href="VehiculoController?action=agregar">Agregar producto</a>
        </p>
    </body>
</html>
