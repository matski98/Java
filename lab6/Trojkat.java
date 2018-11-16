package lab6;

import java.awt.*;

public class Trojkat extends Shape{
    private int px1,px2,px3,py1,py2,py3;
    private final Color c;
    private final boolean bool;

    public Trojkat(int x1, int x2,int x3,int y1, int y2, int y3, Color color, boolean wypelnienie){
        px1=x1;
        px2=x2;
        px3=x3;
        py1=y1;
        py2=y2;
        py3=y3;
        c=color;
        bool=wypelnienie;
    }

    public void draw(Graphics g){
        g.setColor(c);
        if(bool)
            g.fillPolygon(new int[] {px1, px2, px3}, new int[] {py1, py2, py3}, 3);
        else
            g.drawPolygon(new int[] {px1, px2, px3}, new int[] {py1, py2, py3}, 3);
    }

    public void setX(int x) {
        px2=px2-px1+x;
        px3=px3-px1+x;
        px1=x;
    }

    public void setY(int y) {
        py2=py2-py1+y;
        py3=py3-py1+y;
        py1=y;
    }

    public int getX() {
        return px1;
    }

    public int getY() {
        return py1;
    }

    public boolean mouseOver(int px, int py) {
        double areaOrig = Math.abs( (px2-px1)*(py3-py1) - (px3-px1)*(py2-py1) );
        double area1 = Math.abs( (px1- px)*(py2- py) - (px2- px)*(py1- py) );
        double area2 = Math.abs( (px2- px)*(py3- py) - (px3- px)*(py2- py) );
        double area3 = Math.abs( (px3- px)*(py1- py) - (px1- px)*(py3- py) );
        return Math.abs(area1 + area2 + area3 - areaOrig)<0.001;
    }
}