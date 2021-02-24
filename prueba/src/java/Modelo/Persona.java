
package Modelo;


public class Persona {
    int id;
    String cedula;
    String nombre;
    String marcaCarro;

    public Persona(String cedula, String nombre, String marcaCarro) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.marcaCarro = marcaCarro;
    }

    public Persona() {
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }
    
    
    
}
