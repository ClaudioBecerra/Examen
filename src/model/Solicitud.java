package model;

public class Solicitud {

    private Usuario usuarioPrestamista;
    private Usuario usuarioSolicitante;
    private int monto;

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
