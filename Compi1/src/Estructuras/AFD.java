/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author steve
 */
public class AFD {
    private final String nombre;
    private ArrayList<Estado> estados;
    private final Estado inicial;
    private ArrayList<Estado> aceptaciones;
    private ArrayList<String> terminales;
    private ArrayList<Conjunto> conjuntos;

    public AFD(String nombre, ArrayList<Estado> estados, Estado inicial, ArrayList<String> terminales, ArrayList<Estado> aceptaciones, ArrayList<Conjunto> conjuntos){
        this.nombre = nombre;
        this.estados = estados;
        this.terminales = terminales;
        this.aceptaciones = aceptaciones;
        this.conjuntos = conjuntos;
        this.inicial = inicial;
        }
    
    public void graficar(){
    String cadena="digraph G { rankdir=\"LR\";\n";
    for(Estado estado:estados){
        cadena += estado.getNombre()+"[shape=circle, style=\"filled\"];\n";
    }
    cadena += inicial.getNombre()+"[shape=circle, style=\"filled\", fillcolor=greenyellow];";
    for(Estado estado:aceptaciones){
        cadena += estado.getNombre()+"[shape=doublecircle, style=\"filled\", fillcolor=yellow;];\n";
    }
    
    for(Estado estado:estados){
        for(Transicion transicion: estado.getTransiciones()){
            if(transicion.getTerminal().equals("|")||transicion.getTerminal().equals("\\n")||transicion.getTerminal().equals("\\'")||transicion.getTerminal().equals("\\\"")||transicion.getTerminal().equals("\\\\")){
            cadena+="edge[label = \""+"\\"+transicion.getTerminal()+"\" ];"+transicion.getActual()+"->"+transicion.getSigueinte()+";\n";}
            else if(transicion.getTerminal().equals(" ")){
            cadena+="edge[label = \""+"\\\"  \\\""+"\" ];"+transicion.getActual()+"->"+transicion.getSigueinte()+";\n";}
        else{
                cadena+="edge[label = \""+transicion.getTerminal()+"\" ];"+transicion.getActual()+"->"+transicion.getSigueinte()+";\n";}
                }
    }
    cadena +="}";
    
    FileWriter archivo = null;
        PrintWriter escribir = null;
        try{
            archivo = new FileWriter("./Reportes\\AFD_201903974\\AFD"+this.nombre+".dot");
            escribir = new PrintWriter(archivo);
            escribir.println(cadena);
 
        }catch (Exception e){
            System.out.println("No se pudo crear el dot del automata");
            e.printStackTrace();
        }finally{
            try{
                if(null != archivo){
                    archivo.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        try{
            String comando = "dot";
            String rutaDot = "./Reportes\\AFD_201903974\\AFD"+this.nombre+".dot";
            String rutaJPG = "./Reportes\\AFD_201903974\\AFD_"+this.nombre+".png";
            String tParam = "-Tpng";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = comando;
            cmd[1] = tParam;
            cmd[2] = rutaDot;
            cmd[3] = tOParam;
            cmd[4] = rutaJPG;
            
            Runtime.getRuntime().exec(cmd);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    
    }

    }

