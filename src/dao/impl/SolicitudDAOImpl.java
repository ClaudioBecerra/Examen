package dao.impl;

import dao.Conexion;
import dao.SolicitudDAO;
import model.Solicitud;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAOImpl implements SolicitudDAO {

    private Conexion conexionMysql = new ConnectionMysql();

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        Connection connection = null;
        try {
            connection = conexionMysql.getConexion();
            String query = "INSERT INTO prestamo.SOLICITUD (ID_USUARIO_SOLICITANTE,  MONTO) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, solicitud.getUsuarioSolicitante().getId());
            ps.setInt(2, solicitud.getUsuarioSolicitante().getMonto());

            if (ps.executeUpdate() > 0) {
                return solicitud;
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

    //Personas que necesitan dinero
    @Override
    public List<Usuario> obtenerSolicitudes() {
        List<Usuario> solicitudes = new ArrayList<>();
        Connection connection = null;
        try {
            connection = conexionMysql.getConexion();
            String query = "SELECT u.id,u.NOMBRE , u.EMAIL, u.SALDO, s.MONTO FROM prestamo.USUARIO as u inner join prestamo.SOLICITUD as s\n" +
                    "on (u.ID=s.ID_USUARIO_SOLICITANTE);";
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Usuario solicitud = new Usuario();
                solicitud.setId(rs.getInt(1));
                solicitud.setNombre(rs.getString(2));
                solicitud.setEmail(rs.getString(3));
                solicitud.setSaldo(rs.getInt(4));
                solicitud.setMonto(rs.getInt(5));

                solicitudes.add(solicitud);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionMysql.closeConexion(connection);
        }
        return solicitudes;

    }
}
