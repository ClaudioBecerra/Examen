package service.impl;

import dao.PrestamoDAO;
import dao.impl.PrestamoDAOImpl;
import model.Prestamo;
import service.PrestamoService;

import java.util.List;

public class PrestamoServiceImpl implements PrestamoService {

    private PrestamoDAO prestamoDAO = new PrestamoDAOImpl();

    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        return prestamoDAO.crearPrestamo(prestamo);
    }

    @Override
    public List<Prestamo> getPrestamosPorUsuarioPrestamista(Long idUsuarioPrestamista) {
        return prestamoDAO.getPrestamosByPrestamista(idUsuarioPrestamista);
    }

    @Override
    public List<Prestamo> getPrestamosPorUsuarioSolicitante(Long idUsuarioSolicitante) {
        return prestamoDAO.getPrestamosBySolicitante(idUsuarioSolicitante);
    }
}
