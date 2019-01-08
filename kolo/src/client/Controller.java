package client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import serwer.*;

public class Controller {
    @FXML
    public CheckBox p11;
    @FXML
    public CheckBox p12;
    @FXML
    public CheckBox p13;
    @FXML
    public CheckBox p21;
    @FXML
    public CheckBox p22;
    @FXML
    public CheckBox p23;
    @FXML
    public CheckBox p31;
    @FXML
    public CheckBox p32;
    @FXML
    public CheckBox p33;


    public Boolean checkBox(){
        if(p11.isSelected()&&p12.isSelected()&&p13.isSelected())
            return true;
        else
            return false;
    }
    public void pressButton(){

    }


    public void initialize() {


    }
}
