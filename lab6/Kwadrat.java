package lab6;

import java.awt.*;

public class Kwadrat extends Shape{
    private int i;
    private int i1;
    private final int i2;
    private boolean b;
    Color c;

    public Kwadrat(int x, int y, int a, Color color, boolean wypelnienie){
        i=x;
        i1=y;
        i2=a;
        b=wypelnienie;
        c=color;
    }
    public void setX(int _i){i=_i;}
    public void setY(int _i){i1=_i;}

    public void draw(Graphics g){
        g.setColor(c);
        if(b)
            g.fillRect(i,i1,i2,i2);
        else
            g.drawRect(i,i1,i2,i2);
    }
}