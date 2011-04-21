import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.ObjectInputStream.GetField;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Screen {
private GraphicsDevice vc;
private KeyInputHandler key=new KeyInputHandler();
public Screen()

{
	GraphicsEnvironment e=GraphicsEnvironment.getLocalGraphicsEnvironment();
	vc=e.getDefaultScreenDevice();
	}
//vzimane na  displaymode na video kartata
public DisplayMode[] getCompatibleDisplayMode()
{return vc.getDisplayModes();
	}
//proverka za poddrujka na display mode
public DisplayMode findFirstCompatibleMode(DisplayMode modes[])
{DisplayMode goodModes[]=vc.getDisplayModes();
for(int x=0;x<modes.length;x++)

	{
	for(int y=0;y<goodModes.length;y++)
	{
		if(displayModesMatch(modes[x],goodModes[y]))
		{
		return modes[x];	
		}
	}
	}
return null;
}
//get current DisplayMode
public DisplayMode getCurrentDisplayMode()
	{
	return vc.getDisplayMode();
	}
//su6tinsko sravnqvane na dva lista s display mode i izbirane na purviq suvmestim
public boolean displayModesMatch(DisplayMode m1,DisplayMode m2)

{
	if(m1.getWidth()!=m2.getWidth()|| m1.getHeight()!=m2.getHeight())
		{
		return false;
		}
	if(m1.getBitDepth()!= DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth()!=DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth()!=m2.getBitDepth())
	{
		return false;
	}
	if(m1.getRefreshRate()!=DisplayMode.REFRESH_RATE_UNKNOWN &&m2.getRefreshRate()!=DisplayMode.REFRESH_RATE_UNKNOWN &&m1.getRefreshRate()!=m2.getRefreshRate())
	{
		return false;
	}
	 return true;
}

//make full screen
public void setFullScreen(DisplayMode dm)
{JFrame f=new JFrame();
f.setUndecorated(true);
f.setIgnoreRepaint(true);
f.setResizable(false);
f.addKeyListener(key);
f.addMouseListener(key);
f.addMouseWheelListener(key);
f.addMouseMotionListener(key);
Toolkit toolkit = Toolkit.getDefaultToolkit();
Image mouse=toolkit.getImage("sight.png"); 
Point hotSpot = new Point(15,15);
Cursor cursor = toolkit.createCustomCursor(mouse, hotSpot, "Cursor"); 
f.setCursor(cursor);
vc.setFullScreenWindow(f);	
if(dm!=null&& vc.isDisplayChangeSupported())
{
	try{
	vc.setDisplayMode(dm);
	
}catch(Exception ex){}
f.createBufferStrategy(2);
}	

}

public Graphics2D getGraphics()
{
Window w=vc.getFullScreenWindow();
if(w!=null)
{BufferStrategy s=w.getBufferStrategy();
	
return (Graphics2D)s.getDrawGraphics();
}
else return null;
}
//UPDATE
public void update()

{
	Window w=vc.getFullScreenWindow();
	if(w!=null)
	{BufferStrategy s=w.getBufferStrategy();
		if(!s.contentsLost())
		{s.show();
			
		}
	}
	}
//return Fullscrean
public Window getFullScreenWindow()
{return vc.getFullScreenWindow();
	}
public int getWidth()
{Window w=vc.getFullScreenWindow();
if(w!=null)
{return w.getWidth();
	}
else
{
	return 0;
}
	}
public int getHeight()
{Window w=vc.getFullScreenWindow();
if(w!=null)
{
	return w.getHeight();
	}
else
{
	return 0;
}
	}
//get out of fullscreen
public void restoreScreen()
{Window w=vc.getFullScreenWindow();
if(w!=null){
w.dispose();	
}
vc.setFullScreenWindow(null);
}


}
