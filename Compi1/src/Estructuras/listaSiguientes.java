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
public class listaSiguientes extends ArrayList<Siguiente>{
    
    public listaSiguientes() {
    super();
    }

    
    public Siguiente getSiguiente(int numHoja){
    
        this.forEach((Siguiente t) -> {
        if(t.getNum()==numHoja){
            return t;
        }
        });
        return null;
    }
    
};