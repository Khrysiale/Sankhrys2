

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.util.Vector;
import java.util.Collection;


/**
 * Ligne - 
 * Une ligne
 *
 * @version 1.0
 *
 * @author Trinôme[ FERHANE - OUAGUID - BELHABRA ] 
 * @copyright (C) LPSBDR
 * @notes  Mini-projet Paint en Java
 */
public class M_Libre extends Vector implements Dessinable{

    /**
     * Crée une Ligne vide
     * @param _couleurTraits couleur des traits
     * @param _epaisseur épaisseur
     */
    public M_Libre(Color _couleurTraits, int _epaisseur){
	super();
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

    /**
     * Crée une Ligne contenant les éléments de la collection spécifiée
     * @param collection
     * @param _couleurTraits couleur des traits
     * @param _epaisseur épaisseur
     */
    public M_Libre(Collection collection, Color _couleurTraits, int _epaisseur){
	super(collection);
	couleurTraits = _couleurTraits;
	epaisseur = _epaisseur;
    }

    // La couleur utilisée pour les traits
    private Color couleurTraits;

    // Epaisseur des traits
    private int epaisseur;

    /**
     * Dessine la ligne
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setColor(couleurTraits);
	g2d.setStroke(new BasicStroke(epaisseur, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	g.setColor(couleurTraits);
	if(this.size() > 1){
	    for(int i = 1; i < this.size(); i++)
		g2d.draw(new Line2D.Double((Point2D)elementAt(i-1), (Point2D)elementAt(i)));
	}
    }

    /**
     * Vérifie si un point appartient a une extrémité de la ligne
     * @return vrai si le point appartient a une extrémité de la ligne
     */
    public boolean contains(Point2D point){

	 return false;
    }

    /**
     * Translater la ligne
     * @param dx
     * @param dy
     */
    public void translater(int dx , int dy){
    }




    /**
     * Change la couleur des traits
     * @param couleur nouvelle couleur
     */
    public void setCouleurTraits(Color couleur){
	couleurTraits = couleur;
    }


    /**
     * Affiche les caractéristiques de la ligne
     */
    public String information() {
        String info="Dessin trait libre";
        return info;
    }

    public void setCouleurRemplissage(Color couleur) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
