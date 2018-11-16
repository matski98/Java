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

    public void draw(Graphics g){
        g.setColor(c);
        if(bool)
            g.fillRect(i,i1,i2,i3);
        else
            g.drawRect(i,i1,i2,i3);
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
        return (px >= i && px <= i + i2
                && py >= i1 && py <= i1 + i3);
    }
}