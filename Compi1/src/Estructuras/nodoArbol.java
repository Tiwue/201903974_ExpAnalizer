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
public class nodoArbol {
    private nodoArbol left;
    private nodoArbol right;
    private String valor;
    private int numero;
    private ArrayList<Integer> primeros;
    private ArrayList<Integer> ultimos;
    private boolean anulabilidad;
    private int identificador;
    
    public nodoArbol(String valor_, nodoArbol left_, nodoArbol right_, int identificador_, int numero_) {
        this.left = left_;
        this.right = right_;
        this.valor = valor;
        this.identificador = identificador_;
        this.primeros = new ArrayList<Integer>();
        this.ultimos = new ArrayList<Integer>();
        if (left==null && right==null){
            anulabilidad = false;
            this.primeros.add(numero_);
            this.ultimos.add(numero_);
            this.numero = numero_;
        }else{
            switch (valor){
                case "|":
                    if(this.left.getAnulabilidad() || this.right.getAnulabilidad()){
                        this.anulabilidad = true;
                    }else{
                        this.anulabilidad = false;
                    }
                    this.primeros.addAll(this.left.primeros);
                    this.primeros.addAll(this.right.primeros);
                    this.ultimos.addAll(this.left.ultimos);
                    this.ultimos.addAll(this.right.ultimos);
                    break;
                case ".":
                    if(this.left.getAnulabilidad() && this.right.getAnulabilidad()){
                        this.anulabilidad = true;
                    }else{
                        this.anulabilidad = false;
                    }
                    if(this.left.getAnulabilidad()){
                        this.primeros.addAll(this.left.primeros);
                        this.primeros.addAll(this.right.primeros);
                    }else{
                        this.primeros.addAll(this.left.primeros);
                    }
                    if(this.right.getAnulabilidad()){
                        this.ultimos.addAll(this.left.ultimos);
                        this.ultimos.addAll(this.right.ultimos);
                    }else{
                        this.ultimos.addAll(this.right.ultimos);
                    }
                    break;
                case "?":
                    this.anulabilidad = true;
                    this.primeros.addAll(this.left.primeros);
                    this.ultimos.addAll(this.left.ultimos);
                    break;
                case "*":
                    this.anulabilidad = true;
                    this.primeros.addAll(this.left.primeros);
                    this.ultimos.addAll(this.left.ultimos);
                    break;
                case "+":
                    if(this.left.anulabilidad){
                        this.anulabilidad = true;
                    }else{
                        this.anulabilidad = false;
                    }
                    this.primeros.addAll(this.left.primeros);
                    this.ultimos.addAll(this.left.ultimos);
                    break;
            }
                
            
        }
    }
    
    public String getValor() {
        return valor;
    }

    public int getNumHoja() {
        return numero;
    }    

    public nodoArbol getLs() {
        return left;
    }

    public nodoArbol getRs() {
        return right;
    }

    public ArrayList<Integer> getFirightt() {
        return primeros;
    }

    public ArrayList<Integer> getLast() {
        return ultimos;
    }

    public int getId() {
        return identificador;
    }
    
    
    public String nodoGrafica(){
        String especial="";
        if(this.valor.equals("|") || this.valor.equals("\\n") || 
           this.valor.equals("\'")|| this.valor.equals("\\\"") || this.valor.equals("\\\\")){
            especial+="\\" ;
        }
        if(this.valor.equals(" ")){
            especial+="\\\" \\\"";
        }
        String tag;
        tag="nodo"+identificador+"[label=\"";
        tag+="{"+this.primeros.toString()+"}|{";
        if(this.getAnulabilidad()){
            tag+="A|";
        }else{
            tag+="N|";
        }
        tag+=especial+valor+"|";
        if(this.left == null && this.right == null){
            tag+=this.numero;
        }
        tag+="}|{"+this.ultimos.toString()+"}\"];\n";
        if(left != null){
            tag+=left.nodoGrafica()+"nodo"+identificador+"->nodo"+left.identificador+";\n";
        }
        if(right != null){
            tag+=right.nodoGrafica()+"nodo"+identificador+"->nodo"+right.identificador+";\n";
        }
        return tag;
    }


    public boolean getAnulabilidad() {
        return anulabilidad;
    }
    
    public boolean isHoja(){
        boolean ishoja = (this.left == null && this.right == null);
        return ishoja;
    }
    
    
    
}

