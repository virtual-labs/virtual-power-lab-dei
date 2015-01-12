import java.lang.*;
import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

/*
<applet code="X0.class" width=540 height=515>
<param name=img0 value="x0_2.GIF">

</applet>
*/

public class X0 extends Applet implements AdjustmentListener
{
     Scrollbar sx0;
     Image img0;
     int d;
     Panel pnl0;
     Label l0;
     float x00,i0,x0,val;

     int v0;

     public void init()
    {
         setLayout(new BorderLayout(1,1));
         setFont(new Font("arial",Font.BOLD,12));

         sx0=new Scrollbar(Scrollbar.HORIZONTAL,0,1,1,12);
         pnl0=new Panel();
         l0=new Label("Vo");
         pnl0.add(l0);
         pnl0.add(sx0);
         add("South",pnl0);

        sx0.addAdjustmentListener(this);

        img0=getImage(getDocumentBase(),getParameter("img0"));      

    }

     public void adjustmentValueChanged(AdjustmentEvent e)
     {
           repaint();
     }      
    
     public void paint(Graphics g)
     {

         g.drawImage(img0,20,60,this);

         v0=(sx0.getValue())/2;

        Random rnd=new Random();
        val=(float)rnd.nextFloat();
        x00=((float)val/10)+(float)1.8;

        i0=3*(v0/x00);
        x0=3*(v0/i0);        

//     g.drawString(""+x00,300,400);
     
       g.drawString(""+i0,300,437);

       g.drawString(""+x0,337,108);

     }

}