package dao;

import model.Usuario;

public interface UsuarioDAO {

    Usuario login(String rut, String password);

    Usuario registrar(Usuario usuario);

}
