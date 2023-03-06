package Crud;


import Elements.Element;
import jdbc.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlCRUD implements LabCRUDInterface<Element> {

    Connection connection;

    public SqlCRUD(){
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Element elem) {
        try(
            PreparedStatement st = connection.prepareStatement("INSERT INTO entity.entity (images, price, name) "
                            + "VALUES (?, ?, ?);")){
            st.setString(1, elem.getImages());
            st.setInt(2, elem.getPrice());
            st.setString(3, elem.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Element> read() {
        List<Element> list = new ArrayList<Element>();
        try (
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM entity.entity;");){
            while(rs.next()){
                list.add(new Element(rs.getInt(1), rs.getString(2),
                        rs.getInt(3),rs.getString(4) ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(int id, Element elem) {
        try(
            PreparedStatement st = connection.prepareStatement("UPDATE entity.entity "
                    + "SET \"images\"=?, \"price\"=?, \"name\"=? WHERE id=?;")){
            st.setString(1, elem.getImages());
            st.setInt(2, elem.getPrice());
            st.setString(3, elem.getName());
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(
            PreparedStatement st = connection.prepareStatement("DELETE FROM entity.entity WHERE id=?;")){
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
