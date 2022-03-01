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
public class Conjunto {
      private String nombre;
    private ArrayList<Character> caracteres;
    
    public Conjunto(String nombre, String cadena){
        this.nombre = nombre;
        this.caracteres = new ArrayList<Character>();
        if(cadena.length()>3){
            for(int i=0; i<cadena.length();i+=2){
                caracteres.add(cadena.charAt(i));
            }
        }else{
            char e1 = cadena.charAt(0);
            char e2 = cadena.charAt(2);
            for(int i=e1;i<=e2;i++){
                if(e1!=48 && e1!=65 && e1!=97){
                    if(i>=48 && i<=57){
                    continue;
                    }else if(i>=65 && i<=90){
                        continue;
                    }else if(i>=97 && i<=122){
                        continue;
                    }
                }
                caracteres.add((char)i);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Character> getElementos() {
        return caracteres;
    }
    
}
