import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();

            User user = new User("fatma", "123");


            session.beginTransaction();
            session.save(user);

            //get all records
            Query query=session.createQuery("from User");
            List<User> allUsers=query.getResultList();
            for(User u :allUsers){
                System.out.println(u);
            }
            //update query
            query=session.createQuery("update User set username=:n WHERE id= :id ");
            query.setParameter("n","sohaila");
            query.setParameter("id",1);
            query.executeUpdate();

            //get records with pagination
             query=session.createQuery("from Product");
             query.setFirstResult(5);
             query.setMaxResults(10);
            List<Product> allProducts=query.getResultList();
            for(Product p :allProducts){
                System.out.println(p);
            }

        //get total prices of all the products
            query=session.createQuery("select sum (price)from Product");
            List<Integer> list=query.getResultList();
            System.out.println(list.get(0));

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
