<%--
  Created by IntelliJ IDEA.
  User: Claudio
  Date: 27-08-2019
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prestamista</title>
</head>
<body>

<h1>Bienvenido solicitante</h1>
<table>
    <tr>
        <td>Nombre:</td>
        <td></td>
    </tr>
    <tr>
        <td>Saldo:</td>
        <td></td>
    </tr>
    <tr>
        <td><a href="index.jsp">Salir</a></td>
    </tr>

</table>

<h1>Personas a quienes has prestado dinero</h1>

<table cellpadding="1" cellspacing="1" border="1">

    <tr>
        <th>Nombre</th>
        <th>Email</th>
        <th>Necesita</th>
        <th>Alcanzado</th>
        <th>Prestado</th>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>

</table>

<h1>Personas que necesitan dinero</h1>

<table cellpadding="1" cellspacing="1" border="1">

    <tr>
        <th>Nombre</th>
        <th>Email</th>
        <th>Necesita</th>
        <th>Alcanzado</th>
        <th>Accion</th>
    </tr>
    <form action="" method="">
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><input type="text" name="accion"><input type="button" value="Prestar" onclick="this.form.submit()"></td>
        </tr>
    </form>


</table>


</body>
</html>
