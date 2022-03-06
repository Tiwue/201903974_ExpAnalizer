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
        if(cadena.length()==3){
            char ch1 = cadena.charAt(0);
            char ch2 = cadena.charAt(2);
            for(int i=ch1;i<=ch2;i++){
                if(ch1!=48 && ch1!=65 && ch1!=97){
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
        }else
        {
            for(int i=0; i<cadena.length();i++){
                if(cadena.charAt(i)!=','&& cadena.charAt(i)!=' '){
                    caracteres.add(cadena.charAt(i));
            }}}
    
    }
    
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Character> getCaracteres() {
        return caracteres;
    }
    
}
