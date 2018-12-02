package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sql.*;

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


    Baza sql = new Baza();

    public void pressButton(){
        if(comboBox.getValue()!=null && comboBox.getValue()=="Nazwisku") {
            LinkedList<Book> lista = sql.findByAuthor(serchTextField.getText());
            data.clear();
            tabela.getItems().clear();
            data.addAll(lista);
            tabela.setItems(data);
        }
        else if(comboBox.getValue()!=null && comboBox.getValue()=="Numerze ISBN") {
            LinkedList<Book> lista = sql.findByISBN(serchTextField.getText());
            data.clear();
            tabela.getItems().clear();
            data.addAll(lista);
            tabela.setItems(data);
        }
    }

    public void showAll(){
        LinkedList<Book> lista = sql.listAll();
        data.clear();
        tabela.getItems().clear();
        data.addAll(lista);
        tabela.setItems(data);
    }

    public void addNewBook(){
        if(isbnTextField.getText()!=null && titleTextField.getText()!=null && authorTextField.getText()!=null && yearTextField.getText()!=null)
            sql.addBook(isbnTextField.getText(),titleTextField.getText(),authorTextField.getText(),Integer.parseInt(yearTextField.getText()));
        showAll();
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
