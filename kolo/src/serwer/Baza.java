package serwer;

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
                        "jdbc:mysql://mysql.agh.edu.pl/rucinsk1", "rucinsk1",
                        "7zzKw55nW4zQqu4V");
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




    public void add(String wynik) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO `kolo` (`wygral`) "
                            + "VALUES ('"+wynik+"')");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

