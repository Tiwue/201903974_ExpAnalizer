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
public class listaErrores extends ArrayList<MiError> {

    public listaErrores() {
    super();
    }
    
    public void addError(MiError error){
        this.add(error);
    }
    
    public void mostrarEnConsola(){
        this.forEach((t) -> {
            t.toString();
        });
    }
    
}

