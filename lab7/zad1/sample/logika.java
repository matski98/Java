package sample;

import java.util.HashMap;
import java.util.LinkedList;

public class logika {
    private String errorString = null;
    public static HashMap<Double, Double> punkty;
    public static Double sampling;
    public static LinkedList<Double> wspolczynniki=new LinkedList<Double>();
    public static Double start;
    public static Double stop;
    public static Double funkcja(Double x){
        Double out = 0.0;
        for (Double w : wspolczynniki) {
            out = out * x + w;
        }
        return out;
    }
    public static void dodajpunkty() {
        punkty = new HashMap<>();
        for (Double i = start; i <= stop; i += sampling) {
            punkty.put(i, logika.funkcja(i));
        }
    }
}

