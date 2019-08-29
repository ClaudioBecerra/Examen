<%@ page import="model.Usuario" %>
<%@ page import="java.util.List" %><%--
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
            if (((Usuario) sesionOk.getAttribute("usuarioLogin")).getTipo().equalsIgnoreCase("solicitante")) {
                response.sendRedirect("solicitante.jsp");
            }
        }

    %>

    <title>Prestamista</title>
</head>
<body>

<h1>Bienvenido prestamista</h1>
<table>
    <tr>
        <td>Nombre:</td>
        <td><%=user.getNombre()%>
        </td>
    </tr>
    <tr>
        <td>Saldo:</td>
        <td><%=user.getSaldo()%>
        </td>
    </tr>
    <tr>
        <td>
            <form action="Logout" method="post">
        <input type="submit" value="salir">
        </form>
        </td>
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
        <%List<Usuario> us = (List<Usuario>) request.getAttribute("solicitantes");
            if (us!=null){
            for (Usuario u:us) {

        %>
        <tr id="<%u.getId();%>">
            <td ><%=u.getNombre()%></td>
            <td><%=u.getEmail()%></td>
            <td><%=u.getMonto()%></td>
            <td><%=u.getSaldo()%></td>

            <td><input type="text" name="accion"  ><input type="button" value="Prestar" onclick="this.form.submit()"></td>
            <%}
            }
            %>
        </tr>
    </form>

</table>


</body>
</html>
