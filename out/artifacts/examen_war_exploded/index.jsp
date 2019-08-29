<%@ page import="java.net.UnknownServiceException" %>
<%@ page import="model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Claudio
  Date: 16-08-2019
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
  <%
    HttpSession sesionOk = request.getSession();
      Usuario user = (Usuario) sesionOk.getAttribute("usuarioLogin");
    //si la sesion existe redirecciona al home
      if (sesionOk.getAttribute("usuarioLogin")!= null) {
          if (user.getTipo().equals("prestamista")) {
              response.sendRedirect("prestamista.jsp");
          } else {
              response.sendRedirect("solicitante.jsp");
          }
      }
    %>

<%
    if (request.getAttribute("error") != null) {
        String mensaje = (String) request.getAttribute("error");
%>
<p><%=mensaje%></p>
  <%
    }
%>

<%
    if (request.getAttribute("creado") != null) {
        String mensaje = (String) request.getAttribute("creado");
%>
<p><%=mensaje%></p>
<%
    }
%>


<form action="usuario" method="post">

    <table cellspacing="4" cellpadding="4" border="1">
        <tr>
            <td>Rut:</td>
            <td><input type="text" name="rut"/></td>
        </tr>
        <tr>
            <td>Contraseña:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="registro.jsp"><input type="button" value="Crear cuenta"></a>
                <input type="hidden" name="ruta" value="login"/>
                <input type="submit" value="Ingresar">
            </td>
        </tr>
    </table>


</form>

</body>
</html>
