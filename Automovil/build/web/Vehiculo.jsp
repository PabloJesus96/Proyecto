<%-- 
    Document   : Vehiculo
    Created on : 23-sep-2016, 6:16:11
    Author     : Husky Siberiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Vehiculos</title>
    </head>
    <body>
        <form action="VehiculoController" method="post">
            <fieldset>
                <legend>Registro de vehiculos </legend>
               <div>
                    <label for="idVehiculo">Id vehiculo: </label>
                    <input type="text" name="idVehiculo"
                           value="${vehiculo.idVehiculo}"
                           placeholder="Id de vehiculo"
                           readonly="readonly"/> 
                </div>
                <div>
                    <label for="marca">Marca:</label>
                    <input type="text" name="marca"
                           value="${vehiculo.marca}"
                           placeholder="Marca del Vehiculo"
                           /> 
                </div>
                <div>
                    <label for="modelo">Modelo: </label>
                    <input type="text" name="modelo"
                           value="${vehiculo.modelo}"
                           placeholder="Modelo del Vehiculo"
                           /> 
                </div>
                <div>
                    <label for="color">Color: </label>
                    <input type="text" name="color"
                           value="${vehiculo.color}"
                           placeholder="Color de Vehiculo"
                           /> 
                </div>
                <div>
                    <label for="serie">Serie: </label>
                    <input type="numeric" name="serie"
                           value="${vehiculo.serie}"
                           placeholder="Serie de Vehiculo"
                           /> 
                </div>
                <div>
                    <label for="tipo">Tipo: </label>
                    <input type="text" name="tipo"
                           value="${vehiculo.tipo}"
                           placeholder="Tipo de Vehiculo"
                           /> 
                </div>
                
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
        </form>
            
    </body>
</html>
