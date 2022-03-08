/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import compi1.interfaz;
/**
 *
 * @author steve
 */
public class Arbol {
    private nodoArbol raiz;
    private String nombre;
    private listaSiguientes siguientes;
    private ArrayList<Estado> estados;
    private ArrayList<String> terminalesG;
    private AFD determinista;
    
    public Arbol(String nombre, nodoArbol raiz){
        this.nombre = nombre;
        this.raiz = raiz;
        siguientes = new listaSiguientes();
        estados = new ArrayList<Estado>();
        terminalesG = new ArrayList<String>();
    }

    public nodoArbol getRaiz() {
        return raiz;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void graficar(){
        try{
            FileWriter archivo = null;
            PrintWriter writter = null;
            String dot="digraph G{\n rankdir=UD\n node[shape=record]\n color=darkgray\n";
            dot = dot + nodosGrafica();
            dot= dot + "\n subgraph cluster_L { \"indicaciones\" [fontsize=16 label=\"{Primeros}|{Anulabilidad|Valor|Numero de Hoja}|{Ultimos}\"]}";
            dot = dot + "}";
            try{
                archivo = new FileWriter("./Reportes\\ARBOLES_201903974\\ARBOL-"+this.nombre+".dot");
                writter = new PrintWriter(archivo);
                writter.println(dot);
            }catch (Exception e){
                System.out.println("No se pudo generar el archivo...");
                e.printStackTrace();
            }finally{
                try{
                    if(archivo != null){
                        archivo.close();
                    }
                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
            
            
            String comando = "dot";
            
            String rutaDot = "./Reportes\\ARBOLES_201903974\\ARBOL-"+this.nombre+".dot";
            String rutaPNG = "./Reportes\\ARBOLES_201903974\\ARBOL-"+this.nombre+".jpg";
            
            String tParam = "-Tjpg";
            String tOParam = "-o";
            
            String[] cmd = new String[5];
            cmd[0] = comando;
            cmd[1] = tParam;
            cmd[2] = rutaDot;
            cmd[3] = tOParam;
            cmd[4] = rutaPNG;
            
            Runtime rt = Runtime.getRuntime();
            
            rt.exec( cmd );
            
        }catch (IOException ex){
            Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
    public String nodosGrafica(){
        
        
        String cadena;
        cadena="nodo"+this.raiz.identificador+"[label=\"";
        cadena+="{"+this.raiz.primeros.toString().substring(1,raiz.primeros.toString().length()-1)+"}|{";
        if(this.raiz.getAnulabilidad()){
            cadena+="A|";
        }else{
            cadena+="N|";
        }
        String especial="";
        if(this.raiz.valor.equals("|") || this.raiz.valor.equals("\\n") || this.raiz.valor.equals("\'")|| this.raiz.valor.equals("\\\"") || this.raiz.valor.equals("\\\\")){
            especial+="\\" ;
        }else if(this.raiz.valor.equals(" ")){
            especial+="\\\" \\\"";
        }
        cadena+=especial+raiz.valor+"|";
        if(this.raiz.left == null && this.raiz.right == null){
            cadena+=this.raiz.numero;
        }
        cadena+="}|{"+this.raiz.ultimos.toString().substring(1,raiz.ultimos.toString().length()-1)+"}\"];\n";
        if(raiz.left != null){
            cadena+=nodosGrafica_intern(raiz.left)+"nodo"+raiz.identificador+"->nodo"+raiz.left.identificador+";\n";
        }
        if(raiz.right != null){
            cadena+=nodosGrafica_intern(raiz.right)+"nodo"+raiz.identificador+"->nodo"+raiz.right.identificador+";\n";
        }
        return cadena;
    }
    
    public String nodosGrafica_intern(nodoArbol actual){
        String cadena;
        cadena="nodo"+actual.identificador+"[label=\"";
        cadena+="{"+actual.primeros.toString().substring(1,actual.primeros.toString().length()-1)+"}|{";
        if(actual.getAnulabilidad()){
            cadena+="A|";
        }else{
            cadena+="N|";
        }
        String especial="";
        if(actual.valor.equals("|") || actual.valor.equals("\\n") || actual.valor.equals("\'")|| actual.valor.equals("\\\"") || actual.valor.equals("\\\\")){
            especial+="\\" ;
        }else if(actual.valor.equals(" ")){
            especial+="\\\" \\\"";
        }
        cadena+=especial+actual.valor+"|";
        if(actual.left == null && actual.right == null){
            cadena+=actual.numero;
        }
        cadena+="}|{"+actual.ultimos.toString().substring(1,actual.ultimos.toString().length()-1)+"}\"];\n";
        if(actual.left != null){
            cadena+=nodosGrafica_intern(actual.left)+"nodo"+actual.identificador+"->nodo"+actual.left.identificador+";\n";
        }
        if(actual.right != null){
            cadena+=nodosGrafica_intern(actual.right)+"nodo"+actual.identificador+"->nodo"+actual.right.identificador+";\n";
        }
        return cadena;
    }
    
    public void generarTablaSiguientes(){
        this.buscarHojas(raiz);
        this.setSiguientes(raiz);
        String cadena="digraph G{\na[shape=none label=<\n";
        cadena+="<TABLE cellspacing=\"0\">\n<TR>\n<TD colspan=\"2\">Hoja</TD>\n<TD>Siguientes</TD>\n</TR>\n";
        for (int i=0; i<siguientes.size();i++){
            cadena+="<TR>\n";
            if(siguientes.get(i).getNodo().equals(" ")){
                cadena+="<TD>\" \"</TD>\n";
            }else{
                cadena+="<TD>"+siguientes.get(i).getNodo()+"</TD>\n";
            }
                cadena+="<TD>"+(i+1)+"</TD>\n<TD>"+siguientes.get(i).getSiguientes().toString().substring(1,siguientes.get(i).getSiguientes().toString().length()-1)+"</TD>\n</TR>\n";
        }
        cadena+="</TABLE>\n >];\n}";
        
        FileWriter archivo = null;
        PrintWriter escribir = null;
        try{
            archivo = new FileWriter("./Reportes\\SIGUIENTES_201903974\\Siguiente_"+this.nombre+".dot");
            escribir = new PrintWriter(archivo);
            escribir.println(cadena);
 
        }catch (Exception e){
            System.out.println("No se pudo generar la tabla de siguientes...");
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
            String rutaDot = "./Reportes\\SIGUIENTES_201903974\\Siguiente_"+this.nombre+".dot";
            String rutaJPG = "./Reportes\\SIGUIENTES_201903974\\Siguiente_"+this.nombre+".png";
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
    
    public void generarTablaTransiciones(){
    buscarTerminalesG();
    setTransiciones();
    String cadena="digraph G{\na[shape=none label=<\n<TABLE cellspacing=\"0\">\n<TR>\n\n<TD rowspan=\"2\">Estado</TD>\n<TD colspan=\"";
    cadena += terminalesG.size();
    cadena +="\" >Terminales</TD>\n</TR><TR>\n";
    for(String terminal:terminalesG){
    cadena+="<TD>"+terminal+"</TD>";
    }
    cadena+= "\n</TR>";
    for(Estado estado:estados){
    cadena+="<TR>\n<TD>"+estado.getNombre()+" "+estado.getHojas().toString()+ "</TD>";
    for(String terminal:terminalesG){
        Transicion t = obtenerTransicion(estado, terminal);
        if(t!=null){
        cadena+="\n<TD>"+t.getSigueinte()+"</TD>";
        }else{
        cadena+="\n<TD>--</TD>";
        }
    }
    cadena+="\n</TR>";
    }
    cadena+="</TABLE>\n>];\n        \n        \n    }";
    
    FileWriter archivo = null;
        PrintWriter escribir = null;
        try{
            archivo = new FileWriter("./Reportes\\TRANSICIONES_201903974\\Transiciones"+this.nombre+".dot");
            escribir = new PrintWriter(archivo);
            escribir.println(cadena);
 
        }catch (Exception e){
            System.out.println("No se pudo generar la tabla de siguientes...");
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
            String rutaDot = "./Reportes\\TRANSICIONES_201903974\\Transiciones"+this.nombre+".dot";
            String rutaJPG = "./Reportes\\TRANSICIONES_201903974\\Transiciones_"+this.nombre+".png";
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
    
    
    public void setSiguientes(nodoArbol actual){
        if(actual.getLeft()!=null){
            setSiguientes(actual.getLeft());
            if(actual.getRight()!=null){
                setSiguientes(actual.getRight());
            }
            if(actual.getValor().equals(".")){
                for(Integer i: actual.getLeft().getUltimos()){
                    for(int j=0;j<actual.getRight().getPrimeros().size();j++){
                    
                       for(Siguiente k:siguientes){
                       if(k.getNum()==i){
                        k.setSiguiente(actual.getRight().getPrimeros().get(j));
                       }
                       }
                    }
                }
                    
            }else if(actual.getValor().equals("*") || actual.getValor().equals("+")){
                for(Integer i: actual.getLeft().getUltimos()){
                    for(int j=0;j<actual.getLeft().getPrimeros().size();j++){
                    
                       for(Siguiente k:siguientes){
                       if(k.getNum()==i){
                        k.setSiguiente(actual.getLeft().getPrimeros().get(j));
                       }
                       }
                    }
                }
               
        }
    }
    
    }
    public void buscarHojas(nodoArbol actual){
        if(actual.getLeft()==null && actual.getRight()==null){
            this.siguientes.add(new Siguiente(actual.getValor(),actual.getNumHoja()));
        }else{
            if (actual.getLeft()!=null){
            this.buscarHojas(actual.getLeft());
            }
            if(actual.getRight()!=null){
                this.buscarHojas(actual.getRight());
            }
        }
    }
    
     public void setTransiciones(){
        int contador = 0;
        int contadorEstados=0;
        estados.add(new Estado("S"+contador, raiz.getPrimeros(),contador));
        contador++;
        contadorEstados++;
        int i =0;
        while(i<estados.size()){
            Estado estado = estados.get(i);
            
            ArrayList<String> terminales=getTerminales(estado.getHojas());    
            
            for (String terminal: terminales){
                if(!terminal.equals("#")){
                ArrayList<Integer> newSigs = concatenarSiguientes(estado.getHojas(), terminal);

                    if(!estadoExiste(newSigs)){
                        
                        Estado nuevo = new Estado("S"+contadorEstados,newSigs,contadorEstados);
                        estados.add(nuevo);
                        for(Estado estate:estados){
                            if(estate.getNumero()==contador-1){
                              estate.setTransicion(new Transicion(estate.getNombre(),terminal,nuevo.getNombre()));
                             contadorEstados++;
                            }
                        }
                        

                    }else{
                        Estado nuevo= returnEstado(newSigs) ;
                        for(Estado estate:estados){
                            if(estate.getNumero()==contador-1){

                              estate.setTransicion(new Transicion(estate.getNombre(),terminal,nuevo.getNombre()));
                              
                            }
                            
                        }
                    }
                
                }
                
            }
            contador++;
            i++;
        
        }   
    }
    
    public String getDestino(ArrayList<Integer> lista){
        for(Estado estado:estados){
            if(estado.getHojas().equals(lista)){
                return estado.getNombre();
            }
        }
        return null;
    }
    
    public ArrayList<Integer> concatenarSiguientes(ArrayList<Integer> hojas, String terminal){
        ArrayList<Integer> nexts = new ArrayList<>();
        for(Integer hoja:hojas){
            for( Siguiente siguiente:siguientes){
                if (siguiente.getNum()==hoja){
                    if(siguiente.getNodo().equals(terminal)){
                        for(Integer hojita: siguiente.getSiguientes()){
                            if(!nexts.contains(hojita)){
                                
                                    nexts.add(hojita);
                                
                            }
                        }
                    }
                }
            }
            
            }
        return nexts;
        }
    
    
    public ArrayList<String> getTerminales(ArrayList<Integer> hojas){
        ArrayList<String> terminales = new ArrayList<String>();
        for(Integer hoja: hojas){    
            for(Siguiente siguiente:siguientes){
                if(siguiente.getNum()==hoja && !terminales.contains(siguiente.getNodo())){
                    
                    terminales.add(siguiente.getNodo());
                }
            }
        }
        return terminales;
    }
    
    public boolean estadoExiste(ArrayList<Integer> lista){
        for(Estado estado:estados){
            if(estado.getHojas().equals(lista)){
                return true;
            }
        }
        
        return false;
    }
    
    public Estado returnEstado(ArrayList<Integer> lista){
        for(Estado estado:estados){
            if(estado.getHojas().equals(lista)){
                return estado;
            }
        }
        return null;
    }
    
    public Transicion obtenerTransicion(Estado e, String terminal){
        for(Transicion t:e.getTransiciones()){
            if(t.getTerminal().equals(terminal)){
                return t;
            }
        }
        return null;
    }
    
    public void buscarTerminalesG(){
        for(Siguiente siguiente:siguientes){
            if(!terminalesG.contains(siguiente.getNodo())){
                if(!siguiente.getNodo().equals("#"))
                 terminalesG.add(siguiente.getNodo());
            }
        }
    }
    
    public void crearAFD(ArrayList<Conjunto> Conjuntos){
    Estado inicial;
    inicial = estados.get(0);
    ArrayList<Estado> aceptaciones = new ArrayList<Estado>();
    int numAceptacion=1;
    for(Siguiente siguiente:siguientes){
        if(siguiente.getNodo().equals("#")){
         numAceptacion = siguiente.getNum();
        }
    }
    
    for(Estado estado:estados){
        if(estado.getHojas().contains(numAceptacion)){
                aceptaciones.add(estado);
            }
    }
    
    
    this.determinista=new AFD(this.nombre,this.estados,inicial,this.terminalesG,aceptaciones,Conjuntos);
    this.determinista.graficar();
    }
    
    public AFD getDeterminista(){
        return this.determinista;
    }
}
