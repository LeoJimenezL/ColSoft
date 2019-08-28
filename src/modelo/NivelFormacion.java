 
package modelo;

public class NivelFormacion 
{
    private int idNivelFormacion;
    private String nombre;
    private String estado;

    public int getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(int idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
