package lab6;

import java.awt.*;

public class Trojkat extends Shape{
    private int px1,px2,px3,py1,py2,py3;
    private final Color c;
    private final boolean b;

    public Trojkat(int x1, int x2,int x3,int y1, int y2, int y3, Color color, boolean wypelnienie){
        px1=x1;
        px2=x2;
        px3=x3;
        py1=y1;
        py2=y2;
        py3=y3;
        c=color;
        b=wypelnienie;
    }
    //public void setX(int _i){i=_i;}
    //public void setY(int _i){i1=_i;}

    public void draw(Graphics g){
        g.setColor(c);
        if(b)
            g.fillPolygon(new int[] {px1, px2, px3}, new int[] {py1, py2, py3}, 3);
        else
            g.drawPolygon(new int[] {px1, px2, px3}, new int[] {py1, py2, py3}, 3);
    }
}