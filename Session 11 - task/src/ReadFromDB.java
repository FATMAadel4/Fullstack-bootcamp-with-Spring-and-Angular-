import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFromDB {
    private static final Logger logger = LoggerFactory.getLogger(CreateFromDB.class);

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();


            session.beginTransaction();
            Student student = session.get(Student.class, 1);
            session.getTransaction().commit();

            logger.info("Student saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
