import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateFromDB {
    private static final Logger logger = LoggerFactory.getLogger(CreateFromDB.class);

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            int studentId = 1;
            Student student = session.get(Student.class, studentId);

            if (student != null) {
                student.setLast_name("Mohamed");
                session.getTransaction().commit();
                logger.info(" Student updated successfully!");
            }  else {
                logger.warn("No student found with ID = {}", studentId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
