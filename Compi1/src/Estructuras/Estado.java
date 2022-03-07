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
public class Estado {
    private String nombre;
    private int numero;
    private ArrayList<Integer> hojas;
    private ArrayList<Transicion> transiciones;
    
    public Estado(String nombre, ArrayList<Integer> hojas, int numero){
        this.nombre = nombre;
        this.hojas = hojas;
        this.transiciones = new ArrayList<Transicion>();
        this.numero=numero;
    }
    
    public int getNumero(){
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getHojas() {
        return hojas;
    }

    public ArrayList<Transicion> getTransiciones() {
        return transiciones;
    }
    
    public String getSiguiente(String terminal){
        for(Transicion transicion:transiciones){
            if(transicion.getTerminal().equals(terminal)){
                return transicion.getSigueinte();
            }
        }
        return "";
    }
    
    public void setTransicion(Transicion transicion){
     this.transiciones.add(transicion); 
    }
}
