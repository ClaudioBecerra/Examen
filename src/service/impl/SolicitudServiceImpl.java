package service.impl;

import dao.SolicitudDAO;
import dao.impl.SolicitudDAOImpl;
import model.Solicitud;
import service.SolicitudService;

import java.util.List;

public class SolicitudServiceImpl implements SolicitudService {

    private SolicitudDAO solicitudDAO = new SolicitudDAOImpl();

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        return solicitudDAO.crearSolicitud(solicitud);
    }

    @Override
    public List<Solicitud> obtenerSolicitudes() {
        return null;
    }
}
