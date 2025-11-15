import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFromDB {
    private static final Logger logger = LoggerFactory.getLogger(CreateFromDB.class);

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

            logger.info("Student saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
