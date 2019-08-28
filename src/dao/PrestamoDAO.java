package dao;

import model.Prestamo;

import java.util.List;

public interface PrestamoDAO {

    Prestamo crearPrestamo(Prestamo prestamo);

    List<Prestamo> getPrestamosByPrestamista(Long idPrestamista);

    List<Prestamo> getPrestamosBySolicitante(Long idSolicitante);
}
