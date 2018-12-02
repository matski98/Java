package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.util.LinkedList;

public class Controller {

    public ComboBox comboBox;
    public TableColumn<Book,String> isbn;
    public TableColumn<Book,String> title;
    public TableColumn<Book,String> author;
    public TableColumn<Book,String> year;
    public TableView<Book> tabela;
    public TextField serchTextField;
    public TextField isbnTextField;
    public TextField titleTextField;
    public TextField authorTextField;
    public TextField yearTextField;
    private ObservableList<Book> data= FXCollections.observableArrayList();


    Baza baza = new Baza();

    public void pressButton(){
        if(comboBox.getValue()!=null && comboBox.getValue()=="Nazwisku") {
            if(!baza.connect())
                showError();
            LinkedList<Book> lista = baza.findByAuthor(serchTextField.getText());
            data.clear();
            tabela.getItems().clear();
            data.addAll(lista);
            tabela.setItems(data);
        }
        else if(comboBox.getValue()!=null && comboBox.getValue()=="Numerze ISBN") {
            if(!baza.connect())
                showError();
            LinkedList<Book> lista = baza.findByISBN(serchTextField.getText());
            data.clear();
            tabela.getItems().clear();
            data.addAll(lista);
            tabela.setItems(data);
        }
    }

    public void showAll(){
        if(!baza.connect())
            showError();
        LinkedList<Book> lista = baza.listAll();
        data.clear();
        tabela.getItems().clear();
        data.addAll(lista);
        tabela.setItems(data);
    }

    public void addNewBook(){
        if(!baza.connect())
            showError();
        if(isbnTextField.getText()!=null && titleTextField.getText()!=null && authorTextField.getText()!=null && yearTextField.getText()!=null)
            baza.addBook(isbnTextField.getText(),titleTextField.getText(),authorTextField.getText(),Integer.parseInt(yearTextField.getText()));
        showAll();
    }

    private void showError(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Brak połączenia z bazą");
        alert.setContentText("3 próby połączenia z bazą danych nie powiodły się");
        alert.showAndWait();
    }

    public void initialize() {
        comboBox.getItems().add("Nazwisku");
        comboBox.getItems().add("Numerze ISBN");
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        showAll();
    }
}
