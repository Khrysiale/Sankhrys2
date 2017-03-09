

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Polygon;

/**
 * Triangle - 
 * Un Triangle
 *
 * @version 1.0
 *
 * @author Trinôme[BELHABRA - FERHANE - OUAGUID ] 
 * @copyright (C) LPSBDR
 * @date 08/01/2009
 * @notes  Mini-projet Paint en Java
 */
class Triangle_draw extends Polygon  implements Dessinable{
    private Point2D new_Point1,new_Point2,new_Point3;


/**
     * Cree un Cercle avec 2 point2D
     * @param Point1 primier point de triangle
     * @param Point2 2 eme point de triangle
     * @param Point3 3éme point de triangle
     * @param Remplissage couleur de remplissage
     */
public Triangle_draw(Point2D Point1, Point2D Point2, Point2D Point3 ,Color Remplissage) {
super();
this.addPoint((int)Point1.getX(), (int)((Point2D)Point1).getY());
this.addPoint((int)Point2.getX(), (int)((Point2D)Point2).getY());
this.addPoint((int)Point3.getX(), (int)((Point2D)Point3).getY());
couleurRemplissage =Remplissage;
new_Point1=Point1;
new_Point2=Point2;
new_Point3=Point3;

}


    // La couleur utilisée pour les remplissage
private Color couleurRemplissage;
    /**
     * Affiche les caracteristiques du triangle
     */
   public String information(){
              int i=0;
              String s="Triangle (("+new_Point1.getX()+","+new_Point1.getY()+");("+new_Point2.getX()+","+
              new_Point2.getY()+");("+new_Point3.getX()+","+new_Point3.getY()+"))";
              return(s);
    }
       /**
     * Dessine le triangle
     * @param g contexte graphique
     */
  public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(Color.blue);
	g2d.draw(this);}

    /**
     * Translater le cerlce
     * @param dx
     * @param dy
     */
    public void translater(int dx , int dy){
	this.translate(dx, dy);
    }


    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */
    public void setCouleurRemplissage(Color couleur){
	couleurRemplissage = couleur;
    }


}
