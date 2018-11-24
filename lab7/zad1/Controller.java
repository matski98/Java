package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Map;

public class Controller {
    @FXML
    private TextField startTextField;
    @FXML
    private TextField stopTextField;
    @FXML
    private TextField samplingTextField;
    @FXML
    private TextField wielomianTextField;

    public void pressButton(ActionEvent actionEvent) {

        logika.start=Double.parseDouble(startTextField.getText());
        logika.stop=Double.parseDouble(stopTextField.getText());
        logika.sampling=Double.parseDouble(samplingTextField.getText());
        for (String factor : wielomianTextField.getText().split(",")) {
            logika.wspolczynniki.add(Double.parseDouble(factor));
        }
        logika.dodajpunkty();
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<Double, Double> point : logika.punkty.entrySet()) {
            series.getData().add(new XYChart.Data(point.getKey(), point.getValue()));
        }

        Stage stage = new Stage();
        stage.setTitle("wykres wprowdzonego wielomianu");
        lineChart.setCreateSymbols(false);
        lineChart.getData().add(series);
        stage.setScene(new Scene(lineChart,800,600));
        stage.show();
        logika.wspolczynniki.clear();
        logika.punkty.clear();
        logika.sampling = 0.0;
        logika.start = 0.0;
        logika.stop = 0.0;
    }
}