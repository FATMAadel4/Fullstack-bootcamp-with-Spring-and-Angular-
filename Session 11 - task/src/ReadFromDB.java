import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadFromDB {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();


            session.beginTransaction();
            Student student = session.get(Student.class, 1);
            session.getTransaction().commit();

            System.out.println("Student saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
