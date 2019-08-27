<%--
  Created by IntelliJ IDEA.
  User: Claudio
  Date: 27-08-2019
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
</head>
<body>

<form action="" method="">

    <table cellspacing="6" cellpaddin:="2" border="1">
        <tr>
            <td colspan="2">
                <input type="radio" name="tipo" value="solicitante"/>Solicitante
                <input type="radio" name="tipo" value="prestamista"/>Prestamista
            </td>
        </tr>
        <tr>
            <td>Rut:</td>
            <td><input type="text" name="rut"/></td>

        </tr>
        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="nombre"/></td>

        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email"/></td>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>Dinero:</td>
            <td><input type="number"></td>
        </tr>
    </table>


    <a href="index.jsp"><input type="button" value="Ya tengo cuenta"/></a>
    <input type="submit" value="Crear"/>

</form>

</body>
</html>
