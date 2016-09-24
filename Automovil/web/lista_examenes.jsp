<%-- 
    Document   : lista_examenes
    Created on : 23-sep-2016, 13:44:32
    Author     : Husky Siberiano



--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Examenes</title>
    </head>
    <body>
         <table>
            <thead>
                <tr>
                    <th>Id Examen</th>
                    <th>Num Preguntas</th>
                    <th>Taxonomia</th>
                    <th>DefExamen</th>
                    <th>Resultados</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${examenes}" var="examen">
                    <tr>
                        <td>${examen.idDetalleDefExamen}</td>
                        <td>${examen.numPreguntas}</td>
                        <td>${examen.taxonomia}</td>
                        <td>${examen.defExamen}</td>
                        <td>${examen.resultadosAprendizaje}</td>
                        <td>
                            <a href="ExamenController?action=cambiar&idDetalleDefExamen=${examen.idDetalleDefExamen}">Cambiar</a>
                        </td>
                        <td>
                            <a href="ExamenController?action=borrar&idDetalleDefExamen=${examen.idDetalleDefExamen}">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ExamenController?action=agregar">Agregar Examen</a>
        </p>
    </body>
</html>
