package service;

import model.Prestamo;

import java.util.List;

public interface PrestamoService {

    Prestamo crearPrestamo(Prestamo prestamo);

    List<Prestamo> getPrestamosPorUsuarioPrestamista(Long idUsuarioPrestamista);

    List<Prestamo> getPrestamosPorUsuarioSolicitante(Long idUsuarioSolicitante);

}
