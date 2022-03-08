/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi1;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import compi1.Archivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.parser;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import Estructuras.*;
import java.io.PrintWriter;
/**
 *
 * @author steve
 */
public class interfaz extends javax.swing.JFrame {
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3, jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem abrirItem;
    private javax.swing.JMenuItem guardarItem;
    private javax.swing.JMenuItem guardarComoItem;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem nuevoItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea consolaArea;
    private javax.swing.JTextArea editorArea;
    private javax.swing.JTree jTree1;
    private DefaultMutableTreeNode raiz;
    private DefaultMutableTreeNode carpetaExpresiones;
    private DefaultMutableTreeNode carpetaArboles;
    private DefaultMutableTreeNode carpetaSiguientes;
    private DefaultMutableTreeNode carpetaTransiciones;
    private DefaultMutableTreeNode carpetaAutomatas;
    public Archivo actual;
    private ArrayList<Arbol> arboles;
    public static listaErrores errores;
    private ArrayList<Conjunto> conjuntos;
    private ArrayList<AFD> deterministas;
    private ArrayList<Validacion> validaciones;
            
    // End of variables declaration       
    
    
    public interfaz() {
        setTitle("Proyecto 1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        setForeground(Color.GRAY);
        
         JPanel panel = new JPanel();
         panel.setBackground(Color.DARK_GRAY);
         this.setContentPane(panel);
         panel.setLayout(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        jScrollPane1 = new javax.swing.JScrollPane();
        raiz =new DefaultMutableTreeNode("Compi1");
        carpetaExpresiones =new DefaultMutableTreeNode("Expresiones Regulares");
        carpetaArboles = new DefaultMutableTreeNode("Arboles"); 
        carpetaSiguientes = new DefaultMutableTreeNode("Tabla de Siguientes");
        carpetaTransiciones = new DefaultMutableTreeNode("Tabla de Transiciones");
        carpetaAutomatas = new DefaultMutableTreeNode("Automatas");
        jTree1 = new javax.swing.JTree(raiz);
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        botonAnalizar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        consolaArea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        editorArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoItem = new javax.swing.JMenuItem();
        abrirItem = new javax.swing.JMenuItem();
        guardarItem = new javax.swing.JMenuItem();
        guardarComoItem = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        actual= new Archivo("","");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        
        jScrollPane1.setViewportView(jTree1);
        raiz.add(carpetaExpresiones);
        raiz.add(carpetaArboles);
        raiz.add(carpetaSiguientes);
        raiz.add(carpetaTransiciones);
        raiz.add(carpetaAutomatas);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(raiz));

        jButton1.setText("Validar Cadenas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonAnalizar.setText("Analizar Entrada");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        consolaArea.setBackground(new java.awt.Color(0, 0, 0));
        consolaArea.setColumns(20);
        consolaArea.setForeground(new java.awt.Color(255, 255, 255));
        consolaArea.setRows(5);
        jScrollPane4.setViewportView(consolaArea);

        jButton3.setText("Anterior");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Siguiente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setViewportView(jLabel1);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        editorArea.setEditable(true);
        editorArea.setBackground(new java.awt.Color(255, 255, 255));
        editorArea.setColumns(20);
        editorArea.setRows(5);
        jScrollPane2.setViewportView(editorArea);

        jLabel2.setText("Archivo de Entrada: ");
        jLabel2.setForeground(Color.white);
        jLabel3.setText("Salida:");
        jLabel3.setForeground(Color.white);
        jMenu1.setText("Archivo");
        
        jLabel4.setForeground(Color.green);

        nuevoItem.setText("Nuevo Archivo");
        guardarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarItemActionPerformed(evt);
            }
        });
        nuevoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoItemActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoItem);

        abrirItem.setText("Abrir");
        abrirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    abrirItemActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        guardarComoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoItemActionPerformed(evt);
            }
        });
        
        jMenu1.add(abrirItem);

        guardarItem.setText("Guardar...");
        jMenu1.add(guardarItem);

        guardarComoItem.setText("Guardar Como...");
        jMenu1.add(guardarComoItem);

        jMenuItem4.setText("Generar XML");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(446, 446, 446)
                                        .addComponent(botonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1641, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 32, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(botonAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                                               

    private void abrirItemActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {                                           
        interfaz referencia = this;  
        try {
              // TODO add your handling code here:
              JFileChooser fileChooser = new JFileChooser();
               fileChooser.showOpenDialog(referencia);
                String pat=fileChooser.getSelectedFile().getPath();
              File doc = new File(pat);
              
            try (BufferedReader obj = new BufferedReader(new FileReader(doc))) {
                String strng,texto="";
                while ((strng = obj.readLine()) != null)
                    texto = texto + strng+"\n";
                editorArea.setText(texto);
                String nombre= doc.getName();
                DefaultMutableTreeNode archivo=new DefaultMutableTreeNode(nombre);
                carpetaExpresiones.add(archivo);
                jLabel4.setText(nombre);
                jTree1.setModel(new DefaultTreeModel(raiz));
                actual= new Archivo(pat,nombre);
                obj.close();
            }
              
              
          } catch (IOException ex) {
              Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
          }
  
    }                                          

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(this.deterministas!=null){
           if(!this.deterministas.isEmpty()){
             generarJSON();
           }else{
               imprimir("Debe generar automatas primero");
           }
        }else{
             imprimir("Debe generar automatas primero");
        }
       
    }                                        

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {                                         
       String cadena = editorArea.getText();
        interpretar(cadena);
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void nuevoItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
          try {
              int indice = 1;
             
              while(true){
                   String nombre= "Nuevo"+ indice+".exp";
                   String ruta="C:\\Users\\steve\\Desktop\\Compiladores\\Proyecto1\\201903974_ExpAnalizer\\Compi1\\Reportes\\EXPRESIONES_201903974\\";
                   File f = new File(ruta+nombre);
                   if (!f.exists()) {
                        f.createNewFile();
                        Archivo a1=new Archivo(ruta+nombre, nombre);
                        DefaultMutableTreeNode archivo=new DefaultMutableTreeNode(nombre);
                        carpetaExpresiones.add(archivo);
                        jLabel4.setText(nombre);
                        actual= new Archivo(ruta+nombre,nombre);
                        break;
                   }else{
                        indice++;
                   }
                }
                jTree1.setModel(new DefaultTreeModel(raiz));
               
          } catch (IOException ex) {
              Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
          }
    }                                          
    
    private void guardarItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        try(FileWriter fileWriter = new FileWriter(actual.ruta)) {
        String datos=editorArea.getText();
        fileWriter.write(datos);
        fileWriter.close();
            System.out.println("Archivo guardado");
            consolaArea.setText("");
            consolaArea.setText("Archivo Guardado");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
    
    private void guardarComoItemActionPerformed(java.awt.event.ActionEvent evt) {                                           
        interfaz referencia = this;  
        File oldfile = new File(actual.ruta);
        JFileChooser fileChooser = new JFileChooser();
               fileChooser.showSaveDialog(referencia);
               fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
               
                String pat=fileChooser.getSelectedFile().getPath();
        File newfile = new File(pat);
        if (oldfile.renameTo(newfile)) {
            System.out.println("archivo renombrado");
            actual.ruta=newfile.getAbsolutePath();
            actual.nombre=newfile.getName();
            consolaArea.setText("");
            consolaArea.setText("Archivo Guardado");
        } else {
            System.out.println("error");
        }

    }
    
    private void interpretar(String texto) {
        try {
            
            errores = new listaErrores();
            deterministas = new ArrayList<AFD>();
            Analizadores.Sintactico sintactico = new Analizadores.Sintactico(
            new Analizadores.Lexico(new BufferedReader(new StringReader(texto))));
            //analizando
            sintactico.parse();
            this.arboles= sintactico.getArboles();
            this.conjuntos = sintactico.getConjuntos();
            this.validaciones = sintactico.getValidaciones();
            imprimir("Analisis hecho");
            if (errores.isEmpty()){
                for(int i=0;i<arboles.size();i++){
                this.arboles.get(i).graficar();
                this.arboles.get(i).generarTablaSiguientes();
                this.arboles.get(i).generarTablaTransiciones();
                this.arboles.get(i).crearAFD(conjuntos);
                this.deterministas.add(this.arboles.get(i).getDeterminista());
                } 
            }else{
                imprimir("Se encontraton Errores en la entrada\n Generando Reporte de  Errores...");
                generarReporteErrores();
            }
        } catch (Exception ex) {
            System.out.println("No se pudo realizar el analisis");
            System.out.println("Causa: "+ex.getCause());
        } 
    }
    
    public void imprimir(String texto){
    String cadena=consolaArea.getText();
    cadena = cadena + "\n"+texto;
    consolaArea.setText(cadena);
    }

    public void generarReporteErrores(){
            String cadena="""
                          <!DOCTYPE html>
                          <html lang="en">
                          <head>
                            <title>Reporte Errores</title>
                            <meta charset="utf-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1">
                            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
                          </head>
                          <body>
                          
                          <div class="container" align="center">
                            <h2>Reporte de Errores</h2>
                            <p></p>
                            <table class="table">
                              <thead>
                                <tr>
                                  <th>#</th>
                                  <th>Tipo de Error</th>
                                  <th>Descripcion</th>
                                  <th>Linea</th>
                                  <th>Columna</th>
                                </tr>
                              </thead>
                              <tbody>""";
            for(int i=0;i<errores.size();i++){
                        cadena= cadena + "\n<tr>";
                        int numero=i+1;
                        cadena = cadena + "\n<td>"+ numero +"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getTipo()+"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getDescripcion()+"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getFila()+"</td>";
                        cadena = cadena + "\n<td>"+errores.get(i).getColumna()+"</td>";
                        cadena = cadena + "\n</tr>";
                    }
            cadena = cadena + "</tbody>\n" + "  </table>\n" + "</div>\n" + "\n" + "</body>\n" + "</html>";
            FileWriter archivo = null;
            PrintWriter print = null;
                try {
                    archivo = new FileWriter("./Reportes\\\\ERRORES_201903974\\\\ERRORES.html");
                    print = new PrintWriter(archivo);
                    print.println(cadena);
                } catch (IOException e) {
                }finally{
                    if(archivo!=null){
                        try {
                            archivo.close();
                            imprimir("Reporte de errores generado");
                        } catch (IOException ex) {
                            Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                    }
                }
    }
    
    
    public void generarJSON(){
        
        FileWriter archivo = null;
        String cadena = "[\n";
        boolean encontrada = false;
        for(Validacion validacion: this.validaciones){
            encontrada = false;
            for(AFD automata:this.deterministas){
                if(automata.getNombre().equals(validacion.getNombre())){
                    cadena+="  {\n";
                    cadena+="      \"Valor\":\""+validacion.getCadena().replace("\\'", "\\\\'").replace("\\\"", "\\\\\\\"").replace("\\n", "\\\\n")+"\",\n";
                    cadena+="      \"ExpresionRegular\":\""+validacion.getNombre()+"\",\n";
                    if(automata.validarCadena(validacion.getCadena())){
                        cadena+="      \"Resultado\":\"Cadena Valida\"\n";
                        imprimir("La cadena: "+validacion.getCadena()+", es valida con la expresion: "+validacion.getNombre()+".\n");
                    }else{
                        cadena+="      \"Resultado\":\"Cadena No Valida\"\n";
                        imprimir("La cadena: "+validacion.getCadena()+",NO es valida con la expresion: "+validacion.getNombre()+".\n");
                    }
                    cadena+="  },\n";
                    encontrada = true;
                }
            }
            if(!encontrada){
                imprimir("La cadena: "+validacion.getCadena()+", no pudo ser analizada con el siguiente automata: "+validacion.getNombre()+".\n");
            }
        }
        cadena+="\n]";
         try {
            if (actual!=null){
                archivo = new FileWriter("./Reportes/SALIDAS_201903974/SALIDA-"+this.actual.getNombre()+".json");
            } else{
            
            archivo = new FileWriter("./Reportes/SALIDAS_201903974/SALIDA-"+this.actual.getNombre()+".json");
            }
            archivo.write(cadena);
            imprimir("JSON generado.");
        } catch (Exception e) {
            e.printStackTrace();
 
        } finally {
 
            try {
                archivo.flush();
                archivo.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
         imprimir("Analisis de validaciones terminado.");
        
    }    
    
    
    
}

