import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Game {
	 Color c1 = Color.black;
	 public static int score = 0;
	  public static Sprite sprite;
	  public static Sprite sprite2;
	  public static Sprite sprite3;
	  private Screen screen;
	  private Image bg;
	  private Animation a;
	  private Animation a2;
	  private Animation a3;
	  public static boolean running = true;
	  public static float colX;
	  public static float  colY;
	  public static float colX2;
	  public static float  colY2;
	  public static float colX3;
	  public static float  colY3;
	//dopustimi resolucii
	  private static final DisplayMode[] modes1 = { new DisplayMode(800, 600, 32, 0), 
	    new DisplayMode(800, 600, 24, 0), 
	    new DisplayMode(800, 600, 16, 0) };
	  

	public static void main(String[] args) {
	Game game=new Game();
	game.run();

	}
	public void loadImages()
	  {
	    bg = new ImageIcon("moonsmall.jpg").getImage();
	    Image duck1 = new ImageIcon("ship1.png").getImage();
	    Image duck12= new ImageIcon("ship11.png").getImage();
	    Image duck2 = new ImageIcon("ship2.png").getImage();
	    Image duck22= new ImageIcon("ship22.png").getImage();
	    Image duck3 = new ImageIcon("ship3.png").getImage();
	    Image duck32= new ImageIcon("ship33.png").getImage();
	   a = new Animation();
	   a2 = new Animation();
	   a3 = new Animation();
	   a.addScene(duck1, 250);
	    a.addScene(duck12, 250);
	    a2.addScene(duck2, 250);
	    a2.addScene(duck22, 250);
	    a3.addScene(duck3, 250);
	    a3.addScene(duck32, 250);
	   sprite = new Sprite(a);
	   sprite2 = new Sprite(a2);
	   sprite3 = new Sprite(a3);
	  Thread t1 = new Thread(sprite);
	  Thread t2 = new Thread(sprite2);
	  Thread t3 = new Thread(sprite3);
	    t1.start();
	    t2.start();
	    t3.start();
	  }
	//na4alo na igrata
	  public void run()
	  {
	    screen = new Screen();
	    try
	    {
	      DisplayMode dm = screen.findFirstCompatibleMode(modes1);
	     screen.setFullScreen(dm);
	      loadImages();
	      movieLoop();
	    } finally {
	      screen.restoreScreen();
	    }
	  }
	  public void movieLoop() {
		    long startingTime = System.currentTimeMillis();
		    long Time = startingTime;
		    while (running) {
		      long timePassed = System.currentTimeMillis() - Time;
		      Time += timePassed;
		      update(timePassed);

		      Graphics2D g =screen.getGraphics();
		      draw(g);
		      g.dispose();
		     screen.update();
		      try
		      {
		        Thread.sleep(20); } catch (Exception localException) {
		      }
		    }
		  }
	  public void draw(Graphics g) {
		    g.drawImage(bg, 0, 0, null);
		    g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
		    g.drawImage(sprite2.getImage(), Math.round(sprite2.getX()), Math.round(sprite2.getY()), null);
		    g.drawImage(sprite3.getImage(), Math.round(sprite3.getX()), Math.round(sprite3.getY()), null);
		    g.setColor(c1);
		    g.drawString(Integer.toString(score), 742, 48);
		  }
	  public void update(long timePassed)
	  {
	    colX = sprite.getX() + sprite.getWidth();
	    colY = sprite.getY() + sprite.getHeight();
	    colX2 = sprite2.getX() + sprite2.getWidth();
	    colY2= sprite2.getY() + sprite2.getHeight();
	    colX3 = sprite3.getX() + sprite3.getWidth();
	    colY3 = sprite3.getY() + sprite3.getHeight();
	    if (sprite.getX() < 0.0) {
	      sprite.setVX(Math.abs(sprite.getVX()));
	      sprite.setVX(Math.abs(sprite.getVX()));
	    } else if (sprite.getX() + sprite.getWidth() > screen.getWidth()) {
	      sprite.setVX(-Math.abs(sprite.getVX()));
	    }
	    if (sprite.getY() < 0.0) {
	      sprite.setVY(Math.abs(sprite.getVY()));
	      sprite.setVY(Math.abs(sprite.getVY()));
	    } else if (sprite.getY() + sprite.getHeight() > screen.getHeight()) {
	     sprite.setVY(-Math.abs(sprite.getVY()));
	    }sprite.update(timePassed);
	    
	    
	    //vtora patica
	    if (sprite2.getX() < 0.0) {
		      sprite2.setVX(Math.abs(sprite2.getVX()));
		      sprite2.setVX(Math.abs(sprite2.getVX()));
		    } else if (sprite2.getX() + sprite2.getWidth() > screen.getWidth()) {
		      sprite2.setVX(-Math.abs(sprite2.getVX()));
		    }
		    if (sprite2.getY() < 0.0) {
		      sprite2.setVY(Math.abs(sprite2.getVY()));
		      sprite2.setVY(Math.abs(sprite2.getVY()));
		    } else if (sprite2.getY() + sprite2.getHeight() > screen.getHeight()) {
		     sprite2.setVY(-Math.abs(sprite2.getVY()));
		    }sprite2.update(timePassed);
		    
		    //3ta patica
		    if (sprite3.getX() < 0.0) {
			      sprite3.setVX(Math.abs(sprite3.getVX()));
			      sprite3.setVX(Math.abs(sprite3.getVX()));
			    } else if (sprite3.getX() + sprite3.getWidth() > screen.getWidth()) {
			      sprite3.setVX(-Math.abs(sprite3.getVX()));
			    }
			    if (sprite3.getY() < 0.0) {
			      sprite3.setVY(Math.abs(sprite3.getVY()));
			      sprite3.setVY(Math.abs(sprite3.getVY()));
			    } else if (sprite3.getY() + sprite3.getHeight() > screen.getHeight()) {
			     sprite3.setVY(-Math.abs(sprite3.getVY()));
			    }sprite3.update(timePassed);
	  }

}
