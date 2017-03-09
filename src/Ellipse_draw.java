

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

/**
 * Ellipse - 
 * Un Ellipse vide
 *
 * @version 1.0
 *
 * @author Trinôme[BELHABRA - FERHANE - OUAGUID ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class Ellipse_draw extends Ellipse2D.Double implements Dessinable{
/**
     * Cree un Cercle avec 2 point2D
     * @param centre centre du cercle
     * @param point un pointdu cercle
     * @param _couleurRemplissage couleur de remplissage
     */
        public Ellipse_draw(Point2D centre, Point2D point, Color _couleurRemplissage){

		super(centre.getX(), centre.getY(),
	        point.getX()-centre.getX(), point.getY()-centre.getY());
	couleurRemplissage = _couleurRemplissage;
    }
    private Color couleurRemplissage;
    /**
     * Dessine l'ellipse
     * @param g contexte graphique
     */
    public void dessiner(Graphics g) {
       	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurRemplissage);
        g2d.setColor(Color.blue);
	g2d.draw(this);
    }

   /**
     * Affiche les caracteristiques d'ellipse
     */
    public String information() {
        String s="Ellipse vide (" + (int)getWidth()+" , "+ (int)getHeight()+")";
        return(s);
    }
    /**
     * Translater l'ellipse
     * @param dx
     * @param dy
     */
    public void translater(int dx, int dy) {
        this.setFrame(this.x+dx, this.y+dy, this.width,this.height);
    }
    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */
        public void setCouleurRemplissage(Color couleur) {
  couleurRemplissage = couleur;
    }

  

}
