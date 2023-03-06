package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private String url = "jdbc:postgresql://localhost:5432/dp2023";
    private Connection con;

    public Connect(){
        try{
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(this.url, "sample1", "111");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void closeCon(){
        try{
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}