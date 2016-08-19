package Beans;

public class Cuenta {

    private int idCuenta;
    private int idCliente;
    private int idSucursal;
    private float saldo;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, int idCliente, int idSucursal, float saldo) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.idSucursal = idSucursal;
        this.saldo = saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }
        
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
}
