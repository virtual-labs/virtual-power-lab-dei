

import java.awt.*;
import java.applet.Applet;
import java.util.*;
import java .awt.event.*;


public class SimplePlot extends Applet {
  TextField fromFld, toFld;
  Scrollbar s;
  String MyText;
  Label label, toLabel, fromLabel, statusLabel,scrollLabel;
  PlotCanvas canvas;
  public int i;
  Button domainChangeb;
  Color color;
  Panel panel1, panel2, bottomPanel, statusPanel, xdomainPanel, scrollPanel;
  Choice fnChoice,fnChoice1;
  float beginXmin = 0, beginXmax = 1;

 
   public void init() {
     
     setLayout(new BorderLayout(5,5));

     panel1 = new Panel();
     label = new Label("DC MOTOR LOAD");
     panel1.add(label);
     add("North", panel1); 

     panel2 = new Panel();
     panel2.setLayout(new GridLayout(5,1,0,0));
     panel2.add(new Label(" Color plot "));
       fnChoice1 = new Choice();
     fnChoice1.addItem("black");
     fnChoice1.addItem("red");
     fnChoice1.addItem("blue ");
     panel2.add(fnChoice1); 
     panel2.add(new Label("Choose motor variable"));
     fnChoice = new Choice();
     fnChoice.addItem("speed");
     fnChoice.addItem("field current ");
     fnChoice.addItem("armature current");
     panel2.add(fnChoice);
     add("East", panel2);

     canvas = new PlotCanvas(this);
     add("Center", canvas);
     fromLabel = new Label("0");


     

     /* Bottom Panel, with from and to and status line. */
     
     bottomPanel = new Panel();
     bottomPanel.setLayout(new GridLayout(0,1,10,10));

     /* Domain panel */
     xdomainPanel = new Panel();

     xdomainPanel.add(new Label("Plot time from : "));
     fromFld = new TextField("0", 7);
     canvas.setXmin(0);
     xdomainPanel.add(fromFld);

     xdomainPanel.add(new Label("to : "));
     toFld = new TextField(".01", 10);
     canvas.setXmax(.01f);
     xdomainPanel.add(toFld);

     domainChangeb = new Button ("Change time axis");
     xdomainPanel.add(domainChangeb);
     
     bottomPanel.add(xdomainPanel);
     
    

     /* Scroll Line */
    scrollPanel = new Panel();

    s = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1,0, 20);
   
       scrollPanel.add(s);
         
    scrollLabel=new Label("       "); 
    scrollPanel.add(scrollLabel);
    bottomPanel.add(scrollPanel);
    
 
/* Status Line */
     statusPanel = new Panel();
     statusLabel = new Label("                                              ");
     statusLabel.setForeground(Color.black);
     statusPanel.add(statusLabel);

     bottomPanel.add(statusPanel);


     add("South", bottomPanel);

        
   }


  /** Draws a box around this panel. */
  public void paint(Graphics g) {
    Dimension d = size();
    g.drawRect(0,0, d.width - 1, d.height - 1);
  }

  public Insets insets() {
    return new Insets(5,5,5,8);
  }

  public boolean handleEvent(Event e) {
    int newFn;

    try {
      if ((e.target instanceof Button) 
		 && (e.id == Event.ACTION_EVENT)) {
	
	 if (e.target == domainChangeb) {
	  float newXmin = 0, newXmax = 0; 
	  /* Do this to get rid of a possible 
	     "Domain must be a number" message */
	  statusLabel.setText("                           ");
	  newXmin = Float.valueOf(fromFld.getText()).floatValue();
	  newXmax = Float.valueOf(toFld.getText()).floatValue();
	  if (newXmax <= newXmin) {
	    statusLabel.setText("From must be less than To");
	  }
	  else {
	    canvas.setXmin(newXmin);
	    canvas.setXmax(newXmax);
	  }
	}
	canvas.repaint();
      }
      else if (e.target instanceof Choice && 
	       e.id == Event.ACTION_EVENT) {
        if (e.target == fnChoice1) {
            newFn = fnChoice1.getSelectedIndex();
     if (newFn == 0) {
  	  canvas.changeColor(Color.black);
	}
      else if (newFn == 1) {
          canvas.changeColor(Color.red);
         }   
  	 else if (newFn == 2) {
          canvas.changeColor(Color.blue);
         }    
	}
	newFn = fnChoice.getSelectedIndex();
	canvas.setFn(newFn);
	canvas.repaint();
      }


    else if (e.target instanceof Choice && 
	       e.id == Event.ACTION_EVENT) {
     newFn = fnChoice1.getSelectedIndex();
     if (newFn == 0) {
  	  canvas.changeColor(Color.green);
	}
	
	canvas.repaint();
      }

      

else if (e.target instanceof Scrollbar) {
	s = (Scrollbar)e.target;

            int value = s.getValue();                  
                                 
           scrollLabel.setText(String.valueOf
       (value));

                 
                  
                  canvas.sets1(value);
           	canvas.repaint();

      }

    }
    catch (NumberFormatException e1) {
      statusLabel.setText("Domain must be a number");
      System.out.println(e1);
    }

    return false;
  }

} /* End of class */






