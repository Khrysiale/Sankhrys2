

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * Rectangle - 
 * Un rectangle vide
 *
 * @version 1.0
 *
 * @author Trinôme[  BELHABRA - OUAGUID - FERHANE ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class Rectangle_draw extends Rectangle2D.Double implements Dessinable{

    /**
     * Cree un Rectangle avec deux points
     * @param _point1 point 1
     * @param _point2 point 2
     * @param _couleurRemplissage couleur de remplissage
     */
    public Point2D point1,point2;
    public Rectangle_draw(Point2D point1, Point2D point2,Color Remplissage)
    {  
	super(point1.getX(), point1.getY(),Math.abs(point2.getX() - point1.getX()),Math.abs(point2.getY() - point1.getY()));
         couleurRemplissage =Remplissage;
    }



    // La couleur utilis�e pour les remplissage

   private Color couleurRemplissage;


    /**
     * Dessine le rectangle
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(Color.blue);
	g2d.draw(this);
        
    }

    /**
     * Affiche les caracteristiques du rectangle
     */
public String information(){
   String s="Rectangle (" + getWidth()+" , "+ getHeight()+")";
        return(s);
    }


    /**
     * Translater le rectangle
     * @param dx
     * @param dy
     */
      
    public void translater(int dx , int dy){
	setRect(getX() + dx, getY() + dy, getWidth(), getHeight());
    }


    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */
    public void setCouleurRemplissage(Color couleur){
	couleurRemplissage = couleur;
    }


    
}
