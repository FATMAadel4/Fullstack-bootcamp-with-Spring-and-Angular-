import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
try{
    session.beginTransaction();
     Person person=new Person("fatma","Adel",new Date());

    Passport passport=new Passport("abc123",person);


     session.save(passport);
     session.getTransaction().commit();
}catch(Exception e){
    e.printStackTrace();
}
        }
    }
}