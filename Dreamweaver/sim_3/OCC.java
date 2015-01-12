import java.lang.*;
import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

/*
<applet code="OCC" width=450 height=425>

</applet>
*/

public class OCC extends Applet implements AdjustmentListener
{
     int x1,y1,x2,y2,cx1,cy1,cx2,cy2,d;
     Scrollbar sb;
     Label scrollLabel,label;
     Panel scrollPanel,panel1; 

  public void init()
  {
       setLayout(new BorderLayout(5,5));

       panel1 = new Panel();
       setFont(new Font("dialogue",Font.PLAIN,10));
       label = new Label("B-H Curve");
       panel1.add(label);
       add("North", panel1); 

       scrollPanel = new Panel();

       sb=new Scrollbar(Scrollbar.HORIZONTAL,200,1,0,200);
       scrollPanel.add(sb);
  
       scrollLabel=new Label("Resistance Control"); 
       scrollPanel.add(scrollLabel);

       add("South", scrollPanel);

       sb.addAdjustmentListener(this);

  }

  public void adjustmentValueChanged(AdjustmentEvent ae)
  {
    repaint();
  }


  public void paint(Graphics g)
  {

 
      g.drawRect(25,35,350,350);

      g.drawLine(200,35,200,385);         // x-axis line
      g.drawLine(25,210,375,210);          //y-axis line

      g.setColor(Color.BLUE);
      g.drawLine(60,35,60,385);
      g.drawLine(95,35,95,385);
      g.drawLine(130,35,130,385);
      g.drawLine(165,35,165,385);
      g.drawLine(235,35,235,385);
      g.drawLine(270,35,270,385);
      g.drawLine(305,35,305,385);
      g.drawLine(340,35,340,385);

      g.drawLine(25,70,375,70);
      g.drawLine(25,105,375,105);
      g.drawLine(25,140,375,140);
      g.drawLine(25,175,375,175);
      g.drawLine(25,245,375,245);
      g.drawLine(25,280,375,280);
      g.drawLine(25,315,375,315);
      g.drawLine(25,350,375,350);

      g.setColor(Color.RED);

      Graphics2D g2=(Graphics2D) g;

      QuadCurve2D.Double c;
   
     x1=300;
     y1=110;
     x2=100;
     y2=310;
     cx1=250;
     cy1=160;
     cx2=150;
     cy2=260;
   

     d=sb.getValue();

     if(d==199)
     {
       g.drawLine(210,200,190,220);
            
     }

     else
    {
      c=new QuadCurve2D.Double(300,110,(d+1050)/5,(d+600)/5,200,210);
 
      CubicCurve2D cu=new CubicCurve2D.Float(x1,y1,(d+300)/2,(d+120)/2,(950-d)/5,(1500-d)/5,x2,y2);
     
      CubicCurve2D cl=new CubicCurve2D.Float(x1,y1,(d+1050)/5,(d+600)/5,(500-d)/2,(720-d)/2,x2,y2);
          
      g2.draw(cu);
      g2.draw(cl);     
      g2.draw(c);

    }
      
  }


}