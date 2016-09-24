<%-- 
    Document   : examen
    Created on : 23-sep-2016, 13:50:23
    Author     : Husky Siberiano

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Examen</title>
    </head>
    <body>
       <form action="ExamenController" method="post">
            <fieldset>
                <legend>Registro de examenes</legend>
               <div>
                    <label for="idDetalleDefExamen">Id Examen: </label>
                    <input type="text" name="idDetalleDefExamen"
                           value="${examen.idDetalleDefExamen}"
                           placeholder="Id de Examen"
                           readonly="readonly"/> 
                </div>
                <div>
                    <label for="numPreguntas">Num Preguntas: </label>
                    <input type="number" name="numPreguntas"
                           value="${examen.numPreguntas}"
                           placeholder="Numero Preguntas"
                           /> 
                </div>
                <div>
                    <label for="taxonomia">taxonomia: </label>
                    <input type="number" name="taxonomia"
                           value="${examen.taxonomia}"
                           placeholder="taxonomia del Examen"
                           /> 
                </div>
                            <div>
                    <label for="defExamen">defExamen: </label>
                    <input type="text" name="defExamen"
                           value="${examen.defExamen}"
                           placeholder="defExamen"
                           /> 
                </div>
                <div>
                    <label for="resultadosAprendizaje">resultadosAprendizaje: </label>
                    <input type="text" name="resultadosAprendizaje"
                           value="${examen.resultadosAprendizaje}"
                           placeholder="resultados Aprendizaje"
                           /> 
                </div>
          
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
        </form>
    </body>
</html>
