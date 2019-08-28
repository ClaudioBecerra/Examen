package dao;

import model.Solicitud;

import java.util.List;

public interface SolicitudDAO {

    Solicitud crearSolicitud(Solicitud solicitud);

    List<Solicitud> obtenerSolicitudes();

}
