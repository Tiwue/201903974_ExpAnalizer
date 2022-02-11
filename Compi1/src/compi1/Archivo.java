/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi1;

/**
 *
 * @author steve
 */
public class Archivo {
    String ruta, nombre;
    public Archivo(String ruta, String nombre){
        setNombre(nombre);
        setRuta(ruta);
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
