<%--
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
<%--  <%--%>
<%--    HttpSession sesionOk = request.getSession();--%>
<%--    //si la sesion existe redirecciona al home--%>
<%--    if (sesionOk.getAttribute("email") != null) {--%>
<%--      response.sendRedirect("home.jsp");--%>
<%--    }--%>

<%--    String error = (String) request.getAttribute("error");--%>
<%--    if (error != null) {--%>
<%--      out.print(error);--%>
<%--    }--%>
<%--  %>--%>
<form action="" method="">

    <table cellspacing="4" cellpadding="4" border="1">
        <tr>
            <td>Rut:</td>
            <td><input type="text" name="rut"/></td>
        </tr>
        <tr>
            <td>Contraseña:</td>
            <td><input type="password" name="pass"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="registro.jsp"><input type="button" value="Crear cuenta"></a>
                <input type="submit" value="Ingresar">
            </td>
        </tr>
    </table>


</form>

</body>
</html>
