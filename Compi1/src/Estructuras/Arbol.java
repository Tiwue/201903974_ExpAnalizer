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
public class Arbol {
    private nodoArbol raiz;
    private String nombre;
    private ArrayList<Siguiente> siguientes;
    private ArrayList<Estado> estados;
    private ArrayList<String> terminales;
    private AFND afnd;
    
    public Arbol(String nombre, nodoArbol raiz){
        this.nombre = nombre;
        this.raiz = raiz;
        siguientes = new ArrayList<Siguiente>();
        estados = new ArrayList<Estado>();
        terminales = new ArrayList<String>();
    }

    public nodoArbol getRaiz() {
        return raiz;
    }

    public String getNombre() {
        return nombre;
    }
}
