


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
/**
 * Cercle - 
 * Un cercle vide
 *
 * @version 1.0
 *
 * @author Trinôme[ OUAGUID - BELHABRA - FERHANE ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class Cercle_draw extends Ellipse2D.Double implements Dessinable{

/**
     * Cree un Cercle avec 2 point2D
     * @param centre centre du cercle
     * @param point un pointdu cercle
     * @param _couleurRemplissage couleur de remplissage
     */

    public Cercle_draw(Point2D centre, Point2D point, Color _couleurRemplissage){
	super(centre.getX() - centre.distance(point), centre.getY() - centre.distance(point),
	      2 * centre.distance(point), 2 * centre.distance(point));

	couleurRemplissage = _couleurRemplissage;
    }


    // La couleur utilisée pour les remplissage
    private Color couleurRemplissage;


    /**
     * Dessine le cercle
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.blue);
	g2d.draw(this);
    }

    /**
     * Translater le cerlce
     * @param dx
     * @param dy
     */
    public void translater(int dx , int dy){
	setFrame(getX() + dx, getY() + dy, getWidth(), getHeight());
    }

    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */
    public void setCouleurRemplissage(Color couleur){
	couleurRemplissage = couleur;
    }

    /**
     * Affiche les caracteristiques du cercle
     */
    public String information() {
       String s="Cercle vide (centre : ("+(int)this.x+","+(int)this.y+")- rayon :" + (int)getWidth()+")";
        return(s);
    }
}