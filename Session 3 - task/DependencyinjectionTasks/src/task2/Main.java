package task2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class Main {
        public static void main(String[] args) {
            ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

            Vehicle planeBean = container.getBean("plane", Plane.class);
            planeBean.setBrand("boeng");
            planeBean.saveToDatabase(planeBean);

            Vehicle carBean = container.getBean("car", Car.class);
            carBean.setBrand("BMW");
            carBean.saveToDatabase(carBean);
        }
    }
