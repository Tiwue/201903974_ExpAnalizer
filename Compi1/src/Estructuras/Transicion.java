/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author steve
 */
public class Transicion {
    
   private String actual;
   private String siguiente;
   private String terminal;

    public Transicion(String actual, String terminal, String siguiente) {
        this.actual = actual;
        this.terminal = terminal;
        this.siguiente = siguiente;
    }
    
    public String getTerminal() {
        return terminal;
    }

    public String getSigueinte() {
        return siguiente;
    }
    
    public String getActual(){
        return actual;
    }
}
