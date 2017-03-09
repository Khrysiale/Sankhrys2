

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Polygon;
import java.util.Vector;

/**
 * Polygone- 
 * Un Polygone
 *
 * @version 1.0
 *
 * @author Trinôme[BELHABRA - OUAGUID - FERHANE ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class Polygone extends Polygon implements Dessinable{

   
/**
     * Cree un polygone avec une vecteur
     * @param vecteur une vecteur qui contient des points de polygone
     * @param _couleurRemplissage couleur de remplissage
     */
public Polygone(Vector vecteur, Color _couleurRemplissage){
	super();
	if(vecteur.size() > 1)
	    for(int i = 0; i < vecteur.size(); i++)
		addPoint((int)((Point2D)vecteur.elementAt(i)).getX(), (int)((Point2D)vecteur.elementAt(i)).getY());
	couleurRemplissage = _couleurRemplissage;
    }

   private Color couleurRemplissage;

    /**
     * Affiche les caracteristiques du polygone
     */
    public String information(){
             
              String s="Polygone";
              return(s);
    }
    
/**
     * Dessine le polygone
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurRemplissage);
	g2d.fill(this);
	g2d.setColor(Color.blue);
	g2d.draw(this);     
    }

    /**
     * Translater le polygone
     * @param dx
     * @param dy
     */
  public void translater(int dx , int dy){
         this.translate(dx, dy);
  	    
}

    public void setCouleurRemplissage(Color couleur){
	couleurRemplissage = couleur;
    }


    public void dessin_draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
