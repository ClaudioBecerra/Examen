package service;

import model.Solicitud;

import java.util.List;

public interface SolicitudService {

    Solicitud crearSolicitud(Solicitud solicitud);

    List<Solicitud> obtenerSolicitudes();
}
