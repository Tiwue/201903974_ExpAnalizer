/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author steve
 */
public class Archivos {
    
    public void NewFile() throws IOException{
        File f = new File("Nuevo.exp");
    if (!f.exists()) {
    f.createNewFile();
}   
    };
    
}
