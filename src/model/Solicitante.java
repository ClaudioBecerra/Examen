package model;

public class Solicitante {
    private  String nombre;
    private String email;
    private int rut;
    private String password;
    private double montoSolicitado;
    private double sumaPrestamos;
    private String motivo;

    public Solicitante() {
    }

    public Solicitante(String nombre, double montoSolicitado, double sumaPrestamos) {
        this.nombre = nombre;
        this.montoSolicitado = montoSolicitado;
        this.sumaPrestamos = sumaPrestamos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(double montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public double getSumaPrestamos() {
        return sumaPrestamos;
    }

    public void setSumaPrestamos(double sumaPrestamos) {
        this.sumaPrestamos = sumaPrestamos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
