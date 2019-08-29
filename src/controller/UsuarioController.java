package controller;

import constants.Constantes;
import model.Prestamo;
import model.Solicitud;
import model.Usuario;
import service.PrestamoService;
import service.SolicitudService;
import service.UsuarioService;
import service.impl.PrestamoServiceImpl;
import service.impl.SolicitudServiceImpl;
import service.impl.UsuarioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class UsuarioController extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioServiceImpl();
    private PrestamoService prestamoService = new PrestamoServiceImpl();
    private SolicitudService solicitudService = new SolicitudServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ruta = req.getParameter("ruta");

        switch (ruta) {

            case "registro":
                Usuario usuario = crearUsuario(req);
                Usuario usuarioCreado = usuarioService.registrarUsuario(usuario);
                if (usuarioCreado != null) {

                    if (usuarioCreado.getTipo().equalsIgnoreCase(Constantes.SOLICITANTE)) {
                        Solicitud solicitud = new Solicitud();
                        solicitud.setUsuarioSolicitante(usuario);
                        solicitud.setMonto(usuario.getMonto());
                        solicitudService.crearSolicitud(solicitud);
                    }
                    req.setAttribute("creado", "El usuario fue creado correctamente");
                } else {
                    req.setAttribute("error", "Ocurrio un error al crear usuario");
                }
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

            case "login":

                //Login
                String rut = req.getParameter("rut");
                String password = req.getParameter("password");
                Usuario usuarioLogin = usuarioService.login(rut, password);



                if (usuarioLogin != null) {
                    HttpSession sesionOk = req.getSession();
                    sesionOk.setAttribute("usuarioLogin", usuarioLogin);


//                    req.setAttribute("usuarioLogeado", usuarioLogin);

                    if (usuarioLogin.getTipo().equalsIgnoreCase(Constantes.PRESTAMISTA)) {
                        List<Prestamo> prestamos = prestamoService.getPrestamosPorUsuarioPrestamista(usuarioLogin.getId());
                        List<Usuario> user =solicitudService.obtenerSolicitudes();
                        req.setAttribute("prestamos", prestamos);
                        req.setAttribute("solicitantes",user);


                        req.getRequestDispatcher("prestamista.jsp").forward(req, resp);
                    } else {

                        req.getRequestDispatcher("solicitante.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("error", "Ocurrio un error al ingresar");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
        }

    }

    private Usuario crearUsuario(HttpServletRequest req) {
        String tipo = req.getParameter("tipo");
        String rut = req.getParameter("rut");
        String password = req.getParameter("password");
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String dinero = req.getParameter("monto");
        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setRut(rut);
        usuario.setPassword(password);
        usuario.setTipo(tipo);
        if (dinero != null) {
            int monto = Integer.parseInt(dinero);
            usuario.setMonto(monto);
        }

        return usuario;
    }

}
