import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateFromDB {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();

            Student student = new Student("fatma", "adel");


            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Student saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
