import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseMotionListener;
public class KeyInputHandler implements KeyListener,MouseMotionListener,MouseListener,MouseWheelListener{
	public void keyTyped(KeyEvent e) {
	    if (e.getKeyChar() == KeyEvent.VK_ESCAPE)
	      System.exit(0);
	  }
//implementaciq na neobhodimite metodi za mi6ka i klaviatura
	  public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    if (keyCode == 27)
	     Game.running = false;
	    else
	      e.consume();
	  }

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX()>Game.sprite.getX() && e.getX()<Game.colX && e.getY()>Game.sprite.getY() && e.getY()<Game.colY )
		{Game.score=Game.score+1;
		Sprite.hit=true;
		Game.sprite.run();
		
		}
		if(e.getX()>Game.sprite2.getX() && e.getX()<Game.colX2 && e.getY()>Game.sprite2.getY() && e.getY()<Game.colY2 )
		{Game.score=Game.score+5;
		Sprite.hit=true;
		Game.sprite2.run();
		
		}
		if(e.getX()>Game.sprite3.getX() && e.getX()<Game.colX3 && e.getY()>Game.sprite3.getY() && e.getY()<Game.colY3 )
		{Game.score=Game.score+10;
		Sprite.hit=true;
		Game.sprite3.run();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()>Game.sprite.getX() && e.getX()<Game.colX && e.getY()>Game.sprite.getY() && e.getY()<Game.colY )
		{Game.score=Game.score+1;
		Sprite.hit=true;
		Game.sprite.run();
		
		}
		if(e.getX()>Game.sprite2.getX() && e.getX()<Game.colX2 && e.getY()>Game.sprite2.getY() && e.getY()<Game.colY2 )
		{Game.score=Game.score+5;
		Sprite.hit=true;
		Game.sprite2.run();
		
		}
		if(e.getX()>Game.sprite3.getX() && e.getX()<Game.colX3 && e.getY()>Game.sprite3.getY() && e.getY()<Game.colY3 )
		{Game.score=Game.score+10;
		Sprite.hit=true;
		Game.sprite3.run();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
