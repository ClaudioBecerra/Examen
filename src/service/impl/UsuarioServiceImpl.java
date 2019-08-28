package service.impl;

import constants.Constantes;
import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;
import model.Solicitud;
import model.Usuario;
import service.SolicitudService;
import service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    public Usuario login(String rut, String password) {
        return usuarioDAO.login(rut, password);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        if (usuario.getTipo().equalsIgnoreCase(Constantes.PRESTAMISTA)) {
            usuario.setSaldo(usuario.getMonto());
        }
        return usuarioDAO.registrar(usuario);
    }
}
