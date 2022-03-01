/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import java.util.ArrayList;
/**
 *
 * @author steve
 */
public class AFND {
    private String inicio;
    private String aceptacion;
    private ArrayList<Transicion> transiciones;
    
    public AFND(String inicio, String aceptacion, ArrayList<Transicion> transiciones){
        this.inicio = inicio;
        this.aceptacion = aceptacion;
        this.transiciones = transiciones;
    }

    public String getInicio() {
        return inicio;
    }

    public String getAceptacion() {
        return aceptacion;
    }

    public ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }
    
    public int getFinal(){
        return Integer.parseInt(String.valueOf(aceptacion.split("S")[1]));
    }
}
