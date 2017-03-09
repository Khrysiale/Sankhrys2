

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Image - 
 * Une image
*
 * @version 1.0
 *
 * @author Trinôme[ OUAGUID - BELHABRA - FERHANE ] 
 * @copyright (C) LPSBDR
 * @date 08/01/2009
 * @notes  Mini-projet Paint en Java
 */
public class image  implements Dessinable {
 public Image loadedImage;
 public BufferedImage image;
 public String nom_image;
 /**
     * Cree une image
     * @param l image choisi
     * @param s le nom de l'image
     */   
    public image (Image l,String s){
        loadedImage=l;
        nom_image=s;
        
    }
    /**
     * Dessine l'image
     * @param g contexte graphique
     */
    public void dessiner(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
    g.drawImage(loadedImage,0,0,null);
    g2d.drawImage(loadedImage , 0, 0, null);
    }



    /**
     * Translater l'image
     * @param dx
     * @param dy
     */
    public void translater(int dx , int dy){
    }

    public boolean contains(Point2D point) {
        return false;
    }

    /**
     * Affiche les caract�ristiques de l'image
     */
    public String information() {
        String info=nom_image +" ("+loadedImage.getWidth(null)+" , "+loadedImage.getHeight(null)+" )";
        return info;
    }

    public void setCouleurRemplissage(Color couleur) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   


}