class PlotCanvas extends Canvas {
  SimplePlot containedBy;  
  public int mousex, mousey;
  public boolean isMouse = false;
  int timeThrough = 0;
  Color color = Color.black;
  int inset = 20;
  int fn = 0;
  int s1=1;
  float ymax, ymin;
  float xmax, xmin;

  PlotCanvas(SimplePlot containedByIn) {
	super();
	containedBy = containedByIn;
	xmin = 0;
	xmax = 1;
  }

  public void changeColor (Color inColor) {
    color = inColor;
  }
  

  public void setFn(int newFn) {
    fn = newFn;
  }

  public void setXmin(float newXmin) {
    xmin = newXmin;
  }

  public float getXmin() {
    return(xmin);
  }

  public void setXmax(float newXmax) {
    xmax = newXmax;
  }

public void sets1(int value) {
    s1 = value;
  }
/** Draws a box around this panel, plus other stuff. */
  public void paint(Graphics g) {
    int x, y;
    Dimension d = size();
    /* These need to be made into floats. */
    float xcur; 
    float ycur,ycur1;
    float xplot, yplot;
    PlotCoord pc;
    

    g.drawRect(0,0, d.width - 1, d.height - 1);

    g.setColor(color);
    /* This time through is just to find out what the max y value is. */ 
    ymax = 0;
    ymin = 0;
    ycur=0;
    ycur1=0;
     
    float va=220.0f;
    float vf=220.0f;
    float fi=0.01f;
    float ai=0.1f;
    float fr=100f;
    float ra=1f;
    float c=10f;
    float jx=0.0010f;
    float b=3.5f;
    float w=0;
    float fc=0;
    float ac=0;
    float acc=0;
    float rfc=0;
    float rac=0;
    float t=.01f;
    float dT = .0001f;
    float bw,vad,vfd,fcac;
    
    for (xcur = xmin; xcur <= xmax; xcur +=dT) {
      /* The function we are going to plot. */
        fcac=c*ac*fc;
        bw=b*w;
        vad=ac*(ra+s1);
        vfd=fr*fc;
        rfc=(vf-vfd)/fi;
        rac=(va-vad-c*fc*w)/ai;
        acc=(fcac-bw-t)/jx;
        fc=fc+dT*rfc;
        ac=ac+dT*rac;
        w=w+dT*acc;
         switch (fn) {
    case 0:

      ycur1=w*94.3f;
      break;
    case 1:
     
      ycur1=fc;
      break;
    case 2:
      ycur1=ac;
      break;
    
    default:
      System.out.println("Bad function number");
     
    }
        
        ycur= ycur1;
        if (ycur > ymax)
	ymax = ycur;
        if (ycur < ymin)
	ymin = ycur;
    }
    
    pc = new PlotCoord (xmax, ymax, xmin, ymin, d.width, d.height, inset);


    int xcoord = 0, ycoord = 0;

    g.setColor(Color.black);

    float xaxisStart = xmax, xaxisEnd = xmin, xaxisPosy;
    float yaxisStart = ymax, yaxisEnd = ymin, yaxisPosx;;

    /* Axis rules:
       If 0 is on the map, print out the axis there.
       If 0 is not on the map, print out the axis on the 
       minimum. */

    if (xmin < 0  && xmax > 0) 
      yaxisPosx = 0;
    else
      yaxisPosx = xmin;

    if (ymin < 0  && ymax > 0) 
      xaxisPosy = 0;
    else
      xaxisPosy = ymin ;

    /*    System.out.println("Yaxis at x = " + yaxisPosx + 
		       "  Xaxis at y = " + xaxisPosy);
		       */

    Font f = new Font ("Dialog", Font.PLAIN, 10);
    g.setFont(f);

    /* Draw x axis. */
    g.drawLine(pc.xcoord(xaxisStart), pc.ycoord(xaxisPosy), 
	       pc.xcoord(xaxisEnd), pc.ycoord(xaxisPosy));
    /* Draw y axis. */
    g.drawLine(pc.xcoord(yaxisPosx), pc.ycoord(yaxisStart),
	       pc.xcoord(yaxisPosx), pc.ycoord(yaxisEnd));



    /* This draws one tick mark on y */
    ycoord = pc.ycoord(ymin + (ymax - ymin)/2);
    xcoord = pc.xcoord(yaxisPosx);
    
    g.drawLine(xcoord+3, ycoord , xcoord - 3, ycoord);
    g.drawString(
      new Integer(Math.round(ymin + (ymax - ymin)/2)).toString(), 
		 xcoord + 5, ycoord + 10);

    /* This draws one tick mark on x */
    xcoord = pc.xcoord(xmin + (xmax - xmin)/2);
    ycoord = pc.ycoord(xaxisPosy);
    
    g.drawLine(xcoord, ycoord + 3, xcoord , ycoord - 3);
    g.drawString(
       new Integer(Math.round(xmin + (xmax - xmin)/2)).toString(), 
		 xcoord -5, ycoord + 15);

    /* draw a tick at 0 if it is on the graph */
    if (xmin < 0  && xmax > 0) {
      xcoord = pc.xcoord(0);
      ycoord = pc.ycoord(xaxisPosy);
      g.drawLine(xcoord, ycoord + 3, xcoord , ycoord - 3);
      g.drawString("0", xcoord -5, ycoord + 15);
    }

    if (ymin < 0  && ymax > 0) {
      ycoord = pc.ycoord(0);
      xcoord = pc.xcoord(yaxisPosx);
      g.drawLine(xcoord+3, ycoord , xcoord - 3, ycoord);
      g.drawString("0", xcoord + 7, ycoord + 10);
    }

    /* Draw tick marks at the max's. */

    /* This draws one tick mark on y */
    ycoord = pc.ycoord(ymax);
    xcoord = pc.xcoord(yaxisPosx);
    
    g.drawLine(xcoord+3, ycoord , xcoord - 3, ycoord);
    g.drawString(
      new Integer(Math.round(ymax)).toString(), 
		 xcoord + 5, ycoord + 10);

    /* This draws one tick mark on x */
    xcoord = pc.xcoord(xmax);
    ycoord = pc.ycoord(xaxisPosy);
    
    g.drawLine(xcoord, ycoord + 3, xcoord , ycoord - 3);
    g.drawString(
       new Integer(Math.round(xmax)).toString(), 
		 xcoord - 5, ycoord + 15);

    /* end of tick marks at the max's. */



    g.setColor(color);



    int xcoordPrev = 0, ycoordPrev = 0;
    float xprev = 0, yprev = 0;
    ycur=0;
    ycur1=0;
    va=220;
    vf=220;
    fi=0.03f;
    ai=0.1f;
    fr=100f;
    ra=1f;
    c=10f;
    jx=0.001f;
    b=3.5f;
    t=.01f;
    w=0;
    fc=0;
    ac=0;
    acc=0;
    rfc=0;
    rac=0;
    dT = .0001f;
    
     
    for (xcur = xmin; xcur <= xmax; xcur += dT) {
      fcac=c*ac*fc;
        bw=b*w;
        vad=ac*(ra+s1);
        vfd=fr*fc;
        rfc=(vf-vfd)/fi;
        rac=(va-vad-c*fc*w)/ai;
        acc=(fcac-bw-t)/jx;
        fc=fc+dT*rfc;
        ac=ac+dT*rac;
        w=w+dT*acc;
         switch (fn) {
    case 0:

      ycur1=w*94.3f;
      break;
    case 1:
     
      ycur1=fc;
      break;
    case 2:
      ycur1=ac;
      break;
    
    default:
      System.out.println("Bad function number");
      
    }
      
           ycur=ycur1;
	xcoord = pc.xcoord(xcur);
	ycoord = pc.ycoord(ycur);

      /* ie, don't do the very first x */
      if (xcur != xmin) {

	/*if (xcur > -0.01 && xcur < 0.01  )
		System.out.println( xprev + ":" + 
			    xcoordPrev + "  " + 
			    yprev + ":" + 
			    ycoordPrev + "  " + 
			    xcur + ":" + 
			    xcoord + "  " + 
			    ycur + ":" +
			    ycoord);*/

/*	g.drawOval(xcoord-3, ycoord-3, 6, 6);*/

	g.drawLine(xcoordPrev, ycoordPrev, 
		   xcoord, ycoord);

      }
      xcoordPrev = xcoord;
      ycoordPrev = ycoord;
      xprev = xcur;
      yprev = ycur;
    }

  }

 


