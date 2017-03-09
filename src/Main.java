

import java.awt.Color;
import java.awt.Container;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author utilisateur
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	    SplashScreen splash = new SplashScreen(5000);
	     splash.showSplashAndExit();
        
        JFrame frame = new Paint();
	  frame.show();
          
    }

}
 


class Paint extends JFrame implements ActionListener{
public JMenuBar menuBar = new JMenuBar();
public JMenu Fichier,Edition,dessiner,aide;
public JMenuItem New,Ouvrir,coleur,vider,deplacer,Quitter,ligne,rectangle,cercle,ellipse,main,
        polygone,triangle,remplir,gomme,annuler,repeter,apropos,doc;
public JToolBar standart,barre1;
public JButton Main,Ligne,Rectang,Cercle,Ellipse,Triangle,Triangle_draw,Triangle_fill,Deplacer,img,Polygone,Remplir,Gomme,rect_fill,rect_draw,rd_rect_fill,rd_rect_draw,vide1,vide2
        ,taille1,taille2,taille3,taille4,tligne1,tligne2,tligne3,tligne4,ellipse_fill,ellipse_draw,cercle_d,cercle_f,premier_p,arriere_p,color_r;
public Container contenu=getContentPane();
public JSplitPane pane,pane1;
public JComponent p1;
public Dessin panel_1,p2;
public JComponent c1;
public JTextArea info = new JTextArea ();
public File name;
public String nom_image,path,frfr;
public Image im;
public  Color c=Color.black;

public Paint(){
// A propos de la fenêtre principale
    setSize(600,400);
    setTitle("OBF Picture");
    setContentPane(new Dessin());
    
// Barre de menu    
Fichier = new JMenu("Fichier");
Edition = new JMenu("Edition");
dessiner = new JMenu("Dessiner");
aide = new JMenu("Aide");
Ouvrir = new JMenuItem("Ouvrir une image");
New = new JMenuItem("Nouveau dessin");
deplacer=new JMenuItem("Déplacer un objet");
Quitter=new JMenuItem("Quitter");
coleur = new JMenuItem("Couleur");
annuler = new JMenuItem("Annuler");
repeter = new JMenuItem("Répéter");
vider = new JMenuItem("Effacer tous");
main=new JMenuItem("dessin libre");
ligne=new JMenuItem("Ligne");
gomme=new JMenuItem("Gomme");
triangle=new JMenuItem("Triangle");
polygone=new JMenuItem("Polygone");
remplir=new JMenuItem("Remplir");
rectangle= new JMenuItem("Rectangle");
cercle= new JMenuItem("Cercle");
ellipse= new JMenuItem("Ellipse");
doc= new JMenuItem("Documentation");
apropos= new JMenuItem("A propos");


Fichier.add(New);
Fichier.add(Ouvrir);
Fichier.add(Quitter);

Edition.add(annuler);
Edition.add(repeter);
Edition.add(new JSeparator());
Edition.add(coleur);
Edition.add(vider);
Edition.add(deplacer);      
aide.add(doc);
aide.add(apropos);

dessiner.add(main);
dessiner.add(ligne);
dessiner.add(rectangle);
dessiner.add(cercle);
dessiner.add(ellipse);
dessiner.add(polygone);
dessiner.add(triangle);
dessiner.add(new JSeparator());
dessiner.add(deplacer);
dessiner.add(gomme);
dessiner.add(remplir);

annuler.setEnabled(false);
repeter.setEnabled(false);

menuBar.add(Fichier);
menuBar.add(Edition);
menuBar.add(dessiner);
menuBar.add(aide);

setJMenuBar(menuBar);

// Barre d'outil
    standart = new JToolBar("Barre d'outil");
    barre1 = new JToolBar("Barre1",1);
    
    Main = new JButton(new ImageIcon("Image\\Dessiner.gif"));
    Main.setToolTipText("main libre");
    Main.addActionListener(this);

    vide1 = new JButton(new ImageIcon("Image\\vide.gif"));
    vide2 = new JButton(new ImageIcon("Image\\vide.gif"));
    vide1.setEnabled(false);
    vide2.setEnabled(false);

    rect_fill = new JButton(new ImageIcon("Image\\rect1.gif"));
    rect_fill.setToolTipText("dessiner un rectangle plein");
    rect_fill.addActionListener(this);
    rect_draw = new JButton(new ImageIcon("Image\\rect_draw.gif"));
    rect_draw.setToolTipText("dessiner un Rectangle vide");
    rect_draw.addActionListener(this);

    rd_rect_fill = new JButton(new ImageIcon("Image\\roundrec_fill.gif"));
    rd_rect_fill .setToolTipText("dessiner un roundrectangle plein");
    rd_rect_fill .addActionListener(this);
    rd_rect_draw = new JButton(new ImageIcon("Image\\roundrec_draw.gif"));
    rd_rect_draw .setToolTipText("dessiner un roundrectangle vide");
    rd_rect_draw .addActionListener(this);

    Ligne = new JButton(new ImageIcon("Image\\ligne1.gif"));
    Ligne.setToolTipText("Une ligne");
    Ligne.addActionListener(this);
	
    Rectang = new JButton(new ImageIcon("Image\\rect1.gif"));
    Rectang.setToolTipText("Un Rectangle");
    Rectang.addActionListener(this);
    
    Cercle = new JButton(new ImageIcon("Image\\cercle_fill.gif"));
    Cercle.setToolTipText("Un Cercle");
    Cercle.addActionListener(this);

    Ellipse = new JButton(new ImageIcon("Image\\ellipse_fill.gif"));
    Ellipse.setToolTipText("Un Ellipse");
    Ellipse.addActionListener(this);

    Polygone = new JButton(new ImageIcon("Image\\polygone_fill.gif"));
    Polygone.setToolTipText("Un Polygone");
    Polygone.addActionListener(this);

    color_r = new JButton(new ImageIcon("Image\\vide.gif"));
    color_r.setBackground(c);
    color_r.setSize(17, 17);
    color_r.setToolTipText("Un Polygone");
    color_r.addActionListener(this);

    Remplir = new JButton(new ImageIcon("Image\\remplir.gif"));
    Remplir.setToolTipText("Remplir le fond");
    Remplir.addActionListener(this);

    Gomme = new JButton(new ImageIcon("Image\\gomme.gif"));
    Gomme.setToolTipText("Gomme");
    Gomme.addActionListener(this);

    Triangle = new JButton(new ImageIcon("Image\\triangle1_draw.gif"));
    Triangle.setToolTipText("Triangle");
    Triangle.addActionListener(this);

    Triangle_draw = new JButton(new ImageIcon("Image\\triangle1_draw.gif"));
    Triangle_draw.setToolTipText("Triangle");
    Triangle_draw.addActionListener(this);

    Triangle_fill = new JButton(new ImageIcon("Image\\triangle1_fill.gif"));
    Triangle_fill.setToolTipText("Triangle");
    Triangle_fill.addActionListener(this);
    
    Deplacer = new JButton(new ImageIcon("Image\\dp.gif"));
    Deplacer.setToolTipText("Deplacer");
    Deplacer.addActionListener(this);
    
    img = new JButton(new ImageIcon("Image\\img.gif"));
    img.setToolTipText("Selectionner une image");
    img.addActionListener(this);
   
    taille1 = new JButton(new ImageIcon("Image\\taille1.gif"));
    taille1.setToolTipText("changer la taille1");
    taille1.addActionListener(this);
    taille2 = new JButton(new ImageIcon("Image\\taille2.gif"));
    taille2.setToolTipText("changer la taille2");
    taille2.addActionListener(this);
    taille3 = new JButton(new ImageIcon("Image\\taille3.gif"));
    taille3.setToolTipText("changer la taille3");
    taille3.addActionListener(this);
    taille4 = new JButton(new ImageIcon("Image\\taille4.gif"));
    taille4.setToolTipText("changer la taille4");
    taille4.addActionListener(this);



    tligne1 = new JButton(new ImageIcon("Image\\taille1.gif"));
    tligne1.setToolTipText("changer la taille1");
    tligne1.addActionListener(this);
    tligne2 = new JButton(new ImageIcon("Image\\taille2.gif"));
    tligne2.setToolTipText("changer la taille2");
    tligne2.addActionListener(this);
    tligne3 = new JButton(new ImageIcon("Image\\taille3.gif"));
    tligne3.setToolTipText("changer la taille3");
    tligne3.addActionListener(this);
    tligne4 = new JButton(new ImageIcon("Image\\taille4.gif"));
    tligne4.setToolTipText("changer la taille4");
    tligne4.addActionListener(this);

    ellipse_fill = new JButton(new ImageIcon("Image\\ellipse_fill.gif"));
    ellipse_fill.setToolTipText("Ellipse  plein");
    ellipse_fill.addActionListener(this);
    ellipse_draw= new JButton(new ImageIcon("Image\\ellipse_draw.gif"));
    ellipse_draw.setToolTipText("Ellipse vide");
    ellipse_draw.addActionListener(this);

    cercle_d = new JButton(new ImageIcon("Image\\cercle_draw.gif"));
    cercle_d.setToolTipText("Cercle vide");
    cercle_d.addActionListener(this);
    cercle_f = new JButton(new ImageIcon("Image\\cercle_fill.gif"));
    cercle_f.setToolTipText("Cercle  plein");
    cercle_f.addActionListener(this);

    Quitter.setToolTipText("Quitter l'application");
    Quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,KeyEvent.ALT_MASK));
    Quitter.addActionListener(this);

    New.setToolTipText("Quitter l'application");
    New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK));
    New.addActionListener(this);

    Ouvrir.setToolTipText("Quitter l'application");
    Ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK));
    Ouvrir.addActionListener(this);
    
    coleur.setToolTipText("Choisir coleur");
    coleur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_MASK));
    coleur.addActionListener(this);

    annuler.setToolTipText("Annuler la dernière action");
    annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,KeyEvent.CTRL_MASK));
    annuler.addActionListener(this);

    repeter.setToolTipText("Répéter la dernière action");
    repeter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,KeyEvent.CTRL_MASK));
    repeter.addActionListener(this);

    vider.setToolTipText("Vider l'espace de travail");
    vider.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_MASK));
    vider.addActionListener(this);

    deplacer.setToolTipText("Déplacer un objet");
    deplacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_MASK));
    deplacer.addActionListener(this);
    
    ligne.setToolTipText("Dessiner une ligne");
    ligne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_MASK));
    ligne.addActionListener(this);

    main.setToolTipText("Dessin libre");
    main.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_MASK));
    main.addActionListener(this);

    triangle.setToolTipText("Dessiner un triangle");
    triangle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_MASK));
    triangle.addActionListener(this);

    gomme.setToolTipText("utiliser la Gomme");
    gomme.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,KeyEvent.CTRL_MASK));
    gomme.addActionListener(this);

    remplir.setToolTipText("remplir le dessin");
    remplir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
    remplir.addActionListener(this);

    rectangle.setToolTipText("Dessiner un rectangle");
    rectangle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
    rectangle.addActionListener(this);

    polygone.setToolTipText("Dessiner un rectangle");
    polygone.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_MASK));
    polygone.addActionListener(this);

    cercle.setToolTipText("Desssiner un cercle");
    cercle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK));
    cercle.addActionListener(this);

    ellipse.setToolTipText("Desssiner un ellipse");
    ellipse.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));
    ellipse.addActionListener(this);
    
    apropos.setToolTipText("A propos de l'application");
    apropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,KeyEvent.CTRL_MASK));
    apropos.addActionListener(this);
    
    doc.setToolTipText("La documentation de l'application");
    doc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,KeyEvent.CTRL_MASK));
    doc.addActionListener(this);

    premier_p = new JButton(new ImageIcon("Image\\img.gif"));
    premier_p.setToolTipText("Mettre l'objet en premiere plan");
    premier_p.addActionListener(this);

    arriere_p = new JButton(new ImageIcon("Image\\img.gif"));
    arriere_p.setToolTipText("Mettre l'objet en arriére plan");
    arriere_p.addActionListener(this);

    barre1.add(vide1);
    barre1.add(vide2);
    standart.add(Main);
    standart.add(Ligne);
    standart.add(Rectang);
    standart.add(Cercle);
    standart.add(Ellipse);
    standart.add(Polygone);
    standart.add(Triangle);
    standart.add(Gomme);
    standart.add(Remplir);
    standart.add(Deplacer);
    standart.add(img);
    standart.add(color_r);
    standart.setToolTipText("Barre d'outil");
    contenu.add(standart,"North");  //la position de la barre d'outil
    contenu.add(barre1,"West");
    contenu.setBackground(Color.white);
    //pour diviser l'interface en deux
    panel_1=new Dessin();
   
    contenu.add(panel_1);
    c1 = (JComponent) contenu;
    p2=new Dessin();
    pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, c1, p2);
    pane.setResizeWeight(0.82);
    pane.setOneTouchExpandable(true);
    pane.setEnabled(true);
    pane.setAutoscrolls(true);
    setContentPane(pane);
  
    info.setAutoscrolls(true);
    info.setSize(75, 100);
    info.setBackground(Color.white);
    info.setText("Information sur les objets dissinés \n");
    info.setEnabled(false);

    p2.add(info);
   
    //pour la fermeture de l'application
      addWindowListener(new WindowAdapter() {
            @Override
      public void windowClosing(WindowEvent e) {
    	  dispose();
        System.exit(0);
      }
    });
}

