import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            try{
                session.beginTransaction();
                Question question = new Question(  "firstQuestion");

                List<Answer> answers = new ArrayList<>();

                Collections.addAll(answers ,
                        new Answer( "Question 1 first answer"),
                new Answer(  "Question 1 second answer"));

                question.setAnswers(answers);

                session.save(question);



                session.getTransaction().commit();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}