package Beans;

public class Sucursal {

    private int idSucursal;
    private String RFC;
    private String ubicacion;
    private String nombreDelGerente;
    private String telefono;

    public Sucursal() {
    }

    public Sucursal(int idSucursal, String RFC, String ubicacion, String nombreDelGerente, String telefono) {
        this.idSucursal = idSucursal;
        this.RFC = RFC;
        this.ubicacion = ubicacion;
        this.nombreDelGerente = nombreDelGerente;
        this.telefono = telefono;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreDelGerente() {
        return nombreDelGerente;
    }

    public void setNombreDelGerente(String nombreDelGerente) {
        this.nombreDelGerente = nombreDelGerente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
