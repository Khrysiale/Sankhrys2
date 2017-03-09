

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 * roundRectangle - 
 * Un Roundrectangle vide
 *
 * @version 1.0
 *
 * @author Trinôme[ OUAGUID - FERHANE - BELHABRA ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class roundrect_draw extends RoundRectangle2D.Double implements Dessinable{
    /**
     * Cree un Rectangle avec deux points
     * @param _point1 point 1
     * @param _point2 point 2
     * @param _couleurRemplissage couleur de remplissage
     * @param arcw largeur arc
     * @param arch hauteur arc
     */
public roundrect_draw(Point2D point1, Point2D point2,Color Remplissage,double arcw,double arch)
{super(point1.getX(), point1.getY(),Math.abs(point2.getX() - point1.getX()),Math.abs(point2.getY() - point1.getY()),arcw,arch);
couleurRemplissage =Remplissage;
}


private Color couleurRemplissage;


    /**
     * Dessine le round rectangle
     * @param g contexte graphique
     */

public void dessiner(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurRemplissage);
	g2d.setColor(Color.blue);
	g2d.draw(this);
    }
    /**
     * Affiche les caracteristiques du roundrectangle
     */

    public String information() {
        String s="Rectangle (" + getWidth()+" , "+ getHeight()+")";
        return(s);
    }
    /**
     * Translater le rectangle
     * @param dx
     * @param dy
     */
    public void translater(int dx, int dy) {
        setRoundRect(this.x + dx, this.y + dy,this.width,this.height,this.getArcWidth() ,this.getArcHeight());
    }

    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */

    public void setCouleurRemplissage(Color couleur) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
