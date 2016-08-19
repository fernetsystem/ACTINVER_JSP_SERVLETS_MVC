package Beans;

public class Transactions {

    private int idTransaction;
    private int idCuenta;
    private String tipoDeTrnsaccion;
    private double monto;
    private String fecha;

    public Transactions() {
    }

    public Transactions(int idTransaction, int idCuenta, String tipoDeTrnsaccion, double monto, String fecha) {
        this.idTransaction = idTransaction;
        this.idCuenta = idCuenta;
        this.tipoDeTrnsaccion = tipoDeTrnsaccion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoDeTrnsaccion() {
        return tipoDeTrnsaccion;
    }

    public void setTipoDeTrnsaccion(String tipoDeTrnsaccion) {
        this.tipoDeTrnsaccion = tipoDeTrnsaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
