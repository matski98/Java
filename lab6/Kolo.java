package lab6;

import java.awt.*;

public class Kolo extends Shape{
    private int i, i1;
    private final int i2;
    private final Color c;
    private final boolean bool;

    public Kolo(int x, int y, int promien,Color color,boolean wypelnienie){
        i=x;
        i1=y;
        i2=promien*2;
        c=color;
        bool =wypelnienie;
    }

    public void draw(Graphics g){
        g.setColor(c);
        if(bool)
            g.fillOval(i,i1,i2,i2);
        else
            g.drawOval(i,i1,i2,i2);
    }
    public int getX() {
        return i;
    }

    public int getY() {
        return i1;
    }

    public void setX(int x) {
        i = x;
    }

    public void setY(int y) {
        i1 = y;
    }


    public boolean mouseOver(int px, int py) {

        int cx = i + i2/2;
        int cy = i1 + i2/2;

        return (px - cx)*(px - cx) + (py - cy)*(py - cy) <= i2*i2/4;
    }
}