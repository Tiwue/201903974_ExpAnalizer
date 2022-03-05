/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import Estructuras.tipoError;
/**
 *
 * @author steve
 */
public class MiError {
    private tipoError tipo;
    private String descripcion;
    private int fila;
    private int columna;
    
    
    
    
    public MiError(tipoError tipo_, String descripcion_, int fila_, int columna_){
        setTipo(tipo_);
        setDescripcion(descripcion_);
        setFila(fila_);
        setColumna(columna_);
        
    }

    @Override
    public String toString() {
        return "Error{" + "tipo=" + tipo + ", descripcion=" + descripcion + ", fila=" + fila + ", columna=" + columna + '}';
    }
    
    public String getTipo() {
        if(tipo==tipoError.LEXICO){
            return "Lexico";
        }
        return "Sintactico";
    }

    public void setTipo(tipoError tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
}
