/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizadores;
/**
 *
 * @author steven
 */
public class Generador {
    public static void main(String args[]){
        try{
            String ruta = "src/Analizadores/";
            String opcFlex[] = {ruta + "lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "Sintactico", ruta +
                    "sintactico.cup"};
            java_cup.Main.main(opcCUP);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

