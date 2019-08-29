package service;

import model.Solicitud;
import model.Usuario;

import java.util.List;

public interface SolicitudService {

    Solicitud crearSolicitud(Solicitud solicitud);

    List<Usuario> obtenerSolicitudes();
}
