

import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Interface Dessinable - 
 * Donne la possibilite d'etre dessiner
 * @version 1.0
 *
 * @author Trinôme[ BELHABRA -OUAGUID  - FERHANE ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public interface Dessinable{

    /**
     * Dessine la figure
     * @param g contexte graphique
     */
    public abstract void dessiner(Graphics g);

    /**
     * Affiche les caract�ristiques de la figure en console
     */
    
    public abstract String information();


    /**
     * Verifie si un point appartient � la figure
     * @param point un point
     * @return vrai si le point appartient � la figure 
     */
    public abstract boolean contains(Point2D point);

    /**
     * Effectue une translation de la figure
     * @param dx
     * @param dy
     */
    public abstract void translater(int dx, int dy);



    /**
     * Change la couleur de remplissage
     * @param couleur nouvelle couleur
     */
    public abstract void setCouleurRemplissage(Color couleur);

}
