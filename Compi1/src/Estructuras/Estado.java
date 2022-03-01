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
    private ArrayList<Integer> content;
    private ArrayList<Transicion> transiciones;
    
    public Estado(String nombre, ArrayList<Integer> content){
        this.nombre = nombre;
        this.content = content;
        transiciones = new ArrayList<Transicion>();
    }
    
    public Estado(String nombre){
        this(nombre, new ArrayList<Integer>());
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getContent() {
        return content;
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
}
