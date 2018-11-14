package lab6;

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;


public class MyPanel extends java.awt.Panel{
    private LinkedList<Shape> ShapeList = new LinkedList<Shape>();

    public MyPanel(){
        ShapeList.add(new Kolo(0,0,150,Color.BLACK,true));
        ShapeList.add(new Trojkat(0,300,300,0,300,0,Color.BLUE,true));
        ShapeList.add(new Kwadrat(20,30,50,Color.PINK,true));
        ShapeList.add(new Kolo(100,200,50,Color.GREEN,true));
        ShapeList.add(new Kwadrat(300,300,100,Color.RED,false));
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
