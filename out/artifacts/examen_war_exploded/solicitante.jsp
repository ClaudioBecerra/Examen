<%@ page import="model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Claudio
  Date: 27-08-2019
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        // resive la sesion
        HttpSession sesionOk = request.getSession();
        Usuario user = (Usuario) sesionOk.getAttribute("usuarioLogin");
        //si la sesion no existe redirecciona al index
        if (sesionOk.getAttribute("usuarioLogin") == null) {
            response.sendRedirect("index.jsp");
        }
        if (sesionOk.getAttribute("usuarioLogin")!=null) {
            if (((Usuario) sesionOk.getAttribute("usuarioLogin")).getTipo().equalsIgnoreCase("prestamista")) {
                response.sendRedirect("prestamista.jsp");
            }
        }
    %>


    <title>Solicitante</title>
</head>
<body>
<h1>Bienvenido solicitante</h1>
<table>
    <tr>
        <td>Nombre:</td>
        <td><%=user.getNombre()%>
        </td>
    </tr>
    <tr>
        <td>Necesitas:</td>
        <td><%=user.getMonto()%>
        </td>
    </tr>
    <tr>
        <td>Prestamos:</td>
        <td><%=user.getSaldo()%>
        </td>
    </tr>
    <tr>
        <form action="Logout" method="post">
        <td><input type="submit" value="salir"></td>
        </form>
    </tr>

</table>

<h1>Personas que te han prestado dinero</h1>

<table cellpadding="1" cellspacing="1" border="1">

    <tr>
        <th>Nombre</th>
        <th>Email</th>
        <th>Monto</th>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>

</table>

</body>
</html>
