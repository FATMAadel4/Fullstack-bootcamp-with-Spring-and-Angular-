package task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        DatabaseOperations operation = container.getBean("databaseOperations", DatabaseOperations.class);

        ((ClassPathXmlApplicationContext) container).close();
    }
}