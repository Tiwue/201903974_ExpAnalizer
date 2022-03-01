/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author steve
 */
public class Validacion {
    String nombre;
    String cadena;
    
    public Validacion(String nombre, String cadena){
        this.nombre = nombre;
        this.cadena = cadena;
    }

    public String getExpresion() {
        return nombre;
    }

    public String getCadena() {
        return cadena;
    }
}
