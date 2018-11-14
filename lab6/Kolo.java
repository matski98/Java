package lab6;

import java.awt.*;

public class Kolo extends Shape{
    private int i, i1;
    private final int i2;
    private final Color c;
    private final boolean b;

    public Kolo(int x, int y, int promien,Color color,boolean wypelnienie){
        i=y;
        i1=x;
        i2=promien*2;
        c=color;
        b=wypelnienie;
    }
    public void setX(int _i){i=_i;}
    public void setY(int _i){i1=_i;}

    public void draw(Graphics g){
        g.setColor(c);
        if(b)
            g.fillOval(i,i1,i2,i2);
        else
            g.drawOval(i,i1,i2,i2);
    }
}