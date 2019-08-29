package dao;

import model.Solicitud;
import model.Usuario;

import java.util.List;

public interface SolicitudDAO {

    Solicitud crearSolicitud(Solicitud solicitud);

    List<Usuario> obtenerSolicitudes();

}
