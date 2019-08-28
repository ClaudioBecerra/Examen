package dao.impl;

import dao.Conexion;
import dao.UsuarioDAO;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAOImpl implements UsuarioDAO {

    private Conexion conexionMysql = new ConnectionMysql();

    @Override
    public Usuario login(String rut, String password) {
        Connection connection = null;
        try {
            connection = conexionMysql.getConexion();
            String query = "SELECT ID, NOMBRE, EMAIL, RUT, TIPO, MONTO, SALDO FROM prestamo.USUARIO WHERE rut = ? and password = ? LIMIT 1";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, rut);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong(1));
                usuario.setNombre(rs.getString(2));
                usuario.setEmail(rs.getString(3));
                usuario.setRut(rs.getString(4));
                usuario.setTipo(rs.getString(5));
                usuario.setMonto(rs.getInt(6));
                usuario.setSaldo(rs.getInt(7));
                return usuario;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionMysql.closeConexion(connection);
        }
        return null;
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        Connection connection = null;
        try {
            connection = conexionMysql.getConexion();
            String query = "INSERT INTO prestamo.USUARIO (NOMBRE, EMAIL, RUT, PASSWORD, TIPO, MONTO, SALDO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getRut());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, usuario.getTipo());
            ps.setInt(6, usuario.getMonto());
            ps.setInt(7, usuario.getSaldo());

            if (ps.executeUpdate() > 0) {

                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    usuario.setId(rs.getLong(1));
                    break;
                }

                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionMysql.closeConexion(connection);
        }
        return null;
    }
}
