package sql;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.LinkedList;

public class Baza {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    public Boolean connect(){
        for(int i = 0;i < 3;++i) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(
                        "jdbc:mysql://mysql.agh.edu.pl/rucinski", "rucinski",
                        "KNz3AAHFiER3jMxG");
                return true;
            }
            catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    public LinkedList<Book> listAll() {
        try {
            LinkedList<Book> out = new LinkedList<Book>();
            if(!connect())
                showError();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                out.add(new Book(rs.getString("isbn"),rs.getString("title"),rs.getString("author"),rs.getString("year")));
            }
            return out;
        }
        catch (SQLException ex) {
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqlEx) { }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (SQLException sqlEx) { }
                stmt = null;
            }
        }
        LinkedList<Book> lista = new LinkedList<Book>();
        return lista;
    }

    public LinkedList<Book> findByAuthor(String author) {
        try {
            LinkedList<Book> out = new LinkedList<>();
            if(!connect())
                showError();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+author+"'");
            while (rs.next()) {
                out.add(new Book(rs.getString("isbn"),rs.getString("title"),rs.getString("author"),rs.getString("year")));
            }
            return out;
        }
        catch (SQLException ex) {
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqlEx) { }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (SQLException sqlEx) { }
                stmt = null;
            }
        }
        LinkedList<Book> lista = new LinkedList<Book>();
        return lista;
    }

    public LinkedList<Book> findByISBN(String isbn) {
        try {
            LinkedList<Book> out = new LinkedList<Book>();
            if(!connect())
                showError();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE isbn = '"+isbn+"'");
            while(rs.next())
                out.add(new Book(rs.getString("isbn"),rs.getString("title"),rs.getString("author"),rs.getString("year")));
            return out;
        }
        catch (SQLException ex) {
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqlEx) { }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (SQLException sqlEx) { }
                stmt = null;
            }
        }
        return null;
    }


    public void addBook(String isbn, String title, String author, Integer year) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO `books` (`isbn`,`title`,`author`,`year`) "
                            + "VALUES ('"+isbn+"','"+title+"','"+author+"',"+year.toString()+")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showError(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Brak połączenia z bazą");
        alert.setContentText("3 próby połączenia z bazą danych nie powiodły się");
        alert.showAndWait();
    }
}

