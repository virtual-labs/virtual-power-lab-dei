/*   RELAY SIMULATION......
**   author : Tanmay Srivastava
**   date started : 23-feb-2011
**   date last saved : 2-march-2011
**   ......
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import java.util.*;

/*
<applet code="Mod4.class" height=600 width=1000>
</applet>
*/

public class Mod4 extends JApplet implements ActionListener
{
 float val,x,y; 
 long start,time;
 float t,den;
 double cur;

 private int imgCount = 0;

 private JButton incButton = new JButton("Increase Current");
 private JButton decButton=new JButton("Decrease Current");
 private JButton resetButton=new JButton("RESET");

 private JRadioButton r1 = new JRadioButton("2.5");
 private JRadioButton r2 = new JRadioButton("3.75");
 private JRadioButton r3 = new JRadioButton("5");
 private JRadioButton r4 = new JRadioButton("6.25");
 private JRadioButton r5 = new JRadioButton("7.5");
 private JRadioButton r6 = new JRadioButton("8.75");
 private JRadioButton r7 = new JRadioButton("10");   

 private JPanel rPanel = new JPanel();
 private JPanel mainPanel = new JPanel();

 private JTextField txtCur=new JTextField("0.0");
 private JTextField txtTime=new JTextField();

 private JLabel result = new JLabel(new ImageIcon("a.gif"));
 private JLabel resultText = new JLabel();
 private JLabel bulb = new JLabel();
 private JLabel lblTime=new JLabel("Timer");
 private JLabel lblSel=new JLabel("Select the relay");
 private JLabel lblMsg=new JLabel();
 private JLabel lblCur=new JLabel("Fault Current (0-20 A)");
 private JLabel lblBulb=new JLabel("Indicator");
 private JLabel lblDec=new JLabel();

 private ImageIcon[] imgA = { new ImageIcon("a.gif"),
   new ImageIcon("b.gif"),
   new ImageIcon("c.gif"),
   new ImageIcon("d.gif") ,
   new ImageIcon("e.gif"),
   new ImageIcon("f.gif")};

 private ImageIcon[] imgB={new ImageIcon("b1.gif"),
   new ImageIcon("b2.gif")};

 Timer ta = new Timer(200, new ActionListener()
     {
        public void actionPerformed(ActionEvent arg0)
       {
          if (imgCount == 6)
              imgCount = 0;
          result.setIcon(imgA[imgCount++]);
        }
     });

 public void runA()
 {
   resultText.setText("Relay Activated");
   result.setIcon(imgA[5]);
   start=System.currentTimeMillis();
   ta.start();
 }

 public void stopA() 
 {
   resultText.setText("Relay in ideal state");
   result.setIcon(imgA[0]);
   ta.stop();
 }
 
 Timer tb=new Timer(100,new ActionListener()
     {
       public void actionPerformed(ActionEvent evt)
       {
            time = (System.currentTimeMillis() - start);
            txtTime.setText("" + time + " mili sec");
            if(time>(t)*1000)
            {
                tb.stop();
                ta.stop();
  
                lblMsg.setText("RELAY TRIPPED");
                resultText.setText("Relay stopped");
                bulb.setIcon(imgB[1]);
            }
       }
     });

 public void init() 
 {
   setSize(1000, 600);
   setLayout(null);
   //setBackground(Color.white);

  mainPanel.setBounds(0, 0, 1000, 600);
  mainPanel.setLayout(null);
  mainPanel.setBackground(Color.white);
  
  rPanel.setLayout(null);
  rPanel.setBounds(0, 0, 1000, 40);
  rPanel.setBackground(Color.white); 

  lblSel.setBounds(10,10,100,20);

  r1.setBounds(120, 10, 45, 30);
  r2.setBounds(170,10, 50, 30);
  r3.setBounds(225, 10,35, 30);
  r4.setBounds(265, 10, 50, 30);
  r5.setBounds(320, 10, 45, 30);
  r6 .setBounds(370, 10, 55, 30);
  r7.setBounds(430, 10, 45, 30);

  rPanel.add(r1);
  rPanel.add(r2);
  rPanel.add(r3);
  rPanel.add(r4);
  rPanel.add(r5);
  rPanel.add(r6);
  rPanel.add(r7); 
  rPanel.add(lblSel);

  ButtonGroup bg=new ButtonGroup();
  bg.add(r1);
  bg.add(r2);
  bg.add(r3);
  bg.add(r4);
  bg.add(r5);
  bg.add(r6);
  bg.add(r7); 

  lblCur.setBounds(60,100,120,30);
  txtCur.setBounds(50,135,150,30);
  incButton.setBounds(20,170,200,30);
  decButton.setBounds(20,205,200,30);
  lblDec.setBounds(20,245,150,30);

  lblTime.setBounds(380,100,50,30);
  txtTime.setBounds(350,135,100,30);
  result.setBounds(330, 200, 150, 150);
  resultText.setBounds(350, 360, 150, 30);

  bulb.setBounds(640,200,100,100);
  lblBulb.setBounds(650,300,70,30);

  lblMsg.setBounds(800,230,200,50);

  resetButton.setBounds(800,400,100,40);

  mainPanel.add(rPanel);
  mainPanel.add(txtCur);
  mainPanel.add(lblCur);
  mainPanel.add(incButton);
  mainPanel.add(decButton);
  mainPanel.add(lblDec);
  mainPanel.add(result);
  mainPanel.add(resultText);
  mainPanel.add(lblTime);
  mainPanel.add(txtTime); 
  mainPanel.add(bulb);
  mainPanel.add(lblBulb);
  mainPanel.add(lblMsg);
  mainPanel.add(resetButton);

  r1.addActionListener(new R1Listener());
  r2.addActionListener(new R2Listener());
  r3.addActionListener(new R3Listener());
  r4.addActionListener(new R4Listener());
  r5.addActionListener(new R5Listener());
  r6.addActionListener(new R6Listener());
  r7.addActionListener(new R7Listener());
  incButton.addActionListener(new IncListener());
  decButton.addActionListener(new DecListener());
  resetButton.addActionListener(new ResetListener());
  
  add(mainPanel);
  
  bulb.setIcon(imgB[0]);

}

public class R1Listener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       val=(float)2.5;

