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
public class Siguiente {
     private String nodo;
    private ArrayList<Integer> siguiente;

    public Siguiente(String nodo) {
        this.nodo = nodo;
        this.siguiente = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getSiguiente() {
        return siguiente;
    }
    
    public String getNodo(){
        return nodo;
    }
}
