


import java.util.Iterator;
import javax.swing.JTextArea;
/**
 * Information - 
 * permet de remplir JTextArea par des informations des objets dissinés
 *
 * @version 1.0
 *
 * @author Trinôme[ OUAGUID - FERHANE - BELHABRA ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class Information extends JTextArea {
public Figures fg;
public String g="";
/**
     * actualiser le contenu la zone de texte
     * @param f cotinent les objet dissinés
     */    
    public Information (Figures f)
    {
        fg=f;
        this.removeAll();
        this.remplir();
        
    }
/**
     * remplir la zone de texte
     */
    public void remplir()
    {
        for(Iterator i = fg.iterator(); i.hasNext(); )
	g = g + "\n"+ ((Dessinable) i.next()).information();
        this.append(g );
        System.out.println(g);
    }
    /**
     * retourne les informations de tous les objets
     */
    public String getg(){
        return g;
    }
    
}
