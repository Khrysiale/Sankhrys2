

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author utilisateur
 */
class Dessin extends JPanel {
    int xd, yd, x, y,jj=0;
    public static int hh=0;
    Color lwn=Color.black;
    Graphics2D g2;
    Rectangle_fill rect_fill;
    roundrect_fill rd_rect_fill;
    roundrect_draw rd_rect_draw;
    Rectangle_draw rect_draw;
    Segment segment;
    Ellipse_fill ellipse_fill;
    Ellipse_draw ellipse_draw;
    Cercle_draw cercle_draw;
    Cercle_fill cercle_fill;
    Triangle_fill tr_f;
    Triangle_draw tr_d;
    public Vector liste= new Vector();
    Figures figures=new Figures();
    Figures figures1=new Figures();
    public String flag="",flag2="";
    private Dessinable figureSelectionnee;
    private boolean selection;
    public JTextArea a;
    public int i=0;
    public String s;
    public Image loadedImage;
    public File fichier;
    public BufferedImage image;
    public Graphics new_g;
    public Point2D p1,p2,p3;
Dessin()
        {
            setPreferredSize(new Dimension(400,250));
            addMouseListener(new Appuyeur());
            addMouseListener(new relache());
            addMouseMotionListener(new Dragueur());
            setOpaque(false);
        }
public void setlwn(Color c)
        {
             lwn=c;
        }
public String getflag()
        {
             return flag;
        }
public Figures getfigure()
        {
           return figures;
        }
public void vider_dessin()
        {
            figures.clear();
            figures1.clear();
        }