public void actualiser(){
    info.setText("");
    frfr=new Information(panel_1.getfigure()).getg();
    info.append(frfr);
    p2.validate();
    p2.repaint();
    
}

    @SuppressWarnings("static-access")
  public void actionPerformed(ActionEvent evt)  {
    Object source = evt.getSource();
    actualiser();
    
if (source == Rectang || source == rectangle)
       {
             panel_1.setlwn(c);
            annuler.setEnabled(true);
            barre1.removeAll();
            coleur.setEnabled(true);
            barre1.add(rect_fill);
            barre1.add(rect_draw);
            barre1.add(rd_rect_fill);
            barre1.add(rd_rect_draw);
          barre1.add(premier_p);
          barre1.add(arriere_p);
            panel_1.flag="rect_fill";
            barre1.repaint();
        }
if (source==rect_fill)
        {
         panel_1.setlwn(c);
        setCursor(JFrame.CROSSHAIR_CURSOR);
            panel_1.flag="rect_fill";
        }

if (source==rect_draw)
        {
        panel_1.setlwn(c);
        setCursor(JFrame.CROSSHAIR_CURSOR);
            panel_1.flag="rect_draw";
        }
if (source==rd_rect_fill)
        {
        panel_1.setlwn(c);
        setCursor(JFrame.CROSSHAIR_CURSOR);
            panel_1.flag="rd_rect_fill";
        }
if (source==rd_rect_draw)
        {
          panel_1.setlwn(c);
        setCursor(JFrame.CROSSHAIR_CURSOR);
            panel_1.flag="rd_rect_draw";
        }
if (source==apropos)
      panel_1.msgpropos();
if(source==doc)
{
if ( Desktop.isDesktopSupported() ) {
	// On récupère l'instance du desktop :
	Desktop desktop = Desktop.getDesktop();
	
	// On vérifie que la fonction open est bien supportée :
	if (desktop.isSupported(Desktop.Action.OPEN)) {
                    try {

                        // Et on lance l'application associé au fichier pour l'ouvrir :
                        desktop.open(new File("dist\\javadoc\\index.html"));
                    } catch (IOException ex) {
                        
                    }
	}
}

}
if ((source == Triangle)||(source == triangle))
        {
            panel_1.setlwn(c);
             annuler.setEnabled(true);
            barre1.removeAll();
             barre1.add(Triangle_fill);
            barre1.add(Triangle_draw);
            barre1.add(premier_p);
             barre1.add(arriere_p);
            coleur.setEnabled(true);
            panel_1.flag="triangle_fill";
        }
    if ((source ==Triangle_fill))
        {
        panel_1.setlwn(c);
    panel_1.flag="triangle_fill";
        }
     if ((source ==Triangle_draw))
        {
         panel_1.setlwn(c);
    panel_1.flag="triangle_draw";
        }

if ((source ==Gomme)||(source == gomme))
        {
            annuler.setEnabled(true);
            panel_1.flag="taille1";
            barre1.removeAll();
            barre1.add(taille1);
            barre1.add(taille2);
            barre1.add(taille3);
            barre1.add(taille4);
            coleur.setEnabled(false);
            panel_1.setlwn(Color.white);
            barre1.repaint();
        }
if ((source == Main)||(source == main))
        {
              panel_1.setlwn(c);
            annuler.setEnabled(true);
            panel_1.flag="taille1";
            barre1.removeAll();
            barre1.add(taille1);
            barre1.add(taille2);
            barre1.add(taille3);
            barre1.add(taille4);
            coleur.setEnabled(true);
            barre1.repaint();
        }
if (source==taille1)
        {

            panel_1.flag="taille1";
        }
if (source==taille2)
        {

            panel_1.flag="taille2";
        }
if (source==taille3)
        {

            panel_1.flag="taille3";
        }
if (source==taille4)
        {

            panel_1.flag="taille4";
        }
if (source == Deplacer || source == deplacer) 
        {
    setCursor(JFrame.MOVE_CURSOR);
            annuler.setEnabled(true);
            barre1.removeAll();
            barre1.add(vide1);
            barre1.add(vide2);
            barre1.repaint();
            coleur.setEnabled(true);
            panel_1.flag="deplacer";
        }
if (source == coleur || source==color_r)
        {
            c = JColorChooser.showDialog(p2, "Sélection...", getBackground());
            panel_1.setlwn(c);
            color_r.setBackground(c);
        }
if (source == Ligne  || source == ligne) 
        {
        panel_1.setlwn(c);
        setCursor(JFrame.CROSSHAIR_CURSOR);
            annuler.setEnabled(true);
            panel_1.flag="tligne1";
            barre1.removeAll();
            barre1.add(tligne1);
            barre1.add(tligne2);
            barre1.add(tligne3);
            barre1.add(tligne4);
            coleur.setEnabled(true);
            barre1.repaint();
        }
if (source==tligne3)
        {

            panel_1.flag="tligne3";
        }
if (source==tligne1)
        {

            panel_1.flag="tligne1";
        }
if (source==tligne2)
        {

            panel_1.flag="tligne2";
        }
if (source==tligne4)
        {

            panel_1.flag="tligne4";
        }
if ((source == Polygone)||(source == Polygone))
        {
            panel_1.setlwn(c);
            annuler.setEnabled(true);
            barre1.removeAll();
            barre1.add(premier_p);
            barre1.add(arriere_p);
            coleur.setEnabled(true);
            panel_1.flag="polygone";
        }
if ((source ==Remplir)||(source ==remplir))
        {
            panel_1.setlwn(c);
            setCursor(JFrame.HAND_CURSOR);
            annuler.setEnabled(true);
            coleur.setEnabled(true);
            panel_1.flag="remplir";
            barre1.removeAll();
            barre1.add(vide1);
            barre1.add(vide2);
            barre1.repaint();
        }
if (source == Ellipse  || source == ellipse)
        {
            panel_1.setlwn(c);
            setCursor(JFrame.CROSSHAIR_CURSOR);
            annuler.setEnabled(true);
            panel_1.flag="ellipse_fill";
            barre1.removeAll();
            barre1.add(ellipse_fill);
            barre1.add(ellipse_draw);            
            barre1.add(premier_p);
            barre1.add(arriere_p);

            coleur.setEnabled(true);
            barre1.repaint();
        }
if (source== ellipse_fill)
        {
            panel_1.setlwn(c);
            panel_1.flag="ellipse_fill";
        }
if (source== ellipse_draw)
        {
            panel_1.setlwn(c);
            panel_1.flag="ellipse_draw";
        }

if (source == Cercle  || source == cercle)
        {
            panel_1.setlwn(c);
        setCursor(JFrame.CROSSHAIR_CURSOR);
            panel_1.flag="cercle_fill";
            annuler.setEnabled(true);
            barre1.removeAll();
            barre1.add(cercle_f);
            barre1.add(cercle_d);
            barre1.add(premier_p);
            barre1.add(arriere_p);
            coleur.setEnabled(true);
            barre1.repaint();
        }

if (source== cercle_d)
        {
            panel_1.setlwn(c);
            panel_1.flag="cercle_draw";
        }

if (source== cercle_f)
        {
            panel_1.setlwn(c);
            panel_1.flag="cercle_fill";
        }
if (source == Quitter  )
        {
            int confirmation = JOptionPane.showConfirmDialog(contenu,
                    "Etes-vous sur de vouloir quitter paint dyal bessa7 ?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if(confirmation == JOptionPane.YES_OPTION)
            {
                dispose();
                System.exit(0);
            }
        }
if(source==annuler)
        {
            repeter.setEnabled(true);
            panel_1.figures1.add(panel_1.figures.getLast());
            panel_1.figures.removeLast();
            repaint();
            validate();
        }
if(source==repeter)
        {
            if(panel_1.figures1.isEmpty())
                {
                    annuler.setEnabled(false);
                }
                    panel_1.figures.add(panel_1.figures1.getLast());
                    panel_1.figures1.removeLast();
                    repaint();
                    validate();
         }
if (source == New || source==vider)
        {
            panel_1.setlwn(c);
            annuler.setEnabled(false);
            repeter.setEnabled(false);
            barre1.removeAll();
            barre1.add(vide1);
            barre1.add(vide2);
            barre1.repaint();
            coleur.setEnabled(true);
            info.setText("");
            panel_1.vider_dessin();
        }
if (source == premier_p)
        {
             setCursor(JFrame.DEFAULT_CURSOR);
             panel_1.flag="Premier_plan";
        }
if (source == arriere_p)
        {
            setCursor(JFrame.DEFAULT_CURSOR);
             panel_1.flag="Arriere_plan";
        }
if (source == img || source ==Ouvrir)
        {
            panel_1.setlwn(c);
            setCursor(JFrame.DEFAULT_CURSOR);
            coleur.setEnabled(true);
            JFileChooser chooser = new JFileChooser();
            chooser.setAccessory(new FilePreviewer(chooser));
            chooser.setCurrentDirectory(new File("."));
            FileFilter bmp = new filtre("Images BMP",".bmp");
            FileFilter gif =  new filtre("Image GIF",".gif");
            FileFilter png =  new filtre("Image PNG",".png");
            FileFilter jpeg =  new filtre("Images JPEG",".jpg");
            chooser.addChoosableFileFilter( bmp);
            chooser.addChoosableFileFilter(gif);
            chooser.addChoosableFileFilter( png);
            chooser.addChoosableFileFilter( jpeg);
            chooser.setDialogTitle("Ouvrir une image");
            chooser.setMultiSelectionEnabled(false);
            int r = chooser.showOpenDialog(this);
            if (r == JFileChooser.APPROVE_OPTION)
                {
                    name = chooser.getSelectedFile();
                    nom_image=chooser.getSelectedFile().getName();
                    path=name.getPath();
                    panel_1.loadImage(name,nom_image);
                    repaint();
                    setTitle("Dessiner - "+nom_image);
                }
}}

}


