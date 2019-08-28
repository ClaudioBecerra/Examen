package dao.impl;

import dao.Conexion;
import dao.PrestamoDAO;
import model.Prestamo;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAOImpl implements PrestamoDAO {

    private Conexion conexionMysql = new ConnectionMysql();

    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        return null;
    }

    //personas a quien has prestado dinero
    @Override
    public List<Prestamo> getPrestamosByPrestamista(Long idPrestamista) {
        List<Prestamo> prestamos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = conexionMysql.getConexion();
            String query = "SELECT u.ID, u.NOMBRE, u.EMAIL, u.RUT, u.TIPO, u.MONTO, u.SALDO, p.ID, p.MONTO FROM prestamo.PRESTAMO p, prestamo.USUARIO u  WHERE p.ID_USUARIO_PRESTAMISTA = ? AND u.ID=p.ID_USUARIO_SOLICITANTE";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, idPrestamista);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Usuario solicitante = new Usuario();
                solicitante.setId(rs.getLong(1));
                solicitante.setNombre(rs.getString(2));
                solicitante.setEmail(rs.getString(3));
                solicitante.setRut(rs.getString(4));
                solicitante.setTipo(rs.getString(5));
                solicitante.setMonto(rs.getInt(6));
                solicitante.setSaldo(rs.getInt(7));


                Prestamo prestamo = new Prestamo();
                prestamo.setId(rs.getLong(8));
                prestamo.setMonto(rs.getInt(9));
                prestamo.setUsuarioSolicitante(solicitante);
                prestamos.add(prestamo);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionMysql.closeConexion(connection);
        }
        return prestamos;
    }


    //Personas que te han prestado dinero
    @Override
    public List<Prestamo> getPrestamosBySolicitante(Long idSolicitante) {
        return null;
    }
}
