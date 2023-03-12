package Crud;


import Elements.Element;
import Servlets.Helpers;
import jdbc.Connect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SqlCRUD implements LabCRUDInterface<Element> {

    List<Element> list = new ArrayList<>();
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
    public void create(Element element) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Element.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            int id = Helpers.getNextId(list);

            session.save(new Element(
                    id,
                    element.getImages(),
                    element.getPrice(),
                    element.getName())
            );

            session.getTransaction().commit();
        }
    }

    @Override
    public List<Element> read() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Element.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            list = (List<Element>) session.createQuery("from Element").list();

            session.getTransaction().commit();
        }

        return list;
    }

    @Override
    public void update(int id, Element element) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Element.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Element updateTent = new Element(
                    id,
                    element.getImages(),
                    element.getPrice(),
                    element.getName());

            session.update(updateTent);

            session.getTransaction().commit();
        }
    }


    @Override
    public void delete(int id){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Element.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(session.get(Element.class, id));

            session.getTransaction().commit();
            session.close();
        }
    }

    /*  *  @Override
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
*/

}
