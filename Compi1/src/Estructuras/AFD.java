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
public class AFD {
    private String nombre;
    private ArrayList<Estado> estados;
    private String inicial;
    private ArrayList<String> aceptaciones;
    private ArrayList<String> terminales;
    private ArrayList<Conjunto> conjuntos;
    private String actual;
    
    public AFD(String nombre, ArrayList<Estado> estados, ArrayList<String> terminales, int aceptacion, ArrayList<Conjunto> conjuntos){
        this.nombre = nombre;
        this.estados = estados;
        this.terminales = terminales;
        this.conjuntos = conjuntos;
        this.aceptaciones = new ArrayList<String>();
        this.inicial = this.estados.get(0).getNombre();
        for(Estado estado:estados){
            if(estado.getContent().contains(aceptacion)){
                aceptaciones.add(estado.getNombre());
            }
        }
    }
}
