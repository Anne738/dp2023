package jdbc;
import Crud.LabCRUDInterface;
import Crud.SqlCRUD;
import Elements.Element;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class app {

    public static void main(String[] args)  {
        // TODO Auto-generated method stub
        LabCRUDInterface crud = new SqlCRUD();
        Connection connection = new Connect().getCon();

        List<Element> entities;
        List<Element> list = new ArrayList<>();


//JDBC connection
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM entity.entity;");) {
            while (rs.next()) {
                list.add(new Element(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("JDBC");
        for (Element elem : list) {
            System.out.println(elem);
        }


//JPA connection
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Element.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            //session.save(new Element(1, "assets/ja.jpeg", 178000, "JAVELIN"));
            //session.save(new Element(2, "assets/kor.png", 120000,"KORSAR"));

            //Element updateEntity1 = new Element(1, "updated_name_1", 101100, "gg");
            //session.update(updateEntity1);
            //session.delete(new Element(2, "name2", 300300,"1"));

            entities = (List<Element>) session.createQuery("from Element").list();

            session.getTransaction().commit();

        }

        System.out.println("JPA");
        for (Element elem : entities) {
            System.out.println(elem);
        }
        System.out.println("Success!");
    }
}