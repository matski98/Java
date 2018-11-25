package zad2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.ScrollPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.geometry.Insets;
import javax.imageio.ImageIO;

public class Przegladarka_Zdjec extends Application {

    private boolean isImage(File file) {
        try {
            return (ImageIO.read(file) != null);
        }
        catch (IOException e) {
            return false;
        }
    }

    @Override
    public void start(Stage stage) throws Exception{

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(stage);

        TilePane tilePane = new TilePane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        tilePane.setPadding(new Insets(20, 20, 20, 20));
        tilePane.setHgap(20);
        File[] files = directory.listFiles();
        for(File file : files) {
            if (file.isFile()) {
                if (isImage(file)) {
                    ImageView imageView = new ImageView();
                    Image image = new Image(new FileInputStream(file));
                    imageView.setImage(image);
                    imageView.setFitWidth(150);
                    imageView.setPreserveRatio(true);
                    imageView.setSmooth(true);
                    imageView.setOnMouseClicked(event -> {

                        ImageView imageView2 = new ImageView(image);
                        BorderPane pane = new BorderPane();
                        pane.setPrefSize(stage.getWidth() / 2, stage.getWidth() / 2);
                        imageView2.setPreserveRatio(true);
                        imageView2.setFitWidth(stage.getWidth());
                        imageView2.setFitHeight(stage.getHeight()-36);
                        pane.setCenter(imageView2);
                        Stage newStage = new Stage();
                        newStage.setScene(new Scene(pane));
                        newStage.setTitle("Zdjęcie");
                        newStage.setMaximized(true);
                        newStage.show();
                    });
                    tilePane.getChildren().addAll(imageView);
                }
            }
        }
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(tilePane);
        stage.setTitle("Przeglądarka Zdjęć");
        stage.setMaximized(true);
        stage.setScene(new Scene(scrollPane));
        stage.show();
    }

    public static void main(String[] args) {
        try {
            launch(args);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
