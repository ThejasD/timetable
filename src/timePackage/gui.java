package timePackage;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class gui  extends Applet implements ItemListener{
	Choice type,section;
	Label t,s;
	String msg;
	int x,y;
	data d;
	data a=new data();
	data b=new data();
	data c=new data();
	public void init(){
		t=new Label("TYPE:");
		s=new Label("SECTION:");
		type=new Choice();
	    section=new Choice();
		type.add("TEACHER");
		type.add("STUDENT");
		section.add("A");
		section.add("B");
		section.add("C");
		add(t);
		add(type);
		add(s);
		add(section);
		type.addItemListener(this);
		section.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{	
		if('A'==section.getSelectedItem().charAt(0))
			d=a;
		else if('B'==section.getSelectedItem().charAt(0))
			d=b;
		else
		d=c;
		 repaint();
	}
	
	public void paint(Graphics g)
	{ 
		msg="type: ";
		msg+=type.getSelectedItem();
		g.drawString(msg, 6, 60);
		msg="section: ";
		msg+=section.getSelectedItem();
		g.drawString(msg, 6, 80);
		if("STUDENT"==type.getSelectedItem()){
			g.drawString("8:00",66,100);
			g.drawString("8:55",126,100);
			g.drawString("9:50",186,100);
			g.drawString("10:45",246,100);
			g.drawString("11:15",306,100);
			g.drawString("12:10",366,100);
			g.drawString("1:05",426,100);
			g.drawString("2:00",486,100);
			g.drawString("mon", 0, 120);
			g.drawString("tue",0,150);
			g.drawString("wed",0,180);
			g.drawString("thu",0,210);
			g.drawString("fri",0,240);
			g.drawString("sat",0,270);
			x=6;y=120;
			for(int i=0;i<6;i++){
				for(int j=0;j<8;j++){
			g.drawString(d.st[i][j],x=(x+60),y);
			}
				x=6;
				y=(y+30);
				}
		}
	}
}

