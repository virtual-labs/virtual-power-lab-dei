import java.lang.*;
import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

/*
<applet code="X2.class" width=500 height=515>
<param name=img2 value="x2_2.GIF">
</applet>
*/

public class X2 extends Applet implements AdjustmentListener
{
     Scrollbar sx0,sx2;
     Image img2;
     int d;
     Panel pnl2;
     Label l2;
     float vos,ios,x2;
     int v0,vf;

     public void init()
    {
         setLayout(new BorderLayout(1,1));
         setFont(new Font("arial",Font.BOLD,12));

         sx2=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,10);
         pnl2=new Panel();
         l2=new Label("Vf");
         pnl2.add(l2);
         pnl2.add(sx2);
         add("North",pnl2);

        sx2.addAdjustmentListener(this);

        img2=getImage(getDocumentBase(),getParameter("img2"));      

    }

     public void adjustmentValueChanged(AdjustmentEvent e)
     {
           repaint();
     }      
    
     public void paint(Graphics g)
     {

         g.drawImage(img2,45,5,this);

         vf=sx2.getValue();

         ios=(float).95*vf;
         vos=(float)4.95*vf;
         x2=vos/(3*ios);
 
        g.drawString(""+ios,125,395);
        g.drawString(""+vos,230,432);
        g.drawString(""+x2,380,79);

    }

}