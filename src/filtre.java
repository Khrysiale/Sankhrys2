

import javax.swing.filechooser.*;
import java.io.File;
/**
 * filre - 
 * utilisé dans la boite de dialogue pour séléctionner le type de l'image voulue
 *
 * @notes  Mini-projet Paint en Java
 */
public class filtre extends FileFilter{
    private String description;
   private String extension;
     public filtre(String description, String extension){
      if(description == null || extension ==null){
         throw new NullPointerException("La description (ou extension) ne peut etre null.");
      }
      this.description = description;
      this.extension = extension;
   }
   
    public boolean accept(File file){
	   
      if(file.isDirectory()) { 
         return true; 
      } 
      String nomFichier = file.getName().toLowerCase(); 

      return nomFichier.endsWith(extension);
   }
      public String getDescription(){
      return description;
   }
} 
