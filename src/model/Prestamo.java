package model;

public class Prestamo {
    private Long id;
    private Usuario usuarioPrestamista;
    private Usuario usuarioSolicitante;
    private int monto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioPrestamista() {
        return usuarioPrestamista;
    }

    public void setUsuarioPrestamista(Usuario usuarioPrestamista) {
        this.usuarioPrestamista = usuarioPrestamista;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
