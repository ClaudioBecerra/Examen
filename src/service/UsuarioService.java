package service;

import model.Usuario;

public interface UsuarioService {

    Usuario login(String rut, String password);

    Usuario registrarUsuario(Usuario usuario);

}
