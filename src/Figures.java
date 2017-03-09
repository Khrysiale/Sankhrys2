

import java.awt.Color;
import java.util.LinkedList;
import java.util.Iterator;
import java.awt.Graphics;
import java.awt.geom.Point2D;

/**
 * Figures - 
 * Liste des Figures tracées
 * @version 1.0
 *
 * @author Trinôme[ OUAGUID - BELHABRA - FERHANE ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class Figures extends LinkedList{

    /**
     * Crée une nouvelle liste de Figures Dssinables
     */
    public Figures(){
	super();
    }

    /**
     * Dessine les figures
     * @param g contexte graphique
     */
    public void dessiner(Graphics g,Color couleurRemplissage){
	for(Iterator i = this.iterator(); i.hasNext(); )
	  ((Dessinable)i.next()).dessiner(g);
            
    }

    
    /**
     * Vérifie un point est dans l'ensemble des figures
     * @return Renvoie la derniére figure contenant le point et null sinon
     */
    public Dessinable contient(Point2D point){
	Iterator i = this.iterator();
	while(i.hasNext()){
	    Dessinable figure = (Dessinable)i.next();
	    if(figure.contains(point))
		return figure;
	}
	return null;
    }
    


}
