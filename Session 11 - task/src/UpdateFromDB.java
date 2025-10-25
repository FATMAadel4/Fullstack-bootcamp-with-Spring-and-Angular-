import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateFromDB {
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
                System.out.println(" Student updated successfully!");
            } else {
                System.out.println(" No student found with ID = " + studentId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
