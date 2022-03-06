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
    public nodoArbol left;
    public nodoArbol right;
    public String valor;
    public int numero;
    public ArrayList<Integer> primeros;
    public ArrayList<Integer> ultimos;
    public boolean anulabilidad;
    public int identificador;
    
    public nodoArbol(String valor_, nodoArbol left_, nodoArbol right_, int identificador_, int numero_) {
        this.left = left_;
        this.right = right_;
        this.valor = valor_;
        this.identificador = identificador_;
        this.numero=numero_;
        this.primeros = new ArrayList<Integer>();
        this.ultimos = new ArrayList<Integer>();
        this.setAnulabilidadPrimerosUltimos(valor_, left_, right_, identificador_, numero_);
    }
    
    public void setAnulabilidadPrimerosUltimos(String valor_, nodoArbol left_, nodoArbol right_, int identificador_, int numero_){
      if (left==null && right==null){
            anulabilidad = false;
            this.primeros.add(numero_);
            this.ultimos.add(numero_);
            this.numero = numero_;
        }else{
          
            if ("|".equals(valor_)){
                    if(this.left.getAnulabilidad() || this.right.getAnulabilidad()){
                        this.anulabilidad = true;
                    }else{
                        this.anulabilidad = false;
                    }
                    this.primeros.addAll(this.left.primeros);
                    this.primeros.addAll(this.right.primeros);
                    this.ultimos.addAll(this.left.ultimos);
                    this.ultimos.addAll(this.right.ultimos);
                 }else if(".".equals(valor_)){

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
                 }else if("?".equals(valor_)){
                    this.anulabilidad = true;
                    this.primeros.addAll(this.left.primeros);
                    this.ultimos.addAll(this.left.ultimos);
                   
                 }else if("*".equals(valor_)){
                    this.anulabilidad = true;
                    this.primeros.addAll(this.left.primeros);
                    this.ultimos.addAll(this.left.ultimos);
             
                 }else if("+".equals(valor_)){
                    if(this.left.anulabilidad){
                        this.anulabilidad = true;
                    }else{
                        this.anulabilidad = false;
                    }
                    this.primeros.addAll(this.left.primeros);
                    this.ultimos.addAll(this.left.ultimos);
    
            }
      }
                
            
        }
    
    
    public String getValor() {
        return valor;
    }

    public int getNumHoja() {
        return numero;
    }    

    public nodoArbol getLeft() {
        return left;
    }

    public nodoArbol getRight() {
        return right;
    }

    public ArrayList<Integer> getPrimeros() {
        return primeros;
    }

    public ArrayList<Integer> getUltimos() {
        return ultimos;
    }

    public int getIdentificador() {
        return identificador;
    }
    
    public boolean getAnulabilidad() {
        return anulabilidad;
    }
    
}

