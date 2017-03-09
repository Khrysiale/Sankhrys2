

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.BasicStroke;

/**
 * Segment - 
 * Un segment
 *
 * @version 1.0
 *
 * @author Trinôme[ BELHABRA - OUAGUID - FERHANE ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class Segment extends Line2D.Double implements Dessinable{
public double xx_1,xx_2,yy_1,yy_2;
    /**
     * Crée un Segment avec 2 point2D
     * @param p1 point 1
     * @param p2 point 2
     * @param _couleurTraits couleur des traits
     * @param _epaisseur épaisseur
     */
    public Segment(Point2D p1, Point2D p2, Color _couleurTraits, int _epaisseur){
	super(p1, p2);
                xx_1=p1.getX();
                yy_1=p1.getY();
                xx_2=p2.getX();
                yy_2=p2.getY();
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

    /**
     * Crée un Segment avec les coordonnées des 2 points
     * @param x1 abscisse point 1
     * @param y1 ordonnée point 1
     * @param x2 abscisse point 2
     * @param y2 ordonnée point 2
     * @param _couleurTraits couleur des traits
     * @param _epaisseur épaisseur
     */
    public Segment(double x1, double y1, double x2, double y2, Color _couleurTraits, int _epaisseur){
	super(x1, y1, x2, y2);
        
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

    // La couleur utilisée pour les traits
    private Color couleurTraits;

    // Epaisseur des traits
    private int epaisseur;

    /**
     * Dessine le segment
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurTraits);
	g2d.setStroke(new BasicStroke(epaisseur, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	g2d.draw(this);
    }

    /**
     * Vérifie si un point appartient é une extrémité du segment
     * @return vrai si le point appartient é une extrémité du segment
     */
    public boolean contains(Point2D point){
	if(point.equals(getP1()) || point.equals(getP2()))
	    return true;
	else return false;
    }

 
  

    /**
     * Translater le segment
     * @param dx
     * @param dy
     */
    public void translater(int dx , int dy){
	setLine(getX1() + dx, getY1() + dy, getX2() + dx, getY2() + dy);
    }

    /**
     * Change la couleur des traits
     * @param couleur nouvelle couleur
     */
    public void setCouleurTraits(Color couleur){
	couleurTraits = couleur;
    }


    /**
     * Affiche les caractéristiques du segment
     */
    public String information() {
        String info="Ligne (["+xx_1+","+yy_1+"] , ["+xx_2+","+yy_2+"])";
        return info;
    }


    public void setCouleurRemplissage(Color couleur) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
