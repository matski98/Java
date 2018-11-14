package lab6;

import java.awt.*;

public class Prostokat extends Shape{
    private int i;
    private int i1;
    private final int i2;
    private final int i3;
    private boolean bool;
    Color c;

    public Prostokat(int x, int y, int a, int b, Color color, boolean wypelnienie){
        i=x;
        i1=y;
        i2=a;
        i3=b;
        bool=wypelnienie;
        c=color;
    }
    public void setX(int _i){i=_i;}
    public void setY(int _i){i1=_i;}

    public void draw(Graphics g){
        g.setColor(c);
        if(bool)
            g.fillRect(i,i1,i2,i3);
        else
            g.drawRect(i,i1,i2,i3);
    }
}