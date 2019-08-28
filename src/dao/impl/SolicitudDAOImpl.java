package dao.impl;

import dao.Conexion;
import dao.SolicitudDAO;
import model.Solicitud;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public List<Solicitud> obtenerSolicitudes() {
        return null;
    }
}
