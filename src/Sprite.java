import java.awt.*;
import java.util.Random;

public class Sprite implements Runnable {
private Animation a;
private float x;
private float y;
private float vx;
private float vy;
public static  boolean hit=false;
Random r=new Random();
// Constructor
public Sprite (Animation a){
	this.a=a;
}
// smqna na posiciq na vsqko izvikvane
public void update(long timePassed)
{if(Game.score>100){
	x+=vx*timePassed/20*Game.score/100;
	y+=vy*timePassed/20*Game.score/100;
	a.update(timePassed);}
else
{
	x+=vx*timePassed/20;
	y+=vy*timePassed/20;
	a.update(timePassed);}
	}
public float getX(){
	return x;
}
public float getY(){
	return y;
}
public void setX(float x)
{this.x=x;
	}
public void setY(float y)
{this.y=y;
	}
//get sprite width
public float getWidth(){
	return a.getImage().getWidth(null);
}
public float getHeight(){
	return a.getImage().getHeight(null);
}//get VX
public float getVX()
{return vx;}
//get VY
public float getVY()
{return vy;}
//SET
public void setVX(float vx){
	this.vx=vx;
}
public void setVY(float vy){
	this.vy=vy;
}
//get Image
public Image getImage()
{return a.getImage();}
//logika na dvijenie
public void run()
{  if(hit==false){ 
	x=r.nextInt(500);
y=r.nextInt(500);
	vx=r.nextInt(2)+1;
	vy=r.nextInt(2)+1;}
else
{
	hit=false;
	run();
}
	}
}