  /*  public boolean mouseDown(Event e, int x, int y) {
    Graphics gc;
    gc = getGraphics();

    isMouse = true;
    mousex = x;
    mousey = y;
    System.out.println("Got a mouse event at " + x + ", " + y);
    gc.setColor(color);
    System.out.println(color); 
    System.out.println(gc.getColor()); 
    gc.drawLine(mousex, mousey, mousex + 50, mousey + 10);
    return true;
  }
  */

}

class PlotCoord {
  
  float xstretch = 1;
  float ystretch = 1;
  float xshift = 0;
  float yshift = 0;
  float ywholeScreen;       
  int inset;             /* How far from the edge the display is */

  PlotCoord(float xmax, float ymax, float xmin, float ymin, 
	    int width, int height, int insetin ) {

    inset = insetin;

    xstretch = (width - (2 * inset))/ (xmax - xmin);
    ystretch = (height - (2 * inset)) / (ymax - ymin);

    xshift = -xmin;
    yshift = -ymin;

    ywholeScreen = ymax - ymin;

  }

  /* Return the X and Y coordinates on the canvas. */
  int xcoord(float x) {
    float xcoordFloat;
    
    xcoordFloat = (x + xshift) * xstretch + inset;
    return(Math.round(xcoordFloat));
  }

  int ycoord(float y) {
    float ycoordFloat;
    
    ycoordFloat = (ywholeScreen - (y + yshift)) * ystretch + inset;
    return(Math.round(ycoordFloat));
  }
       

}
