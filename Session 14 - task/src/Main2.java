import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            try{
                session.beginTransaction();
                Instructor instructor = new Instructor("Dr. Ahmed");
                List<Course> courses = new ArrayList<>();

                Collections.addAll(courses ,
                        new Course( "Question 1 first answer"),
                        new Course(  "Question 1 second answer"));

                instructor.setCourseList(courses);

                session.save(instructor);



                session.getTransaction().commit();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}