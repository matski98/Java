package lab6;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;


public class MyPanel extends java.awt.Panel implements MouseMotionListener {
    private LinkedList<Shape> ShapeList = new LinkedList<Shape>();
    private int mousePosX;
    private int mousePosY;
    public MyPanel(){
        ShapeList.add(new Kolo(175,75,50,Color.CYAN, true));
        ShapeList.add(new Trojkat(225,50,400,10,200,200,Color.RED,true));
        ShapeList.add(new Kwadrat(130,250,50,Color.CYAN,true));
        ShapeList.add(new Kwadrat(270,250,50,Color.CYAN,true));
        ShapeList.add(new Kwadrat(270,350,50,Color.CYAN,true));
        ShapeList.add(new Kwadrat(130,350,50,Color.CYAN,true));
        ShapeList.add(new Prostokat(205,375,40, 75,new Color(200, 142, 84),true));
        ShapeList.add(new Kwadrat(300,95,50,Color.GRAY,true));
        ShapeList.add(new Kwadrat(100,200,250,new Color(160,85,45),true));

        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i=ShapeList.size()-1;i>=0;--i) {
            ShapeList.get(i).draw(g);
        }
    }

    public Dimension getPreferredSize() {

        return new Dimension(450, 450);
    }

    private static void createAndShowGui() {

        MyPanel myPanel = new MyPanel();
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(myPanel);
        frame.setContentPane(myPanel);
        frame.setLocationByPlatform(true);

        frame.setVisible(true);

        frame.pack();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int dx = mouseEvent.getX() - mousePosX;
        int dy =  mouseEvent.getY() - mousePosY;

        for(Shape s : ShapeList) {
            if(s.mouseOver(mouseEvent.getX(), mouseEvent.getY())) {

                s.setX(s.getX() + dx);
                s.setY(s.getY() + dy);

                int index = ShapeList.indexOf(s);
                ShapeList.remove(index);
                ShapeList.add(0, s);

                this.repaint();
                break;
            }
        }
        mousePosX = mouseEvent.getX();
        mousePosY = mouseEvent.getY();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mousePosX = mouseEvent.getX();
        mousePosY = mouseEvent.getY();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

}
