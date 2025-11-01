import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import java.util.Date;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            try{
                session.beginTransaction();

//fetch person from passport
Passport passport=session.get(Passport.class,1);
                System.out.println(passport);
//fetch passport from person
Person person=session.get(Person.class,1);
                System.out.println(person);

                session.getTransaction().commit();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}