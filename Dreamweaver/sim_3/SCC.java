import java.lang.*;
import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

/*
<applet code="SCC" width=550 height=500>

<param name="img" value="Current.gif">
</applet>
*/

public class SCC extends Applet implements AdjustmentListener
{

     Scrollbar svf;
     Label scrollLabel;
     Panel scrollPanel;
     int d,x,y;
     Image img;
     
   public void init()
   {

      setLayout(new BorderLayout(5,5));

      setFont(new Font("arial",Font.BOLD,10));

      scrollPanel = new Panel();

      scrollLabel=new Label("Field Voltage (0 - 230 V)"); 
      scrollPanel.add(scrollLabel);

      svf=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,230);

      scrollPanel.add(svf);
  
      add("North",scrollPanel);

      svf.addAdjustmentListener(this);

      img=getImage(getDocumentBase(),getParameter("img"));      

  }

  public void adjustmentValueChanged(AdjustmentEvent ae)
  {
    repaint();
  }
      
   public void paint(Graphics g)
   {
        g.drawImage(img,50,50,this);
 	
        d=svf.getValue();

        g.drawRect(106,85,38,22);

        g.drawRect(77,270,46,22);

        String vif=new String();

        vif=""+(float)(.01*d);

        String visc=new String();

        visc=""+(float)(.1522*d);

        g.drawString(vif,108,100);

        g.drawString(visc,79,285);

        g.drawLine(350,100,350,250);
        g.drawLine(350,250,500,250);

        g.drawString("If ",490,263);
        g.drawString("Isc ",333,110);

        g.drawRect(325,70,200,200);

        x=d/10;
        y=d*35/75;

        g.drawLine(350,250,350+2*x,250-y);

        g.drawString("Graph between If and Isc", 360,65);
        g.drawString("If = ",88,100);
        g.drawString("Isc ",95,304);

   }

 }