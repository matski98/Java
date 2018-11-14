package lab6;

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;


public class MyPanel extends java.awt.Panel{
    private LinkedList<Shape> ShapeList = new LinkedList<Shape>();

    public MyPanel(){
        //ShapeList.add(new Kolo(0,0,150,Color.BLACK,true));
        ShapeList.add(new Kwadrat(300,95,50,Color.GRAY,true));
        ShapeList.add(new Trojkat(225,50,400,10,200,200,Color.RED,true));
        ShapeList.add(new Kwadrat(100,200,250,new Color(160,85,45),true));
        ShapeList.add(new Kolo(74,175,50,Color.CYAN, true));
        ShapeList.add(new Kwadrat(130,250,50,Color.CYAN,true));
        ShapeList.add(new Kwadrat(270,250,50,Color.CYAN,true));
        ShapeList.add(new Kwadrat(270,350,50,Color.CYAN,true));
        ShapeList.add(new Kwadrat(130,350,50,Color.CYAN,true));
        ShapeList.add(new Prostokat(205,375,40, 75,Color.RED,true));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape: ShapeList){
            shape.draw(g);
        }
    }

    public Dimension getPreferredSize(){

        return new Dimension(450, 450);
    }

    private static void createAndShowGui(){

        MyPanel myPanel = new MyPanel();
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(myPanel);
        frame.setContentPane(myPanel);
        frame.setLocationByPlatform(true);

        frame.setVisible(true);

        frame.pack();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
