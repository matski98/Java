package lab6;

import java.awt.*;

public abstract class Shape{
    public String name;


    public abstract void draw(Graphics g);

    public abstract void setX(int x);

    public abstract void setY(int y);

    public abstract int getX();

    public abstract int getY();

    public abstract boolean mouseOver(int px, int py);
}