       y=Float.parseFloat(txtCur.getText());
       if(y>val)
       {
           runA();
       }
       else
       {
           stopA();
       } 
  }
}
public class R2Listener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       val=(float)3.75;

       y=Float.parseFloat(txtCur.getText());
       if(y>val)
       {
           runA();
       }
       else
       {
            stopA();
       } 
  }
}
public class R3Listener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       val=(float)5;

       y=Float.parseFloat(txtCur.getText());
       if(y>val)
       {
           runA();
       }
       else
       {
            stopA();
       } 
  }
}
public class R4Listener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       val=(float)6.25;

       y=Float.parseFloat(txtCur.getText());
       if(y>val)
       {
           runA();
       }
       else
       {
            stopA();
       } 
  }
}
public class R5Listener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       val=(float)7.5;

       y=Float.parseFloat(txtCur.getText()); 
       if(y>val)
       {
           runA();
       }
       else
       {
            stopA();
       } 
  }
}
public class R6Listener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       val=(float)8.75;

       y=Float.parseFloat(txtCur.getText());
       if(y>val)
       {
           runA();
       }
       else
       {
            stopA();
       }
   }
}
public class R7Listener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       val=(float)10;

       y=Float.parseFloat(txtCur.getText());
       if(y>val)
       {
           runA();
       }
       else
       {
            stopA();
       }
   }
}
public class IncListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       x=Float.parseFloat(txtCur.getText());
       y=(float)x+(float)(.2);
       txtCur.setText(""+y);
       lblDec.setText("");
       bulb.setIcon(imgB[0]);
       if(y>20)
       {
           txtCur.setText(""+20);
           stopA();
           tb.stop();
           txtTime.setText("");
           bulb.setIcon(imgB[0]);
           lblDec.setText("");
       }
       else if(y>val)
       {
           cur=Double.parseDouble(txtCur.getText());
           den=(float)cur/(float)val;

//           t=((float)40.95*((float)Math.pow(den,(-2.063)))+(float)2.441);

           t=(float).003245*(float)Math.pow(den,6)+(float)(-.1228)*(float)Math.pow(den,5)+(float)(1.86)*(float)Math.pow(den,4)+(float)(-14.49)*(float)Math.pow(den,3)+(float)(61.29)*(float)Math.pow(den,2)+(float)(-134.4)*(float)Math.pow(den,1)+(float)(125.5);
           if(t<(float)0.04)
		   {
		     t=0.04F;
		   }
           lblDec.setText("   t= "+t);
           runA();
           lblMsg.setText("") ;
           tb.start();
        }
        else
        {
           lblMsg.setText("") ;
           stopA();
           bulb.setIcon(imgB[0]);
        }       
    }
}

public class DecListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
       x=Float.parseFloat(txtCur.getText());
       y=x-(float)(.2);
       bulb.setIcon(imgB[0]);
       if(y<0)
           lblDec.setText("Cant decrease further");
       else
       {
           txtCur.setText(""+y);
           lblDec.setText("");
           if(y>20)
           {
               txtCur.setText(""+20);
               stopA();
               tb.stop();
               txtTime.setText("");
               lblDec.setText("");
               bulb.setIcon(imgB[0]);
           }
           else if(y>val)
           {
               cur=Double.parseDouble(txtCur.getText());
               den=(float)cur/(float)val;

//               t=((float)40.95*((float)Math.pow(den,(-2.063)))+(float)2.441);

               t=.003245F*(float)Math.pow(den,6)+(-.1228F)*(float)Math.pow(den,5)+(1.86F)*(float)Math.pow(den,4)+(-14.49F)*(float)Math.pow(den,3)+(61.29F)*(float)Math.pow(den,2)+(-134.4F)*(float)Math.pow(den,1)+(125.5F);
               if(t<0.04F)
		       {
		         t=0.04F;
		       }
               lblDec.setText("   t= "+t);
               runA();
               lblMsg.setText("") ;
               tb.start();
           }
           else
           {
               lblMsg.setText("");
               stopA();
               tb.stop();
               txtTime.setText("");
               bulb.setIcon(imgB[0]);
           }           
       }
   }
}

public class ResetListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
        txtCur.setText("0.0");
        txtTime.setText("0.0");
        r1.setSelected(false);
        r2.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        r5.setSelected(false);
        r6.setSelected(false);
        r7.setSelected(false);
        stopA();
        lblMsg.setText("");  
        lblDec.setText("");
        bulb.setIcon(imgB[0]);
        tb.stop();
   }
}
public void actionPerformed(ActionEvent e)
{
}

}
 