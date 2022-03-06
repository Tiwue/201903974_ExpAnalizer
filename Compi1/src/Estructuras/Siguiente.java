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
     private String hoja;
     private int numHoja;
    private ArrayList<Integer> siguientes;

    public Siguiente(String nodo, int numHoja) {
        this.hoja = nodo;
        this.numHoja = numHoja;
        this.siguientes = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getSiguientes() {
        return siguientes;
    }
    
    public String getNodo(){
        return hoja;
    }
    
    public int getNum(){
        return numHoja;
    }
    
    public void setSiguiente(int siguiente){
    this.siguientes.add(siguiente);
    }
}