    @Override
public void paintComponent(Graphics g)
        {
            new_g=g;
            Graphics2D g2 = (Graphics2D) new_g;
            g2.setStroke(new BasicStroke(3));
            g2.setBackground(Color.white);
            figures.dessiner(new_g,lwn);
            repaint();
            xd = x; yd = y;
        }

public void setpoint(int x,int y)
        {
            Point2D m=new Point2D.Double(xd, yd);
            liste.add(m);
        }

public void loadImage(File name,String nom_image)
        {
             loadedImage = null;
            fichier=name;
            try {
            loadedImage = ImageIO.read(name);
            } catch (IOException e1) {
            JOptionPane.showMessageDialog(this,"Impossible d'ouvrir ce fichier,une autre image est ouvert" +"e1","Erreur chargement",JOptionPane.WARNING_MESSAGE);
            }
            Graphics g = getGraphics();
            g.drawImage(loadedImage, x, y, this);
            image pic=new image(loadedImage,nom_image);
            if (JOptionPane.showConfirmDialog(this, "Mettre l'image en premiere plan", "Position",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION)
            {
            figures.add(pic);
            }else{
            figures.add(0,pic);
            }
            pic.dessiner(g);
            repaint();
          }

    void msgpropos() {
        JOptionPane.showMessageDialog(this, "Cette application est realisée par: \n      BELHABRA Abdrahim \n      FERHANE Mustapha  \n      OUAGUID Abdellah","A propos",JOptionPane.INFORMATION_MESSAGE); 
    }

class Appuyeur extends MouseAdapter {
        @Override
public void mousePressed(MouseEvent e1) {
if (flag.equals("rect_draw") ||flag.equals("rect_fill")||
            flag.equals("taille1")|| flag.equals("taille2")|| 
            flag.equals("taille3")||flag.equals("taille4")||
            flag.equals("rd_rect_fill")|| flag.equals("rd_rect_draw")||
            flag.equals("tligne1")||flag.equals("tligne2")||
            flag.equals("tligne3")||flag.equals("tligne4")||
            flag.equals("cercle_fill")||flag.equals("cercle_draw")||
            flag.equals("ellipse_fill")||flag.equals("ellipse_draw")||
            flag.equals("triangle_draw")||
            flag.equals("triangle_fill"))
        {
             xd = e1.getX(); yd = e1.getY();
             liste.add(new Point2D.Double(xd, yd));
             System.out.println(liste.size());
        }

if (flag.equals("polygone"))
        {
            xd = e1.getX(); yd = e1.getY();
            System.out.println("salut 1");
            liste.add(new Point2D.Double(xd, yd));
            System.out.println("salut 2");
            System.out.println(liste.size());

        }

if (flag.equals("deplacer"))
        {
            if(!selection){
                    Point2D point = new Point2D.Double(e1.getX(), e1.getY());
                    figureSelectionnee = figures.contient(point);
                    if(figureSelectionnee != null)
                        {
                             liste.add(point);
                             selection = true;
                        }}
        }
if (flag.equals("remplir"))
        {
            if(!selection){
                 Point2D point = new Point2D.Double(e1.getX(), e1.getY());
                 figureSelectionnee = figures.contient(point);
                 if(figureSelectionnee != null){
                        liste.add(point);
                        selection = true;        }
                            }
        }

}
        @Override
public void mouseClicked(MouseEvent me)
        {
if (flag.equals("triangle_fill")) {
               if (i<3){
			Point2D point = new Point2D.Double(me.getX(), me.getY());
			liste.add(point);
                        System.out.println(i);
                        System.out.println(liste.size());
                        i++;
                         }
               if (i==3)
                     {
         Point2D point1 = (Point2D)liste.firstElement();
         Point2D point2 = (Point2D)liste.elementAt(2);
         Point2D point3 = (Point2D)liste.lastElement();

         tr_f= new Triangle_fill(point1, point2,point3,lwn);
         figures.add(tr_f);
         liste.clear();
         repaint();
         i=0;
                     }
                       }
else if (flag.equals("triangle_draw")) {
               if (i<3){
			Point2D point = new Point2D.Double(me.getX(), me.getY());
			liste.add(point);
                        System.out.println(i);
                        System.out.println(liste.size());
                        i++;
                         }
               if (i==3)
                     {
         Point2D point1 = (Point2D)liste.firstElement();
         Point2D point2 = (Point2D)liste.elementAt(2);
         Point2D point3 = (Point2D)liste.lastElement();

         tr_d= new Triangle_draw(point1, point2,point3,lwn);
         figures.add(tr_d);
         liste.clear();
         repaint();
         i=0;
                     }
                       }
          else if(flag.equals("Premier_plan"))
          {
              	Point2D point = new Point2D.Double(me.getX(), me.getY());
		figureSelectionnee = figures.contient(point);
		if(figureSelectionnee != null){
		    figures.remove(figureSelectionnee);
		    figures.add(figureSelectionnee);
		    repaint();
	    }
          }
        else if(flag.equals("Arriere_plan"))
          {
		Point2D point = new Point2D.Double(me.getX(), me.getY());
		figureSelectionnee = figures.contient(point);
		if(figureSelectionnee != null){

		    figures.remove(figureSelectionnee);
		    figures.add(0,figureSelectionnee);
		    repaint();
		}

          }
          else{
            if(liste.size()>0){
                        Point2D point1 = (Point2D)liste.lastElement();
			Point2D point2 = new Point2D.Double(me.getX(), me.getY());
			liste.add(point2);
			segment = new Segment(point1, point2, lwn,5);
			Graphics g = getGraphics();
			segment.dessiner(g);
			g.dispose();
                        }

            } }
}
class relache extends MouseAdapter {
public void mouseReleased(MouseEvent e) {

        if (flag.equals("rect_draw"))
                 { x =e.getX(); y = e.getY();
                 Point2D point1 = (Point2D)liste.lastElement();
                 Point2D point2 = new Point2D.Double(e.getX(), e.getY());
                 rect_draw  = new Rectangle_draw(point1, point2,lwn);
                 figures.add(rect_draw);
                 liste.clear();
                 repaint(); }


         if (flag.equals("rect_fill"))
                { x =e.getX(); y = e.getY();
                 Point2D point1 = (Point2D)liste.lastElement();
                 Point2D point2 = new Point2D.Double(e.getX(), e.getY());
                 rect_fill  = new Rectangle_fill(point1, point2,lwn);
                 figures.add(rect_fill);
                 liste.clear();
                 repaint();  }
        if (flag.equals("rd_rect_fill"))
                { x =e.getX(); y = e.getY();
                 Point2D point1 = (Point2D)liste.lastElement();
                 Point2D point2 = new Point2D.Double(e.getX(), e.getY());
                 rd_rect_fill  = new roundrect_fill(point1, point2,lwn,20,20);
                 figures.add(rd_rect_fill);
                 liste.clear();
                 repaint();  }
if (flag.equals("rd_rect_draw"))
                { x =e.getX(); y = e.getY();
                 Point2D point1 = (Point2D)liste.lastElement();
                 Point2D point2 = new Point2D.Double(e.getX(), e.getY());
                 rd_rect_draw  = new roundrect_draw(point1, point2,lwn,20,20);
                 figures.add(rd_rect_draw);
                 liste.clear();
                 repaint();  }

if (flag.equals("polygone"))
    {

           	 liste.add(new Point2D.Double(e.getX(), e.getY()));
			Polygone poly=new Polygone(liste,lwn);
    			figures.add(poly);
    			     liste.clear();
    			repaint();


           	}
        if (flag.equals("deplacer"))
        {if(selection){
		selection = false;
		liste.clear(); } }

         if (flag.equals("remplir"))
        {if(selection){
		selection = false;
		liste.clear(); } }

      	if(flag.equals("tligne1")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(e.getX(), e.getY());
		    segment = new Segment(point1, point2, lwn,2);
		    figures.add(segment);
		    liste.clear();
		    repaint();
		}
        if(flag.equals("tligne2")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(e.getX(), e.getY());
		    segment = new Segment(point1, point2, lwn,5);
		    figures.add(segment);
		    liste.clear();
		    repaint();
		}

       if(flag.equals("tligne3")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(e.getX(), e.getY());
		    segment = new Segment(point1, point2, lwn,9);
		    figures.add(segment);
		    liste.clear();
		    repaint();
            segment = new Segment(point1, point2, lwn,2);
               figures.add(segment);
		    liste.clear();
		    repaint();
		}
        if(flag.equals("tligne4")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(e.getX(), e.getY());
		    segment = new Segment(point1, point2, lwn,13);
		    figures.add(segment);
		    liste.clear();
		    repaint();
              segment = new Segment(point1, point2, lwn,2);
               figures.add(segment);
		    liste.clear();
		    repaint();
		}





        if(flag.equals("taille1")){
            M_Libre ligne = new M_Libre(liste, lwn, 2);
		    figures.add(ligne);
		    liste.clear();
		    repaint();}
        if(flag.equals("taille2")){
            M_Libre ligne = new M_Libre(liste, lwn, 5);
		    figures.add(ligne);
		    liste.clear();
		    repaint();}
        if(flag.equals("taille3")){
        	M_Libre ligne = new M_Libre(liste, lwn, 9);
		    figures.add(ligne);
		    liste.clear();
		    repaint();
        M_Libre ligne1 = new M_Libre(liste, lwn, 2);
		    figures.add(ligne1);
		    liste.clear();
		    repaint();}
        if(flag.equals("taille4")){
            M_Libre ligne = new M_Libre(liste, lwn, 13);
		    figures.add(ligne);
		    liste.clear();
		    repaint();
        M_Libre ligne1 = new M_Libre(liste, lwn, 2);
		    figures.add(ligne1);
		    liste.clear();
		    repaint();}

if (flag.equals("cercle_draw"))
    {
         x =e.getX(); y = e.getY();
         Point2D point1 = (Point2D)liste.lastElement();
         Point2D point2 = new Point2D.Double(e.getX(), e.getY());
         cercle_draw= new Cercle_draw(point1, point2,lwn);
         figures.add(cercle_draw);
         liste.clear();
         repaint();
}
if (flag.equals("cercle_fill"))
    {
         x =e.getX(); y = e.getY();
         Point2D point1 = (Point2D)liste.lastElement();
         Point2D point2 = new Point2D.Double(e.getX(), e.getY());
         cercle_fill= new Cercle_fill(point1, point2,lwn);
         figures.add(cercle_fill);
         liste.clear();
         repaint();
}
        if (flag.equals("ellipse_draw"))
    {
         x =e.getX(); y = e.getY();
         Point2D point1 = (Point2D)liste.lastElement();
         Point2D point2 = new Point2D.Double(e.getX(), e.getY());
         ellipse_draw= new Ellipse_draw(point1, point2,lwn);
         figures.add(ellipse_draw);
         liste.clear();
         repaint();
}
        if (flag.equals("ellipse_fill"))
    {
         x =e.getX(); y = e.getY();
         Point2D point1 = (Point2D)liste.lastElement();
         Point2D point2 = new Point2D.Double(e.getX(), e.getY());
         ellipse_fill= new Ellipse_fill(point1, point2,lwn);
         figures.add(ellipse_fill);
         liste.clear();
         repaint();
}
        
}
}

class Dragueur extends MouseMotionAdapter {
       
        @Override
public void mouseDragged(MouseEvent me) {
           if (flag.equals("rect_draw"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
      rect_draw= new Rectangle_draw(point1, point2,lwn);
      Graphics g = getGraphics();
      repaint();
      rect_draw.dessiner(g);
      String w="Rectangle ..(" + getWidth()+" , "+ getHeight()+")";
//      System.out.println(w);
//      setxt(rect.information());
      s=rect_draw.information();
System.out.println("rectangle_ok");

}
    if (flag.equals("rect_fill"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
      rect_fill= new Rectangle_fill(point1, point2,lwn);
      Graphics g = getGraphics();
      repaint();
      rect_fill.dessiner(g);
      String w="Rectangle ..(" + getWidth()+" , "+ getHeight()+")";
//      System.out.println(w);
//      setxt(rect.information());
      s=rect_fill.information();
System.out.println("rectangle_ok");
     
}
             if (flag.equals("rd_rect_fill"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
      rd_rect_fill= new roundrect_fill(point1, point2,lwn,20,20);
      Graphics g = getGraphics();
      repaint();
      rd_rect_fill.dessiner(g);
      String w="Rectangle ..(" + getWidth()+" , "+ getHeight()+")";
//      System.out.println(w);
//      setxt(rect.information());
      s=rd_rect_fill.information();
System.out.println("rectangle_ok");

}
if (flag.equals("rd_rect_draw"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
      rd_rect_draw= new roundrect_draw(point1, point2,lwn,20,20);
      Graphics g = getGraphics();
      repaint();
      rd_rect_draw.dessiner(g);
      s=rd_rect_draw.information();
System.out.println("rectangle_ok");

}

     if (flag.equals("polygone"))
    {
			liste.add(new Point2D.Double(me.getX(), me.getY()));
			Polygone poly=new Polygone(liste,lwn);
           	                 Graphics g = getGraphics();
              		    repaint();
    			poly.dessiner(g);
          }
       	  	 
    if(flag.equals("taille1")){

		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    liste.add(point2);
		    M_Libre seg=new M_Libre(liste,lwn,2);
		    Graphics g = getGraphics();
            repaint();
		    seg.dessiner(g);
            repaint();}

      if(flag.equals("taille2")){

		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    liste.add(point2);
		    M_Libre seg=new M_Libre(liste,lwn,5);
		    Graphics g = getGraphics();
            repaint();
		    seg.dessiner(g);
            repaint();}
     if(flag.equals("taille3")){

		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    liste.add(point2);
		    M_Libre seg=new M_Libre(liste,lwn,9);
		    Graphics g = getGraphics();
            repaint();
		    seg.dessiner(g);
            repaint();} if
      (flag.equals("taille4")){

		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    liste.add(point2);
		    M_Libre seg=new M_Libre(liste,lwn,13);
		    Graphics g = getGraphics();
            repaint();
		    seg.dessiner(g);
            repaint();}


    if(flag.equals("tligne1")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    segment = new Segment(point1, point2, lwn,2);
		    Graphics g = getGraphics();
		    repaint();
		    segment.dessiner(g);}
   if(flag.equals("tligne2")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    segment = new Segment(point1, point2, lwn,5);
		    Graphics g = getGraphics();
		    repaint();
		    segment.dessiner(g);}
  if(flag.equals("tligne3")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    segment = new Segment(point1, point2, lwn,9);
		    Graphics g = getGraphics();
		    repaint();
		    segment.dessiner(g);}
  if(flag.equals("tligne4")){
		    Point2D point1 = (Point2D)liste.lastElement();
		    Point2D point2 = new Point2D.Double(me.getX(), me.getY());
		    segment = new Segment(point1, point2, lwn,13);
		    Graphics g = getGraphics();
		    repaint();
		    segment.dessiner(g);
  }


if(flag.equals("deplacer")){
          if(selection){
		    Point2D point = new Point2D.Double(me.getX(), me.getY());
		    int dx = (int)(point.getX() - ((Point2D)liste.lastElement()).getX());
		    int dy = (int)(point.getY() - ((Point2D)liste.lastElement()).getY());
		    figureSelectionnee.translater(dx, dy);
		    liste.add(point);
		    repaint();}}
if(flag.equals("remplir")){
          if(selection){
		    figureSelectionnee.setCouleurRemplissage(lwn);
		    repaint();}}

if (flag.equals("cercle_draw"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
     cercle_draw= new Cercle_draw(point1, point2,lwn);
      Graphics g = getGraphics();
      repaint();
      cercle_draw.dessiner(g);
}
if (flag.equals("cercle_fill"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
     cercle_fill= new Cercle_fill(point1, point2,lwn);
      Graphics g = getGraphics();
      repaint();
      cercle_fill.dessiner(g);
}
if (flag.equals("ellipse_fill"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
     ellipse_fill= new Ellipse_fill(point1, point2,lwn);
      Graphics g = getGraphics();
      repaint();
      ellipse_fill.dessiner(g);
}
if (flag.equals("ellipse_draw"))
{
      x =me.getX(); y = me.getY();
      Point2D point1 = (Point2D)liste.lastElement();
      Point2D point2 = new Point2D.Double(me.getX(), me.getY());
     ellipse_draw= new Ellipse_draw(point1, point2,lwn);
      Graphics g = getGraphics();
      repaint();
      ellipse_draw.dessiner(g);
}
}
    }


}